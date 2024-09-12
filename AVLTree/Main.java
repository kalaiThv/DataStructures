
import java.util.Scanner;

public class Main 
{
  
    public static void main(String[] args) 
    {
     System.out.println();
     System.out.println();
     System.out.println();
     @SuppressWarnings("resource")
     Scanner sc = new Scanner(System.in);
     Utility ut=new Utility();
     AVL avl = new AVL();
     int userInput;
     do
     {
         System.out.println();
         System.out.println("---------------AVL Tree  Menu----------------");
         System.out.println("1 ->  Insert Data");
         System.out.println("2 ->  Show Inorder");
         System.out.println("3 ->  Show Preorder");
         System.out.println("4 ->  Show Postorder");
         System.out.println("5 ->  Delete Data");
         System.out.println("6 ->  Search Data");
         System.out.println("7 ->  Show Height");
         System.out.println("8 -> printTree");
         System.out.println("9 -> Exit");
         System.out.print("Enter Your Option : ");
         userInput = sc.nextInt();
         switch (userInput) 
         {
             case 1 -> {
                            System.out.print("Enter the insert value : ");
                            int insertValue = sc.nextInt();
                            if (AVL.HeadRoot==null)
                            {
                                AVL.HeadRoot=avl.insertData(AVL.HeadRoot, insertValue);
                            }
                            else
                            {
                                avl.insertData(AVL.HeadRoot, insertValue);
                            }
                        }
            case 2 -> ut.inOrder(AVL.HeadRoot);
            case 3 -> ut.preOrder(AVL.HeadRoot);
            case 4 -> ut.postOrder(AVL.HeadRoot);
            case 5 -> {
                            System.out.print("Enter the data to be delete: ");
                            int deletedata=sc.nextInt();
                            if(ut.search(AVL.HeadRoot,deletedata)!=null)
                            {
                                AVL.HeadRoot = avl.deleteData(AVL.HeadRoot, deletedata);
                                System.out.println("Data deleted successfully");
                            }
                        }
            case 6 ->   {
                            System.out.print("Enter the  Oldvalue to be change : ");
                            int oldData=sc.nextInt();
                            System.out.print("Enter the Newvalue to be update : ");
                            int newData=sc.nextInt();
                            avl.updation(newData, oldData);
                           
                        }
            case 7 ->   {
                            System.out.print("Enter the data to be Search");
                            int searchData=sc.nextInt();
                            ut.search(AVL.HeadRoot,searchData);
                        }
            case 8 -> ut.printHeight(AVL.HeadRoot) ;
            case 9 -> ut.printTree(AVL.HeadRoot);  
            case 10 -> {   
                            System.out.println("Thanks You!!!");
                            return;
                       }
            default -> System.out.println("Invalid Choice");
         }
     } while (userInput!=10);
 }
    
}
