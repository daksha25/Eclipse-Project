package cobertura;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void shouldCalculateFibonacci() {
        calculator calculator1 = new calculator();
        int expected = 13;
        int actual = calculator1.nextFibonacci(5, 8);

        assertThat(actual, is(expected));
    }
}