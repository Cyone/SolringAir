import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BracesTest {
    private final Braces braces = new Braces();

    @ParameterizedTest
    @ValueSource(strings = {"[()]","[<()>]","[]<>","<[()]>", "<<[[(())]]>>"})
    public void testValid(String s){

        assertTrue(braces.isValid(s));
    }
    @ParameterizedTest
    @ValueSource(strings = {"[()","[<(])>","<[(])>"})
    public void testInvalid(String s){
        assertFalse(braces.isValid(s));
    }

}
