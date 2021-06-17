package deeperJunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class ReaderWriterTest {
    private File writtenFile;
    private File tempFolder;
    @Before
    public void setup() throws Exception{
        //with a temporary folder to write to
        tempFolder = File.createTempFile("tmp", "file");
        tempFolder.delete();
        tempFolder.mkdir();
    }

    @After
    public void teardown() throws Exception{
        //and the tidy up is successful
        assertTrue(writtenFile.delete());
        assertTrue(tempFolder.delete());
    }

    @Test
    public void readsLinesItWrote() throws Exception{
        //when we write the file
        List<String> someLines = asList("one", "two", "three");
        writtenFile = ReaderWriter.write(tempFolder, "MyFile", someLines);

        //then we can read back
        List<String> readLines = ReaderWriter.read(writtenFile);

        //and they match
        assertEquals(someLines, readLines);
    }

}