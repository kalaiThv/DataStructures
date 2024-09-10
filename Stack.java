package DataStructure;
import java.util.*;
public class Stack 
{
   Node head;
   int size;
   class Node
   {
      int data;
		Node next;
		public Node(int data)
		{
			this.data=data;
      }
   }
   public Stack(int size)
   {
      this.size=size;
   }
   // push Method
   public void push(int data)
   {
      if(!isFull()) 
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
      else
      {
         System.out.println("Stack is full");
      }
   }
   //checking the stack is full or not 
   public boolean isFull()
   {
      Node temp=head;
      int count=0;
      while(temp!=null) 
      {
         count++;
         temp=temp.next;
      }
      if(count==size)
      {
         return true;
      }
      return false;
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
   public int peek()
   {
     if(!isEmpty())
     {
         return head.data;
     }
     return 0;
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
      System.out.println("-------Stack---------");
      System.out.print("Enter the size of Stack");
      int size=sc.nextInt();
      Stack stack=new Stack(size);
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
            case 3:  System.out.println(stack.peek());  
                     break;
            case 4:  stack.display();                  
                     break;                     
            case 5:  System.out.println("Thanks You!!!"); return;
            default: System.out.println("Invalid Choice");   
          }
      } while (userInput!=5);
  }
   
}
    

