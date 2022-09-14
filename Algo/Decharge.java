import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;
							  
public class Decharge {
	private static DecimalFormat df = new DecimalFormat("#.000");
	
       /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
		static double calculerDistance(int x1, int y1, int x2, int y2) {
		double result = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		return result;
		}

		public static int plusProche(int x, int y, int[] coordonneesHabitations) {
			double min = Integer.MAX_VALUE;
			int habitation = 0;

			for (int i = 0; i < (coordonneesHabitations.length - 1); i += 2) {

				int habX = coordonneesHabitations[i];
				int habY = coordonneesHabitations[i + 1];
				double calculateDist = calculerDistance(x, y, habX, habY);

				if (calculateDist < min) {
					min = calculateDist;
					habitation = i;
				}
			}
			return habitation;
		}

		public static int[] troisPlusProches(int x, int y, int[] coordonneesHabitations) {
			int []resultat = new int[6];

			//on fait une copie du tableau coordonneesHabitations pour ne pas le modifié 
			int [] temp = new int [coordonneesHabitations.length];
			System.arraycopy(coordonneesHabitations, 0, temp, 0, coordonneesHabitations.length);

			//on cree une boucle pour parcourir temp a la recherche de la plus petite distance avec la méthode "plusproche"

			for (int index = 0; index < resultat.length; index+=2) {

				//on recherche le plus petite distance
			
				int position = plusProche(x, y, temp);
				resultat[index] = temp[position];
				resultat[index+1] = temp[position+1];
				temp[position] = 1000000;
				temp[position+1] = 1000000;
			
			}

			return resultat;
		}

		public static int [] meilleurePlace(int x, int y , int [] coordonneesHabitations){
			int []gravite = new int [2];
			int cx = 0;
			int cy = 0;
			for (int index = 0; index < 6; index+=2) {
				int[]tableau = troisPlusProches(x, y, coordonneesHabitations);
				cx += tableau[index];
				cy += tableau[index+1];

			}
			cx = cx/3;
			cy = cy/3;
			gravite[0]=cx;
			gravite[1]=cy;

			return gravite;
		}

        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

	public static void afficheTroisPlusProches(int x, int y, int[] coordonneesHabitations) {
		int[] tpp = troisPlusProches(x, y, coordonneesHabitations);
		
		System.out.println("(" + x + "," + y + ") est a :");
		for (int i = 0 ; i < 3 ; i++) {
			System.out.println("    " + df.format(calculerDistance(x, y, tpp[2*i], tpp[2*i+1])) + " de (" + tpp[2*i] + "," + tpp[2*i+1] + ")"); 
		}
	}
	
	

	//PROGRAMME PRINCIPAL
	public static void main(String args[]) {
		
		int[] coordonneesHabitations = {
				9, 30, 18, 8, 3, 18, 25, 36
		};
		
		// Lecture des donnees
		Scanner clavier = new Scanner(System.in);
		System.out.print("Entrez la coordonnee x de la decharge: ");
		int x = clavier.nextInt();
		System.out.print("Entrez le coordonnee y de la decharge: ");
		int y = clavier.nextInt();
		
		// trouve les coordonnees de l'habitation la plus proche
		// (identifiees par l'indice correspondant dans le tableau
		// de coordonnees)
		int plusProche = plusProche(x, y, coordonneesHabitations);
		System.out.println("--- Question 1 ---");
		System.out.println("Coordonnees de l'habitation la plus proche de la decharge :");
		System.out.println("(" + coordonneesHabitations[plusProche * 2] + "," + coordonneesHabitations[plusProche * 2 + 1] + ") ; distance = " +
						   df.format(calculerDistance(x, y, coordonneesHabitations[plusProche * 2], coordonneesHabitations[plusProche * 2 + 1]))  + " metres");	
			
		// trouve les coordonnees des 3 habitations les plus proches et affiche les coordonnees
		
		System.out.println("--- Question 2 ---");
		System.out.println("Coordonnees des 3 habitations les plus proches de la decharge :");
		afficheTroisPlusProches(x, y, coordonneesHabitations);
		
		// affiche le centre de gravite des 3 plus proches (la meilleure place)
		int[] grav = meilleurePlace(x, y, coordonneesHabitations);
		System.out.println("--- Question 3 ---");
		System.out.println("Coordonnees de la meilleure place pour la decharge :");
		System.out.println("(" + grav[0] + "," + grav[1] + ")");
		clavier.close();
	}

}
	