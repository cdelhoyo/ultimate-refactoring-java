package untestableLegacy;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class LoggerShould {

    private Logger sut = new Logger();

    @Test
    public void print_words() {
        Logger spySut = spy(sut);

        spySut.printWords("Hola pepe");

        verify(spySut).print("<Hola>");
        verify(spySut).print("<pepe>");
    }
}