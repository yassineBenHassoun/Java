import java.util.Scanner;

public class Paques {
    private final static Scanner CLAVIER = new Scanner(System.in);

    public static int demanderAnnee() {
        int annee = 0;
        while (annee < 1583 || annee > 4000) {
            System.out.println("Entrez une annee (1583-4000) :");
            annee = CLAVIER.nextInt();
        }
        return annee;
    }

    public static int datePaques(int year) {

        int siecle = year / 100;
        int p = (13 + 8 * siecle) / 25;
        int q = siecle / 4;
        int m = (15 - p + siecle - q) % 30;
        int n = (4 + siecle - q) % 7;
        int d = (m + 19 * (year % 19)) % 30;
        int e = (2 * (year % 4) + 4 * (year % 7) + 6 * d + n) % 7;
        int day = e + d + 22;

        if (e == 6 && (d == 29 || (d == 28 && 11 * (m + 1) % 30 < 19))) {

            day = day - 7;
        }
        return day;
    }

    public static String afficheDate(int annee, int nbDay) {

        String month = "";

        if (nbDay >= 22 && nbDay <= 56) {

            if (nbDay >= 22 && nbDay <= 31) {
                month = "mars";
            }
            if (nbDay > 31 && nbDay <= 56) {
                nbDay = nbDay - 31;
                month = "avril";
            }
        }
        return "Date de Paques en " + annee + " : " + nbDay + " " + month;
    }

    public static void main(String args[]) {

        int annee = demanderAnnee();
        int jour = datePaques(annee);

        System.out.println(afficheDate(annee, jour));

    }

}