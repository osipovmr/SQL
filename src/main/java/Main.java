import javax.xml.transform.sax.SAXResult;
import java.sql.*;


public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://c-c9qkc196nr3nge59qclr.rw.mdb.yandexcloud.net:6432/students-project";
        String login = "students-project";
        String password = "kd5HdsI2fcidKsqC";
        Statement statement = null;
        String query = "select * from bookings.airports";
        ResultSet result;
        try (Connection conn = DriverManager.getConnection(url, login, password)) {
            if (conn != null) {
                System.out.println("Connected to the database!");
                statement = conn.createStatement();
                result = statement.executeQuery(query);
                while (result.next()) {
                    System.out.println(result.getString("airport_code") + "\t " + result.getString("airport_name")
                            + "\t" + result.getString("city")
                            + "\t" + result.getString("longitude")
                            +"\t"+ result.getString("latitude")
                            + "\t" + result.getString("timezone"));
                }
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}