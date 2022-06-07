package junit5;

import org.example.SalaryCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;


class SalaryCalculatorTest {

    private SalaryCalculator salaryCalculator;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor;

    public SalaryCalculatorTest() {
        this.outputStreamCaptor = new ByteArrayOutputStream();

    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));

    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);


    }

    @ParameterizedTest
    @CsvSource({"6000, 822.60", "7000, 959.70", "15891.68, 2178.76"})
    void getZusTotal(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        Assertions.assertEquals(expected, salaryCalculator.getZusTotal());
    }

    @ParameterizedTest
    @CsvSource({"6000, 465.97", "7000, 543.63", "15891.68, 1234.16"})
    void getHealthNfzTotal(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        Assertions.assertEquals(expected, salaryCalculator.getHealthNfzTotal());
    }

    @ParameterizedTest
    @CsvSource({"6000, 391.99", "7000, 457.32", "15891.68, 1786.96"})
    void getAdvancePaymentTotal(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        Assertions.assertEquals(expected, salaryCalculator.getAdvancePaymentTotal());
    }

    @ParameterizedTest
    @CsvSource({"6000, 4319.44", "7000, 5039.35", "15891.68, 10691.80"})
    void getNet(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        Assertions.assertEquals(expected, salaryCalculator.getNet());

    }

    @ParameterizedTest
    @CsvSource({"6000.,585.60", "7000, 683.20", "15891.68, 1551.03"})
    void getZusPension(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        Assertions.assertEquals(expected, salaryCalculator.getZusPension());

    }

    @ParameterizedTest
    @CsvSource({"6000,90.00", "7000, 105.00", "15891.68, 238.38"})
    void getZusDisability(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        Assertions.assertEquals(expected, salaryCalculator.getZusDisability());
    }

    @ParameterizedTest
    @CsvSource({"6000, 147.00", "7000, 171.50", "15891.68, 389.35"})
    void getZusSickness(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        Assertions.assertEquals(expected, salaryCalculator.getZusSickness());
    }

    @ParameterizedTest
    @CsvSource({"6000, 72000.00", "7000, 84000.00", "15891.68, 190700.16"})
    void getAnnualSum(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        Assertions.assertEquals(expected, salaryCalculator.getAnnualSum());
    }


    @ParameterizedTest
    @CsvSource({"6000, 6000", "7000, 7000", "15891.68, 15891.68"})
    void getGross(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        Assertions.assertEquals(expected, salaryCalculator.getGross());
    }

    @ParameterizedTest
    @CsvSource({"6000, 17", "7000, 17", "15891.68, 32"})
    void getTaxRate(BigDecimal input, int expected) {
        salaryCalculator = new SalaryCalculator(input);
        Assertions.assertEquals(expected, salaryCalculator.getTaxRate());
    }

    @ParameterizedTest
    @NullSource
    void testNullCase(BigDecimal input) {
        salaryCalculator = new SalaryCalculator(input);
        Assertions.assertEquals("Null value or Value less than 2000.00 cannot be passed", outputStreamCaptor.toString().trim());
    }


    @ParameterizedTest
    @CsvSource({"-2000.5515158151522615", "-1.7976931348623157E308", "1999.99", "0"})
    void testLessThanTwoThousand(BigDecimal input) {
        salaryCalculator = new SalaryCalculator(input);
        Assertions.assertEquals("Null value or Value less than 2000.00 cannot be passed", outputStreamCaptor.toString().trim());
    }


}