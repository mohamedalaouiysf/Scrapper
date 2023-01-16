package Controller;
import java.sql.*;

import DAO.OffreEmploi;
import DAO.OffreRekrute;
import DAO.Societe;
public class insert {
	public static void inserer(OffreRekrute off) {
		try {
			   String requete =String.format("INSERT IGNORE INTO offre (`NomSociete`, `Secteur`, `Fonction`, `Experience`, `NivEtude`, `DatePublication`, `NbPostes`, `TitreOffre`, `TypeContrat`, `DateExpiration`, `Langue`, `Niveau`, `Python`, `Java`, `Html`, `Css`, `Js`, `Sql`, `Laravel`) VALUES ('%s','%s','%s','%s','%s','%s','%d','%s','%s','%s','%s','%s','%d','%d','%d','%d','%d','%d','%d')",off.getSc().getNomSociete(),off.getSecteur(),off.getFonction(),off.getExperience(),off.getNiveauEtude(),off.getDatePublication(),off.getNbPostes(),off.getTitreOffre(),off.getTypeContrat(),off.getDateE(),null,null,off.isPython(),off.isJava(),off.isHtml(),off.isCss(),off.isJs(),off.isSql(),off.isLaravel());
			   Statement stmt = DbConn.con.createStatement();
			   System.out.println(requete);
			   int resultats = stmt.executeUpdate(requete);

			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	public static void inserer(OffreEmploi off) {
		try {
			   
			   String requete =String.format("INSERT IGNORE INTO offre (`NomSociete`, `Secteur`, `Fonction`, `Experience`, `NivEtude`, `DatePublication`, `NbPostes`, `TitreOffre`, `TypeContrat`, `DateExpiration`, `Langue`, `Niveau`, `Python`, `Java`, `Html`, `Css`, `Js`, `Sql`, `Laravel`) VALUES ('%s','%s','%s','%s','%s','%s','%d','%s','%s','%s','%s','%s','%d','%d','%d','%d','%d','%d','%d')",off.getSc().getNomSociete(),off.getSecteur(),off.getFonction(),off.getExperience(),off.getNiveauEtude(),off.getDatePublication(),off.getNbPostes(),off.getTitreOffre(),off.getTypeContrat(),null,off.getLangue(),off.getNiveau(),off.isPython(),off.isJava(),off.isHtml(),off.isCss(),off.isJs(),off.isSql(),off.isLaravel());
			   Statement stmt = DbConn.con.createStatement();
			   int resultats = stmt.executeUpdate(requete);
			   System.out.println(requete);
			   
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	public static void inserer_soc(Societe soc) {
		try {
			   String requete =String.format(" INSERT IGNORE INTO `societe`(`NomSociete`, `Region`) VALUES ('%s','%s')",soc.getNomSociete(),soc.getRegion());
			   Statement stmt = DbConn.con.createStatement();
			   int resultats = stmt.executeUpdate(requete);
			   System.out.println(requete);
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
}
