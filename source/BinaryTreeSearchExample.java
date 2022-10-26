package source;

class search{

    public boolean findTheNode(Node root, int key) {
        if (root==null)
            return false;

        if (root.data==key)
            return true;

        if (root.data>key)
            return findTheNode(root.left, key);
        else
            return findTheNode(root.right,key);
        }
    }

public class BinaryTreeSearchExample {
    public static void main(String[] args) {
        BST t=new BST();

        t.root=new Node(15);
        t.root.left=new Node(10);
        t.root.right=new Node(20);

        t.root.left.left=new Node(5);
        t.root.left.right=new Node(13);

        t.root.right.left=new Node(17);
        t.root.right.right=new Node(25);

        search s1=new search();
        int key=99;

        System.out.println(s1.findTheNode(t.root,key));
    }
}
