import java.sql.*;

public class MssqlDB {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String connectionString = "����:1433;" + "databaseName=�����̸�;user=�����;password=��й�ȣ";
			
			conn = DriverManager.getConnection(connectionString);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select top(1) name, info from �����̸� order by num desc;");
			System.out.println("name / info");
			System.out.println("------------------------");
			
			while(rs.next()) {
				String bookname = rs.getString("name");
				String publishing = rs.getString("info");

				System.out.printf("%s %s\n", bookname, publishing);
			}
			
		}catch (ClassNotFoundException cnfe) {
			// TODO: handle exception
			System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." + cnfe.getMessage());
		}catch (SQLException se) {
			// TODO: handle exception
			System.out.println(se.getMessage());
		}finally {
			try {
				stmt.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
			try {
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
