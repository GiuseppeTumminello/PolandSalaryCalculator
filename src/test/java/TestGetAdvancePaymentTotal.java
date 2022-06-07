import org.example.SalaryCalculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestGetAdvancePaymentTotal {

    private SalaryCalculator salaryCalculator;
    private double gross;
    private double expected;

    public TestGetAdvancePaymentTotal(double gross, double expected) {
        this.salaryCalculator = new SalaryCalculator(gross);
        this.gross = gross;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
                {6000.0, 391.99130880000007},
                {7000.0, 543.627},
                {8000.0, 621.288},
                {15000.0, 1164.915},
                {20000.0, 1553.22},

        });
    }

    @Test
    public void getZusTotalTest() {
        salaryCalculator.setGross(gross);
        Assert.assertEquals(expected, salaryCalculator.getAdvancePaymentTotal(), 0.000001);
    }


}
