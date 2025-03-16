import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class App {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://172.19.0.3:5432/postgres";
		String user = "postgres";
		String password = "changeme";

		try     (Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM products");
			ResultSet rs = preparedStatement.executeQuery()) {
		   	while (rs.next()) {
				System.out.println("Data: " + rs.getString("price"));
		    	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}