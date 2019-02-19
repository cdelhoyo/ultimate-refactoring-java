package unit;

import valueAndReference.SomeType;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class YouShouldUnderstandValuesAndReferences {
    @Test
    public void because_its_fundamental() throws Exception {
        SomeType instance = new SomeType();

        String arg1 = "bar";
        instance.firstMethod(arg1);
        assertThat(arg1).isEqualTo("bar");

        SomeType other = new SomeType();
        other.numbers[0] = 100;
        instance.secondMethod(other);
        assertThat(other.numbers[0]).isEqualTo(100);
        assertThat(other.someField).isEqualTo(null);

        SomeType another = new SomeType();
        another.numbers[0] = 200;
        instance.thirdMethod(another);
        assertThat(another.numbers[0]).isEqualTo(100);
        assertThat(another.someField).isEqualTo("changed");
        assertThat(another.child).isNotNull();

        SomeType yetAnother = new SomeType();
        yetAnother.numbers[0] = 200;
        instance.fourthMethod(yetAnother.numbers);
        assertThat(yetAnother.numbers[0]).isEqualTo(0);
    }
}
