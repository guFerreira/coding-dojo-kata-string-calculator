import org.junit.platform.commons.util.StringUtils;


public class StringCalculator {

    public String add(String number){
        if(number.equals("")){
            return "0";
        }
        String [] numbers = number.split(",");

        if(numbers.length == 1){
            return numbers[0];
        }

        return this.sumMultipleNumbersInString(numbers);
    }

    private String sumMultipleNumbersInString(String[] numbers){
        int sum = 0;
        for (int i = 0; i < numbers.length; i++){
            sum += Integer.parseInt(numbers[i]);
        }
        return Integer.toString(sum);
    }
}
