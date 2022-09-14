import java.util.*;

public class Champi 
{

	private static Scanner clavier = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String champiT = "";
	
		System.out.println("Pensez à un champignon : amanite tue mouches, pied bleu, girolle,\n"
				+ "cèpe de Bordeaux, coprin chevelu ou agaric jaunissant.");
		
	

		System.out.print("Est-ce que votre champignon a un anneau (true : oui, false : non) ?  ");  
	    boolean q1 = clavier.nextBoolean();  
	        

        System.out.print("Est-ce que votre champignon a un chapeau convexe (true : oui, false : non) ? ");  
        
        boolean q2 = clavier.nextBoolean();
        
        
        if (q1 == false && q2 == true ) {
        	
        	champiT = "le pied bleu";
        	
        	   
    		System.out.print("==> Le champignon auquel vous pensez est ");
        	System.out.print(champiT);
            System.exit(0);
        	
        
        } 

        if (q1 == false && q2 == false ) {
        
        
    	    champiT = "la girolle";
            System.out.print("==> Le champignon auquel vous pensez est ");
            System.out.print(champiT);
            System.exit(0);
        
    
        } 
        
        
        if (q1 == false ) {
        	
        	
            System.out.print("Est-ce que votre champignon à des lamelle (true : oui, false : non) ?"); 
    	    boolean q3 = clavier.nextBoolean();
    	    
    	    if(q3 == true) {
    	    	
    	    	champiT = "le cèpe de Bordeaux";
                  System.exit(0);
    	    	
    	    } else {
    	    	
    	        System.out.print(champiT);
                System.exit(0);
    	    }
    	    
        	
        } else {
        	
            
        	System.out.print("Est-ce que votre champignon vit en forêt (true : oui, false : non) ?");  
    	    boolean q3 = clavier.nextBoolean();
    	    
    	    
    	    
    	    if (q1 == true && q2 == true && q3 == true) {
    	    	
    	    	
    	    	
                champiT = "l'amanite tue-mouches";
    	    	
    	    } 
    	    if(q1 == true && q2 == true && q3 == false) {
    	    	
                champiT = "l'agaric jaunissant";
    	    	
    	    }
    	    
    	    
    	    if(q1 == true && q2 == false && q3 == true) {
    	    	
    	    	champiT = "le coprin chevelu";
    	    }
    	    
    	    
    	    
    	    if(q1 == false && q2 == false && q3 == false) {
    	    	
    	    	champiT = "la girolle";
    	    }
        }    
        
        
		System.out.print("==> Le champignon auquel vous pensez est ");
    	System.out.print(champiT);
  
       
        clavier.close();        
	}

}
