import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ShortestPathTest {
    private final ShortestPath shortestPath = new ShortestPath();

    @Test
    void sequenceTest(){
        assertEquals(4,shortestPath.path("aa","zq",new String[]{"ab","ac","bc","ec","zq","ay","xy","qx","zq"}));
    }
    @Test
    void sameTest(){
        assertEquals(0,shortestPath.path("aa","aa",new String[]{"aa"}));
    }
    @Test
    void missingTest(){
        assertEquals(-1,shortestPath.path("aa","ab",new String[]{"aa"}));
    }
}
