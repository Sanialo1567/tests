
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

class CalculatorTest {
    Calculator calculator;

    @BeforeTest
    public void setUp() {
        calculator = new Calculator();
    }

    @DataProvider(name = "SumTestData")
    public static Object[][] sumTestData() {
        return new Object[][]{
                {1, 1, 2},
                {5, -5, 0},
        };
    }

    @Test(dataProvider ="SumTestData" )
    public void dataProviderTest(double firstoperand, double secondoperand, double expectedSum) {
        Assertions.assertEquals(expectedSum, calculator.sum(firstoperand, secondoperand));
    }

    @Test
    void sumTest() {
        double expectedValue = 7.4f;
        Assertions.assertEquals(expectedValue, calculator.sum(2.4, 5), 0.1);
    }

    @Test
    void subtractionTest() {
        Calculator calculatorOne = new Calculator();
        Calculator calculatorSecond = new Calculator();
        Assertions.assertEquals(calculatorSecond.subtraction(4.5, 2.5), calculatorOne.subtraction(6, 4));

    }

    @Test
    void multiplicationTest() {
        double expectedValue = 40;
        Assertions.assertEquals(calculator.multiplication(8, 5), expectedValue);
    }

    @Test
    void divisionTest() {
        double expectedValue = 0.8;
        Assertions.assertEquals(calculator.division(4, 5), expectedValue);
    }

    @Test
    public void divideByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.division(4, 0));
    }

    @Test
    void getSin() {
        Assertions.assertEquals(calculator.getSin(Math.PI), 0, 0.1);
    }

    @Test
    public void getNegativeSin() {
        Assertions.assertDoesNotThrow(() -> calculator.getSin(-4));
    }

    @Test
    void getCos() {
        Assertions.assertEquals(calculator.getCos(Math.PI), 1, 0.1);
    }


    @Test
    void getTan() {
        Assertions.assertEquals(calculator.getTan(0), 0, 0.1);
    }

    @Test
    void checkTrigonometric() {
        Assertions.assertTrue(calculator.getCos(Math.PI) * calculator.getCos(Math.PI) + calculator.getSin(Math.PI) * calculator.getSin(Math.PI) == 1);
    }


}