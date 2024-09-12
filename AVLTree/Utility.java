
import java.util.LinkedList;
import java.util.Queue;

public class Utility 
{
    AVL.Node search(AVL.Node HeadRoot, int data) 
    {
        if (HeadRoot == null) 
        {
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
   void printHeight(AVL.Node HeadRoot)
    {
       Queue<AVL.Node> queue=new LinkedList<>();
       queue.add(HeadRoot);
       if(HeadRoot==null)
       {
        System.out.println("Tree is Empty");

       }
       else
       {
        while(!queue.isEmpty())
        {
            AVL.Node node = queue.remove();
            System.out.println("Height of "+node.rootData + " ---> "+node.height);
            if (node.left != null) 
            {
                queue.add(node.left);
            }
            if (node.right != null) 
            {
                queue.add(node.right);
            }
        }

       }
    }
     void printTree(AVL.Node HeadRoot)
    {
       Queue<AVL.Node> queue=new LinkedList<>();
       queue.add(HeadRoot);
       if(HeadRoot==null)
       {
        System.out.println("Tree is Empty");

       }
       else
       {

        while(!queue.isEmpty())
        {
            
            AVL.Node node = queue.remove();
            if (node.left != null) 
            {
                System.out.println("Root is --> "+node.rootData);
                System.out.println(node.rootData+ "  left child  -->  "+node.left.rootData);
                queue.add(node.left);
            }
            if (node.right != null) 
            {
                System.out.println(node.rootData+ "  right child  -->  "+node.right.rootData);
                queue.add(node.right);
            }
        }

       }
        
    }
    void inOrder(AVL.Node HeadRoot)
    {
        if(HeadRoot!=null)
        {
            inOrder(HeadRoot.left);
            System.out.print(HeadRoot.rootData+"  ");
            inOrder(HeadRoot.right);
        }
    }
    void preOrder(AVL.Node HeadRoot)
    {
        if(HeadRoot!=null)
        {
            System.out.print(HeadRoot.rootData);
            preOrder(HeadRoot.left);
            preOrder(HeadRoot.right);
        }
    }
    void postOrder(AVL.Node HeadRoot)
    {
        if(HeadRoot!=null)
        {
            postOrder(HeadRoot.left);
            postOrder(HeadRoot.right);
            System.out.println(HeadRoot.rootData);
        }
    }
    
}
