import java.util.*;
public class Demo{
  Node head,tail;
  public static void main(String[] args) {
    Demo ob=new Demo();
    Scanner scan=new Scanner(System.in);
    System.out.println("Enter size os list");
    int n=scan.nextInt();
    for (int i=0; i<n; i++) {
      ob.insertEnd(scan.nextInt());
    }

    ob.print();
    ob.insertAt(1,99);
    ob.print();
    ob.deleteAt(1);
    ob.print();
  }
  public void insertEnd(int data){
    Node temp=new Node(data);
    if(head == null){
      temp.next=temp;
      temp.pre=temp;
      head=temp;
      tail=head;
    }
    else{
      tail.next=temp;
      temp.pre=tail;
      tail=temp;
      tail.next=head;
      head.pre=tail;
    }
  }
  public void insertBegin(int data){
    Node temp=new Node(data);
    if(head == null){
      temp.next=temp;
      temp.pre=temp;
      head=temp;
      tail=head;
    }
    else{
      temp.next=head;
      temp.pre=tail;
      tail.next=temp;
      head.pre=temp;
      head=temp;
    }
  }

  public void deleteBegin(){
    if(head == null){
      System.out.print("Empty list");
    }
    else{
      if(head == tail){
        head=null;
        tail=null;
      }
      else{
        tail.next=head.next;
        head=head.next;
        head.pre=tail;
      }
    }
  }
  public void deleteEnd(){
    if(head == null){
      System.out.print("Empty list");
    }
    else{
      if(head == tail){
        head=null;
        tail=null;
      }
      else{
        tail=tail.pre;
        tail.next=head;
        head.pre=tail;
      }
    }
  }


  public void print(){
    Node ptr=head;
    while(ptr.next != head){
      System.out.print(ptr.data+" ");
      ptr=ptr.next;
    }
    System.out.println(ptr.data);
  }

  public void insertAt(int pos ,int data){

    if(head == null){
      Node tmp=new Node(data);
      head=tmp;
      tail=tmp;
      tmp.next=null;
      tmp.pre=null;
    }
    else if(pos == 1){
      insertBegin(data);
    }
    else{
      Node tmp=new Node(data);
      Node ptr=head;
      N:for(int i=1;i<pos;i++){
        if(ptr.next==head){
          ptr=ptr.next;
          break N;
        }
        ptr=ptr.next;
      }
      tmp.next=ptr;
      ptr=ptr.pre;
      ptr.next=tmp;
      tmp.pre=ptr;
      ptr=tmp.next;
      ptr.pre=tmp;
    }
  }
  public void deleteAt(int pos){
    if(head == null){
      System.out.println("List is already Empty");
    }
    else if(head == tail){
      head=null;
      tail=null;
    }
    else{
      Node ptr=head;
      N:for(int i=1;i<pos;i++){
        if(ptr.next==head){
          // ptr=ptr.next;
          break N;
        }
        ptr=ptr.next;
      }
      (ptr.next).pre=ptr.pre;
      (ptr.pre).next=ptr.next;
      if(ptr == head){
        head=ptr.next;
      }

    }
  }
}



class Node{
  Node next,pre;
  int data;
  Node(int data){
    this.data=data;
  }
}
