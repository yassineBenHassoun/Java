import java.util.Scanner;

class Parachutiste {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        double masse = 80.0;
        do {
            System.out.print("masse du parachutiste (>= 40) ? ");
            masse = clavier.nextDouble();
        } while (masse < 40.0);

        double h0 = 39000.0;
        do {
            System.out.print("hauteur de depart du parachutiste (>= 250) ? ");
            h0 = clavier.nextDouble();
        } while (h0 < 250.0);

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        double g = 9.81;
        double v0 = 0;
        double t0 = 0;
        double vitesse = v0;
        double accel= 0;
        double hauteur= h0;
        double t = 0;
        int surface = 2;

        accel = g;

        double s = 0 ;
	      double q = 0;
        boolean vitesseDuSon = false;
        boolean vitesseMaximale = false;
        boolean ouvertureParachute = false;

  	    System.out.printf("%.0f, %.4f, %.4f, %.5f\n", t, hauteur, vitesse, accel);


	      while (hauteur > 0) {


	        	 t++;
		    	   s = surface / masse ;
		         q = Math.exp( -s * (t - t0));
		         vitesse = (g/s) * (1.0 - q) + (v0 * q);
		         hauteur = h0-(g/s) * (t-t0)-((v0-g/s)/s)*(1.0-q);
		         accel = g - s * vitesse;

		         if(hauteur > 0) {

		        	 System.out.printf("%.0f, %.4f, %.4f, %.5f\n", t, hauteur, vitesse, accel);

		         }

		         if (vitesseMaximale == false && accel < 0.5) {
		              System.out.println("## Felix a atteint sa vitesse maximale");
		              vitesseMaximale = true;
		         }


		         if (vitesseDuSon == false && vitesse > 343) {
		              System.out.println("## Felix depasse la vitesse du son");
		              vitesseDuSon = true;
		         }


		         if (ouvertureParachute == false && hauteur <= 2500) {

		              ouvertureParachute = true;
		              surface = 25;
		              s = surface / masse;
		              v0 = vitesse;
		              t0 = t;
		              h0 = hauteur;

		              System.out.println("## Felix ouvre son parachute");
		         }

       }
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
        clavier.close();
    }
}
