import java.util.*;

class BinaryTreeNode {
    public int data; 
    public BinaryTreeNode left, right; 
    public BinaryTreeNode(int data) {
        this.data = data; 
        left = null; 
        right = null; 
    }
}

class Solution {
    public boolean isBalanced(BinaryTreeNode root) {   
        // Check if the tree is balanced using a height calculation
        if (root == null) return true;
        return height(root) != -1;
    }

    private int height(BinaryTreeNode root) {
        if (root == null || root.data == -1) return 0;
        
        int leftHeight = height(root.left);
        if (leftHeight == -1) return -1; // Left subtree is not balanced
        
        int rightHeight = height(root.right);
        if (rightHeight == -1) return -1; // Right subtree is not balanced
        
        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // Current node is not balanced
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

public class BalancedBinaryTree {
    static BinaryTreeNode root;
    
    void insert(int key) { 
        if (root == null) {
            root = new BinaryTreeNode(key);
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        // Level-order traversal to find an empty spot
        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.remove();

            if (temp.left == null) {
                temp.left = new BinaryTreeNode(key);
                break;
            } else {
                q.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new BinaryTreeNode(key);
                break;
            } else {
                q.add(temp.right);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BalancedBinaryTree tree = new BalancedBinaryTree();
        Solution sol = new Solution();

        // Read input and build the tree
        String[] str = sc.nextLine().split(" ");
        root = new BinaryTreeNode(Integer.parseInt(str[0]));
        for (int i = 1; i < str.length; i++) {
            tree.insert(Integer.parseInt(str[i]));
        }

        // Check if the tree is balanced
        System.out.println(sol.isBalanced(root));
    }
}
