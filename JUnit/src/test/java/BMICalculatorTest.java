import healthycoderapp.BMICalculator;
import healthycoderapp.Coder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BMICalculatorTest {


    @Test
    public void should_ReturnTrue_When_DietRecommended(){
        //always create a three step method
        //given
        double weight = 100.0;
        double height = 1.70;
        //when
        boolean recommended = BMICalculator.isDietRecommended(weight,height);
        //then
        assertTrue(recommended);
    }
    /*@Test
    public void should_ThrowArithmeticException_When_HeightZero(){
        //given
        double weight = 100.0;
        double height = 0.0;
        //when
        Executable executable = () -> BMICalculator.isDietRecommended(weight,height);
        //then
        Assert.assertThrows(ArithmeticException.class, executable);
    }*/
    @Test
    public void should_ReturnCoderWorstBMI_When_CodersListNotEmpty(){
        //always create a three step method
        //given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60));
        coders.add(new Coder(1.82, 92));
        coders.add(new Coder(1.82, 64.5));

        //when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
        Assert.assertAll(

        )
        Assert.assertEquals(1.82,coderWorstBMI.getHeight(), 0.01);
        Assert.assertEquals(1.82,coderWorstBMI.getHeight(), 0.01);
        Assert.assertEquals(1.82,coderWorstBMI.getHeight(), 0.01);
        //then

    }
}
