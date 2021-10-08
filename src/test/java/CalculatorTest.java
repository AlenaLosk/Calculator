import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeTest
    public void beforeClass() {
        this.calculator = new Calculator();
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {"4", "+", "2", "6"},
                {"10", "/", "2", "5"},
                {"-60", ":", "3", "-20"},
                {"70", "*", "30", "2100"},
                {"29", "-", "40", "-11"},
                {"0", "*", "-71", "0"},
                {"-0", "/", "1", "0"}
        };
    }

    @DataProvider
    public Object[][] testDataNegative() {
        return new Object[][]{
                {"-abd", "/", "100", "0"},
                {"15", "+", "Cucu", "15"},
                {"136aopp", "+", "2", "68"},
                {"0", "*", "2$lk", "0"},
                {"24,12", "/", "2", "12,06"},
                {"100", "*", "0,25", "25"},
                {"186", "+", "4.04", "190,04"},
                {"4.575", ":", "1.5", "3.05"},
        };
    }

    @DataProvider
    public Object[][] testDataBorder() {
        return new Object[][]{
                {String.valueOf(Integer.MAX_VALUE), "+", "2", "2147483649"},
                {String.valueOf(Integer.MIN_VALUE), "-", "5", "-2147483653"},
                {"-10", "-", "2147483648", "-2147483658"},
                {"15", "+", "2147483640", "2147483655"},
                {"10737418275", "/", "5", "2147483655"},
                {"1073741824", "*", "2", "2147483648"},
        };
    }

    @DataProvider
    public Object[][] testDataException() {
        return new Object[][]{
                {"0", "/", "0", "0"},
                {"-10", "/", "-0", "-0"},
                {"54", "^", "1", "54"},
        };
    }

    @Test(dataProvider = "testData")
    public void testCalculate(String one, String operation, String two, String result) throws Exception {
        Assert.assertEquals(calculator.calculate(one, operation, two), result, "Значение не соответствует ожидаемому!");
    }

    @Test(dataProvider = "testDataNegative")
    public void testCalculateNegative(String one, String operation, String two, String result) throws Exception {
        Assert.assertNotEquals(calculator.calculate(one, operation, two), result, "Значение не соответствует ожидаемому!");
    }

    @Test(dataProvider = "testDataBorder")
    public void testCalculateBorder(String one, String operation, String two, String result) throws Exception {
        Assert.assertNotEquals(calculator.calculate(one, operation, two), result, "Значение не соответствует ожидаемому!");
    }

    @Test(dataProvider = "testDataException", expectedExceptions = Exception.class)
    public void testCalculateException(String one, String operation, String two, String result) throws Exception {
        Assert.assertNotEquals(calculator.calculate(one, operation, two), result, "Значение не соответствует ожидаемому!");
    }
}