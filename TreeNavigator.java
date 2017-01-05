

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Sharyar
 *This class constructs a TreeNode either by manually adding children to a node (left and right
 *child at the same time) or by constructing a tree from a file. Can be used to search for people/things 
 **/
public class TreeNavigator {
	
	private TreeNode root= new TreeNode() ;
	private TreeNode cursor;

	private Scanner scan;
	
	public int[] id= new int[100];	//used to keep track of a decision path
	public int idCount=0;			//keeps track of the position in the array
	
	
	
	/**
	 * Default Constructor, sets the cursor to the root
	 */
	TreeNavigator(){
		this.cursor=root;
	}
	

	
	//assigned methods
	/**
	 * @param fileName takes a file name and opens up a file stream with it. Must be exact filepath
	 * @return a TreeNavigator object that has been fully built
	 */
	public static TreeNavigator buildTree(String fileName){
		
		//Declaration of the tree that will hold the file's tree
		TreeNavigator tree= new	TreeNavigator();
		
		//opening the file
		
		File unparsedFile = new File(fileName);
 		//create an empty FileInputStream
 		Scanner inputFile=null;
 		//holds the string that has the input
 		
 		try {
 			inputFile = new Scanner(unparsedFile);

 			//inputFile.read() returns -1 of type Long when there is no longer anything in the file , similar to an EOF
 			while (inputFile.hasNextLine()) {
 				String treeFile=inputFile.nextLine();
 			
 				//the following code will run for each line of the file
 				
 				
 				//temp string array to hold the input as 3 separate Strings, separate by ;
 				//temp string array to hold the input as 3 separate Strings, separate by ;
 				int i=0;
 				String temp[] = treeFile.split(";");
 				

 				//can hold up to 100 char, each describing a path
 				//pathCursor keeps track of how big the array is
 				char[] pathArray= new char[100];
 				int pathCursor=0;

 				//once again split the first part of the string, which holds the path, into an array of chars,
 				//parse each String into a char and then set equal to its position in a char array
 				for(String newTemp: temp[0].split("-")){
 					char c=newTemp.charAt(0);
 					pathArray[i]=c;
 					i++;
 					pathCursor++;
 				}

 				//now we have a fully parsed input of a line in the text file. We need to now navigate to the relevant node and 
 				//then add it to the tree. To do this, we will navigate up until the second to last position. Once we are there
 				//depending on whether it is a one or zero, we will add a right or left child.
 				
 				//this will check to see whether or not there is a root made already,
 				//if there isn't we will add a key to the root
 				if(!tree.getCursor().hasKeyword()){
 					tree.root.addKey(temp[1].toUpperCase());
 					continue ;
 				}
 				

 				//then we move on to the rest of the path array, getting the left or right depending on 
 				// whether it is a 0 or 1.
 				//The for loop increments the path array to just before the last location, in order to navigate
 				//to that specific part of the tree. Once it has reached the spot, it will add the last node 
 				if(pathCursor>0){
 					for(i=1;i<pathCursor-1;i++){
 						if(pathArray[i]=='0'){
 							tree.cursor=tree.cursor.getLeft();
 						}
 						else{
 							tree.cursor=tree.cursor.getRight();
 						}
 					}
 				}
 				
 				
 				//takes care of creating the last path's locations new node (Ex. in the path 0-0-0-1 this will 
 				//create the right child node 1
 				
 				
 				if(pathArray[pathCursor-1]=='0'){
 					//creates a new tree node, sets it to the left of the cursor
 					TreeNode newNode= new TreeNode();
 					tree.cursor.setLeft(newNode);
 					//sets the cursor to the left child node
 					tree.cursor=tree.cursor.getLeft();	
 					tree.cursor.addKey(temp[1].toUpperCase());

 				}
 				
 				else{
 					TreeNode newNode= new TreeNode();
 					tree.cursor.setRight(newNode);
 					//sets the cursor the the right child node
 					tree.cursor=tree.cursor.getRight();
 					tree.cursor.addKey(temp[1].toUpperCase());
 				}
 				

 				tree.resetCursor();

 			}

 		} catch (IOException e) {
 			System.out.println("File Could Not Be Opened, Please Make Sure to Include the While File Path"); 		
 		} 
		
		System.out.println("\n Tree Successfully Loaded\n\n");

		return tree;
	}
	
	
	/**
	 * @param text takes a text that you'd like to classify in the tree. Can be a word or a sentence
	 * @return what the Binary tree classifies the string as
	 */
	public String classify(String text){
		//clears the id count array
		
		String classifyArray[] = text.split(" ");
		
		//used to store Classification
		String classifiedAs="";
		resetCursor();
		
		if(root.isLeaf()){
			return root.getKeywordsString();
		}
		
		while(!cursor.isLeaf()){
			
			boolean containsKeywords=compareKeywords(classifyArray);
			
			if(containsKeywords){
	 			System.out.println("getting right node");
				cursor=cursor.getRight();
				classifiedAs=cursor.getKeywordsString();
				//used to keep a running track of the path
			}
			else{
	 			System.out.println("getting left node");
				cursor=cursor.getLeft();
				classifiedAs=cursor.getKeywordsString();
				//used to keep a running track of the path
			}
		}
		
		return classifiedAs;
		
	}	
		
	
	/**
	 * this is used when you don't want to output a decision, and are using it to return the decision path 
	 * @param text takes a text that you'd like to classify in the tree. Can be a word or a sentence
	 */
	public void classifyForPath(String text){
		//clears the id count array
		idCount=0;
				
		String classifyArray[] = text.split(" ");
		
		//used to store Classification
		resetCursor();
		
		while(!cursor.isLeaf()){
			
			boolean containsKeywords=compareKeywords(classifyArray);
			
			if(containsKeywords){
				cursor=cursor.getRight();
				//used to keep a running track of the path
				incrementId(true);
			}
			else{
				cursor=cursor.getLeft();
				//used to keep a running track of the path
				incrementId(false);
			}
		}
		
		
	}	
	
	
	/**
	 * @return the complete path, as a String of what decisions were made at each node when classfying the 
	 * inputted string
	 */
	public String getPath(){
		
		resetCursor();
		
		String path="";
		

		for(int i=0;i<=idCount-1;i++){
			if(id[i]==1){
				System.out.println(cursor.getKeywordsString());
				
				path=path.concat("IS "+cursor.getKeywordsString()+ ", ");
				cursor=cursor.getRight();
			}
			
			else{
				System.out.println(cursor.getKeywordsString());
				path=path.concat("NOT "+cursor.getKeywordsString()+ ", ");
				cursor=cursor.getLeft();
			}
		}
		
//		if(id[idCount]==1){
//			cursor=cursor.getRight();
//		}
//		else{
//			cursor=cursor.getLeft();
//		}
		
		path=path.concat("Decision: " + cursor.getKeywordsString());

		
		return path;
	}
	
	
	/**
	 * Resets the cursor to the root of this Tree
	 */
	public void resetCursor(){
		cursor=root;
	}
	
	
	
