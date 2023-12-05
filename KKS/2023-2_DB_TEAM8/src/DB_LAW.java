import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

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
   
   public mainResult mainSql() throws SQLException{
	   mainResult result = new mainResult();
	   try{	DB_Connect();
			CallableStatement cs = con.prepareCall("{call CALC_STATUS(?,?,?)}");
			cs.registerOutParameter(1,Types.INTEGER);
			cs.registerOutParameter(2,Types.DOUBLE);
			cs.registerOutParameter(3,Types.INTEGER);
			
			cs.execute();
		
			result.setTotalCase(cs.getInt(1));
			result.setWinRate(cs.getDouble(2));
			result.setCountLawyer(cs.getInt(3));
			
			System.out.print("\t" + result.getTotalCase());
            System.out.print("\t" + result.getWinRate());
            System.out.print("\t" + result.getCountLawyer());
	   }catch(SQLException e) {
		   e.printStackTrace();
	   }
	   
	   return result;
   }
   
   public String checkLawyer(String lawyer_name) throws SQLException{
	   String lawyer_number="null";
	   String sql = "SELECT 변호사번호 FROM 변호사 WHERE 이름=(?)";
	   try {DB_Connect();
	   		PreparedStatement preparedStatement = con.prepareStatement(sql);
	   		preparedStatement.setString(1, lawyer_name);
	   		
	   		ResultSet rs = preparedStatement.executeQuery();
	   		
	   		if(rs.next()) {
	   			lawyer_number = rs.getString("변호사번호");
	   			System.out.println("변호사 정보 확인 완료");
	   		}else {
	   			lawyer_number = "존재하지 않는 변호사";
	   		}
	   		rs.close(); preparedStatement.close();
	   }catch(SQLException e) {
		   e.printStackTrace();
	   }
	   
	   return lawyer_number;
   }
   
   public String checkCustomer(String customer_name) throws SQLException{
	   String customer_number="null";
	   String sql = "SELECT 고객번호 FROM 고객 WHERE 이름=(?)";
	   try {DB_Connect();
	   		PreparedStatement preparedStatement = con.prepareStatement(sql);
	   		preparedStatement.setString(1, customer_name);
	   		
	   		ResultSet rs = preparedStatement.executeQuery();
	   		
	   		if(rs.next()) {
	   			customer_number = rs.getString("고객번호");
	   			System.out.println("고객 정보 확인 완료");
	   		}else {
	   			customer_number = "존재하지 않는 고객";
	   		}
	   		rs.close(); preparedStatement.close();
	   }catch(SQLException e) {
		   e.printStackTrace();
	   }
	   
	   return customer_number;
   }
   
   public void createCounsel(String lawyer_number,String customer_number,String counsel_genre,String counsel_body) {
	   try {DB_Connect();
	   		CallableStatement cs = con.prepareCall("{call CREATE_COUNSEL(?,?,?,?)}");
		   cs.setString(1, lawyer_number);
		   cs.setString(2, customer_number);
		   cs.setString(3, counsel_genre);
		   cs.setString(4, counsel_body);
		   
		   cs.execute();
		   
		   System.out.println("상담 데이터 삽입 완료");
		   
		   cs.close(); con.close();
	   }catch(SQLException e) {
		   e.printStackTrace();
	   }
   }

public static void main(String arg[]) throws SQLException {
       DB_LAW law = new DB_LAW();
       law.sqlRun();
    }
}
