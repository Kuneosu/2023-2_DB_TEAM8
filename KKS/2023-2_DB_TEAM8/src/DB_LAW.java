import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import oracle.jdbc.OracleTypes;

public class DB_LAW {
   Connection con = null;
   String url = "jdbc:oracle:thin:@localhost:1521:XE";
   String id = "LAW";      String password = "1234";
   
   
   public DB_LAW() {
     try {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("드라이버 적재 성공");
     } catch (ClassNotFoundException e) { System.out.println("No Driver."); }  
   }
   
   
   private void DB_Connect() {
     try {
         con = DriverManager.getConnection(url, id, password);
         System.out.println("DB 연결 성공");
     } catch (SQLException e) {         System.out.println("Connection Fail");      }
   }
   
   
   private void sqlRun() throws SQLException{   // 단순 검색
    String query = "select 사건번호,사건명,사건종류,상태 from 사건";

    try { DB_Connect();
    	  Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(query);
          while (rs.next()) {
        	  System.out.print("\t" + rs.getString("사건번호"));
        	  System.out.print("\t" + rs.getString("사건명"));
        	  System.out.print("\t" + rs.getString("사건종류"));
        	  System.out.print("\t" + rs.getString("상태"));
        	  System.out.print("\n");
           }
          stmt.close();    rs.close();
    } catch (SQLException e) { e.printStackTrace(); 
    } finally {   con.close(); }
    
   }

public static void main(String arg[]) throws SQLException {
       DB_LAW law = new DB_LAW();
       law.sqlRun();
    }
}
