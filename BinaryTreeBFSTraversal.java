class Node {
    int data;
    Node left;
    Node right;

   public Node(int data) {
            this.data=data;
            left=right=null;
    }
}
class Tree{
    Node root;

    public Tree(){
        this.root=null;
    }

    public int calculateTreeHeight(Node root){
        if (root==null)
            return 0;

        int leftHeight= 1+ calculateTreeHeight(root.left);
        int rightHeight= 1+ calculateTreeHeight(root.right);

        if (leftHeight >= rightHeight)
            return leftHeight;
        else
            return rightHeight;

    }

    public void BFSTraversal(){
        int h=calculateTreeHeight(root);
        for (int i=1;i<=h;i++){
            printNode(root,i,1);
        }
    }

    public void printNode(Node root, int Level, int currentLevel){
        if (root==null)
            return;
        else if (Level==currentLevel)
            System.out.print(root.data + " ");
        else{
            printNode(root.left,Level,currentLevel+1);
            printNode(root.right,Level,currentLevel+1);

        }

    }
}

public class BinaryTreeBFSTraversal  {
    public static void main(String[] args) {
        Tree T=new Tree();

        T.root=new Node(1);

        T.root.left=new Node(2);
        T.root.right=new Node(3);

        T.root.left.left=new Node(4);
        T.root.left.right=new Node(5);

        T.root.right.left=new Node(6);
        T.root.right.left=new Node(7);

        T.BFSTraversal();
    }
}
