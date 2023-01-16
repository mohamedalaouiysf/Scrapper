package DAO;

public class Societe{
	
	private String NomSociete;
	private String Region;
	public Societe() {
		// TODO Auto-generated constructor stub
	}
	public Societe(String nomSociete, String region) {
		NomSociete = nomSociete;
		Region = region;
	}
	public String getNomSociete() {
		return NomSociete;
	}
	public void setNomSociete(String nomSociete) {
		NomSociete = nomSociete;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	@Override
	public String toString() {
		return "Societe [NomSociete=" + NomSociete + ", Region=" + Region + "]";
	}
	
	public void Affiche() {
		System.out.println(toString());
	}
	
}