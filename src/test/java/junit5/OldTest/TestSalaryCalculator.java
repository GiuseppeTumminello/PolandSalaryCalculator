package junit5.OldTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import org.example.oldWay.SalaryCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;


class TestSalaryCalculator {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor;
    private SalaryCalculator salaryCalculator;

    public TestSalaryCalculator() {
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
        //Assertions.assertEquals(expected, salaryCalculator.getZusTotal());
        //Using AssertJ
        assertThat(salaryCalculator.getZusTotal()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"6000, 465.97", "7000, 543.63", "15891.68, 1234.16"})
    void getHealthNfzTotal(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        //Assertions.assertEquals(expected, salaryCalculator.getHealthNfzTotal());
        assertThat(salaryCalculator.getHealthNfzTotal()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"6000, 391.99", "7000, 457.32", "15891.68, 1786.96"})
    void getAdvancePaymentTotal(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        //Assertions.assertEquals(expected, salaryCalculator.getAdvancePaymentTotal());
        assertThat(salaryCalculator).extracting(SalaryCalculator::getAdvancePaymentTotal).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"6000, 4319.44", "7000, 5039.35", "15891.68, 10691.80"})
    void getNet(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        //Assertions.assertEquals(expected, salaryCalculator.getNet());
        assertThat(salaryCalculator.getNet()).isEqualTo(expected);

    }

    @ParameterizedTest
    @CsvSource({"6000.,585.60", "7000, 683.20", "15891.68, 1551.03"})
    void getZusPension(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        //Assertions.assertEquals(expected, salaryCalculator.getZusPension());
        assertThat(salaryCalculator.getZusPension()).isEqualTo(expected);

    }

    @ParameterizedTest
    @CsvSource({"6000,90.00", "7000, 105.00", "15891.68, 238.38"})
    void getZusDisability(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        //Assertions.assertEquals(expected, salaryCalculator.getZusDisability());
        assertThat(salaryCalculator.getZusDisability()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"6000, 147.00", "7000, 171.50", "15891.68, 389.35"})
    void getZusSickness(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        //Assertions.assertEquals(expected, salaryCalculator.getZusSickness());
        assertThat(salaryCalculator.getZusSickness()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"6000, 72000.00", "7000, 84000.00", "15891.68, 190700.16"})
    void getAnnualSum(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        //Assertions.assertEquals(expected, salaryCalculator.getAnnualSum());
        assertThat(salaryCalculator.getAnnualSum()).isEqualTo(expected);
    }


    @ParameterizedTest
    @CsvSource({"6000, 6000", "7000, 7000", "15891.68, 15891.68"})
    void getGross(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        //Assertions.assertEquals(expected, salaryCalculator.getGross());
        assertThat(salaryCalculator.getGross()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"6000, 17", "7000, 17", "15891.68, 32"})
    void getTaxRate(BigDecimal input, int expected) {
        salaryCalculator = new SalaryCalculator(input);
        assertThat(salaryCalculator.getTaxRate()).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullSource
    void testNullCase(BigDecimal input) {
        salaryCalculator = new SalaryCalculator(input);
        //Assertions.assertEquals("Null value or Value less than 2000.00 cannot be passed", outputStreamCaptor
        // .toString().trim());
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(
                "Null value or Value less than 2000.00 cannot be passed");
    }


    @ParameterizedTest
    @CsvSource({"-2000.5515158151522615", "-1.7976931348623157E308", "1999.99", "0"})
    void testLessThanTwoThousand(BigDecimal input) {
        salaryCalculator = new SalaryCalculator(input);
        //Assertions.assertEquals("Null value or Value less than 2000.00 cannot be passed", outputStreamCaptor
        // .toString().trim());
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(
                "Null value or Value less than 2000.00 cannot be passed");
    }

    @Test
    void getZusPensionRate() {
        salaryCalculator = new SalaryCalculator(BigDecimal.valueOf(8000.0));
        assertThat(salaryCalculator.getZusPensionRate()).isEqualTo(9.76);
    }

    @Test
    public void getZusDisabilityRate() {
        salaryCalculator = new SalaryCalculator(BigDecimal.valueOf(8000.0));
        assertThat(salaryCalculator.getZusDisabilityRate()).isEqualTo(1.50);
    }

    @Test
    public void getZusSicknessRate() {
        salaryCalculator = new SalaryCalculator(BigDecimal.valueOf(8000.0));
        assertThat(salaryCalculator.getZusSicknessRate()).isEqualTo(2.45);
    }

    @Test
    public void getHealthNFZRate() {
        salaryCalculator = new SalaryCalculator(BigDecimal.valueOf(8000.0));
        assertThat(salaryCalculator.getHealthNFZRate()).isEqualTo(9.0);
    }

}