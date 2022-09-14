import java.util.Scanner;

public class Crypto {

    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    static final int DECALAGE = 4;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Veuillez entrer une chaine de caracteres : ");
        String s = scanner.nextLine();

        // la chaine a coder
        String aCoder = "";
        // la chaine codee
        String chaineCodee = "";

        /*******************************************
         * Completez le programme a partir d'ici.
        *******************************************/
           
            
        
            String [] alpha = ALPHABET.split("");
            String [] valueArray = null;
            String [] receiptVal = null;
            String valeur = "";
        

            if (s.contains("'") == true) {
              
                s = s.replace("'", "");
                
            } 

            if (s.contains("-") == true) {
                
                s = s.replace("-", "");
                
            } 
        
            s = s.replaceAll("[0-9]", "");
            s = s.replaceAll("[^a-zA-Z0-9 .-]", "");  
            s = s.replaceAll("[A-Z]","");
            
            
            aCoder = s;
            valueArray = s.split(""); 
            
            for (String val : valueArray) {
                
                receiptVal = val.split("(?!^)");
                
                
                for (String v : receiptVal) {
                    
                    
                    int counter = 0; 
                    
                    
                    for (int i = 0; i < alpha.length; i++) {
                        
                        
                        if(v.equals(alpha[i]) == true )  {
                    
                            counter = (i + DECALAGE);
                        } 
                        
                        if (v.matches("^\\s*$") == true) {

                            counter = -1;
                        }	

                    }
                    
                    
                    if (counter == -1) {
                        
                        System.out.print(" ");
                        valeur += " ";
                    } else {
                        
                        if (counter == 29 ) {
                            valeur += alpha[3];
                        } else if (counter == 28) {
                            
                            valeur += alpha[2];			    		
                        } else if (counter == 27) {
                            
                            
                            valeur += alpha[1];
                        } 
                            else if (counter == 26) {
                                valeur += alpha[0];
                        } 
                        
                        
                        else {
                            
                            valeur += alpha[counter];
                                                    
                        }
                    }
                
                }
            }
            

            
            chaineCodee = valeur;

        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
        System.out.format("La chaine initiale etait : '%s'\n", s);

        if (aCoder.isEmpty()) {
            System.out.println("La chaine a coder est vide.\n");
        } else {
            System.out.format("La chaine a coder est : '%s'\n", aCoder);
            System.out.format("La chaine codee est : '%s'\n", chaineCodee);
        }
    }
}