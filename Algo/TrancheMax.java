import java.util.ArrayList;
import java.util.Scanner;

class TrancheMax {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        // Entree de la matrice
        System.out.println("Saisie de la matrice :");
        String matrice = clavier.nextLine();
        System.out.format("Matrice saisie :\n%s\n", matrice);
        clavier.close();

        // Validation de la matrice
        if (!checkFormat(matrice)) {
            return;
        }

        // Trouver la liste des lignes avec le plus grand nombre de 1 consecutif
        // Ces numéros de lignes sont stockés dans un tableau dynamique
        ArrayList<Integer> maxConsecutifList = findConsecutiveList(matrice);

        if (maxConsecutifList.isEmpty()) {
            System.out.println("Pas de lignes avec des 1 !");
        } else {
            System.out.println("Ligne(s) avec le plus de 1 consecutifs :");
            for (Integer index : maxConsecutifList) {
                System.out.println(index);
            }
        }
    }

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/

    public static Boolean checkFormat(String matrice) {

        if (matrice.length() == 0) {
            System.out.println("Matrice vide !");
            return false;
        }

        String reformatSpaces = new String(matrice).trim().replaceAll(" +", " ");
        boolean checkLen = checkLineLength(reformatSpaces);
        String[] v = reformatSpaces.split(" {1,}");
        String [] lignes = reformat(v);

        if (checkLen != true) {

            return false;
        }

        for (int l = 0; l < lignes.length; l++) {

            String mat = lignes[l];
            char[] chars = mat.toCharArray();

            for (char ch : chars) {

                if (ch != '1' && ch != '0') {
                    System.out.println("Matrice invalide : seuls '1', '0' et ' ' sont admis !");
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkLineLength(String matrice) {

        String[] splitLignes = matrice.split(" {1,}");
        String [] lignes = reformat(splitLignes);
        int lenOrigin = lignes[0].length();

        for (int l = 0; l < lignes.length; l++) {
            int len = lignes[l].length();

            if (lenOrigin != len) {
                System.out.println("Matrice invalide, lignes de longueurs differentes !");
                return false;
            }
        }

        return true;

    }

    public static ArrayList<Integer> findConsecutiveList(String matrice) {

        String[] splitLignes = matrice.split(" {1,}");
        String [] lignes = reformat(splitLignes);
        ArrayList<Integer> result = new ArrayList<Integer>();

        int maxValue = 0;
        int iteration = 0;

        for (int l = 0; l < lignes.length; l++) {

            String mat = lignes[l];
            int numbOfOnes = calculate(mat);

            if (numbOfOnes > maxValue) {
                    maxValue = numbOfOnes;
                    iteration = l ; 
            }
        }

        result.add(0,iteration);

        for (int l = 0; l < lignes.length; l++) {

            String mat = lignes[l];
            int numbOfOnes = calculate(mat);

            if ( maxValue == numbOfOnes && iteration != l) {
                   result.add(l);
            }
        }
        return result;

   
    }

    public static String[] reformat (String[] lignes) {

        String[] newLignes = new String[lignes.length - 1];

        if(lignes[0].isEmpty() == true ) {
            int rm_index = 0; 
            for (int i = 0, k = 0; i < lignes.length; i++) { 
                if (i == rm_index) { 
                    continue; 
                } 
                newLignes[k++] = lignes[i]; 
            } 

            return newLignes;
        }

        return lignes;
    }

    public static int calculate(String numbers) {

        char[] nums = numbers.toCharArray();

        int cnt = 0;
        int maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == '1') {
                cnt++;
            } else {
                cnt = 0;
            }

            if (maxi < cnt) {

                maxi = cnt;
            }
        }

        if (maxi == 1) {
            maxi = 0;
        }
        return maxi;
    }
    /*******************************************
     * Ne rien modifier apres cette ligne
     *******************************************/
}