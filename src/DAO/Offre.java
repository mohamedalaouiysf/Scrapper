package DAO;

public class Offre {
	private Societe Sc;
	private String Secteur;
	private String Fonction;
	private String Experience;
	private String NiveauEtude;
	private String TypeContrat;
	private String DatePublication;
	private int NbPostes;
	private String TitreOffre;
	private int Python,Java,Html,Css,Js,Sql,Laravel,Php;
	
	public Offre() {
		
	}



	public Offre(Societe societe,String secteur, String fonction, String experience, String niveauEtude, String typeContrat,
			String datePublication, int nbPostes, String titreOffre) {
		Sc = societe;
		Secteur = secteur;
		Fonction = fonction;
		Experience = experience;
		NiveauEtude = niveauEtude;
		TypeContrat = typeContrat;
		DatePublication = datePublication;
		NbPostes = nbPostes;
		TitreOffre = titreOffre;
		Python=0;
		Java=0;
		Html=0;
		Css=0;
		Js=0;
		Sql=0;
		Laravel=0;
		Php=0;
	}



	public int isPython() {
		return Python;
	}



	public void setPython(int python) {
		Python = python;
	}



	public int isJava() {
		return Java;
	}



	public void setJava(int java) {
		Java = java;
	}



	public int isHtml() {
		return Html;
	}



	public void setHtml(int html) {
		Html = html;
	}



	public int isCss() {
		return Css;
	}



	public void setCss(int css) {
		Css = css;
	}



	public int isJs() {
		return Js;
	}



	public void setJs(int js) {
		Js = js;
	}



	public int isSql() {
		return Sql;
	}



	public void setSql(int sql) {
		Sql = sql;
	}



	public int isLaravel() {
		return Laravel;
	}



	public void setLaravel(int laravel) {
		Laravel = laravel;
	}



	public int isPhp() {
		return Php;
	}



	public void setPhp(int php) {
		Php = php;
	}



	public String getSecteur() {
		return Secteur;
	}

	public void setSecteur(String secteur) {
		Secteur = secteur;
	}

	public String getFonction() {
		return Fonction;
	}

	public void setFonction(String fonction) {
		Fonction = fonction;
	}

	public String getExperience() {
		return Experience;
	}

	public void setExperience(String experience) {
		Experience = experience;
	}

	public String getNiveauEtude() {
		return NiveauEtude;
	}

	public void setNiveauEtude(String niveauEtude) {
		NiveauEtude = niveauEtude;
	}

	public String getTypeContrat() {
		return TypeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		TypeContrat = typeContrat;
	}

	public String getDatePublication() {
		return DatePublication;
	}

	public void setDatePublication(String datePublication) {
		DatePublication = datePublication;
	}

	public int getNbPostes() {
		return NbPostes;
	}

	public void setNbPostes(int nbPostes) {
		NbPostes = nbPostes;
	}

	public String getTitreOffre() {
		return TitreOffre;
	}

	public void setTitreOffre(String titreOffre) {
		TitreOffre = titreOffre;
	}

	@Override
	public String toString() {
		return "Offre [Secteur=" + Secteur + ", Fonction=" + Fonction + ", Experience=" + Experience + ", NiveauEtude="
				+ NiveauEtude + ", TypeContrat=" + TypeContrat + ", DatePublication=" + DatePublication + ", NbPostes="
				+ NbPostes + ", TitreOffre=" + TitreOffre + "]";
	}
	public void Affiche() {
		System.out.println(toString());
	}



	public Societe getSc() {
		return Sc;
	}



	public void setSc(Societe societe) {
		Sc = societe;
	}
}
