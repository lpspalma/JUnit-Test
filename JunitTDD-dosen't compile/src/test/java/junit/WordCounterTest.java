package junit;

import junit.WordCounter;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordCounterTest {
    private WordCounter counter = new WordCounter();
    @Test
    public void emptyStringHasNoWords(){
        counter.add("");
        assertEquals(0,counter.getUniqueWordsCount());
    }

    @Test
    public void singleWordStringHasOneWord(){
        counter.add("Hello");
        assertEquals(1,counter.getUniqueWordsCount());
    }

    @Test
    public void twoSingleWordStringHaveTwoWords(){
        counter.add("Hello");
        counter.add("World");
        assertEquals(2,counter.getUniqueWordsCount());
    }

    @Test
    public void multiWordStringHasCorrectWordCount(){
        counter.add("One Two Three");
        assertEquals(3,counter.getUniqueWordsCount());
    }

    @Test
    public void severalSpacedMultiWordStringHasCorrectWordCount(){
        counter.add("      One    Two   Three  ");
        assertEquals(3,counter.getUniqueWordsCount());
    }

    @Test
    public void severalWordStringHasCorrectWordCount(){
        counter.add("One Two Three");
        counter.add("Four five six");
        assertEquals(6,counter.getUniqueWordsCount());
    }

    @Test
    public void inputWithDuplicatesCountsOnlyIndividualsCases(){
        counter.add("nine nine nine");
        assertEquals(1,counter.getUniqueWordsCount());
    }

    @Test
    public void inputWithMixedCasesDuplicatesCountsOnlyIndividualsCases(){
        counter.add("nine Nine NINE");
        assertEquals(1,counter.getUniqueWordsCount());
    }

    @Test
    public void inputWithPunctuationStillSpotsDuplicates(){
        counter.add("Nine.");
        counter.add("Nine ten.");
        counter.add("nine, ten, eleven");
        assertEquals(3, counter.getUniqueWordsCount());
    }
}