	/**
	 * Resets the cursor the left child if possible (not null)
	 */
	public void cursorLeft(){
		if(cursor.getLeft()==null){
			System.out.print("Cursor is a leaf, cannot get new node");
			return;
		}
		cursor=cursor.getLeft();
		if(cursor.isLeaf()){
			System.out.print("Cursor is at a left leaf");
		}
	}
	
	
	/**
	 * Resets the cursor the right child if possible (not null)

	 */
	public void cursorRight(){
		if(cursor.getRight()==null){
			System.out.print("Cursor is a leaf, cannot get new node");
			return;
		}
		cursor=cursor.getRight();
		if(cursor.isLeaf()){
			System.out.print("Cursor is at a left leaf");
		}
	}
	
	
	/**
	 * @return the location of the cursor
	 */
	public TreeNode getCursor(){
		return cursor;
	}
	
	
	/**
	 * @param text desired text that you would like to add the to keywords stored by this node
	 */
	public void editCursor(String text){
		this.cursor.addKey(text);
		System.out.print(cursor.toString());
	}

	
	
	//my methods
	/**
	 * this method is used when you want to add children to a leaf node. Asks for the desired keywords 
	 * for both the right and left child nodes.
	 */
	public void addChildren(){
		scan = new Scanner(System.in);	
		
		//makes sure that the cursor does not have children, then proceeds to build children
		if(cursor.getLeft() == null && cursor.getRight() == null)
		{
			//Declares node for NO (Left) tree
			TreeNode newLeft = new TreeNode();
			cursor.setLeft(newLeft);
			
			//reads the keywords for the NO (Left) tree
			System.out.println("Enter keywords for the No leaf seperated by a comma, then press enter");
			String tempKey = scan.nextLine();
			tempKey = tempKey.toUpperCase();
			String leftKey = tempKey.replaceAll("\\s+","");
			newLeft.addKey(leftKey);
						
			//Declares node for YES (right) tree
			TreeNode newRight = new TreeNode();
			cursor.setRight(newRight);
			
			//reads the keywords for the YES (right) tree
			System.out.println("Enter keywords the Yes leaf seperated by a comma, then press enter");
			tempKey = scan.nextLine();
			tempKey = tempKey.toUpperCase(); 
			String rightKey = tempKey.replaceAll("\\s+","");
			newRight.addKey(rightKey);
			
		}
		
	}

	
	/**
	 * @param temp a String that takes whatever you want to add to the key and adds it to the keywords of the current node
	 */
	public void addKey(String temp){
		cursor.addKey(temp);
	}
	
	
	/**
	 * will delete all the keywords stored in the node pointed to by the cursor
	 */
	public void clearKey(){
		cursor.clearKey();
	}
	
	
	/**
	 * will delete the two children of the cursor node by setting the cursor's children to null. Will then delete the
	 * keywords stored in the cursor and ask the user for a terminal text that is added as the sole keywords
	 */
	public void deleteChildren(){
		Scanner scan= new Scanner(System.in);
		
		cursor.setLeft(null);
		cursor.setRight(null);
		
		//clears current key at cursor, and asks for final
		cursor.clearKey();
		System.out.println("Please enter terminal text for this node:");
		String tempKey = scan.nextLine();
		tempKey = tempKey.toUpperCase(); 
		cursor.addKey(tempKey);
	}
	
	
	/**
	 * prints the keywords of the current cursor, calls getKeywords from TreeNode
	 */
	public void printNode(){
		cursor.getKeywords();
	}

	
	/**
	 * @param keywords takes a string of keywords that are separated word by word, can compares all of the Strings stored in 
	 * the array to 
	 * @return a boolean true or false depending on whether the array of strings was found in the current cursors keywords
	 */
	public boolean compareKeywords(String [] keywords){
		
		for(int i=0;i<keywords.length;i++){
			if(cursor.compareKeyword(keywords[i])){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * @param direction takes a boolean, true if there is a right child node, and false if there is a left child node
	 * this method adds to the ID array a 1 or 0 depending on the value passed into it. ID array keeps track of how the current
	 * cursors location was determined
	 */
	public void incrementId(boolean direction){
		
		if(direction){
			id[idCount]=1;
		}
		else{
			id[idCount]=0;
		}
		
		idCount++;
	}
	

}
