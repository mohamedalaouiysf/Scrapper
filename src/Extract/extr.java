package Extract;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Controller.DbConn;
import Controller.insert;
import DAO.OffreEmploi;
import DAO.OffreRekrute;
import DAO.Societe;

public class extr {
		public static boolean checkSkill(String content,String skill) {
			return content.contains(skill);
		}
		public static void extraire(String choice) {
			if(choice.equals("Rekrute.ma")) {
				for(int in=0;in<5;in++) {
					DbConn.connecter();
					String url="https://www.rekrute.com/offres.html?p="+in+"&s=1&o=1&positionId%5B0%5D=13&positionId%5B1%5D=19&positionId%5B2%5D=23";
					try {
						Document doc = Jsoup.connect(url).timeout(100000).get();
						Elements els=doc.select(".post-id");
						for(Element el : els) {
							Element el2=el.select("h2").select("a").first();
							String titre=el2.text().split("\\|")[0].trim().replace('\'',' ');
							String Region=el2.text().split("\\|")[1].trim().split(" ")[0];
							String Societe =el.select("img").attr("alt").replace('\'',' ');
							Element content=el.select(".info").get(2);
							Elements li = content.select("li");
							String Secteur=li.get(0).select("a").first().text().replace('\'',' ');
							String fonction=li.get(1).select("a").first().text().replace('\'',' ');
							String Exp=li.get(2).select("a").first().text();
							String Niv=li.get(3).select("a").first().text();
							String Contrat=li.get(4).select("a").first().text();
							Elements Dates=el.select(".holder > em");
							String DateP=Dates.select("span").get(0).text();
							String DateE=Dates.select("span").get(1).text();
							int NbrPost=(Dates.select("span").size()==3)? Integer.parseInt(Dates.select("span").get(2).text().trim()) : 0 ;
							Societe sc=new Societe(Societe,Region);
							OffreRekrute of=new OffreRekrute(sc,Secteur, fonction, Exp, Niv, Contrat, DateP, NbrPost, titre, DateE);
							String urlsite=el.select(".section").select("a").first().attr("href");
							Document doc2 = Jsoup.connect("https://www.rekrute.com"+urlsite).timeout(100000).get();
							Elements els2 = doc2.select(".blc");
							String els3 = els2.get(4).text().toLowerCase();
							String els4 = els2.get(5).text().toLowerCase();
							String els5 = els3+els4;
							
							if(checkSkill(els5,"python")) {
								of.setPython(1);
							}
							if(checkSkill(els5,"java")) {
								of.setJava(1);
							}
							if(checkSkill(els5,"html")) {
								of.setHtml(1);
							}
							if(checkSkill(els5,"css")) {
								of.setCss(1);
							}
							if(checkSkill(els5,"sql")) {
								of.setSql(1);
							}
							if(checkSkill(els5,"php")) {
								of.setPhp(1);
							}
							//ggggggggggggggggggggggg
							insert.inserer_soc(sc);
							insert.inserer(of);
							//System.out.println(of.toString());
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}DbConn.fermer();
				
				
			}else {
				for(int in=0;in<1;in++) {
					DbConn.connecter();
					String url="https://www.emploi.ma/recherche-jobs-maroc?f%5B0%5D=im_field_offre_metiers%3A31&page="+in;
					try {
						Document doc = Jsoup.connect(url).get();
						Elements els=doc.select(".job-title");
						for(Element el : els) {
							String titre=el.select("a").first().text();
							String link="https://www.emploi.ma"+el.select("a").first().attr("href");
							Document doc2=Jsoup.connect(link).get();
							Element job=doc2.select(".job-ad-criteria").first();
							Elements rows=job.select("tr");
							String Societe=doc2.select(".company-title").text();
							String Date=doc2.select(".job-ad-publication-date").text();
							Date=Date.substring(11,Date.length());
							String Fonction,Secteur,Contrat,Region,Exp,Niv,Langue,NivLangue;
							int nb;
							Fonction=rows.get(0).select("td").get(1).text();
							Secteur=rows.get(1).select("td").get(1).text();
							Contrat=rows.get(2).select("td").get(1).text();
							Region=rows.get(3).select("td").get(1).text();
							Exp=rows.get(5).select("td").get(1).text();
							Niv=rows.get(6).select("td").get(1).text();
							if(rows.size()==9) {
								Langue=rows.get(7).select("td").get(1).text().split(" ")[0].split("›")[0];
								NivLangue=rows.get(6).select("td").get(1).text().split(" ")[0].split("›")[1];
								nb = Integer.parseInt(rows.get(8).select("td").get(1).text());								
							}else {
								Langue=null;
								NivLangue=null;
								nb = Integer.parseInt(rows.get(7).select("td").get(1).text());
							}
							String comp=doc2.select(".jobs-ad-details").text().toLowerCase();
							Societe sc2=new Societe(Societe,Region);
							OffreEmploi of=new OffreEmploi(sc2,Secteur, Fonction, Exp, Niv, Contrat, Date, nb, titre, Langue, NivLangue);
							if(checkSkill(comp,"python")) {
								of.setPython(1);
							}
							if(checkSkill(comp,"java")) {
								of.setJava(1);
							}
							if(checkSkill(comp,"html")) {
								of.setHtml(1);
							}
							if(checkSkill(comp,"css")) {
								of.setCss(1);
							}
							if(checkSkill(comp,"sql")) {
								of.setSql(1);
							}
							if(checkSkill(comp,"php")) {
								of.setPhp(1);
							}
							insert.inserer_soc(sc2);
							insert.inserer(of);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}					
				}				
			}
		}


}
//C:\Users\ALAOUI\eclipse-workspace