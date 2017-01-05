# 20-Questions-Clone
After inputting a sentence, the program will try to figure out what the
user is describing by traversing a tree containing various keywords, checking
to see whether that keyword is found in the inputted sentence. If it is, the program moves to the 
right child and if not to the left. This processes is repeated until a leaf node is reached in which case
the final character/item is printed.

Some other options in the program are to edit the tree and print the decision path of the program, printing the nodes of the tree it took to get
to its location

The tree.txt file is the format in which a tree can be imported into the program. This contains the information that the
program can draw from in order to make a correct classification. 

Why it is simple
The program's classification is limited to the information stored in the tree and therefore can come to the wrong conclusion. A much much larger tree with many more nodes will be more accurate, but the overall program works
correctly when staying within the bounds of the imported tree. Also a user input with the following example: "not XXXXX" would create a false positive if the tree contains XXXX regardless of the not infront of it. 

