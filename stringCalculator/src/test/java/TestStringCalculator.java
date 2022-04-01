import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestStringCalculator {
    StringCalculator stringCalculator;

    @BeforeEach
    private void initObjects(){
        this.stringCalculator = new StringCalculator();
    }

    @Test
    public void testStringEmpty(){
        String numbersForSumEmpty = "";
        String result = stringCalculator.add(numbersForSumEmpty);

        Assertions.assertEquals("0", result);
    }

    @Test
    public void testStringWithOneNumber(){
        String numbersForSumEmpty = "1";
        String result = stringCalculator.add(numbersForSumEmpty);

        Assertions.assertEquals("1", result);
    }

    @Test
    public void testStringWithTwoNumbers(){
        String numbersForSumEmpty = "1,2";
        String result = stringCalculator.add(numbersForSumEmpty);

        Assertions.assertEquals("3", result);
    }
}
