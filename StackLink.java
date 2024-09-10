package DataStructure;
import java.util.*;
public class StackLink 
{
    Node head;
    class Node
    {
      int data;
		Node next;
		public Node(int data)
		{
			this.data=data;
      }
    }
   // push Method
   public void push(int data)
   {
      
         Node newNode=new Node(data);
         if(head==null)
         {
            head=newNode;
         }
         else
         {
            newNode.next=head;
            head=newNode;
         }
         System.out.println("Data successfully inserted");
   }
   //checking the stack is empty or not 
   public boolean isEmpty()
   {
      if(head==null)
      {
         System.out.println("Stack is empty");
         return true;
      }
      return false;
   }
   //Deleting the peekElement
   public void  pop()
   {
      if(!isEmpty())
      {
         head=head.next;
      }
   }
   //displaying the top element
   public void peek()
   {
     if(!isEmpty())
     {
         System.out.println(head.data); 
     }
     
   }
   //Stack Display
   public void display() 
   {
	Node temp=head;
    if(!isEmpty())
    {
        while(temp!=null) 
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println("");
    }
	}
   public static void main(String[] args) 
   {
      Scanner sc=new Scanner(System.in);
      int userInput;
      System.out.println();
      System.out.println();
      StackLink stack=new StackLink();
      do
      {
         System.out.println();
         System.out.println("---------------Stack Menu----------------");
         System.out.println("1 ->  Insert Data");
         System.out.println("2 ->  Delete Data(POP)");
         System.out.println("3 ->  Show peek Element");
         System.out.println("4 ->  Display");
         System.out.println("5 ->  Exit");
         System.out.print("Enter Your Option : ");
         userInput = sc.nextInt();
         switch (userInput) 
         {
            case 1:  System.out.print("Enter the insert value : ");
                     int insertValue = sc.nextInt();
                     stack.push(insertValue);
                     break;
            case 2:  stack.pop();                       
                     break;
            case 3:  stack.peek();  
                     break;
            case 4:  stack.display();                  
                     break;                     
            case 5:  System.out.println("Thanks You!!!"); return;
            default: System.out.println("Invalid Choice");   
          }
      } while (userInput!=5);
    }
}
