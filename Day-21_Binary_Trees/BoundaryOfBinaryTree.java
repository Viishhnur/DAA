import java.util.*;

class BinaryTreeNode
{
	public int data; 
	public BinaryTreeNode left, right; 
	public BinaryTreeNode(int data)
	{
		this.data = data; 
		left = null; 
		right = null; 
	}
}

class Solution
{
	private List<Integer> ans = new ArrayList<>();
	public List<Integer> boundaryOfBinaryTree(BinaryTreeNode root) {
	    //Write your code here and return list of nodes
	       
	   if(root == null) return ans;
	   
	   ans.add(root.data);
	   // Step-1 add left boundary nodes
	   addLeftBoundaryNodes(root.left);
	   
	   // Step-2 Now add left leaves
	   addLeaves(root.left);
	   
	   //Step-3 Now add right leaves
	   addLeaves(root.right);
	   
       // Step-4: Add right boundary nodes (excluding root and leaf nodes) in reverse order
        List<Integer> rightBoundary = new ArrayList<>();
        // addRightBoundaryNodes(root.right, rightBoundary);
        Collections.reverse(rightBoundary);
        ans.addAll(rightBoundary);
	   
	   return ans;
	}
	//Your supporting methods if any goes here
	
	private void addLeaves(BinaryTreeNode root){
	    if(root == null) return;
	        
	   //go complete left
	   addLeaves(root.left);
	    if(root.left != null && root.right != null){
	        ans.add(root.data);
	        
	    }
	    
	    addLeaves(root.right);
	    
	}
	
	private void addLeftBoundaryNodes(BinaryTreeNode root){
	    if(root == null) return;
	    if(root.left != null){
	        ans.add(root.data);
	        addLeftBoundaryNodes(root.left);
	    }
	    else if(root.right != null){
	        ans.add(root.data);
	        addLeftBoundaryNodes(root.right);
	    }
	    
	    
	}
	private void addRightBoundaryNodes(BinaryTreeNode root){
	    if(root == null) return;
	    if(root.right != null){
	        ans.add(root.data);
	        addRightBoundaryNodes(root.right);
	    }
	    else if(root.left != null){
	        ans.add(root.data);
	        addRightBoundaryNodes(root.left);
	    }
	    
	    
	}
}

public class BoundaryOfBinaryTree
{
	static BinaryTreeNode root;
	void insert(BinaryTreeNode temp, int key){ 
        if (temp == null) {
            temp = new BinaryTreeNode(key);
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(temp);
 
        // Do level order traversal until we find an empty place.
        while (!q.isEmpty()) {
            temp = q.remove();
 
            if (temp.left == null) {
                temp.left = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.left);
 
            if (temp.right == null) {
                temp.right = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		BoundaryOfBinaryTree bbt=new BoundaryOfBinaryTree();
		Solution sol= new Solution();
		
		String str[]=sc.nextLine().split(" ");

		root=new BinaryTreeNode(Integer.parseInt(str[0]));

		for(int i=1; i<str.length; i++)
			bbt.insert(root,Integer.parseInt(str[i]));

		System.out.println(sol.boundaryOfBinaryTree(root));
	}
}
