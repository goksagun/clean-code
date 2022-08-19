package guess;

public class MessagePrinter {
    public static void main(String[] args) {
        GuessStatisticsMessage message = new GuessStatisticsMessage();
        System.out.println(message.make('a', 10));;
    }
}
