package safeUnwrap;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ConsumerShould {

    private Consumer sut = new Consumer();

    @Test
    public void getAmount() {
        String result = sut.getColor(new Model("agua", 5));

        assertThat(result, equalTo("agua"));
    }
}