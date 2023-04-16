public class binarySearch2 {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (root.data > value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static boolean searchKey(Node root, int key){
        if (root == null) {
            return false;
        }

        if (root.data == key ){
            return true;
        }
        if (root.data > key){
           return searchKey(root.left,key);
        }else {
            return searchKey(root.right,key);
        }

    }
    public static void main(String[] args) {
        int[] value={5,1,3,4,2,7};
        Node root=null;

        for (int i=0; i<value.length; i++){
            root = insert(root, value[i]);
        }
        if (searchKey(root,6)){
            System.out.println("found");
        }else {
            System.out.println("not found");
        }
    }
}
