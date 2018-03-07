import java.sql.*;

public class MssqlDB {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String connectionString = "서버:1433;" + "databaseName=서버이름;user=사용자;password=비밀번호";
			
			conn = DriverManager.getConnection(connectionString);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select top(1) name, info from 서버이름 order by num desc;");
			System.out.println("name / info");
			System.out.println("------------------------");
			
			while(rs.next()) {
				String bookname = rs.getString("name");
				String publishing = rs.getString("info");

				System.out.printf("%s %s\n", bookname, publishing);
			}
			
		}catch (ClassNotFoundException cnfe) {
			// TODO: handle exception
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
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
