import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.*;

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

    @Test
    @Order(3)
    void connectToSpecificDatabase() {
        Assertions.assertDoesNotThrow(() -> connect("testoo"));
    }

    @Test
    @Order(4)
    void createTable() {
        Assertions.assertDoesNotThrow(() -> {
            Connection c = connect("testoo");

            Statement s = c.createStatement();
            s.executeUpdate("CREATE TABLE testootable (mycolumn VARCHAR(255) NULL)");

            s.close();
            c.close();
        });
    }

    @Test
    @Order(5)
    void insertIntoTable() {
        Assertions.assertDoesNotThrow(() -> {
            Connection c = connect("testoo");

            Statement s = c.createStatement();
            s.executeUpdate("INSERT INTO testootable (mycolumn) VALUES ('random txt')");

            s.close();
            c.close();
        });
    }

    @Test
    @Order(6)
    void selectFromTable() {
        Assertions.assertDoesNotThrow(() -> {
            Connection c = connect("testoo");

            Statement s = c.createStatement();
            ResultSet res = s.executeQuery("SELECT * FROM testoo");

            if (res.first()) {
                Assertions.assertEquals(res.getString("mycolumn"), "random txt");
            }

            s.close();
            c.close();
        });
    }

    @Test
    @Order(7)
    void dropFromTable() {
        Assertions.assertDoesNotThrow(() -> {
            Connection c = connect("testoo");

            Statement s = c.createStatement();
            ResultSet res = s.executeQuery("DROP * FROM testoo");

            s.close();
            c.close();
        });
    }

    @Test
    @Order(8)
    void dropTable() {
        Assertions.assertDoesNotThrow(() -> {
            Connection c = connect("testoo");

            Statement s = c.createStatement();
            s.executeUpdate("DROP TABLE testootable");

            s.close();
            c.close();
        });
    }

    @Test
    @Order(9)
    void dropDatabase() {
        Assertions.assertDoesNotThrow(() -> {
            Connection c = connect("");

            Statement s = c.createStatement();
            s.executeUpdate("DROP DATABASE testoo");

            s.close();
            c.close();
        });
    }

}