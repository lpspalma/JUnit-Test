package mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.util.List;

import static com.sun.javaws.JnlpxArgs.verify;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeInterfaceTest {
    @Mock
    SomeInterface someInterface;

    @Captor
    private ArgumentCaptor<List<String>> listCaptor;

    @Test
    public void exempleTest(){
        when(someInterface.getMatchingSize(anyInt(),anyInt())).thenReturn(1);
        for (int i =0; i<5;i++){
            System.out.println(someInterface.getMatchingSize(1,2));
        }
    }

    @Test
    public void exampleVerifyMultiple(){
        someInterface.getMatchingSize(1,2);
        someInterface.getMatchingSize(1,2);
        //verify(someInterface, times(2)).getMatchingSize(1,2);
    }

    /*@Test
    public void verifyList(){
        someInterface.receiveList(asList("A","B","C"));
        verify(someInterface).receiveList(listCaptor.capture());
    }*/

    @Test(expected = IOException.class)
    public void willThrow() throws Exception{
        when(someInterface.isFileValid("myName")).thenThrow(new IOException("Boom"));
        someInterface.isFileValid("myName");
    }

    /*@Test
    public void thenAnswer(){
        when(someInterface.getMatchingSize(anyInt(),anyInt())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                return (int)invocationOnMock.getArguments()[0] + (int)invocationOnMock.getArguments()[1];
            }
        });
        assertEquals(4,someInterface.getMatchingSize(1,2));
    }*/
}
