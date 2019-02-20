package safeUnwrap;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class AnotherConsumerShould {

    private AnotherConsumer sut = new AnotherConsumer();

    @Test
    public void getAmount() {
        int result = sut.getAmount(new Model("agua", 5));

        assertThat(result, equalTo(5));
    }
}