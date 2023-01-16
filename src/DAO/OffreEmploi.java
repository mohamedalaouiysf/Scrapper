package DAO;

public class OffreEmploi extends Offre{
	private String Langue;
	private String Niveau;

	@Override
	public String toString() {
		return super.toString()+"[Langue=" + Langue + ", Niveau=" + Niveau + "]";
	}
	public OffreEmploi(Societe societe,String secteur, String fonction, String experience, String niveauEtude, String typeContrat,
			String datePublication, int nbPostes, String titreOffre, String langue, String niveau) {
		super(societe,secteur, fonction, experience, niveauEtude, typeContrat, datePublication, nbPostes, titreOffre);
		Langue = langue;
		Niveau = niveau;
	}
	public String getLangue() {
		return Langue;
	}
	public void setLangue(String langue) {
		Langue = langue;
	}
	public String getNiveau() {
		return Niveau;
	}
	public void setNiveau(String niveau) {
		Niveau = niveau;
	}
	
}
