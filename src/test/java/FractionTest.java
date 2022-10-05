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

        Assertions.assertEquals(11, f.getDivisor());
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

    @Test
    void add() {
        Fraction f1 = new Fraction(10, 5);
        Fraction f2 = new Fraction(15, 10);

        Fraction f = f1.add(f2);

        Assertions.assertEquals("175 / 100", f.toString());
    }

    @Test
    void subtract() {
        Fraction f1 = new Fraction(10, 5);
        Fraction f2 = new Fraction(15, 10);

        Fraction f = f1.subtract(f2);

        Assertions.assertEquals("25 / 0", f.toString());
    }

    @Test
    void divide() {
        Fraction f1 = new Fraction(10, 5);
        Fraction f2 = new Fraction(15, 10);

        Fraction f = f1.divide(f2);

        Assertions.assertEquals("100 / 75", f.toString());
    }

    @Test
    void multiply() {
        Fraction f1 = new Fraction(10, 5);
        Fraction f2 = new Fraction(15, 10);

        Fraction f = f1.multiply(f2);

        Assertions.assertEquals("150 / 50", f.toString());
    }

    @Test
    void shorten() {
        Fraction f = new Fraction(20, 100);

        f.shorten();

        Assertions.assertEquals("1 / 5", f.toString());
    }
}