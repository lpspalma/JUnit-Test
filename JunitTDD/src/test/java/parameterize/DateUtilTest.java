package parameterize;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class DateUtilTest {
    @Parameterized.Parameter(0)
    public int year;
    @Parameterized.Parameter(1)
    public boolean shouldBeLeap;

    @Parameterized.Parameters(name = "The year {0,number,####} should have a leap year as {1}")
    public static  Object[][] parameters(){
        return new Object[][]{
                {1992, true},
                {1996, true},
                {1991, false},
                {1900, false},
                {2000, true}
        };
    }
    @Test
    public void isLeapYear(){
        assertThat(DateUtil.isLeapYear(year),is(shouldBeLeap));


    }
    /*@Test
    public void normalLeapYearIsLeap(){
        Assert.assertTrue(DateUtil.isLeapYear(1992));
    }
    @Test
    public void nonLeapYear(){
        Assert.assertFalse(DateUtil.isLeapYear(1991));
    }

    @Test
    public void centuryYearAreNotLeapYear(){
        Assert.assertFalse(DateUtil.isLeapYear(1900));
    }

    @Test
    public void year2000wasLeapYear(){
        Assert.assertTrue(DateUtil.isLeapYear(2000));
    }*/

}