package Tree;
public class BinaryTree{
    Node root;
    public BinaryTree(Node root){
        this.root = root;
    }

    void printLeaves(Node node){
        if(node == null) return;

        // go complete left 
        printLeaves(node.left);
        if(node.left == null && node.right == null){
            System.out.print(node.data + " ");
        }
        // now go complete right
        printLeaves(node.right);
    }

    void printLeftBoundary(Node node){
        if(node == null) return;

        if(node.left != null){

            System.out.print(node.data + " ");
            printLeftBoundary(node.left);
        }

        else if(node.right != null){
            System.out.print(node.data + " ");
            printLeftBoundary(node.right);
        }

    }

    void printRightBoundary(Node node){
        if(node == null) return;

        if(node.right != null){

            System.out.print(node.data + " ");
            printRightBoundary(node.right);
        }

        else if(node.left != null){
            System.out.print(node.data + " ");
            printRightBoundary(node.left);
        }

    }

    void printBoundary(Node root){
        if(root == null) return;
        System.out.print(root + " ");

        printLeftBoundary(root.left);

        printLeaves(root.left);
        printLeaves(root.right);

        printRightBoundary(root.right);
    }

    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree(null);
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.printBoundary(tree.root);
    }
}