import java.util.ArrayList;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Position {
    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
        this.x = 0;
        this.y = 0;

    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public String toString() {
		return "(" + x + ", " + y +  ")";
    }
}

class Neurone {
    private Position position;
    private ArrayList<Neurone> connexions;
    private double signal;
    private double attenuation;

    public Neurone(Position position, double attenuation) {
        this.position = position;
        this.attenuation = attenuation;
        this.signal = 0;
        connexions = new ArrayList<Neurone>();
    }

    public Position getPosition() {
        return this.position;
    }

    public ArrayList<Neurone> getConnexions() {
        return connexions;
    }

    public double getSignal() {
        return this.signal;
    }

    public double getAttenuation() {
        return this.attenuation;
    }

    public Neurone getConnexion(int index) {
        return connexions.get(index);
    }

    public void connexion(Neurone n) {
        connexions.add(n);
    }

    public int getNbConnexions() {
        return connexions.size();
    }

    public void recoitStimulus(double stimulus) {
        this.signal = this.attenuation * stimulus;
        for (Neurone n : connexions) {
            n.recoitStimulus(this.signal);
        }
    }

    public String toString() {
        double d = this.attenuation;
        double f = (double) Math.round(d * 100) / 100;

        String message = "Le neurone en position "+ position.toString() +" avec attenuation "+f+" en connexion avec\n";
        if (getNbConnexions() > 0) {
            for (Neurone n : connexions) {
                message += "  - un neurone en position " + n.position.toString() + "\n";
            }
        } else {
            message += " sans connexion\n";
        }
        return message;
    }
}

class NeuroneCumulatif extends Neurone {
    public NeuroneCumulatif(Position position, double attenuation) {
        super(position, attenuation);
    }

    public void recoitStimulus(double stimulus) {

        super.recoitStimulus(getSignal() / getAttenuation() + stimulus);
    }
}

class Cerveau {
    private ArrayList<Neurone> neurones;

    public Cerveau() {
        neurones = new ArrayList<Neurone>();
    }

    public int getNbNeurones() {
        return neurones.size();
    }

    public Neurone getNeurone(int i) {
        return this.neurones.get(i);
    }

    public void ajouterNeurone(Position pos, double attenuation) {
        this.neurones.add(new Neurone(pos, attenuation));
    }

    public void ajouterNeuroneCumulatif(Position pos, double attenuation) {
        neurones.add(new NeuroneCumulatif(pos, attenuation));
    }

    public void stimuler(int index, double stimulus) {
        neurones.get(index).recoitStimulus(stimulus);
    }

    public double sonder(int index) {
        double d = neurones.get(index).getSignal();
        double f = (double) Math.round(d * 100) / 100;
        return f;
    }

    public void creerConnexions() {
        if (neurones.size() > 1) {
            neurones.get(0).connexion(neurones.get(1));
        }

        if (neurones.size() > 2) {
            neurones.get(0).connexion(neurones.get(2));
        }
        for (int i = 1; i < neurones.size() - 2; i += 2) {
            neurones.get(i).connexion(neurones.get(i + 1));
            neurones.get(i + 1).connexion(neurones.get(i + 2));
        }
    }

    public String toString() {
        System.out.println();
        String msg = "Le cerveau contient " + neurones.size() + " neurone(s)\n";
        for (Neurone n : neurones) {
            msg += n + "\n";
        }
        return msg + "*----------*\n\n";
    }

}

/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/
public class SimulateurNeurone {

    public static void main(String[] args) {
        // TEST DE LA PARTIE 1
        System.out.println("Test de la partie 1:");
        System.out.println("--------------------");

        Position position1 = new Position(0, 1);
        Position position2 = new Position(1, 0);
        Position position3 = new Position(1, 1);
        Position position4 = new Position(12.5, 21.3);

        Neurone neuron1 = new Neurone(position1, 0.5);
        Neurone neuron2 = new Neurone(position2, 1.0);
        Neurone neuron3 = new Neurone(position3, 2.0);
        Neurone neuron4 = new Neurone(position4, 2.0);


        neuron1.connexion(neuron2);
        neuron2.connexion(neuron3);
        neuron3.connexion(neuron4);
        
        neuron1.recoitStimulus(10);

        System.out.println("Signaux : ");
        System.out.println(neuron1.getSignal());
        System.out.println(neuron2.getSignal());
        System.out.println(neuron3.getSignal());

        System.out.println();
        System.out.println("Premiere connexion du neurone 1");
        System.out.println(neuron1.getConnexion(0));

        // FIN TEST DE LA PARTIE 1

        // TEST DE LA PARTIE 2
        System.out.println("Test de la partie 2:");
        System.out.println("--------------------");

        Position position5 = new Position(0, 0);
        NeuroneCumulatif neuron5 = new NeuroneCumulatif(position5, 0.5);
        neuron5.recoitStimulus(10);
        neuron5.recoitStimulus(10);
        System.out.println("Signal du neurone cumulatif  -> " + neuron5.getSignal());

        // FIN TEST DE LA PARTIE 2

        // TEST DE LA PARTIE 3
        System.out.println();
        System.out.println("Test de la partie 3:");
        System.out.println("--------------------");
        Cerveau cerveau = new Cerveau();


        // parametres de construction du neurone:
        // la position et le facteur d'attenuation
        cerveau.ajouterNeurone(new Position(0, 0), 0.5);
        cerveau.ajouterNeurone(new Position(0, 1), 0.2);
        cerveau.ajouterNeurone(new Position(1, 0), 1.0);

        // parametres de construction du neurone cumulatif:
        // la position et le facteur d'attenuation
        cerveau.ajouterNeuroneCumulatif(new Position(1, 1), 0.8);
        cerveau.creerConnexions();
        cerveau.stimuler(0, 10);

        System.out.println("Signal du 3eme neurone -> " + cerveau.sonder(3));
        System.out.println(cerveau);
        // FIN TEST DE LA PARTIE 3
    }
}