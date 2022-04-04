
import java.util.ArrayList;
import java.util.List;

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

        this.verifySeparatorNumberFormatIsCorrect(number);
        this.verifyDelimiterInFinalString(number);

        String [] numbers = number.split(",|\n");

        if(numbers.length == 1){
            return numbers[0];
        }
        return this.sumMultipleNumbersInString(numbers);
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
        int sum = 0;
        for (int i = 0; i < numbers.length; i++){
            sum += Integer.parseInt(numbers[i]);
        }
        return Integer.toString(sum);
    }
}
