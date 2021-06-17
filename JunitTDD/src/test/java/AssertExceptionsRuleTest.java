import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class AssertExceptionsRuleTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void willThrowError() throws IOException {
        expectedException.expect(IOException.class);
        willThrow();
    }

    @Test
    public void willThrow2(){

    }

    public static void  willThrow() throws IOException {
        throw new IOException("Bang");
    }
}
