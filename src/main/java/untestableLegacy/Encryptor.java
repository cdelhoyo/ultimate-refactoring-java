package untestableLegacy;

import java.security.InvalidParameterException;

public class Encryptor {

    public String cryptWord(String word) {
        if (word.contains(" "))
            throw new InvalidParameterException();

        return crypt(word, word);
    }

    public String cryptWord(String word, String charsToReplace) {
        if (word.contains(" "))
            throw new InvalidParameterException();

        return crypt(word, charsToReplace);
    }


    public String cryptWordToNumbers(String word) {
        if (word.contains(" "))
            throw new InvalidParameterException();

        String cryptWord = crypt(word, word);
        return convertEachCharToNumber(cryptWord);
    }

    public String cryptSentence(String sentence) {
        return crypt(sentence, sentence);
    }

    private String convertEachCharToNumber(String word) {
        char[] wordArray = word.toCharArray();
        String newWord = "";
        for (int i = 0; i < word.length(); i++) {
            int charValue = wordArray[i];
            newWord += String.valueOf(charValue);
        }
        return newWord;
    }

    private String crypt(String sentence, String charsToReplace) {
        char[] wordArray = sentence.toCharArray();
        char[] replacement = charsToReplace.toCharArray();
        char[] result = wordArray.clone();
        for (int i = 0; i < wordArray.length; i++) {
            for (int j = 0; j < replacement.length; j++) {
                if (replacement[j] == wordArray[i]) {
                    int charValue = wordArray[i];
                    result[i] = (char) (charValue + 2);
                }
            }
        }
        return String.valueOf(result);
    }

}
