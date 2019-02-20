package untestableLegacy;

import java.util.ArrayList;
import java.util.List;

public class StringToCharConverter {

    List<Character> convertStringToCharacterList(String fromName) {
        final List<Character> chars = new ArrayList();
        for (char c : fromName.toCharArray()) {
            chars.add(c);
        }
        return chars;
    }
}