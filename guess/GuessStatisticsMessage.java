package guess;

public class GuessStatisticsMessage {
    private String number;
    private String verb;
    private String pluralModifier;

    public String make(char candidate, int count) {
        createPluralDependentMessageParts(count);
        String guessMessage = String.format(
            "There %s %s %s%s", verb, number, candidate, pluralModifier
        );
        return guessMessage;
    }

    private void createPluralDependentMessageParts(int count) {
        if (count == 0) {
            thereAreNoletters();
        } else if (count == 1) {
            thereIsOneLetter();
        } else {
            thereAreManyLetters(count);
        }
    }

    private void thereAreNoletters() {
        number = "no";
        verb = "are";
        pluralModifier = "s";
    }

    private void thereIsOneLetter() {
        number = "1";
        verb = "is";
        pluralModifier = "";
    }

    private void thereAreManyLetters(int count) {
        number = Integer.toString(count);
        verb = "are";
        pluralModifier = "s";
    }
}
