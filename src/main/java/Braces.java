import java.util.Deque;
import java.util.LinkedList;


public class Braces {

    /**
     * Checks a string of braces for pairless braces or  braces closed on a pairless brace
     * @param s String made of <[()]>
     * @return true if no braces are pairless braces or no braces are closed on a pairless brace, fasle otherwise
     */
    public boolean isValid(String s) {
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '<' || c == '(') {
                queue.add(c);
            } else {
                if (queue.peekLast() == null) return false;

                char charInQueue = queue.pollLast();
                switch (charInQueue) {
                    case '(':
                        if (c != ')') return false;
                        break;
                    case '<':
                        if (c != '>') return false;
                        break;
                    case '[':
                        if (c != ']') return false;
                        break;
                }

            }

        }
        return queue.isEmpty() ? true : false;
    }
}
