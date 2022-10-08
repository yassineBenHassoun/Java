/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
import java.util.ArrayList;

// La classe Piece Les méthodes publiques de la classe Piece seront :
// — un constructeur permettant d’initialiser le nom de la pièce au moyen d’une
// valeur passée en paramètre ;
// — un getter getNom() ;
// — une méthode toString() produisant une représentation d’une Piece
// respectant strictement le format suivant : <nom> (nom de la pièce).

class Piece 
{
    private String nom;

    public Piece (String nom) {
        this.nom = nom;
    }
    public String getNom() {return this.nom;}

    public String toString() {
        return getNom();
    }
}

// La classe Composant Les méthodes publiques de la classe Composant seront :
// — un constructeur permettant d’initialiser la pièce du composant et sa quantité au moyen de valeurs passées en paramètres (la pièce du composant sera
// initialisée au moyen d’une référence sur une pièce passée en paramètre) ;
// — les getters getPiece() et getQuantite().

class Composant 
{
    private Piece piece;
    private int nbPiece = 0; 

    public Composant (Piece namePiece ,  int quantity) 
    {
        this.piece = namePiece;
        this.nbPiece = quantity;
    }

    public Piece getPiece() {return piece; }
    public int getQuantite() { return nbPiece;}

}  


// simple
// Les méthodes publiques de la classe Simple seront :
// — un constructeur conforme à la méthode main() fournie et permettant
// d’initialiser le nom de la pièce simple et son orientation au moyen de valeurs passées en paramètres. Si aucune valeur n’est donnée pour l’orientation, la valeur par défaut "aucune" sera utilisée ;
// — un getter getOrientation() ;
// — une méthode toString() produisant une représentation d’une pièce
// Simple respectant strictement le format suivant :
// <nom> [<orientation>]
// où <nom> est le nom de la pièce est <orientation> son orientation.
// L’orientation ne sera présente que si sa valeur est différente de "aucune".


class Simple extends Piece
{
    private String orientation; 

    public Simple (String namePiece, String orientation) {
        super(namePiece);
        this.orientation = orientation;
    }

    public Simple (String namePiece) {
        super(namePiece);
        this.orientation = "aucune";
    }

    public String getOrientation () {return this.orientation;}

    public String toString () {
        if (this.orientation == "aucune") {
            return this.getNom();
        }

        return  this.getNom() + " est le nom de la pièce est " + this.orientation + " son orientation.";
    }
}


// La classe Composee 

// Les méthodes publiques de la classe Composee seront :
// — un constructeur conforme à la méthode main() fournie et permettant
// d’initialiser le nom de la pièce composée et le nombre maximal de pièces
// 7
// pouvant la constituer ;


// — une méthode int taille() retournant le nombre de pièces constituant
// la pièce composée ;
// — une méthode int tailleMax() retournant le nombre maximal de pièces
// pouvant constituer la pièce composée ;
// — une méthode void construire() conforme à la méthode main()
// fournie, permettant d’ajouter une pièce dans la liste des pièces constituant
// la pièce composée. Cet ajout ne sera possible que si le nombre de pièces
// maximal n’est pas atteint. S’il y a tentative d’ajout alors que la liste est
// pleine, le message
// Construction impossible
// sera affiché (suivi d’un saut de ligne),
// — une méthode toString() produisant une représentation d’une pièce
// Composee respectant strictement le format suivant :
// <nom> (<description piece1>, <description piece2>, ... <description pieceN> )
// (sans saut de ligne) où <nom> est le nom de la pièce et <descripion pieceX>
// est la représentation sous forme d’une String de la Xieme pièce constituant la pièce composée. Toutes les pièces constituant la pièce composée
// devront être présentes (voir l’exemple de déroulement plus bas).


class Composee extends Piece
{
    private int nbPiece;
    public  ArrayList<Piece> arrayPieces;

    public Composee (String nom, int nbPiece) 
    {
        super(nom);
        this.nbPiece = nbPiece;
        this.arrayPieces = new ArrayList<Piece>();
    }

    public int taille() {return this.arrayPieces.size();}
    public int tailleMax() {return this.nbPiece;} 

    public void construire(Piece piece) {

        if( taille() < tailleMax()) {
            arrayPieces.add(piece);
        } else {

            System.out.println("Construction impossible");
        }
    }

    public String toString(){
		String res = "";
		for (Piece p : arrayPieces){
			res += p.toString() + ",";
		}
		return super.toString() + " (" + res.substring(0, res.length() - 2) + ")";
	}
 
}


// — un constructeur conforme à la méthode main() fournie et permettant
// d’initialiser le nombre maximal de composants pouvant constituer la construction ;
// — une méthode int taille() retournant le nombre de composants constituant la construction ;
// — une méthode int tailleMax() retournant le nombre maximal de composants pouvant constituer la construction ;
// — une méthode void ajouterComposant conforme à la méthode main()
// fournie, permettant d’ajouter un composant dans la liste des composants
// constituant la construction. Cet ajout ne sera possible que si le nombre de
// composants maximal n’est pas atteint. S’il y a tentative d’ajout alors que
// la liste est pleine, le message
// Ajout de composant impossible

class Construction 
{
    private int nbPieces;
    private ArrayList<Composant> composants;
    public Construction (int pieces) 
    {
        this.nbPieces = pieces;
        this.composants = new ArrayList<Composant>();
    }

    public int taille() { return this.composants.size();}
    public int tailleMax() {return this.nbPieces;} 

    public void ajouterComposant(Piece p, int nombre){
		if (taille() < tailleMax()){
			composants.add(new Composant(p, nombre));
		}
		else{
			System.out.println("Ajout de composant impossible");
		}
	}
	
	public String toString(){
		String res = "";
		for(Composant c: composants){
			res += c.getPiece().toString() + " (quantite " + c.getQuantite() + ")\n";
		}
		return res;
	}

}


/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

class Lego {

    public static void main(String[] args) {
        // declare un jeu de construction de 10 pieces
        Construction maison = new Construction(10);

        // ce jeu a pour premier composant: 59 briques standard
        // une brique standard a par defaut "aucune" comme orientation
        maison.ajouterComposant(new Simple("brique standard"), 59);

        // declare une piece dont le nom est "porte", composee de 2 autres pieces
        Composee porte = new Composee("porte", 2);

        // cette piece composee est constituee de deux pieces simples:
        // un cadran de porte orient'e a gauche
        // un battant orient'e a gauche
        porte.construire(new Simple("cadran porte", "gauche"));
        porte.construire(new Simple("battant", "gauche"));

        // le jeu a pour second composant: 1 porte
        maison.ajouterComposant(porte, 1);

        // déclare une piece composee de 3 autres pieces dont le nom est "fenetre"
        Composee fenetre = new Composee("fenetre", 3);

        // cette piece composee est constitu'ee des trois pieces simples:
        // un cadran de fenetre (aucune orientation)
        // un volet orient'e a gauche
        // un volet orient'e a droite
        fenetre.construire(new Simple("cadran fenetre"));
        fenetre.construire(new Simple("volet", "gauche"));
        fenetre.construire(new Simple("volet", "droit"));

        // le jeu a pour troisieme composant: 2 fenetres
        maison.ajouterComposant(fenetre, 2);

        // affiche tous les composants composants (nom de la piece et quantit'e)
        // pour les pieces compos'ees : affiche aussi chaque piece les constituant
        System.out.println("Affichage du jeu de construction : ");
        System.out.println(maison);
    }
}
