package source;

class addNode{

    public Node insertNode(Node root, int i) {
        if (root==null){
            root=new Node(i);
            return root;
        }

        if (i < root.data)
            root.left=insertNode(root.left,i);
        else
            root.right=insertNode(root.right,i);

        return root;
    }
}

public class InsertNodeToBST {
    public static void main(String[] args) {
        BST t = new BST();

        t.root = new Node(15);
        t.root.left = new Node(10);
        t.root.right = new Node(20);

        t.root.left.left = new Node(5);
        t.root.left.right = new Node(13);

        t.root.right.left = new Node(17);
        t.root.right.right = new Node(25);

        System.out.println("\nbefore");
        t.inOrder(t.root);

        addNode s1 = new addNode();
        s1.insertNode(t.root, 30);

        System.out.println("\nafter");
        t.inOrder(t.root);
    }
}
