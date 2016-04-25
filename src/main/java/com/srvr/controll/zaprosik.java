package com.srvr.controll;

/**
 * Created by Aleksandr on 25.04.2016.
 */
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    //import com.mysql.jdbc.Driver;
    public class zaprosik {
        public static void main(String[] args) {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
//			new com.mysql.jdbc.Driver();
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                String connectionUrl = "jdbc:mysql://localhost:3306/test";
                String connectionUser = "root";
                String connectionPassword = "";
                conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                stmt = conn.createStatement();
                    //filling the table
			/*String query = "INSERT INTO project (id, sovet) \n" +
			" VALUES (5,'dont worry, be happy');";
			stmt.executeUpdate(query);*/
                rs = stmt.executeQuery("SELECT * FROM project WHERE id>0 ORDER BY RAND() LIMIT 1");
                while (rs.next()) {
                    String id = rs.getString("id");
                    String advice = rs.getString("sovet");

                    System.out.println(advice+", bitch");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }

