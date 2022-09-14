import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    @Test
    void getDividend() {
        Fraction f = new Fraction(1, 16);

        Assertions.assertEquals(1, f.getDividend());
    }

    @Test
    void setDividend() {
        Fraction f = new Fraction(1, 16);
        f.setDividend(2);

        Assertions.assertEquals(2, f.getDividend());
    }

    @Test
    void getDivisor() {
        Fraction f = new Fraction(1, 10);

        Assertions.assertEquals(10, f.getDivisor());
    }

    @Test
    void setDivisor() {
        Fraction f = new Fraction(1, 10);
        f.setDivisor(20);

        Assertions.assertEquals(20, f.getDivisor());
    }

    @Test
    void testToString() {
        Fraction f = new Fraction(17, 3);

        Assertions.assertEquals("17 / 3", f.toString());
    }
}