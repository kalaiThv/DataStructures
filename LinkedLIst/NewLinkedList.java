
import java.util.Scanner;
public class NewLinkedList
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
	
    public int  insertAsscending(int data)
	{

		Node newNode=new Node(data);
		if(head==null || head.data>data)
		{
			newNode.next=head;
			head=newNode;
			return 1;

		}
	     if(head.data==data)
		{
		  return 0;//   if the data is already in the node
		}
	    else
		{
			Node temp=head;
			while(temp.next!=null && temp.next.data<=data)
			{
				if(temp.next.data==data) 
				{
                	return 0;
				}
			   	temp=temp.next;
			}
			
		    newNode.next= temp.next;
			temp.next=newNode;


		}
		return 1;

	}
	
// 	Deletion of Node

public boolean  delete(int data) {
	// deleting Head
	if(head==null){
	    return false;
	}
	  if(head.data==data) 
	   {
	     head=head.next;
       }
      else {


	   Node temp=head;
	   while((temp.next!=null && temp.next.data<data) ) {
		  temp=temp.next;
	   }
	    if(temp.next!=null && temp.next.data==data) 
	    {
			   temp.next=temp.next.next;

		}
	   else{
			 return false; //if data not present in the LinkedList
	   }

   }
   return true;
}

public void update(int newValue,int oldValue)
{
    if(head==null || newValue==oldValue)
    {
        System.out.println("Unable to update");
        return;
    }
        Node delpos=null;
		Node insertPos=null;
        Node previousNode=null;
        Node previousNode2=null;
        int count=0;
		for(Node temp=head;temp!=null;temp=temp.next)
        {
            if(temp.data==oldValue)
			{
                delpos=temp;
                previousNode2=previousNode;
            }
			if(temp.data==newValue)
			{
                System.out.println(temp.data+"  Data already Present");
			    return;
			}
            if(temp.data>newValue && insertPos==null && count==0)
            {
                insertPos=previousNode;
                count++;
            }
            previousNode=temp;
        }
        Node newNode=new Node(newValue);
        if(delpos==null)
        {
            System.out.println("Data not found");
            return;
        }
        if (delpos == head) 
        {
            head = delpos.next; 
        }
        else if (previousNode2 != null) 
        {
            previousNode2.next = delpos.next; //FIND DELPOS AND DELETE
        }
        if (insertPos == null && head.data>newValue)
        { 
            newNode.next = head;
            head = newNode;
        } 
        if(insertPos == null)
        {
            previousNode.next=newNode;
        }
        else 
        {
            newNode.next = insertPos.next;
            insertPos.next = newNode;
        }
        System.out.println("UPDATION SUCCESSFULL");
    }
    public void display() 
    {
        Node temp=head;
        if(head==null)
        {
            System.out.println("Node is Empty");
            return;
        }
        while(temp!=null) 
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
            System.out.println("");
    }
	public static void main(String[] args)
	{
		NewLinkedList list=new NewLinkedList();
		Scanner sc=new Scanner(System.in);
		int choice=0,addData;
		while(choice>=0)
		{
			System.out.println("LINKEDLIST MENU\n*************************");
			System.out.println("1.ADD\n2.DELETE \n3.UPDATE \n4.DISPLAY \n5.EXIT");
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:
						System.out.println("Enter the Number");
						addData=sc.nextInt();
						if(list.insertAsscending(addData)==1)
						{
							System.out.println(addData+" is successfully added in the node");
						}
							
						else
						{
							System.out.println(addData+" is already present in the node");
						}
						break;
				case 2:
						System.out.println("Enter the number to be deleted");
						int delData=sc.nextInt();
						if(list.delete(delData))	
						{
							System.out.println(delData+ " is successfully deleted");
						}
						else 
						{System.out.println("Unable to delete Either List is Empty OR "+delData+" doesn't exist in LinkedList");}
						break;
				case 3:	System.out.println("Enter the number to be update");
						int updateNum=sc.nextInt();
						System.out.println("Enter the NewNumber ");
						int NewNumber=sc.nextInt();
						list.update(NewNumber,updateNum);
						break;
				case 4:list.display();break;
				case 5:System.out.println("Nandri Meendum varuga");return;
				default:System.out.println("Invalid Choice");
			        
			}



		}
	}
}
