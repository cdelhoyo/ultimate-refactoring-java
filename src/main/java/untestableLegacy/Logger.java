package untestableLegacy;

public class Logger {

    public void printWords(String sentence) {
        String[] words = sentence.split(" ");
        for (String word : words) {
            String formatWord = "<" + word + ">";
            print(formatWord);
        }
    }

    protected void print(String text) {
        System.out.print(text);
    }
}