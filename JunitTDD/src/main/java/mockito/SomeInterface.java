package mockito;

import java.io.IOException;
import java.util.List;

public interface SomeInterface {
    int getMatchingSize(int x, int y);

    boolean isFileValid(String filename) throws IOException;

    void receiveList(List<String> list);
}
