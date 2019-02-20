package untestableLegacy;

/*
 * This code has been extracted from OpenbravoERP:
 * https://code.openbravo.com/erp/stable/2.50-bp/file/cec9b1da72ed/src/org/openbravo/base/model/Entity.java
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FormatNameService {

    private static final List<Character> ILLEGAL_ENTITY_NAME_CHARS = Arrays.asList('*', '?');
    private static final String NORMAL_CHARACTER_REGEX = "[A-Za-z0-9_]";

    private final StringToCharConverter stringToCharConverter;
    private final Log log;

    public FormatNameService(Log log, StringToCharConverter stringToCharConverter) {
        this.log = log;
        this.stringToCharConverter = stringToCharConverter;
    }

    protected String removeIllegalChars(String fromName) {
        final List<Character> chars = stringToCharConverter.convertStringToCharacterList(fromName);

        String newName = chars.stream()
                .filter(character -> !ILLEGAL_ENTITY_NAME_CHARS.contains(character))
                .map(character -> character.toString())
                .collect(Collectors.joining(""));

        boolean namedChanged = !fromName.equals(newName);
        if (namedChanged) {
            logIllegalCharactes(fromName, newName);
        } else {
            logExtrangeCharactersIfExists(fromName);
        }
        return newName;
    }

    private void logIllegalCharactes(String fromName, String newName) {
        log.warn("The entity name " + fromName + " contains illegal characters, it has been repaired to " + newName);
    }

    private void logExtrangeCharactersIfExists(String fromName) {
        List<String> characters = Arrays.asList(fromName.trim().split(""));
        characters.stream()
                .filter(this::isExtrangeCharacter)
                .forEach(letter -> logExtrangeCharacter(fromName, letter));
    }


    private void logExtrangeCharacter(String fromName, String letter) {
        log.warn("The entity name " + fromName + " contains a character (" + letter
                + ") which could result in issues in HQL or "
                + "webservices. Use characters from a to z, A to Z or 0 to 9 or the _");
    }

    private boolean isExtrangeCharacter(String letter) {
        return !letter.matches(NORMAL_CHARACTER_REGEX);
    }

}
