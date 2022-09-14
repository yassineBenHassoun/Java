class MostFrequent {

    public static void main(String[] args) {
        int[] tab1 = {2, 7, 5, 6, 7, 1, 6, 2, 1, 7, 6};
        int taille = tab1.length;

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        boolean visited[] = new boolean[taille];
 	    int[] array = new int[100];  
 	    int maxNum = array[0];


        for (int i = 0; i < taille; i++) {
		   
	        if (visited[i] == true)
	            continue;
	  
	        int count = 1;
	        for (int j = i + 1; j < taille; j++) {
	            if (tab1[i] == tab1[j]) {
	                visited[j] = true;
	                count++;
	                
	            }
	        }
	        
 
	       array[i] = count;
	          
	    }
	
        for (int j : array) {
           if (j > maxNum)
               maxNum = j;
        }


        for (int i = 0; i < taille; i++) {
		   
	        if (visited[i] == true)
	            continue;
	        int count = 1;
	        for (int j = i + 1; j < taille; j++) {
	            if (tab1[i] == tab1[j]) {
	                visited[j] = true;
	                count++;
	                
	            }
	        }
	    
	       if (maxNum == count ) {
	    	   
	    	   System.out.print("Le nombre le plus frequent dans le tableau est le :\n"
	    	   		+ tab1[i]+ " ("+ maxNum + " x)");
	    	   break;
	    	   //7 (3 x)
	       }   
	    }
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

    }
}