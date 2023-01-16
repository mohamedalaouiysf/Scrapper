package Controller;
import java.sql.*;
public class Select {
public static  String requete = "SELECT * FROM offre";
public static ResultSet sel() {
		try {
		   Statement stmt = DbConn.con.createStatement();
		   ResultSet resultats = stmt.executeQuery(requete);
		   return resultats;
		} catch (SQLException e) {
			return null;
		}
	}
}
