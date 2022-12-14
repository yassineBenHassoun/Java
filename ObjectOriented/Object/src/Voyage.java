
/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
import java.util.ArrayList;

class OptionVoyage {
    private String nom;
    private double prix = 0;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double prix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public OptionVoyage(String name, double prix) {
        this.nom = name;
        this.prix = prix;
    }

    public OptionVoyage(String name) {
        this.nom = name;
    }

    public String toString() {
        return nom + " -> " + prix() + " CHF";
    }
}

class Sejour extends OptionVoyage {

    private int nbNuit = 1;
    private double price;

    public Sejour(String nom, double prix, int nbNuit, double prixNuit) {
        super(nom, prix);
        this.nbNuit = nbNuit;
        this.price = prixNuit;

    }

    public double prix() {
        return this.nbNuit * this.price + super.prix();
    }

}

class Transport extends OptionVoyage {
    public final static double TARIF_LONG = 1500;
    public final static double TARIF_BASE = 200;
    private boolean trajetLong;

    public Transport(String nom, double prix) {
        super(nom, prix);
        this.trajetLong = false;
    }

    public Transport(String nom, double prix, boolean trajetLong) {
        super(nom, prix);
        this.trajetLong = trajetLong;
    }

    public double prix() {
        if (trajetLong) {
            return TARIF_LONG + super.prix();
        } else {
            return TARIF_BASE + super.prix();
        }
    }
}

class KitVoyage {
    private ArrayList<OptionVoyage> options;
    private String depart;
    private String destination;

    public KitVoyage(String start, String end) {
        this.depart = start;
        this.destination = end;
        options = new ArrayList<OptionVoyage>();

    }

    public void ajouterOption(OptionVoyage o) {
        if (o != null) {
            options.add(o);
        }

    }

    public double prix() {
        double prix = 0;
        for (OptionVoyage opVoyage : options) {
            prix += opVoyage.prix();
        }
        return prix;
    }

    public String toString() {
        String chaine;
        chaine = "Voyage de " + depart + " ?? " + destination + ", avec pour options :\n";
        for (OptionVoyage o : options) {
            chaine += "- " + o + "\n";
        }
        chaine += "Prix total : " + prix() + " CHF\n";
        return chaine;
    }

    public void annuler() {
        options.clear();
    }

    public int getNbOptions() {
        return options.size();
    }

}
/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/

public class Voyage {
    public static void main(String args[]) {

        // TEST 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        OptionVoyage option1 = new OptionVoyage("S??jour au camping", 40.0);
        System.out.println(option1.toString());

        OptionVoyage option2 = new OptionVoyage("Visite guid??e : London by night", 50.0);
        System.out.println(option2.toString());
        System.out.println();

        // FIN TEST 1

        // TEST 2
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        Transport transp1 = new Transport("Trajet en car ", 50.0);
        System.out.println(transp1.toString());

        Transport transp2 = new Transport("Croisi??re", 1300.0);
        System.out.println(transp2.toString());

        Sejour sejour1 = new Sejour("Camping les flots bleus", 20.0, 10, 30.0);
        System.out.println(sejour1.toString());
        System.out.println();

        // FIN TEST 2

        // TEST 3
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        KitVoyage kit1 = new KitVoyage("Zurich", "Paris");
        kit1.ajouterOption(new Transport("Trajet en train", 50.0));
        kit1.ajouterOption(new Sejour("Hotel 3* : Les amandiers ", 40.0, 5, 100.0));
        System.out.println(kit1.toString());
        System.out.println();
        kit1.annuler();

        KitVoyage kit2 = new KitVoyage("Zurich", "New York");
        kit2.ajouterOption(new Transport("Trajet en avion", 50.0, true));
        kit2.ajouterOption(new Sejour("Hotel 4* : Ambassador Plazza  ", 100.0, 2, 250.0));
        System.out.println(kit2.toString());
        kit2.annuler();

        // FIN TEST 3
    }
}
