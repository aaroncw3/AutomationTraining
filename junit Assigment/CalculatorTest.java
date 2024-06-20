import org.example.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testSum() {
        Calculator calc = new Calculator();
        int result = calc.sum(3, 2);
        assertEquals(5, result);
    }

    @Test
    public void testDiff() {
        Calculator calc = new Calculator();
        int result = calc.diff(5, 3);
        assertEquals(2, result);
    }
}
