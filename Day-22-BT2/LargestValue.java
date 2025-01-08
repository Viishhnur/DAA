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
    public List<Integer> largestValues(BinaryTreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null || root.data == -1) return ans;

        Queue<BinaryTreeNode> qu = new LinkedList<>();

        qu.offer(root);

        while(!qu.isEmpty()){
            int size = qu.size();
            int maxi = Integer.MIN_VALUE;
            for(int i = 0 ; i < size ; i++){
                BinaryTreeNode front = qu.poll();
                maxi = Math.max(front.data,maxi);

                if(front.left != null && front.left.data != -1) qu.offer(front.left);
                if(front.right != null && front.right.data != -1) qu.offer(front.right);

            }
            ans.add(maxi);
        }

        return ans;
    }
   
}

public class LargestValue 
{
	static BinaryTreeNode root;
	void insert(BinaryTreeNode temp, int key)
    { 
        if (temp == null) {
            temp = new BinaryTreeNode(key);
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(temp);
 
        // Do level order traversal until we find an empty place.
        while (!q.isEmpty()) 
		{
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

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		LargestValue ln=new LargestValue();
		Solution sol= new Solution();
		
		String str[]=sc.nextLine().split(" ");
		root=new BinaryTreeNode(Integer.parseInt(str[0]));
		for(int i=1; i<str.length; i++)
			ln.insert(root,Integer.parseInt(str[i]));

		System.out.println(sol.largestValues(root));
	}
}
