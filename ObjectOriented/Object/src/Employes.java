/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
 import java.util.ArrayList;
 import java.util.InputMismatchException;
 import java.util.List;
 import java.util.Scanner;

 class Employe{
 	private final String nom;
 	private double revenuMensuel;
 	private double tauxOccupation;
 	private double prime;

 	// Constructeurs
 	public Employe(String unNom, double unRevenu, double unTaux){
 		nom = unNom;
 		revenuMensuel = unRevenu;
 		prime = 0;
 		if (unTaux < 10){
 			tauxOccupation = 10;
 		} else {
 			if (unTaux > 100){
 				tauxOccupation = 100;
 			} else {
 				tauxOccupation = unTaux;
 			}
 		}
 		System.out.print("Nous avons un nouvel employé : " + getNom() + ",");
 	}
 	public Employe(String unNom, double unRevenu){
 		this(unNom, unRevenu, 100);
 	}

 	// Getters/Setters
 	public double getRevenuMensuel(){
 		return revenuMensuel;
 	}
 	public double getTauxOccupation(){
 		return tauxOccupation;
 	}
 	public String getNom(){
 		return nom;
 	}
 	public double getPrime(){
 		return prime;
 	}

 	// M�thodes
 	public double revenuAnnuel(){
 		return (12 * getRevenuMensuel() * (getTauxOccupation()/100) + getPrime());
 	}
 	public void demandePrime(){
 		Scanner input = new Scanner(System.in);
 		double mtPrimeDemande = 0;
 		int nbEssais = 0;
 		do{
 			nbEssais += 1;
 			try{
 				System.out.println("Montant de la prime souhaitée par " + getNom() + " ?");
 				mtPrimeDemande = input.nextDouble();
 				if (mtPrimeDemande > (revenuAnnuel()*0.02)){
 					System.out.println("Trop cher!");
 				} else {
 					prime = mtPrimeDemande;
 				}
 			}
 			catch (InputMismatchException e){
 				System.out.println("Vous devez introduire un nombre!");
 				input.nextLine();
 			}
 		}while ((getPrime() == 0) && nbEssais < 5);
 		input.close();
 	}
 	public String toString(){
 		String res = getNom() + " :\n";
 		res += "  Taux d'occupation : " + (int)getTauxOccupation() + "%. Salaire annuel : " + String.format("%.2f", revenuAnnuel()) + " francs";
 		if (getPrime() > 0){
 			res += ", Prime : " + String.format("%.2f", getPrime()) + ".";
 			return res ;
 		} else {
 			res += ".";
 			return res;
 		}
 	}
 }

 class Manager extends Employe{
 	public final static int FACTEUR_GAIN_CLIENT = 500;
 	public final static int FACTEUR_GAIN_VOYAGE = 100;
 	private int nbJoursVoyages;
 	private int nbNouveauxClients;

 	public Manager(String unNom, double unRevenu, int unNbJours, int unNbClients, double unTaux){
 		super(unNom, unRevenu, unTaux);
 		nbJoursVoyages = unNbJours;
 		nbNouveauxClients = unNbClients;
 		System.out.print(" c'est un manager.\n");
 	}
 	public Manager(String unNom, double unRevenu, int unNbJours, int unNbClients){
 		this(unNom, unRevenu, unNbJours, unNbClients, 100);
 	}

 	public int getNbJoursVoyages(){
 		return nbJoursVoyages;
 	}
 	public int getNbNouveauxClients(){
 		return nbNouveauxClients;
 	}

 	private double primeClient(){
 		return (double)(FACTEUR_GAIN_CLIENT * getNbNouveauxClients());
 	}
 	private double primeVoyage(){
 		return (double)(FACTEUR_GAIN_VOYAGE * getNbJoursVoyages());
 	}

 	@Override
 	public double revenuAnnuel(){
 		return super.revenuAnnuel() + primeClient() + primeVoyage();
 	}
 	@Override
 	public String toString(){
 		String res = "\n";
 		res += "  A voyagé " + getNbJoursVoyages() + " jours et apporté " + getNbNouveauxClients() + " nouveaux clients.\n";
 		return super.toString() + res;
 	}
 }

 class Testeur extends Employe{
 	public final static int FACTEUR_GAIN_ERREURS = 10;
 	private int nbErreursCorrigees;

 	public Testeur(String unNom, double unRevenu, int unNbErreurs, double unTaux){
 		super(unNom, unRevenu, unTaux);
 		nbErreursCorrigees = unNbErreurs;
 		System.out.print(" c'est un testeur.\n");
 	}
 	public Testeur(String unNom, double unRevenu, int unNbErreurs){
 		this(unNom, unRevenu, unNbErreurs, 100);
 	}

 	public int getNbErreursCorrigees(){
 		return nbErreursCorrigees;
 	}

 	@Override
 	public double revenuAnnuel(){
 		return super.revenuAnnuel() + (FACTEUR_GAIN_ERREURS * getNbErreursCorrigees());
 	}
 	@Override
 	public String toString(){
 		String res = "\n";
 		res += "  A corrigé " + getNbErreursCorrigees() + " erreurs.\n";
 		return super.toString() + res;
 	}
 }

 class Programmeur extends Employe{
 	public final static int FACTEUR_GAIN_PROJETS = 200;
 	private int nbProjetsAcheves;

 	public Programmeur(String unNom, double unRevenu, int unNbProj, double unTaux){
 		super(unNom, unRevenu, unTaux);
 		nbProjetsAcheves = unNbProj;
 		System.out.print(" c'est un programmeur.\n");
 	}
 	public Programmeur(String unNom, double unRevenu, int unNbProj){
 		this(unNom, unRevenu, unNbProj, 100);
 	}

 	public int getNbProjetsAcheves(){
 		return nbProjetsAcheves;
 	}

 	@Override
 	public double revenuAnnuel(){
 		return super.revenuAnnuel() + (FACTEUR_GAIN_PROJETS * getNbProjetsAcheves());
 	}
 	@Override
 	public String toString(){
 		String res = "\n";
 		res += "  A mené à bien " + getNbProjetsAcheves() + " projets\n";
 		return super.toString() + res;
 	}
 }
/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
class Employes {
    public static void main(String[] args) {

        List<Employe> staff = new ArrayList<Employe>();

        // TEST PARTIE 1:

        System.out.println("Test partie 1 : ");
        staff.add(new Manager("Serge Legrand", 7456, 30, 4 ));
        staff.add(new Programmeur("Paul Lepetit" , 6456, 3, 75 ));
        staff.add(new Testeur("Pierre Lelong", 5456, 124, 50 ));

        System.out.println("Affichage des employés : ");
        for (Employe modele : staff) {
            System.out.println(modele);
        }
        // FIN TEST PARTIE 1
        // TEST PARTIE 2
        System.out.println("Test partie 2 : ");

        staff.get(0).demandePrime();

        System.out.println("Affichage après demande de prime : ");
        System.out.println(staff.get(0));

        // FIN TEST PARTIE 2
    }
}
