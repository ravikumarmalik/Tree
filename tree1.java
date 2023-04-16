import java.util.LinkedList;
import java.util.*;
public class tree1 {
    static class Node {//node class
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class binaryTree {
        static int index = -1;

        public static Node buildTree(int nodes[]) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[index]);//create Node object
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

//        public static void preOrder(Node root) {
//            if (root == null){
//                return;
//            }
//            System.out.print(root.data+" ");
//            preOrder(root.left);
//            preOrder(root.right);
//        }


//        public static void postOrder(Node root){
//            if (root == null){
//                return;
//            }
//            postOrder(root.left);
//            postOrder(root.right);
//            System.out.print(root.data+" ");
//        }



//        public static void inOrder(Node root){
//            if (root == null){
//                return;
//            }
//            inOrder(root.left);
//            System.out.print(root.data+" ");
//            inOrder(root.right);
//        }


        //level order traversal
        public static void levelOrder(Node root){
            if (root == null){
                return;
            }
            Queue<Node> q=new LinkedList<>();
            q.add(root);//root node
            q.add(null);//null for next node

            while (!q.isEmpty()){
                Node currentNode=q.remove();
                if (currentNode == null) {
                    System.out.println();

                    if (q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currentNode.data+" ");
                    if (currentNode.left != null){
                        q.add(currentNode.left);
                    }
                    if (currentNode.right != null){
                        q.add(currentNode.right);
                    }
                }
            }
        }
    }




        public static void main(String[] args) {
            int[] node = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

            binaryTree tree = new binaryTree();
            Node root = tree.buildTree(node);
            System.out.println(root.data);

            //tree.preOrder(root);//1 2 4 5 3 6
            //tree.postOrder(root);//4 5 2 6 3 1
            //tree.inOrder(root);//4 2 5 1 3 6

            tree.levelOrder(root);

        }
    }

