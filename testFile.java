import java.util.Scanner;

public class testFile {
	public static void main(String[] Args){
		
//		TreeNavigator tree= new TreeNavigator();
		Scanner scan= new Scanner(System.in);
//		
//		while(true){
//			System.out.println("\n\t\tMAIN MENU");
//			System.out.println("I)	Import A Tree From A File");
//			System.out.println("E)	Edit Current Tree");
//			System.out.println("C)	Classify A Description");
//			System.out.println("P)	Show Descition Path For A Description ");
//			System.out.println("Q)	Quit");
//			
//			System.out.println("Enter a menu option");
//			String allUpper =scan.next();
//			allUpper = allUpper.toUpperCase();
//			char choice = allUpper.charAt(0);
//
//			
//			switch (choice) {
//			
//		         case 'I': 
//		        	 
//		        	 	break;
//		        	 
//		         case 'E': 
//		 			while(printEditSubMenu(tree, scan)){	}
//		        	 	break;
//		        	 	
//		         case 'C': 
//		        	 
//		        	 	break;
//		        	 	
//		         case 'P': 
//		        	 
//		        	 	break;
//		        	 	
//		         case 'Q': 
//		        	 	System.exit(0);
//		        	 	break;
//			
//			
//			
//			
//			}	
//		}	
//	}
//		
//
//	public static boolean printEditSubMenu(TreeNavigator tree, Scanner scan){
//		System.out.print("\n"); 		
//		System.out.println("E)	Edit Keywords");
//		System.out.println("C)	Add Children (Children are automatically leaves, can also be edited later)");
//		System.out.println("D)	Delete Children, and Make Leaf Ask user for new value for keyword(only one, no commas).");
//		System.out.println("N)	Cursor to No Child");
//		System.out.println("Y)	Cursor to Yes Child");
//		System.out.println("R)	Cursor to Root");
//		System.out.println("P)	Print the Node");
//		System.out.println("M)	Main Menu");
//		
//		
//		System.out.println("Enter a menu option");
//		String allUpper =scan.next();
//		allUpper = allUpper.toUpperCase();
//		char choice = allUpper.charAt(0);
//
//		
//		switch (choice) {
//		
//	         case 'E': 
//	        	 //edit keywords 
//	 			System.out.println("Would you like to clear the contents of this node before adding a key? (Y or N)");
//				String decision =scan.next();
//				decision = decision.toUpperCase();
//				//clears current key of cursor if decision is yes
//				if(decision.equals("Y")){
//					tree.clearKey();
//				}
//				
//				System.out.println("Enter a the keyword for this node seperated by a comma, then press enter");
//				String tempKey = scan.nextLine();
//				 tempKey = scan.nextLine();
//				tempKey = tempKey.toUpperCase(); 
//				tree.addKey(tempKey);
//				break;
//					
//	         case 'C': //add children
//	        	 
//	        	 	tree.addChildren();
//	        	 	break;
//	                  
//	         case 'D': //Delete Children
//	        	 	tree.deleteChildren();
//	        	 	break;
//	                  
//	         case 'N': //Cursor to No child
//	        	 	tree.cursorLeft();
//	        	 	break;
//	             	  
//	         case 'Y': //Cursor to Yes child
//	        	 	tree.cursorRight();
//	        	 	break;
//	                 
//	         case 'R':  //Cursor to root
//	        	 tree.resetCursor();
//	        	 break;
//	          
//	         case 'P': //print node
//	        	 	tree.printNode();
//	            break;       
//	            
//	         case 'M': //quit
//	        	 
//	        	 return false;  
//	    
//	         default: 
//	        	 	System.out.println("No Such Operation");
//	        	 	return true;
//	}
//		return true;
		
		
			for(int i=0;i<=0;i++){
				System.out.println("Enter a String");
			}
	}
		
		
}