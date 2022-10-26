class Node{
    int data;
    Node left, right;

    public Node(int data){
        this.data=data;
        left=right=null;
    }
}

class Tree{
    Node root;

    public Tree(){
        root=null;
    }

    public void Mirror(Node root){
        if (root==null)
            return;

        Mirror(root.left);
        Mirror(root.right);

        Node temp;

        temp=root.left;
        root.left=root.right;
        root.right=temp;
    }

    public void printNode(Node root){
        if (root==null)
            return;

        System.out.print(root.data + " ");
        printNode(root.left);
        printNode(root.right);

    }
}
public class BinaryTreeMirrorExample {
    public static void main(String[] args) {
        Tree t=new Tree();

        t.root=new Node(1);
        t.root.left=new Node(2);
        t.root.left.left=new Node(4);
        t.root.left.right=new Node(5);

        t.root.right=new Node(3);
        t.root.right.left=new Node(6);
        t.root.right.right=new Node(7);

        System.out.println("before");
        t.printNode(t.root);

        t.Mirror(t.root);

        System.out.println("\nafter");
        t.printNode(t.root);
    }
}
