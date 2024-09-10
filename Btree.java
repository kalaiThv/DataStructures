package DataStructure;
import java.util.*;
public class Btree 
{
    static Node root;
    Queue<Node> queue = new LinkedList<>();
    class Node 
    {
        int val;
        Node left;
        Node right;
        Node(int val) 
        {
            this.val = val;
        }
    }
    public Btree(int data)
    {
        root=new Node(data);
    }
    public void insert(int data)
    {
        Node temp=queue.peek();
        if(temp.left==null)
        {
            temp.left=new Node(data);
            queue.add(temp.left);

        }
        else 
        {
            temp.right=new Node(data);
            queue.add(temp.right);
            queue.remove();
        }
    }
    void DFStravel(Node root)
    {
        if(root!=null)
        {
            System.out.print(root.val+" ");
            DFStravel(root.left);
            DFStravel(root.right);
        }
    }
    void postOrder(Node root)
    {
        if(root!=null)
        {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val+" ");
        }
    }
    void inOrder(Node root)
    {
        if(root!=null)
        {
            inOrder(root.left);
            System.out.print(root.val+" ");
            inOrder(root.right);
            
        }
    }
    public void printTreeBFS() {
        if (root == null) 
        {
            System.out.println("Tree is empty");
            return;
        }

        Queue<Node> levelQueue = new LinkedList<>();
        levelQueue.add(root);
        while (!levelQueue.isEmpty()) 
        {
            
            Node node = levelQueue.peek();
           
            System.out.print(" "+node.val+" ");
               
                if (node.left != null) 
                {
                    levelQueue.add(node.left);
                }
                if (node.right != null) 
                {
                    levelQueue.add(node.right);
                   
                }
                levelQueue.remove();
            
        }
    }

    public static void printSpaces(int count)
    {
        for (int i= 1; i <= count; i++)
            {
                System.out.print("   ");
            }         
    }

   
    public void BFStravel() 
    {
        if (root == null) 
        {
            System.out.println("Tree is empty");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) 
        {
            Node node = queue.peek();
            System.out.print(" " +node.val);
            if (node.left != null) 
            {
                queue.add(node.left);
            }
            if (node.right != null) 
            {
                queue.add(node.right);
            }
            queue.remove();
        }
    }
    public static void main(String[] args) 
    {
        System.out.println();
        System.out.println();
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------Binary Tree----------------");
        System.out.print("Enter the Root Element : ");
        int HeadRoot=sc.nextInt();
        Btree Btree = new Btree(HeadRoot);
        Btree.queue.add(root);
        int userInput;
        System.out.println();
        do
        {
            System.out.println();
            System.out.println("---------------Binary Tree Menu----------------");
            System.out.println();
            System.out.println("1 -> INSERT DATA");
            System.out.println("2 -> DISPLAY DFS");
            System.out.println("3 -> DISPLAY BFS");
            System.out.println("4 -> POSTORDER");
            System.out.println("5 -> INORDER");
            System.out.println("6 -> EXIT");
            System.out.println();
            System.out.print("Enter Your Option : ");
            userInput = sc.nextInt();
            switch (userInput) 
            {
                case 1: System.out.print("Enter the insert value : ");
                        int insertValue = sc.nextInt();
                        Btree.insert(insertValue);
                        break;
                case 2: Btree.DFStravel(root);
                        break;
                case 3: Btree.printTreeBFS();break;
                case 4: Btree.postOrder(root);break;
                case 5: Btree.inOrder(root); break;
                
                case 6:System.out.println("Thanks You!!!");return;
                default:System.out.println("Invalid Choice");
            }
        } while (userInput!=6);

}
}
    

