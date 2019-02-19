package unit;

import moveResponsibility.Calculator;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorShould {
    @Test
    public void add_numbers() throws Exception {
        Calculator calculator = new Calculator();
        assertThat(calculator.add(2,2)).isEqualTo(4);
    }

    @Test
    public void substract_numbers() throws Exception {
        Calculator calculator = new Calculator();
        assertThat(calculator.substract(2,2)).isEqualTo(0);
    }
}
