//Sharyar Khan				ID: 110677446			Homework 5



import java.util.List;

/**
 * @author Sharyar
 * TreeNode creates a node that has various attributes. Each node has an array of keywords, 
 * a left child and a right child. various helper methods exist to clear the keywords, print the keywords etc.
 *  
 * 
**/

public class TreeNode {

	
	private String[] keyword;
	//keeps track of how big the keyword array is
	int arrayCursor;
	
	private TreeNode left;
	private TreeNode right;
	
	
	//constructor
	TreeNode(){		
		//set cursor to the front of the array initially
		arrayCursor=0;
		left=null;
		right=null;
		keyword= new String[100];
	}
	
 	
	//setters
	/**
	 * @param temp takes a TreeNode that is to be set as the new child left
	 */
	public void setLeft(TreeNode temp){
		left=temp;
	}
	
	
	/**
	 * @param temp takes a TreeNode that is to be set as the new right child node
	 */
	public void setRight(TreeNode temp){
		right=temp;
	}
	
	
	//getters
	/**
	 * @return the left child node of the current cursor
	 */
	public TreeNode getLeft(){
		return left;
	}
	
	/**
	 * @return the right child node of the current cursor
	 */
	public TreeNode getRight(){
		return right;
	}
	
	
	//methods
	/**
	 * this method will take a string holding multiple keywords seperated by a comma and
	 * split it according to where the comma's are placed, holding it in an array
	 * @param temp takes a string that is holding all the desired keywords
	 */
	public void addKey(String temp){
	      for (String newTemp: temp.split(",")) {
	  		keyword[arrayCursor]=newTemp;
	  		arrayCursor++;
	       }
	}
	
	
	/**
	 * this will clear the key to which the cursor is currently pointing at
	 */
	public void clearKey(){
		//if the cursor is at the start of the array (position 0, it is already empty)
		if(arrayCursor==0){
			return;
		}
		else{
			//else if the cursor is not 0, it will set all the previous array locations to null;
			for(int i=0; i<arrayCursor; i++){
	 			keyword[i]=null;
	 		}
			arrayCursor=0;
		}
}
	
	
 	/**
 	 * @return whether the current cursor is a leaf or not
 	 */
 	public Boolean isLeaf(){

		if(left==null && right==null){
			return true;
		}
		return false;
	}

 	
 	//prints whatever is in the String
 	/**
 	 * will print the current keywords held in an array
 	 */
 	public void getKeywords(){
 		
 		if(arrayCursor==0){
 			System.out.println("This node is initialized but does not have a keyword");
 			return ;
 		}
 		
  		for(int i=0; i<arrayCursor; i++){
 			System.out.println(keyword[i]);
 		}
 		
 	}
 	
 	
 	/**
 	 * method occasionaly used when a string with all the current keywords is needed
 	 * @return a String that holds the keywords
 	 */
 	public String getKeywordsString(){
 		
 		if(arrayCursor==0){
 			System.out.println("This node is initialized but does not have a keyword");
 			return "Cannot Be Found";
 		}
 		
 		if(arrayCursor==1){
 			return keyword[0];
 		}
 		
 		String message= "";
 		for(int i=0; i<arrayCursor; i++){
 			//for formatting issues
 			if(i==arrayCursor-1){
 	 			message=message.concat(keyword[i]+ " ");
 	 			break;
 			}
 			message=message.concat(keyword[i]+ ", ");
 		}
	
 	return message;

 	}
 	
 	
 	
 	/**
 	 * @return whether the current node has a keyword store in it
 	 */
 	public boolean hasKeyword(){
 		if(arrayCursor==0){
 			return false;
 		}
 		else{
 			return true;
 		}
 	}
 	
 	
 	/**
 	 * @param textToCompare a string that holds the specific keyword that you want to compare to the 
 	 * keywords stored at this node
 	 * @return will return true or false depending on whether the text is found in any of the node's keywords 
 	 */
 	public boolean compareKeyword(String textToCompare){
 		if(arrayCursor==0){
 			System.out.println("This node is initialized but does not have a keyword");
 			return false;
 		}
 		for(int i=0; i<arrayCursor; i++){
	 	
 			if(keyword[i].equals(textToCompare)){
 				return true;
 			}
 		}
			return false;
 		}
 		
 	
}
