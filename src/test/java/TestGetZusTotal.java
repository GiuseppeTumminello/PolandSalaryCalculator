import org.example.SalaryCalculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class TestGetZusTotal {


    private SalaryCalculator salaryCalculator;
    private double gross;
    private double expected;

    public TestGetZusTotal(double gross, double expected) {
        this.salaryCalculator = new SalaryCalculator(gross);
        this.gross = gross;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
                {6000.0, 822.6},
                {7000.0, 959.7},
                {8000.0, 1096.8},
                {15000.0, 2056.5},
                {20000.0, 2742.0},

        });
    }

    @Test
    public void getZusTotalTest() {
        salaryCalculator.setGross(gross);
        Assert.assertEquals(expected, salaryCalculator.getZusTotal(), 0.000001);
    }


}
