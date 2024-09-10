import java.util.Scanner;

public class Bstree{
    static Node HeadRoot;
    void inOrder(Node HeadRoot)
    {
        if(HeadRoot!=null)
        {
            inOrder(HeadRoot.left);
            System.out.print(HeadRoot.rootData+"  ");
            inOrder(HeadRoot.right);
        }
    }
    void preOrder(Node HeadRoot)
    {
        if(HeadRoot!=null)
        {
            System.out.println(HeadRoot.rootData);
            preOrder(HeadRoot.left);
            preOrder(HeadRoot.right);
        }
    }
    void postOrder(Node HeadRoot)
    {
        if(HeadRoot!=null)
        {
            postOrder(HeadRoot.left);
            postOrder(HeadRoot.right);
            System.out.println(HeadRoot.rootData);
        }
    }
    class Node
    {
        Node left;
        int rootData;
        Node right;
        public  Node(int data)
        {
            rootData=data;
        }
    }
    public Node insertData(Node root,int data)
    {
        if(root==null)
        {
            return new Node(data);
        }
        if(root.rootData>data)
        {
            root.left = insertData(root.left , data);
        }
        else if(root.rootData<data)
        {
            root.right=insertData(root.right , data);
        }
        else
        {
            System.out.println("Value " + data + " already exists in the tree.");
        }
         return root;
    }
    public Node search(Node HeadRoot, int data) 
    {
        if (HeadRoot == null) {
            System.out.println("Value " + data + " doesn't exist in the tree.");
            return null;
        }
        if (HeadRoot.rootData > data)
        {
            return search(HeadRoot.left, data);
        } 
        else if (HeadRoot.rootData < data) 
        {
            return search(HeadRoot.right, data);
        } 
        else 
        {
            System.out.println("Value " + data + " exists in the tree.");
            return HeadRoot;
        }
    }
    
    
    public Node deleteData(Node root, int data)
     {
        if (root == null) 
        {
            return null;
        }
        if (data < root.rootData) 
        {
            root.left = deleteData(root.left, data);
        } 
        else if (data > root.rootData)
        {
            root.right = deleteData(root.right, data);
        } 
        else 
        {
            if (root.left == null) 
            {
                return root.right;
            } 
            else if (root.right == null) 
            {
                return root.left;
            }
            Node temp = root.right;
            while (temp.left != null) 
            {
                temp = temp.left;
            }
            root.rootData = temp.rootData;
            root.right = deleteData(root.right, temp.rootData);
        }
    
        return root;
    }
    
       public static void main(String[] args) 
       {
        System.out.println();
        System.out.println();
        System.out.println();
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        Bstree Btree = new Bstree();
        int userInput;
        do
        {
            System.out.println();
            System.out.println("---------------Binary Search  Menu----------------");
            System.out.println("1 ->  Insert Data");
            System.out.println("2 ->  Show Inorder");
            System.out.println("3 ->  Show Preorder");
            System.out.println("4 ->  Show Postorder");
            System.out.println("5 ->  Delete Data");
            System.out.println("6 ->  Search Data");
            System.out.println("7 ->  Exit");
            System.out.print("Enter Your Option : ");
            userInput = sc.nextInt();
            switch (userInput) 
            {
                case 1: System.out.print("Enter the insert value : ");
                        int insertValue = sc.nextInt();
                        if(HeadRoot==null)
                        HeadRoot = Btree.insertData(HeadRoot, insertValue);
                        else
                        Btree.insertData(HeadRoot, insertValue);
                        System.out.println("Data successfully inserted");
                        break;
                case 2: Btree.inOrder(HeadRoot);
                        break;
                case 3: Btree.preOrder(HeadRoot);
                        break;
                case 4: Btree.postOrder(HeadRoot);
                        break;
                case 5:
                        System.out.print("Enter the data to delete: ");
                        int deletedata = sc.nextInt();
                        Node nodeToDelete = Btree.search(HeadRoot, deletedata);
                        if (nodeToDelete != null) 
                        {
                            HeadRoot = Btree.deleteData(HeadRoot, deletedata);
                            System.out.println("Data deleted successfully");
                        } 
                        else 
                        {
                            System.out.println("Value " + deletedata + " not found in the tree.");
                        }
                        break;
                    
                case 6: System.out.print("Enter the data to be Search");
                        int searchData=sc.nextInt();
                        Btree.search(HeadRoot,searchData);break;                        
                case 7:  System.out.println("Thanks You!!!");return;
                default: System.out.println("Invalid Choice");   
            }
        } while (userInput!=7);
    }
}