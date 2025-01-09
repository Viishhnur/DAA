package Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class AverageOfLevels {
   
    public List<Double> averageOfLevels(TreeNode root) {
        // simple do a level order traversal
        if(root == null) return Arrays.asList(0.0);
        

        List<Double> ans = new ArrayList<>();

        Queue<TreeNode> qu = new LinkedList<>();

        qu.offer(root);

        while(!qu.isEmpty()){
            int size = qu.size();
            double sum = 0.0;
            for(int i = 0 ; i < size ; i++){
                TreeNode front = qu.poll();
                sum += front.val;

                if(front.left != null) qu.offer(front.left);

                if(front.right != null) qu.offer(front.right);
            }   
            ans.add(sum/size);
        }

        return ans;

    }
}