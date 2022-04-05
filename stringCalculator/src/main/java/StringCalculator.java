
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private List<String> delimiters;

    public StringCalculator() {
        this.delimiters = new ArrayList<>();
        this.addPatternsDelimiters();
    }

    private void addPatternsDelimiters(){
        this.delimiters.add(",");
        this.delimiters.add("\n");
    }

    public String add(String number){
        if(number.equals("")){
            return "0";
        }
        if (isCustomSeparator(number)){
            return this.sumWithCustomDelimiter(number);
        }

        String [] numbers = number.split(",|\n");
        this.verifySeparatorNumberFormatIsCorrect(number);
        this.verifyDelimiterInFinalString(number);

        return this.sumMultipleNumbersInString(numbers);
    }

    private boolean isCustomSeparator(String numbers){
        return numbers.startsWith("//");
    }

    private String sumWithCustomDelimiter(String input){
        String[] customSeparator = input.split("\n");
        String delimiter = this.extractCustomSeparator(customSeparator[0]);
        String formattedNumbers = customSeparator[1];

        String [] numbers = formattedNumbers.split(delimiter);

        return this.sumMultipleNumbersInString(numbers);
    }

    private String extractCustomSeparator(String numbers){
        String delimiter = "";
        for (int i = 2; i <= numbers.length()-1;i++){
            delimiter += numbers.charAt(i);
        }
        if(delimiter.equals("|")){
            return "\\|";
        }
        return delimiter;
    }

    private void verifySeparatorNumberFormatIsCorrect(String numbers){
        for(int i = 0; i < this.delimiters.size(); i++){
            for(int j = 0; j < this.delimiters.size(); j++){
                String delimiters = this.delimiters.get(i) + this.delimiters.get(j);
                this.verifyInvalidDelimiter(delimiters, numbers);
            }
        }
    }

    private void verifyInvalidDelimiter(String delimiter, String numbers){
        System.out.println("delimiter:"+delimiter);
        System.out.println("char com problema:"+numbers.charAt(numbers.indexOf(delimiter)+1));
        if (numbers.contains(delimiter)){
            throw new IllegalArgumentException("Number expected but '\\n' found" +
                    " at position "+ (numbers.indexOf(delimiter)+1) +".");
        }
    }

    private void verifyDelimiterInFinalString(String numbers){
        for (String delimiter : this.delimiters) {
            if(numbers.charAt(numbers.length()-1) == delimiter.charAt(0)){
                throw new IllegalArgumentException("Number expected but EOF found.");
            }
        }
    }

    private String sumMultipleNumbersInString(String[] numbers){

        if(numbers.length == 1){
            return numbers[0];
        }
        int sum = 0;
        for (int i = 0; i < numbers.length; i++){
            sum += Integer.parseInt(numbers[i]);
        }
        return Integer.toString(sum);
    }
}
