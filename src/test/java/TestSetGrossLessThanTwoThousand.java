import org.example.SalaryCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestSetGrossLessThanTwoThousand {
    private SalaryCalculator salaryCalculator;
    private double gross;

    public TestSetGrossLessThanTwoThousand(double gross) {
        this.salaryCalculator = new SalaryCalculator(gross);
        this.gross = gross;
    }

    @Parameterized.Parameters
    public static Collection<Object> data(){
        return Arrays.asList(new Object[][]{
                {1000.0},
                {1999.0},
                {-2000},
                {0.0}
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void lessThanZero(){
        salaryCalculator.setGross(gross);
    }




}
