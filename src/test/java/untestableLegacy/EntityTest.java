package untestableLegacy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class EntityTest {

    private Log log = mock(Log.class);
    private Entity sut = new Entity(log);

    @Test
    public void removeIllegalCharsShouldRemoveQuestion() {
        String withOutQuestion = sut.removeIllegalChars("sdfdsf?sdasd");

        assertThat(withOutQuestion, equalTo("sdfdsfsdasd"));
    }

    @Test
    public void removeIllegalCharsShouldRemoveStar() {
        String withOutQuestion = sut.removeIllegalChars("sdfdsfsdasd*");

        assertThat(withOutQuestion, equalTo("sdfdsfsdasd"));
    }

    @Test
    public void removeIllegalCharsShouldDoNothingIfNoHasStarOrQuestion() {
        String withOutQuestion = sut.removeIllegalChars("sdfdsfsdasd");

        assertThat(withOutQuestion, equalTo("sdfdsfsdasd"));
    }

    @Test
    public void removeIllegalCharsShouldLogIfHasExtrangeCharAndNotRemoveIt() {
        String withOutQuestion = sut.removeIllegalChars("sdfdsfs/dasd");

        verify(log).warn(contains("contains a character (/)"));
        verify(log, times(0)).warn(contains("contains illegal characters"));
        assertThat(withOutQuestion, equalTo("sdfdsfs/dasd"));
    }

    @Test
    public void removeIllegalCharsShouldNotLogExtrangeCharIfHasIllegalChars() {
        String withOutQuestion = sut.removeIllegalChars("sdfdsfs/*dasd");

        verify(log, times(0)).warn(contains("contains a character (/)"));
        verify(log).warn(contains("contains illegal characters"));
        assertThat(withOutQuestion, equalTo("sdfdsfs/dasd"));
    }
}