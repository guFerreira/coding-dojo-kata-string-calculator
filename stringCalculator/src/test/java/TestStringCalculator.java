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
        String emptyNumbers = "";
        String result = stringCalculator.add(emptyNumbers);

        Assertions.assertEquals("0", result);
    }

    @Test
    public void testStringWithOneNumber(){
        String number = "1";
        String result = stringCalculator.add(number);

        Assertions.assertEquals("1", result);
    }

    @Test
    public void testStringWithTwoNumbers(){
        String numbers = "1,2";
        String result = stringCalculator.add(numbers);

        Assertions.assertEquals("3", result);
    }

    @Test
    public void testStringWithMultipleNumbers(){
        String numbers= "1,2,5,10";
        String result = stringCalculator.add(numbers);

        Assertions.assertEquals("18", result);
    }

    @Test
    public void testEntryWithNewLineSeparator(){
        String numbersSeparatedByNewLine= "1\n2,3";
        String result = stringCalculator.add(numbersSeparatedByNewLine);

        Assertions.assertEquals("6", result);
    }


}
