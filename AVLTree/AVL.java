public class AVL
{
    static Node HeadRoot;
 
    class Node
    {
        Node left;
        int rootData;
        Node right;
        int height=1;
        public  Node(int data)
        {
            rootData=data;
        }
    }
    int balanceNumber(Node node)
    {
        if(node==null)
        {
            return 0;
        }
        int leftBalance=(node.left == null?0:node.left.height);
        int rightBalance=(node.right == null?0:node.right.height);
        return leftBalance-rightBalance;
    }
    int childHeight(Node child)
    {
        if(child == null)
        {
            return 0;
        }
        return child.height;
    }

    int rootHeight(int leftNode,int rightNode)
    {
        return leftNode>rightNode?leftNode:rightNode;
    }
    // ROTATIONS
    Node lRight(Node node)
    {
        node.left=leftRotate(node.left);
        node=rightRotate(node);
        if(node==HeadRoot)                                      //LEFT RIGHT ROTATION
        {
            HeadRoot=node;
        }
        return node;
    }
    Node rLeft(Node node)
    {
        node.right=rightRotate(node.right);
        node=leftRotate(node);
        if(node==HeadRoot)                                      //RIGHT LEFT ROTATION
        {
            HeadRoot=node;
        }
        return node;
    }
    Node leftRotate(Node node) 
    {
        Node newRoot = node.right; 
        node.right = newRoot.left; 
        newRoot.left = node; 
        node.height = 1 + rootHeight(childHeight(node.left), childHeight(node.right));
        newRoot.height = 1 + rootHeight(childHeight(newRoot.left), childHeight(newRoot.right));
        if (node == HeadRoot) 
        {
            HeadRoot = newRoot;                                      //LEFT  ROTATION
        }
        return newRoot; 
    }
    Node rightRotate(Node node)
    {
        Node newRoot = node.left; 
        node.left = newRoot.right; 
        newRoot.right = node; 
        node.height = 1 + rootHeight(childHeight(node.left), childHeight(node.right));
        newRoot.height = 1 + rootHeight(childHeight(newRoot.left), childHeight(newRoot.right));
        if (node == HeadRoot) 
        {
            HeadRoot = newRoot;                                      //RIGHT ROTATION
        }
        return newRoot; 
       
    }
    // INSERTION OF NODE
    Node insertData(Node root,int data)
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
            return root;
        }
        root.height= 1 + rootHeight ( childHeight(root.left), childHeight(root.right) ) ;
        int balance=balanceNumber(root);      
        if(balance > 1 && root.left.rootData > data)
        {
             return rightRotate(root); //Leftcase
        }
        else if(balance > 1 && root.left.rootData < data )
        {
            return lRight(root);  //RightLeftCase
        }
        else if(balance < -1 && root.right.rootData < data)
        {
            return  leftRotate(root); //RightCase
        }
        else if(balance < -1 && root.right.rootData > data)
        {
            return rLeft(root); //LeftRightCase
        }


        return root;
    }
    // DELETION OF NODE 
     Node deleteData(Node headRoot2, int data)
     {
        if (headRoot2 == null) 
        {
            return null;
        }
        if (data < headRoot2.rootData) 
        {
            headRoot2.left = deleteData(headRoot2.left, data);
        } 
        else if (data > headRoot2.rootData)
        {
            headRoot2.right = deleteData(headRoot2.right, data);
        } 
        else 
        {
            if (headRoot2.left == null) 
            {
                return headRoot2.right;
            } 
            else if (headRoot2.right == null) 
            {
                return headRoot2.left;
            }
            Node temp = headRoot2.right;
            while (temp.left != null) 
            {
                temp = temp.left;
            }
            headRoot2.rootData = temp.rootData;
            headRoot2.right = deleteData(headRoot2.right, temp.rootData);
        }
        headRoot2.height=  rootHeight ( childHeight(headRoot2.left), childHeight(headRoot2.right) ) + 1 ;
        int balance=balanceNumber(headRoot2);
        if(balance > 1 && balanceNumber(headRoot2.left)>0 )
        {
           return rightRotate(headRoot2); //Leftcase
        }
        else if(balance > 1 && balanceNumber(headRoot2.left)<0 )
        {
            return lRight(headRoot2);  //RightLeftCase
        }
        else if(balance < -1 &&balanceNumber(headRoot2.right) < 0 )
        {
            return  leftRotate(headRoot2); //RightCase
        }
        else if(balance < -1 && balanceNumber(headRoot2.right)>0)
        {
            return rLeft(headRoot2); //LeftRightCase
        }
        return headRoot2;
    }
    void updation(int newData,int oldData)
    {
        Utility  ut=new Utility();
        if(ut.search(HeadRoot, oldData)!=null && ut.search(HeadRoot, newData)==null)
        {
            insertData(HeadRoot, newData);
            deleteData(HeadRoot, oldData);

            System.out.println("Updatiuon Successfull");
        }

    }
}