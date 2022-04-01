import org.junit.platform.commons.util.StringUtils;

public class StringCalculator {

    public String add(String number){
        if(number.equals("")){
            return "0";
        }
        int sum = 0;
        if(number.contains(",")){
            String [] numbers = number.split(",");
            for (int i = 0; i < numbers.length; i++){
                sum += Integer.parseInt(numbers[i]);
            }
            return Integer.toString(sum);
        }

        return "";
    }
}
