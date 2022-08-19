package guess;

public class GuessStatisticsMessage {
    private String number;
    private String verb;
    private String pluralModifier;

    private void printGuessStatistics(char candidate, int count) {
        if (count == 0) {
            number = "no";
            verb = "are";
            pluralModifier = "s";
        } else if (count == 1) {
            number = "1";
            verb = "is";
            pluralModifier = "";
        } else {
            number = Integer.toString(count);
            verb = "are";
            pluralModifier = "s";
        }
        String guessMessage = String.format(
            "There %s %s %s%s", verb, number, candidate, pluralModifier
        );
        print(guessMessage);
    }

    private void print(String guessMessage) {
        System.out.println(guessMessage);
    }
}
