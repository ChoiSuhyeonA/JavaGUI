import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnectionNew {
   Connection con = null;

   public Statement stmt;
   public ResultSet rs;
   PreparedStatement pstmt;
   
   
   
   public SQLConnectionNew () throws SQLException {
      
      con = makeConnection();
      selectFromDB();
   //   insertIntoDB("한신대", "컴공", "2019", 112645);
      
      insertIntoDB2("한신대", "컴퓨터공학부", "2000", 2000);
      
   }
   
   



   private void insertIntoDB2(String title, String publisher, String year, int price) throws SQLException {
      pstmt=con.prepareStatement("insert into books (title, publisher, year, price) values(?,?,?,?);");
      pstmt.setString(1, title);
      pstmt.setString(2, publisher);
      pstmt.setString(3, year);
      pstmt.setInt(4, price);
      pstmt.executeUpdate();
      System.out.println("insert 성공");
   }



   private void insertIntoDB(String title, String publisher, String year, int price) {
      try {
         stmt = con.createStatement();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      int result;
      try {
         result = stmt.executeUpdate("insert into books (title,publisher, year,price) value('"+title+"','"+publisher+"','"+year+"',"+price+");");
         if (result ==1) {
            System.out.println("DB insert 성공");
         }
         else {
            System.out.println("실페");
         }
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   
   }



   private void selectFromDB() {
      try {
         stmt=con.createStatement();
      } catch (SQLException e) {
         System.out.println("selectFromDB: createStatement");
         e.printStackTrace();
      }
      try {
         rs=stmt.executeQuery("select * from books");
         while(rs.next())
         {
            System.out.print("book_ID:" + rs.getInt("book_id"));
            System.out.print("title:" + rs.getString("title"));
            System.out.println("Price:" +rs.getInt("price"));
         }
      } catch (SQLException e) {
         System.out.println("executeQuery오류");
         e.printStackTrace();
      }
   }



   private Connection makeConnection() {
      java.sql.Statement stmt;
      ResultSet rs;
   
         String url = "jdbc:mysql://localhost:3306/book_db?characterEncoding=UTF-8&serverTimezone=UTC";

         String id = "root";
         String password = "suhyeon1250*";
         Connection con = null;

         // 예외처리
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC 적재 성공...");

            con = DriverManager.getConnection(url, id, password);
            System.out.println("DB 연결 성공...");
         } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("JDBC 적재 오류...");
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("DB 연결 실패...");
         }
      return con;
   }



   public static void main(String args[]) throws SQLException {
      new SQLConnectionNew();
   }
}