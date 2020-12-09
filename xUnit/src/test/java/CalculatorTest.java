import org.junit.Test;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    public static Object[][] sumTestData() {
        return new Object[][]{
                {1, 1, 2},
                {5, -5, 0},
        };
    }

    @ParameterizedTest
    @MethodSource("sumTestData")
    public void dataProviderTest(double firstoperand, double secondoperand, double expectedSum) {
        Assertions.assertEquals(expectedSum, calculator.sum(firstoperand, secondoperand));
    }

    @Test
    void sumTest() {
        double expectedValue = 7.4f;
        Assert.assertEquals(expectedValue, calculator.sum(2.4, 5), 0.1);
    }

    @Test
    void subtractionTest() {
        Calculator calculatorOne = new Calculator();
        Calculator calculatorSecond = new Calculator();
        Assert.assertEquals(calculatorSecond.subtraction(4.5, 2.5), calculatorOne.subtraction(8, 4));

    }

    @Test
    void multiplicationTest() {
        double expectedValue = 40;
        Assert.assertEquals(calculator.multiplication(8, 5), expectedValue);
    }

    @Test
    void divisionTest() {
        double expectedValue = 0.8;
        assertEquals(calculator.division(4, 5), expectedValue);
    }

    @Test
    public void divideByZero() {
        Assert.assertThrows(ArithmeticException.class, () -> calculator.division(4, 0));
    }

    @Test
    void getSin() {
        Assert.assertEquals(calculator.getSin(Math.PI), 0, 0.1);
    }

    @Test
    public void getNegativeSin() {
        Assert.assertDoesNotThrow(() -> calculator.getSin(-4));
    }

    @Test
    void getCos() {
        assertEquals(calculator.getCos(Math.PI), 1, 0.1);
    }


    @Test
    void getTan() {
        Assert.assertEquals(calculator.getTan(0), 0, 0.1);
    }

    @Test
    void checkTrigonometric() {
        Assert.assertTrue(calculator.getCos(Math.PI) * calculator.getCos(Math.PI) + calculator.getSin(Math.PI) * calculator.getSin(Math.PI) == 1);
    }


}