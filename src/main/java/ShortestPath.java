import java.util.*;

public class ShortestPath {
    /**
     * Basic path finding algorithm. It takes starting starting word, goal word and an array of all words to visit.
     * Then it explores all word using greedy search visiting all words in the worst case. Stops if: start and end are
     * equal, all words were visited and no connection to starting word was found, connection found
     * @param from Starting word
     * @param to    end word
     * @param graph words to explore
     * @return Minimum letter changes to achieve the goal word or -1 if not possible
     */
    public int path(String from, String to, String[] graph) {
        String reverseTo = new StringBuilder(to).reverse().toString();
        if ((from.equals(to) || from.equals(reverseTo))) return 0;

        Set<String> toVisitSet = new HashSet<>();
        Set<String> visitedSet = new HashSet<>();
        Map<String, Integer> distanceMap = new HashMap<>();

        toVisitSet.add(from);
        int distance = 0;
        while (visitedSet.size() < graph.length){
            Set<String> adjacent = new HashSet<>();
            for (String s : toVisitSet){
                adjacent.addAll(findAdjacent(s, graph));
                distanceMap.put(s,distance);
                visitedSet.add(s);
            }
            toVisitSet.removeAll(toVisitSet);
            toVisitSet.addAll(adjacent);
            if (distanceMap.containsKey(to)) return distanceMap.get(to);
            if (distanceMap.containsKey(reverseTo)) return distanceMap.get(reverseTo);

            distance++;
        }
        return -1;
    }

    /*
     Returns a set of words adjacent to input one
     */
    private Set<String> findAdjacent(String from, String[] graph){
        Set<String> adjacent = new HashSet<>();
        for (String s : graph){
            if (s.contains(from.substring(0, 1)) || s.contains(from.substring(1))) {
                adjacent.add(s);
            }
        }
        return adjacent;
    }

}
