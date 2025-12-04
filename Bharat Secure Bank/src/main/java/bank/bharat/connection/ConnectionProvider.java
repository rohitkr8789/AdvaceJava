package bank.bharat.connection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionProvider {

	static Connection con=null;
	

	public static Connection getConnection() {
		Properties props = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\LapTask13MajorBankProject\\src\\main\\java\\com\\bank\\connection\\db.properties");
			props.load(fis);
			String driver=props.getProperty("driver");
			String url=props.getProperty("url");
			String uname=props.getProperty("uname");
			String pass=props.getProperty("pass");
			
			Class.forName(driver);
			if(con==null) {	
			con=DriverManager.getConnection(url, uname, pass);
			System.out.println("Connection established..");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	public static void main(String[] args) {
		ConnectionProvider.getConnection();
	}
}

