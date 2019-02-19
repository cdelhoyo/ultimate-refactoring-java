package untestableLegacy;

/*
 * This code has been extracted from OpenbravoERP:
 * https://code.openbravo.com/erp/stable/2.50-bp/file/cec9b1da72ed/src/org/openbravo/base/model/Entity.java
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Log{
	public void warn(String msg){
		System.out.println(msg);
	}
}

public class Entity {
	private static final List<Character> ILLEGAL_ENTITY_NAME_CHARS = Arrays.asList('*', '?');
	private String name;
	public final Log log;

	public Entity(Log log){
		this.log = log;
	}
	
	public void setName(String name) {
	    // repair the name if it contains any illegal character
	    this.name = removeIllegalChars(name);
	  }

	  protected String removeIllegalChars(String fromName) {
		  final List<Character> chars = convertStringToCharacterList(fromName);

		  String newName = chars.stream()
			.filter(character -> !ILLEGAL_ENTITY_NAME_CHARS.contains(character))
			.map(character -> character.toString())
			.collect(Collectors.joining(""));

		  boolean namedChanged = !fromName.equals(newName);
		  if (namedChanged) {
	      log.warn("The entity name " + fromName
	          + " contains illegal characters, it has been repaired to " + newName);
	    } else {
	      // check for other less normal characters
	      for (char c : fromName.trim().toCharArray()) {
	        final boolean normalChar = ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9')
	            || ('a' <= c && c <= 'z') || c == '_';
	        if (!normalChar) {
	          log.warn("The entity name " + fromName + " contains a character (" + c
	              + ") which could result in issues in HQL or "
	              + "webservices. Use characters from a to z, A to Z or 0 to 9 or the _");
	        }
	      }
	    }
	    return newName;
	  }

	private List<Character> convertStringToCharacterList(String fromName) {
		final List<Character> chars = new ArrayList();
		for(char c : fromName.toCharArray()) {
			chars.add(c);
		}
		return chars;
	}


}
