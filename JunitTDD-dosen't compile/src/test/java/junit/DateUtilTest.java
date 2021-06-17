package junit;

import junit.DateUtil;
import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {
    @Test
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
    }


}
