package source;
import java.util.*;


public class BinaryTreeSampleQuestion{

    public static class BinaryTree
    {
        Node root;

        BinaryTree() {
            root = null;
        }

        // Function to insert in the BST
        void insert(int key) {
            root = insertRec(root, key);
        }

        // A recursive function to insert a new key in BST
        Node insertRec(Node root, int key) {

            if (root == null) {
                root = new Node(key);
                return root;
            }

            if (key < root.data)
                root.left = insertRec(root.left, key);
            else if (key > root.data)
                root.right = insertRec(root.right, key);

            return root;
        }

        int getLeafCount()
        {
            return getLeafCount(root);
        }

        int getLeafCount(Node node)
        {
            int leafCount = 0;
            if (node==null)
                return 0;
            if (node.left==null && node.right==null)
                return 1;
            else{
                leafCount=getLeafCount(node.left) +
                        getLeafCount(node.right);
                return leafCount;
            }

        }

        //Function to print nodes that dont have a sibling
        void printSingles(Node node) {
            // complete this function
            if (node==null)
                return;

            if (node.left!=null && node.right!=null){
                printSingles(node.left);
                printSingles(node.right);
            }
            else if (node.left==null && node.right!=null) {
                System.out.print(node.right.data + " ");
                printSingles(node.right);
            }
            else if (node.right==null && node.left!=null) {
                System.out.print(node.left.data + " ");
                printSingles(node.left);
            }
         }

    }

    public static void main(String[] args)
    {

        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        int size;
        size = sc.nextInt();

        if(size<= 0){
            System.out.println("Size should be a positive integer");
        }

        else{
            int[] elementsArr = new int[size];
            for(int i = 0; i < size; i++){
                elementsArr[i] = sc.nextInt();
                tree.insert(elementsArr[i]);
            }
            System.out.println(tree.getLeafCount());
            tree.printSingles(tree.root);
        }
    }
}