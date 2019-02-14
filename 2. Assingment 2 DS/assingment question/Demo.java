import java.util.*;
class Node{
  Node next;
  int data;
  Node(int data){
    this.data=data;
  }
}

public class Demo{
  Node head,tail;
  public static void main(String[] args) {
    Demo ob=new Demo();
    Scanner scan=new Scanner(System.in);
    System.out.println("Enter size os list");
    int n=scan.nextInt();
    for (int i=0; i<n; i++) {
      ob.insertBegin(scan.nextInt());
    }
    ob.print();
    ob.remove();
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
  public void  deleteAt(int pos){

    Node temp=null;
    Node ptr=head;
    if(pos==1){
      ptr=head;
      head=head.next;
      ptr.next=null;
      ptr=head;
    }
    else{
      for(int i=1;i<pos-1;i++){
        ptr=ptr.next;
      }
    // System.out.print(ptr.data+" ");
    temp=ptr;
    ptr=ptr.next.next;
    temp.next=ptr;
  }
}
// public void remove(){
//   int i=0,j=0;
//   Node ptr=head;
//   Node pptr=head;
//   while(ptr != null){
//     while(pptr != null){
//       if( ( pptr.data + ptr.data )==0){
//         // System.out.print(ptr.data +"  "+pptr.data);
//         ptr=ptr.next;
//         pptr=pptr.next;
//         deleteAt(i-1);
//         deleteAt(j-1);
//       }else{
//         pptr=pptr.next;
//         j++;
//       }
//     }
//     ptr=ptr.next;
//     i++;
//   }
// }
  public void remove(){
    int i=0,j=1;
    Node ptr=head;
    Node pptr=head;
    Node curr=ptr.next;
    while(ptr.next != null){
      pptr=curr.next;
      if((ptr.data + curr.data) == 0){
        ptr=ptr.next;
        deleteAt(i);
        deleteAt(j-1);
        System.out.println("deleteAt -> "+i+j);
      }
      if(pptr != null){
        curr=pptr;
        j++;
        System.out.println("curr inc -> "+i+j);
      }
      else{
        j=i;
        curr=ptr;
      }
      if(ptr.next !=null){
        ptr=ptr.next;
        i++;
        System.out.println("ptr inc -> "+i+j);
      }

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
