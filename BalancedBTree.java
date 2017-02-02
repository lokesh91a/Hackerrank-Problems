import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
public class BalancedBTree {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int noOfNodes = scan.nextInt();
		TreeNode root = new TreeNode(scan.nextInt());
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode current = null, fresh= null;
		for(int i=0;i<(noOfNodes-1)/2;i++){
			current = q.remove();
			fresh = new TreeNode(scan.nextInt());
			current.left = fresh;
			if(fresh.val!=-1)
				q.add(fresh);
			fresh = new TreeNode(scan.nextInt());
			current.right = fresh;
			if(fresh.val!=-1)
				q.add(fresh);
		}
		System.out.println(isBalanced(root));
	}
	public static int isBalanced(TreeNode a) {
	    int heightLeft = 0, heightRight = 0;
	    if(a.val==-1)
	        return 1;
	    heightLeft = findHeight(a.left);
	    heightRight = findHeight(a.right);
	    System.out.println("Height: "+heightLeft+" "+heightRight);
	    return Math.abs(heightLeft-heightRight)>1?0:1;
	}
	
	public static int findHeight(TreeNode a){
	    if(a.val==-1)
	        return 0;
	    else if(a.left.val!=-1 && a.right.val==-1){
	        return 1+findHeight(a.left);
	    }
	    else if(a.right.val!=-1 && a.right.val==-1){
	        return 1+findHeight(a.right);
	    }
	    else{
	        return findMax(1+findHeight(a.right),1+findHeight(a.left));
	    }
	}
	
	public static int findMax(int v1, int v2){
	    return v1>v2?v1:v2;
	}
}