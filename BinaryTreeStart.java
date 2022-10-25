
    class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left=right=null;
        }


    }
    class Tree{
        Node root;

        public Tree() {
            this.root = null;
        }
        public void preOrderDFS(Node node){
            if (node==null)
                return;

            System.out.print(node.data + " ");

            preOrderDFS(node.left);
            preOrderDFS(node.right);
        }

        public void inOrderDFS(Node node){
            if (node==null)
                return;

            inOrderDFS(node.left);

            System.out.print(node.data + " ");

            inOrderDFS(node.right);
        }

        public void postOrderDFS(Node node){
            if (node==null)
                return;

            postOrderDFS(node.left);

            postOrderDFS(node.right);

            System.out.print(node.data + " ");

        }

    }
    public class BinaryTreeStart {
        public static void main(String[] args) {
        Tree T=new Tree();

        T.root= new Node(5);
        T.root.left=new Node(10);
        T.root.right=new Node(15);

        T.root.left.left=new Node(20);
        T.root.left.right=new Node(25);

        T.root.right.left=new Node(12);
        T.root.right.right=new Node(30);

        //preorder
            System.out.print("\nPreOrder DFS: ");
        T.preOrderDFS(T.root);

        //Inorder
            System.out.print("\nInOrder DFS: ");
        T.inOrderDFS(T.root);

        //Postorder
            System.out.print("\nPostOrder DFS: ");
        T.postOrderDFS(T.root);

        }
}
