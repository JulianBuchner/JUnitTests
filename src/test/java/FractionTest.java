import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class FractionTest {
    private Connection connect(String db) throws SQLException {
        Connection conn = null;

        if (db.length() > 0) {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
        } else {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, "root", "root");
        }

        return conn;
    }

    // lambda geht nur bei Interfaces die nur EINE Methode hat
    @Test
    @Order(1)
    void connectToDatabase() {
        Assertions.assertDoesNotThrow(() -> connect(""));
    }

    @Test
    @Order(2)
    void createDatabase() {
        Assertions.assertDoesNotThrow(() -> {
            Connection c = connect("");

            Statement s = c.createStatement();
            s.executeUpdate("CREATE DATABASE testoo");

            s.close();
            c.close();
        });
    }

    @org.junit.jupiter.api.Test
    void constructorTest() {
        // check normal use
        Fraction f1 = new Fraction(1, 1);
        Assertions.assertEquals("1 / 1", f1.toString());

        // check negative numbers
        Fraction f2 = new Fraction(1, -1);
        Assertions.assertEquals("1 / -1", f2.toString());

        // check two negative numbers
        Fraction f3 = new Fraction(-1, -1);
        Assertions.assertEquals("1 / 1", f3.toString());

        // check if the divisor is 0
        Fraction f4 = new Fraction(1, 0);
        Assertions.assertEquals("1 / 1", f4.toString());
    }


    @org.junit.jupiter.api.Test
    void getDividend() {
        // normal value
        Fraction f = new Fraction(1, 10);
        Assertions.assertEquals(1, f.getDividend());

        // negative value
        Fraction f2 = new Fraction(-1, 10);
        Assertions.assertEquals(-1, f2.getDividend());

        // 0 value
        Fraction f3 = new Fraction(0, 10);
        Assertions.assertEquals(0, f3.getDividend());
    }

    @org.junit.jupiter.api.Test
    void setDividend() {
        // normal value
        Fraction f = new Fraction(1, 10);
        f.setDividend(2);

        Assertions.assertEquals(2, f.getDividend());

        // negative value
        Fraction f2 = new Fraction(1, 10);
        f2.setDividend(-1);

        Assertions.assertEquals(-1, f2.getDividend());

        // 0 value
        Fraction f3 = new Fraction(0, 10);
        f3.setDividend(0);

        Assertions.assertEquals(0, f3.getDividend());
    }

    @org.junit.jupiter.api.Test
    void getDivisor() {
        // normal
        Fraction f = new Fraction(1, 10);
        Assertions.assertEquals(10, f.getDivisor());

        // negative value
        Fraction f2 = new Fraction(1, -10);
        Assertions.assertEquals(-10, f2.getDivisor());

        // 0 value
        Fraction f3 = new Fraction(1, 0);
        Assertions.assertEquals(1, f3.getDivisor());
    }

    @org.junit.jupiter.api.Test
    void setDivisor() {
        Fraction f = new Fraction(1, 10);
        try {
            f.setDivisor(20);
        } catch (Exception ignored) {
        }

        Assertions.assertEquals(20, f.getDivisor());

        // negative value
        Fraction f2 = new Fraction(1, 10);
        try {
            f2.setDivisor(-1);
        } catch (Exception ignored) {
        }

        Assertions.assertEquals(-1, f2.getDivisor());

        // 0 value
        Fraction f3 = new Fraction(1, 10);
        try {
            f3.setDivisor(0);
        } catch (Exception e) {
            Assertions.assertEquals("can't divide through 0", e.getMessage());
        }

        Assertions.assertEquals(10, f3.getDivisor());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        // normal
        Fraction f = new Fraction(17, 3);
        Assertions.assertEquals("17 / 3", f.toString());

        // negative 1
        Fraction f2 = new Fraction(-17, 3);
        Assertions.assertEquals("-17 / 3", f2.toString());

        // negative 2
        Fraction f3 = new Fraction(17, -3);
        Assertions.assertEquals("17 / -3", f3.toString());

        // negative 3
        Fraction f4 = new Fraction(-17, -3);
        Assertions.assertEquals("17 / 3", f4.toString());

        // 0 value 1
        Fraction f5 = new Fraction(0, 3);
        Assertions.assertEquals("0 / 3", f5.toString());

        // 0 value 2
        Fraction f6 = new Fraction(1, 0);
        Assertions.assertEquals("1 / 1", f6.toString());
    }

    @Test
    void add() {
        Fraction f1 = new Fraction(12, 78);
        Fraction f2 = new Fraction(4, 6);

        Fraction result = f1.add(f2).shorten();

        Assertions.assertEquals(32, result.getDividend());
        Assertions.assertEquals(39, result.getDivisor());
    }

    @Test
    void sub() {
        Fraction f1 = new Fraction(1, 70);
        Fraction f2 = new Fraction(2, 90);

        Fraction result = f1.subtract(f2).shorten();
        Assertions.assertEquals(-1, result.getDividend());
        Assertions.assertEquals(126, result.getDivisor());
    }

    @Test
    void mul() {
        Fraction f1 = new Fraction(1, 27);
        Fraction f2 = new Fraction(9, 44);

        Fraction result = f1.multiply(f2).shorten();
        Assertions.assertEquals(1, result.getDividend());
        Assertions.assertEquals(132, result.getDivisor());
    }

    @Test
    void div() {
        Fraction f1 = new Fraction(1, 27);
        Fraction f2 = new Fraction(9, 44);

        Fraction result = f1.divide(f2).shorten();

        Assertions.assertEquals(44, result.getDividend());
        Assertions.assertEquals(243, result.getDivisor());
    }

    @Test
    void shorten() {
        // normal
        Fraction f = new Fraction(56, 528);
        f.shorten();
        Assertions.assertEquals(7, f.getDividend());
        Assertions.assertEquals(66, f.getDivisor());

        // negative 1
        Fraction f1 = new Fraction(-56, 528);
        f1.shorten();
        Assertions.assertEquals(-7, f1.getDividend());
        Assertions.assertEquals(66, f1.getDivisor());

        // negative 2
        Fraction f2 = new Fraction(56, -528);
        f2.shorten();
        Assertions.assertEquals(7, f2.getDividend());
        Assertions.assertEquals(-66, f2.getDivisor());


    }
}