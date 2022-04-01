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

        int sum = 0;
        if(number.contains(",")){

            for (int i = 0; i < numbers.length; i++){
                sum += Integer.parseInt(numbers[i]);
            }
            return Integer.toString(sum);
        }

        return "";
    }
}
