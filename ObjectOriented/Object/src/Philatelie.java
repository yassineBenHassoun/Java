import java.util.ArrayList;

class Timbre {

    public static final int ANNEE_COURANTE = 2016;
    public static final int VALEUR_TIMBRE_DEFAUT = 1;
    public static final String PAYS_DEFAUT = "Suisse";
    public static final String CODE_DEFAUT = "lambda";

    public static final int BASE_1_EXEMPLAIRES = 100;
    public static final int BASE_2_EXEMPLAIRES = 1000;
    public static final double PRIX_BASE_1 = 600;
    public static final double PRIX_BASE_2 = 400;
    public static final double PRIX_BASE_3 = 50;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
     protected String timbreCodeName = CODE_DEFAUT;
     protected int timbreYearOfEmission = ANNEE_COURANTE;
     protected String timbreCountry = PAYS_DEFAUT;
     protected double timbrePrice = VALEUR_TIMBRE_DEFAUT;

     // CONSTRUCTORS

     public Timbre(String codeName, int yearOfEmission, String country, double price) {
         this.timbreCodeName = codeName;
         this.timbreYearOfEmission = yearOfEmission;
         this.timbreCountry = country;
         this.timbrePrice = price;
     }

     public Timbre(String codeName, int yearOfEmission, String country) {
         this.timbreCodeName = codeName;
         this.timbreYearOfEmission = yearOfEmission;
         this.timbreCountry = country;
     }

     public Timbre(String codeName, int yearOfEmission) {
         this.timbreCodeName = codeName;
         this.timbreYearOfEmission = yearOfEmission;
     }

     public Timbre(String codeName) {
         this.timbreCodeName = codeName;
     }

     public Timbre() {}

     /// GETTERS
     public String getCode() {return this.timbreCodeName;}
     public String getPays() {  return this.timbreCountry;}
     public int getAnnee() {return this.timbreYearOfEmission;}
     public double getValeurFaciale() {return this.timbrePrice;}

     // METHODS

     public double vente() {
         if (age() < 5) {
             return this.timbrePrice;
         }
         return this.timbrePrice * age() * 2.5;
     }

     public String toString() {
         return "Timbre de code " + this.timbreCodeName
                 + " datant de " + this.timbreYearOfEmission
                 + " (provenance " + this.timbreCountry
                 + ") ayant pour valeur faciale " + this.timbrePrice
                 + " francs";
     }

     public int age() {return ANNEE_COURANTE - timbreYearOfEmission;}
 }

class Rare extends Timbre
 {
     private int numberOfExemplaire = 0;

     public Rare(String codeName, int yearOfEmission, String country, double price, int numberOfExemplaire) {
         super(codeName, yearOfEmission, country, price);
         this.numberOfExemplaire = numberOfExemplaire;
     }
     public Rare(String codeName, int yearOfEmission, String country, int numberOfExemplaire) {
         super(codeName, yearOfEmission, country);
         this.numberOfExemplaire = numberOfExemplaire;
     }
     public Rare(String codeName, int yearOfEmission, int numberOfExemplaire) {
         super(codeName, yearOfEmission);
         this.numberOfExemplaire = numberOfExemplaire;
     }
     public Rare(String codeName, int numberOfExemplaire) {
         super(codeName);
         this.numberOfExemplaire = numberOfExemplaire;
     }
     public Rare(int numberOfExemplaire) {
         super();
         this.numberOfExemplaire = numberOfExemplaire;
     }

     public int getExemplaires() {return this.numberOfExemplaire;}

     public String toString() {
         return super.toString()
                 + "\nNombre d'exemplaires -> " + this.numberOfExemplaire;
     }

     public double vente() {

         double price = 0;
         // nombre exemplaire de timbre = nb
         int nb = this.numberOfExemplaire;

         if (nb < 100) {
             price = PRIX_BASE_1;

         } else if (nb > 100 && nb < 1000) {
             price = PRIX_BASE_2;
         } else {
             price = PRIX_BASE_3;
         }
         return price * (this.age() / 10.0);
     }
}

class Commemoratif extends Timbre {
     public Commemoratif(String codeName, int yearOfEmission, String country, double price) {
         super(codeName, yearOfEmission, country, price);
     }
     public Commemoratif(String codeName, int yearOfEmission, String country) {
         super(codeName, yearOfEmission, country);
     }
     public Commemoratif(String codeName, int yearOfEmission) {
         super(codeName, yearOfEmission);
     }
     public Commemoratif(String codeName) {
         super(codeName);
     }
     public Commemoratif() {
         super();
     }
     public double vente() {
         return super.vente() * 2;
     }
     public String toString() {
         return super.toString()
                 + "\nTimbre celebrant un evenement";
     }
}
	
/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

class Philatelie {

    public static void main(String[] args) {

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale,
        // nombre d'exemplaires
        Rare t1 = new Rare("Guarana-4574", 1960, "Mexique", 0.2, 98);

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale
        Commemoratif t2 = new Commemoratif("700eme-501", 2002, "Suisse", 1.5);
        Timbre t3 = new Timbre("Setchuan-302", 2004, "Chine", 0.2);

        Rare t4 = new Rare("Yoddle-201", 1916, "Suisse", 0.8, 3);


        ArrayList<Timbre> collection = new ArrayList<Timbre>();

        collection.add(t1);
        collection.add(t2);
        collection.add(t3);
        collection.add(t4);

        for (Timbre timbre : collection) {
            System.out.println(timbre);
            System.out.println("Prix vente : " + timbre.vente() + " francs");
            System.out.println();
        }
    }
}

