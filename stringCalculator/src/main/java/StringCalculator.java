import org.junit.platform.commons.util.StringUtils;


public class StringCalculator {

    public String add(String number){
        if(number.equals("")){
            return "0";
        }

        this.verifySeparatorNumberFormatIsCorrect(number);
        this.verifyDelimiterInFinalString(number);
        String [] numbers = number.split(",|\n");

        if(numbers.length == 1){
            return numbers[0];
        }

        return this.sumMultipleNumbersInString(numbers);
    }

    private void verifySeparatorNumberFormatIsCorrect(String numbers){
        if (numbers.contains(",\n")){
            for (int i = 0; i < numbers.length()-1;i++) {
                if (numbers.charAt(i) == ',' && numbers.charAt(i+1) == '\n'){
                    int positionIncorrectSeparator = i+1;
                    throw new IllegalArgumentException("Number expected but '\\n' found" +
                            " at position "+positionIncorrectSeparator+".");
                }
            }
        }
    }

    private void verifyDelimiterInFinalString(String numbers){
        if(numbers.charAt(numbers.length()-1) == ',' || numbers.charAt(numbers.length()-1) == '\n'){
            throw new IllegalArgumentException("Number expected but EOF found.");
        }
    }

    private String sumMultipleNumbersInString(String[] numbers){
        int sum = 0;
        for (int i = 0; i < numbers.length; i++){
            sum += Integer.parseInt(numbers[i]);
        }
        return Integer.toString(sum);
    }


}
