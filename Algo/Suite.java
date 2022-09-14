import java.util.Scanner;

class Suite {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        int debut;
        do {
            System.out.print("de (>= 1) ? ");
            debut = clavier.nextInt();
        } while (debut < 1);

        int fin;
        do {
            System.out.print("a (>= " + debut + ") ? ");
            fin = clavier.nextInt();
        } while (fin < debut);

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        if (debut <= fin) {

      		for(int i = debut ; i <= fin; i++ ) {

      			int iteration = 0;
      			int toto =  i;
      			do {

      				if((toto % 3 )  == 0  ) {

      					toto = toto + 4;

      				} else if ((toto % 4) == 0 ) {

      					toto = toto / 2;


      				} else {
      					toto = toto - 1;
      				}

      				iteration++;

      			} while(toto != 0);

      			System.out.println(i +" -> " + iteration );
      		}
        }

        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
        clavier.close();
    }
}
