package untestableLegacy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class EncryptorShould {

    Encryptor encryptor = new Encryptor();

    @Test(expected = IllegalArgumentException.class)
    public void throw_exception_crypting_sentence_when_crypt_word() {
        encryptor.cryptWord("Hola pepe");
    }

    @Test
    public void crypt_a_word_when_crypt_word() {
        String cryptWord = encryptor.cryptWord("pepe");

        assertThat("rgrg", equalTo(cryptWord));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throw_exception_crypting_sentence_when_crypt_word_to_numbers() {
        encryptor.cryptWordToNumbers("Hola pepe");
    }


    @Test
    public void crypt_a_word_when_crypt_word_to_numbers() {
        String cryptWord = encryptor.cryptWordToNumbers("pepe");

        assertThat("114103114103", equalTo(cryptWord));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throw_exception_crypting_sentence_when_crypt_word_with_char_replace() {
        encryptor.cryptWord("Hola pepe","p" );
    }


    @Test
    public void crypt_a_word_when_crypt_word_to_numbers_with_char_replace() {
        String cryptWord = encryptor.cryptWord("pepa", "pa");

        assertThat("rerc", equalTo(cryptWord));
    }

    @Test
    public void crypt_a_sentence_when_crypt_a_sentence() {
        String cryptSentence = encryptor.cryptSentence("pepa es de la mejor isla de canarias");

        assertThat("rgrc\"gu\"fg\"nc\"oglqt\"kunc\"fg\"ecpctkcu", equalTo(cryptSentence));
    }
}