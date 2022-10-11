/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
import java.util.ArrayList;

class Vehicule {
   private String nom = "Anonyme";
   private double vitesse = 130;
   private int poids =  1000;
   private int carburant = 0;

   public boolean estDeuxRoues(){
		return false;
	};

   public String getNom() {
       return this.nom;
   }

   public double getVitesse() {
       return this.vitesse;
   }

   public int getPoids() {
       return this.poids;
   }

   public int getCarburant() {
       return this.carburant;
   }

  public Vehicule (String nom , double speed, int poids , int carburant) {
        this.nom = nom;
        this.vitesse = speed;
        this.poids = poids;
        this.carburant = carburant;
  }

  public Vehicule (double speed, int poids , int carburant) {
       this.vitesse = speed;
       this.poids = poids;
       this.carburant = carburant;
    }
    public Vehicule ()
    {
        super();
    }
   public String toString()
   {
     return nom + " -> vitesse max = " + vitesse + " km/h, poids = " + poids + " kg";
   }
   public boolean  meilleur (Vehicule autreVehicule) {

       double calculateBasicPerf = performance(this.vitesse, this.poids);
       double calculateAutrePerf = performance(autreVehicule.vitesse, autreVehicule.poids);

       if(calculateBasicPerf >= calculateAutrePerf) {
           return true;
       }
       return false;
   }

   private double performance ( double vitesse , int poids)  {
       return vitesse / poids;
   }

   public void deduireCarburant(int tours) {
		carburant -= tours;
		if (carburant < 0){
			carburant = 0;
		}
	}
}

class Voiture extends Vehicule
{
   private String category;

   public Voiture (String name , double speed, int poids , int carburant, String category)
   {
        super(name,speed,poids, carburant);
        this.category = category;
   }

   public String getCategorie() {
       return this.category;
   }

   public void setCategory(String category) {
       this.category = category;
   }

    public String toString()
    {
        return super.toString() + ", Voiture de " + category;
    }

}
class Moto extends Vehicule
{
   private boolean sidecar = false;

   public Moto (String name , double speed, int poids , int carburant,boolean sidecar)
   {
       super(name,speed,poids, carburant );
       this.sidecar = sidecar;
   }

   public Moto (String name , double speed, int poids , int carburant)
   {
       super(name,speed,poids, carburant );
   }

   public String toString()
    {
        return super.toString() + ", Moto" 
        + (sidecar == true ? ", avec sidecar" : "");
    }

	public boolean estDeuxRoues(){
		return !sidecar;
	};

}

abstract class Rallye{
 	  public abstract boolean check();
}

class GrandPrix  extends Rallye
{
   private ArrayList<Vehicule> vehicules;

   public GrandPrix ()
   {
       vehicules = new ArrayList<Vehicule>();
   }

   public void ajouter(Vehicule vehicule)
   {
       vehicules.add(vehicule);
   }

   @Override
	   public boolean check() {
 		boolean deuxRoues = false;
 		boolean pasDeuxRoues = false;
 		for (Vehicule vehicule: vehicules){
 			if (vehicule.estDeuxRoues()){
 				deuxRoues = true;
 			}
 			else{
 				pasDeuxRoues = true;
 			}
 		}
 		return deuxRoues != pasDeuxRoues;
 	}

	public void run(int tours) {
		if (check()){
			Vehicule winner = null;
			for (Vehicule vehicule: vehicules){
				vehicule.deduireCarburant(tours);
				if (winner == null && vehicule.getCarburant() > 0
						|| winner != null && vehicule.getCarburant() > 0 && vehicule.meilleur(winner)){
                           winner = vehicule;
				}
			}
			if (winner != null){
				System.out.println("Le gagnant du grand prix est -> " + winner);
			}
			else {
				System.out.println("Elimination de tous les vehicules");
			}
		}
		else {
			System.out.println("Pas de Grand Prix");
		}
	}
}
/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/
public class Course {

    public static void main(String[] args) {
        // PARTIE 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        Vehicule v0 = new Vehicule();
        System.out.println(v0);

        // les arguments du constructeurs sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        Vehicule v1 = new Vehicule("Ferrari", 300.0, 800, 30);
        //0.3
        Vehicule v2 = new Vehicule("Renault Clio", 180.0, 1000, 20);
        //
        System.out.println();
        System.out.println(v1);
        System.out.println();
        System.out.println(v2);

        if (v1.meilleur(v2)) {
            System.out.println("Le premier vehicule est meilleur que le second");
        } else {
            System.out.println("Le second vehicule est meilleur que le premier");
        }
        // FIN PARTIE 1

       // PARTIE2
        System.out.println();
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        // les trois premiers arguments sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        // le dernier argument indique la presence d'un sidecar
        Moto m1 = new Moto("Honda", 200.0, 250, 15, true);
        Moto m2 = new Moto("Kawasaki", 280.0, 180, 10);
        System.out.println(m1);
        System.out.println();
        System.out.println(m2);
        System.out.println();

        // les trois premiers arguments sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        // le dernier argument indique la categorie
        Voiture vt1 = new Voiture("Lamborghini", 320, 1200, 40, "course");
        Voiture vt2 = new Voiture("BMW", 190, 2000, 35, "tourisme");
        System.out.println(vt1);
        System.out.println();
        System.out.println(vt2);
        System.out.println();
        // FIN PARTIE 2

        // PARTIE 3
        System.out.println();
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        GrandPrix gp1 = new GrandPrix();
        gp1.ajouter(v1);
        gp1.ajouter(v2);
        System.out.println(gp1.check());

        GrandPrix gp2 = new GrandPrix();
        gp2.ajouter(vt1);
        gp2.ajouter(vt2);
        gp2.ajouter(m2);
        System.out.println(gp2.check());

        GrandPrix gp3 = new GrandPrix();
        gp3.ajouter(vt1);
        gp3.ajouter(vt2);
        gp3.ajouter(m1);
        System.out.println(gp3.check());

        GrandPrix gp4 = new GrandPrix();
        gp4.ajouter(m1);
        gp4.ajouter(m2);
        System.out.println(gp4.check());
        // FIN PARTIE 3


        // PARTIE 4
        System.out.println();
        System.out.println("Test partie 4 : ");
        System.out.println("----------------");
        GrandPrix gp5 = new GrandPrix();
        gp5.ajouter(vt1);
        gp5.ajouter(vt2);

        System.out.println("Premiere course :");
        gp5.run(11);
        System.out.println();

        System.out.println("Deuxieme  course :");
        gp3.run(40);
        System.out.println();

        System.out.println("Troisieme  course :");
        gp2.run(11);
        // FIN PARTIE 4
    }
}
