import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class TreeTest {
    Node root;
    public TreeTest(){
        root=null;
    }

    public void levelOrderBFS() {
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node temp=queue.peek();
            queue.remove();
            System.out.print(temp.data + " ");

            if (temp.left!=null)
                queue.add(temp.left);

            if (temp.right!=null)
                queue.add(temp.right);
        }
    }
}

public class BinaryTreeBFSTraversalUsingQueue {
    public static void main(String[] args) {
        TreeTest T=new TreeTest();
        T.root=new Node(1);

        T.root.left=new Node(2);
        T.root.right=new Node(3);

        T.root.left.left=new Node(4);
        T.root.left.right=new Node(5);

        T.root.right.left=new Node(6);
        T.root.right.right=new Node(7);

        T.levelOrderBFS();

    }

}
