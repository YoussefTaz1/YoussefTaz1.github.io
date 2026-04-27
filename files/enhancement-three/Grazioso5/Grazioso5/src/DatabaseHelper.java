import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseHelper {

    // Enhancement category 3 change:
    // Added a database file so animal data can be stored permanently.
    private static final String DB_URL = "jdbc:sqlite:grazioso.db";

    // Enhancement category 3 change:
    // Added one shared connection method for all database operations.
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // Enhancement category 3 change:
    // Creates the dogs and monkeys tables if they do not already exist.
    public static void createTables() {
        String createDogsTable = "CREATE TABLE IF NOT EXISTS dogs ("
                + "name TEXT PRIMARY KEY,"
                + "breed TEXT NOT NULL,"
                + "gender TEXT NOT NULL,"
                + "age TEXT NOT NULL,"
                + "weight TEXT NOT NULL,"
                + "acquisitionDate TEXT NOT NULL,"
                + "acquisitionCountry TEXT NOT NULL,"
                + "trainingStatus TEXT NOT NULL,"
                + "reserved INTEGER NOT NULL,"
                + "inServiceCountry TEXT NOT NULL"
                + ");";

        String createMonkeysTable = "CREATE TABLE IF NOT EXISTS monkeys ("
                + "name TEXT PRIMARY KEY,"
                + "gender TEXT NOT NULL,"
                + "age TEXT NOT NULL,"
                + "weight TEXT NOT NULL,"
                + "acquisitionDate TEXT NOT NULL,"
                + "acquisitionCountry TEXT NOT NULL,"
                + "trainingStatus TEXT NOT NULL,"
                + "reserved INTEGER NOT NULL,"
                + "inServiceCountry TEXT NOT NULL,"
                + "tailLength TEXT NOT NULL,"
                + "height TEXT NOT NULL,"
                + "bodyLength TEXT NOT NULL,"
                + "species TEXT NOT NULL"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(createDogsTable);
            stmt.execute(createMonkeysTable);

        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }

    // Enhancement category 3 change:
    // Checks whether a dog already exists in the database by name.
    public static boolean dogExists(String name) {
        String sql = "SELECT name FROM dogs WHERE LOWER(name) = LOWER(?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            System.out.println("Error checking dog: " + e.getMessage());
            return false;
        }
    }

    // Enhancement category 3 change:
    // Checks whether a monkey already exists in the database by name.
    public static boolean monkeyExists(String name) {
        String sql = "SELECT name FROM monkeys WHERE LOWER(name) = LOWER(?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            System.out.println("Error checking monkey: " + e.getMessage());
            return false;
        }
    }

    // Enhancement category 3 change:
    // Inserts a new dog record into the database.
    public static void insertDog(Dog dog) {
        String sql = "INSERT INTO dogs(name, breed, gender, age, weight, acquisitionDate, "
                + "acquisitionCountry, trainingStatus, reserved, inServiceCountry) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, dog.getName());
            pstmt.setString(2, dog.getBreed());
            pstmt.setString(3, dog.getGender());
            pstmt.setString(4, dog.getAge());
            pstmt.setString(5, dog.getWeight());
            pstmt.setString(6, dog.getAcquisitionDate());
            pstmt.setString(7, dog.getAcquisitionLocation());
            pstmt.setString(8, dog.getTrainingStatus());
            pstmt.setInt(9, dog.getReserved() ? 1 : 0);
            pstmt.setString(10, dog.getInServiceCountry());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error inserting dog: " + e.getMessage());
        }
    }

    // Enhancement category 3 change:
    // Inserts a new monkey record into the database.
    public static void insertMonkey(Monkey monkey) {
        String sql = "INSERT INTO monkeys(name, gender, age, weight, acquisitionDate, "
                + "acquisitionCountry, trainingStatus, reserved, inServiceCountry, "
                + "tailLength, height, bodyLength, species) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, monkey.getName());
            pstmt.setString(2, monkey.getGender());
            pstmt.setString(3, monkey.getAge());
            pstmt.setString(4, monkey.getWeight());
            pstmt.setString(5, monkey.getAcquisitionDate());
            pstmt.setString(6, monkey.getAcquisitionLocation());
            pstmt.setString(7, monkey.getTrainingStatus());
            pstmt.setInt(8, monkey.getReserved() ? 1 : 0);
            pstmt.setString(9, monkey.getInServiceCountry());
            pstmt.setString(10, monkey.getTailLength());
            pstmt.setString(11, monkey.getHeight());
            pstmt.setString(12, monkey.getBodyLength());
            pstmt.setString(13, monkey.getSpecies());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error inserting monkey: " + e.getMessage());
        }
    }

    // Enhancement category 3 change:
    // Reads all dog records from the database and returns them as Dog objects.
    public static ArrayList<Dog> getAllDogs() {
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        String sql = "SELECT * FROM dogs";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Dog dog = new Dog(
                        rs.getString("name"),
                        rs.getString("breed"),
                        rs.getString("gender"),
                        rs.getString("age"),
                        rs.getString("weight"),
                        rs.getString("acquisitionDate"),
                        rs.getString("acquisitionCountry"),
                        rs.getString("trainingStatus"),
                        rs.getInt("reserved") == 1,
                        rs.getString("inServiceCountry")
                );

                dogs.add(dog);
            }

        } catch (SQLException e) {
            System.out.println("Error reading dogs: " + e.getMessage());
        }

        return dogs;
    }

    // Enhancement category 3 change:
    // Reads all monkey records from the database and returns them as Monkey objects.
    public static ArrayList<Monkey> getAllMonkeys() {
        ArrayList<Monkey> monkeys = new ArrayList<Monkey>();
        String sql = "SELECT * FROM monkeys";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Monkey monkey = new Monkey(
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("age"),
                        rs.getString("weight"),
                        rs.getString("acquisitionDate"),
                        rs.getString("acquisitionCountry"),
                        rs.getString("trainingStatus"),
                        rs.getInt("reserved") == 1,
                        rs.getString("inServiceCountry"),
                        rs.getString("tailLength"),
                        rs.getString("height"),
                        rs.getString("bodyLength"),
                        rs.getString("species")
                );

                monkeys.add(monkey);
            }

        } catch (SQLException e) {
            System.out.println("Error reading monkeys: " + e.getMessage());
        }

        return monkeys;
    }

    // Enhancement category 3 change:
    // Updates the reserved status of a dog or monkey in the database.
    public static void reserveAnimal(String animalType, String name) {
        String sql = "";

        if (animalType.equalsIgnoreCase("dog")) {
            sql = "UPDATE dogs SET reserved = 1 WHERE LOWER(name) = LOWER(?)";
        } else if (animalType.equalsIgnoreCase("monkey")) {
            sql = "UPDATE monkeys SET reserved = 1 WHERE LOWER(name) = LOWER(?)";
        } else {
            return;
        }

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error reserving animal: " + e.getMessage());
        }
    }

    // Enhancement category 3 change:
    // Deletes a dog or monkey record from the database by animal type and name.
    public static boolean deleteAnimal(String animalType, String name) {
        String sql = "";

        if (animalType.equalsIgnoreCase("dog")) {
            sql = "DELETE FROM dogs WHERE LOWER(name) = LOWER(?)";
        } else if (animalType.equalsIgnoreCase("monkey")) {
            sql = "DELETE FROM monkeys WHERE LOWER(name) = LOWER(?)";
        } else {
            return false;
        }

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            int rowsAffected = pstmt.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting animal: " + e.getMessage());
            return false;
        }
    }
}