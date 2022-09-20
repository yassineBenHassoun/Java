import java.util.ArrayList;

class Auteur {

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    // Completer la classe Auteur ici
    private String nom;
    private boolean prix;

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isPrix() {
        return this.prix;
    }

    public boolean getPrix() {
        return this.prix;
    }

    public void setPrix(boolean prix) {
        this.prix = prix;
    }

    public Auteur(String nom, boolean prix) {

        this.nom = nom;
        this.prix = prix;
    }
}

class Oeuvre {
    // Completer la classe Oeuvre ici
    private String titre;
    private String langue;
    private Auteur auteur;

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLangue() {
        return this.langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public Auteur getAuteur() {
        return this.auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public Oeuvre(String titre, Auteur aut, String langue) {
        this.langue = langue;
        this.titre = titre;
        auteur = aut;
    }

    public Oeuvre(String titre, Auteur aut) {
        this.titre = titre;
        this.auteur = aut;
        this.langue = "francais";
    }

    public void afficher() {
        Auteur a = this.auteur;

        System.out.printf("%.1f, %.1f, en  %.1f m\n", this.titre, a.getNom(), this.langue);
    }

}

class Exemplaire {
    private Oeuvre oeuvre;

    public Oeuvre getOeuvre() {
        return this.oeuvre;
    }

    public void setOeuvre(Oeuvre oeuvre) {
        this.oeuvre = oeuvre;
    }

    public Exemplaire(Oeuvre oeuvre) {

        this.oeuvre = oeuvre;

        System.out.println("Nouvel exemplaire -> "
		+ this.oeuvre.getTitre() + ", "
		+ this.oeuvre.getAuteur().getNom() + ", en "
		+ this.oeuvre.getLangue());
    }

    public Exemplaire(Exemplaire ex) {
        this.oeuvre = ex.oeuvre;
        System.out.println("Copie d'un exemplaire de ->"
                + this.oeuvre.getTitre() + ", "
                + this.oeuvre.getAuteur().getNom() + ", en "
                + this.oeuvre.getLangue());
    }

    public void afficher() {
        System.out.print("Un exemplaire de "
                + this.oeuvre.getTitre() + ", "
                + this.oeuvre.getAuteur().getNom() + ", en "
                + this.oeuvre.getLangue());
    }
}

class Bibliotheque {
    private ArrayList<Exemplaire> exemplaires = new ArrayList<Exemplaire>();
    private String nom;

    public Bibliotheque(String name) {
        this.nom = name;

        System.out.println("La bibliothèque " + this.nom
                + " est ouverte !");

    }

    public Bibliotheque(String name, ArrayList<Exemplaire> exemplaires) {

        this.nom = name;
        this.exemplaires = exemplaires;
    }

    public String getNom() {
        return this.nom;
    }

    public int getNbExemplaires() {

        if (this.exemplaires.isEmpty()) {
            return 0;
        }
        System.out.println(this.exemplaires.size());
        return this.exemplaires.size();
    }

    public void stocker(Oeuvre oeuvre, int nbExamplaire) {

        if (nbExamplaire == 0) {

            nbExamplaire = 1;
        }

        for (int i = 0; i < nbExamplaire; i++) {
            Exemplaire ex = new Exemplaire(oeuvre);
            this.exemplaires.add(ex);
        }
    }

    public void stocker(Oeuvre book) {
        this.stocker(book, 1);
    }

    public ArrayList<Exemplaire> listerExemplaires() {

        return this.exemplaires;
    }

    public ArrayList<Exemplaire> listerExemplaires(String langue) {
        ArrayList<Exemplaire> exLang = new ArrayList<Exemplaire>();
        for (int i = 0; i < this.exemplaires.size(); i++) {
            Exemplaire exIn = (Exemplaire) this.exemplaires.get(i);
            String inLang = exIn.getOeuvre().getLangue();
            if (langue.equals(inLang)) {
                exLang.add(exIn);
            }
        }
        return exLang;
    }

    public int compterExemplaires(Oeuvre book) {
        int num = 0;
        for (int i = 0; i < this.exemplaires.size(); i++) {
            Exemplaire exIn = (Exemplaire) this.exemplaires.get(i);
            Oeuvre bookIn = exIn.getOeuvre();
            if (bookIn.equals(book)) {
                num++;
            }
        }
        return num;
    }

    public void afficherAuteur(boolean aw) {
        for (int i = 0; i < this.exemplaires.size(); i++) {
            Exemplaire exIn = (Exemplaire) this.exemplaires.get(i);
            boolean award = exIn.getOeuvre().getAuteur().getPrix();
            if (aw == award) {
                System.out.println(exIn.getOeuvre().getAuteur().getNom());
            }
        }
    }

    public void afficherAuteur() {
        afficherAuteur(true);
    }
}

// completer les autres classes ici

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

public class Biblio {

    public static void afficherExemplaires(ArrayList<Exemplaire> exemplaires) {
        for (Exemplaire exemplaire : exemplaires) {
            System.out.print("\t");
            exemplaire.afficher();
        }
    }

    public static void main(String[] args) {
        // create and store all the exemplaries
        Auteur a1 = new Auteur("Victor Hugo", false);
        Auteur a2 = new Auteur("Alexandre Dumas", false);
        Auteur a3 = new Auteur("Raymond Queneau", true);

        Oeuvre o1 = new Oeuvre("Les Miserables", a1, "francais");
        Oeuvre o2 = new Oeuvre("L\'Homme qui rit", a1, "francais");
        Oeuvre o3 = new Oeuvre("Le Comte de Monte-Cristo", a2, "francais");
        Oeuvre o4 = new Oeuvre("Zazie dans le metro", a3, "francais");
        Oeuvre o5 = new Oeuvre("The count of Monte-Cristo", a2, "anglais");

        Bibliotheque biblio = new Bibliotheque("municipale");
        biblio.stocker(o1, 2);
        biblio.stocker(o2);
        biblio.stocker(o3, 3);
        biblio.stocker(o4);
        biblio.stocker(o5);

        // ...
        System.out.println("La bibliotheque " + biblio.getNom() + " offre ");
        afficherExemplaires(biblio.listerExemplaires());
        String langue = "anglais";
        System.out.println("Les exemplaires en " + langue + " sont  ");
        afficherExemplaires(biblio.listerExemplaires(langue));
        System.out.println("Les auteurs a succes sont  ");
        biblio.afficherAuteur();
        System.out.print("Il y a " + biblio.compterExemplaires(o3) + " exemplaires");
        System.out.println(" de  " + o3.getTitre());
    }
}
