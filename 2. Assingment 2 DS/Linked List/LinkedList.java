import java.util.*;
class Node{
  Node next;
  int data;
  Node(int data){
    this.data=data;
  }
}

public class LinkedList{
  Node head,tail;
  public static void main(String[] args) {
    LinkedList ob=new LinkedList();
    Scanner scan=new Scanner(System.in);
    System.out.println("Enter size os list");
    int n=scan.nextInt();
    for (int i=0; i<n; i++) {
      ob.insertBegin(scan.nextInt());
    }
    ob.insertAt(1,99);
    ob.print();
    ob.deleteAt(2);
    ob.print();
  }
  public void insertBegin(int data){
    Node temp=new Node(data);
    if(head == null){
      head=temp;
      tail=head;
    }
    else{
      tail.next=temp;
      tail=temp;
    }
  }
  public void insertAt(int pos,int data){
    Node ptr=head;
    Node temp=new Node(data);
    if(head == null){
      head=temp;
      tail=head;
    }
    else{
          while (pos != 1 && ptr.next != null) {
            pos--;
            ptr=ptr.next;
        }
        temp.next=ptr.next;
        ptr.next=temp;
        if(tail == ptr){
          tail=temp;
        }
    }
  }
  public void  deleteAt(int pos){

		Node temp=null;
		Node ptr=head;
		if(pos==1){
			head=null;
		}
		else{
			for(int i=1;i<pos-1;i++){
				ptr=ptr.next;
			}
		temp=ptr;
		ptr=ptr.next.next;
		temp.next=ptr;

  }
}
  void print(){
    Node ptr=head;
    while(ptr!= null){
      System.out.print(ptr.data+" ");
      ptr=ptr.next;
    }
    System.out.println();
  }
}
