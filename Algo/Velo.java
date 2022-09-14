import java.util.Scanner;

public class Velo {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.print("Donnez l'heure de début de la location (un entier) : ");
        int debut = clavier.nextInt();
        System.out.print("Donnez l'heure de fin de la location (un entier) : ");
        int fin = clavier.nextInt();
        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        int debutFin = fin - debut;
        int matin = 0;
        int apresMidi = 0;
        int soir = 0;

        if (debut < 0 || fin < 0 || debut > 24  || fin > 24 ) {

                System.out.println("Les heures doivent être comprises entre 0 et 24 !");

        } else if (debut > fin) {
        	
        	System.out.println("Bizarre, le début de la location est après la fin ...");
        	
        } else if (debut == fin ) {

            System.out.println("Bizarre, vous n'avez pas loué votre vélo bien longtemps !");
        }
    
        else {

                if (debut < 7 && fin < 7 ) {

                matin = debutFin;
                }

                else if (debut < 7 && fin < 17 ) {

                matin = 7 - debut;
                apresMidi = debutFin - matin;


                }
                else if  (debut >= 7 && fin <= 17) {

                apresMidi = debutFin;

                }
                else if (debut > 17) {

                soir  = debutFin;

                } else if (debut >= 7 && fin > 17 ) {
                	
                	
                soir = fin - 17; 
                apresMidi = debutFin  - soir ;
      

                } else if(debut == 17 ) {
                
                	soir = debutFin;
                	
                }
                
                else if (debut < 7 && fin >= 17 ) {

                matin  =  7 - debut;
                apresMidi = 10;
                soir  =  (debutFin - matin) - apresMidi ;
                } 

               
                System.out.println("Vous avez loué votre vélo pendant");
                int countMorningNight = matin + soir;

                if(countMorningNight > 0) {

                    System.out.println(countMorningNight + " heure(s) au tarif horaire de 1.0 franc(s)");

                } 
                if (apresMidi > 0 ) {

                    System.out.println(apresMidi + " heure(s) au tarif horaire de 2.0 franc(s)");
                }

                double total = countMorningNight + (apresMidi * 2);
                System.out.println("Le montant total à payer est de " + total + " franc(s).");

                

         }
   
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

        clavier.close();
    }
}