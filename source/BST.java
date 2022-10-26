package source;

public class BST {
    Node root;

    public BST() {
        this.root = null;
    }

    public void preOrder(Node root){
        if (root==null)
            return;

        System.out.print(root.data + " ");

        preOrder(root.left);
        preOrder(root.right);

    }

    public void inOrder(Node root){
        if (root==null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }
}
