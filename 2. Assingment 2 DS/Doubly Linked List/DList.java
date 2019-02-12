class Node{
	Node next;
	Node prev;
	int data;
	Node(int d){
		data=d;
	}
}

public class DList{

	Node insert(int d,Node head){
		Node temp=new Node(d);
		if(head==null){
			head=temp;
			head.next=null;
			head.prev=null;
			return head;
		}
		else{
			Node ptr=head;
			while(ptr.next!=null){
				ptr=ptr.next;
			}
			temp.prev=ptr;
			ptr.next=temp;
			return head;
		}
	}
	Node insertBeg(int d,Node head){
		Node temp=new Node(d);
		if(head==null){
			head=insert(d,head);return head;
		}
		else{
			head.prev=temp;
			temp.next=head;
			head=temp;
			head.prev=null;
			return head;
		}
	}
	Node insertAt(int pos,int num,Node head){
		Node ptr=head;
		while(pos > 1){
			ptr=ptr.next;
			pos-=1;
			if(ptr==null){System.out.println("position does not exist !");
					return head;
			}
		}
		if(ptr==head){
			head=insertBeg(num,head);
		}
		else if(ptr.next==null){
			head=insert(num,head);
		}
		else{
			Node temp=new Node(num);
			(ptr.prev).next=temp;
			temp.prev=ptr.prev;
			temp.next=ptr;
			ptr.prev=temp;

		}
		return head;
	}
	Node delete(int n,Node head){
		Node ptr=head;
		while(ptr!=null){

			if(ptr.data==n && ptr.next==null && ptr.prev==null ){
				head=null;
				ptr=ptr.next;
			}
			else if(ptr.data==n && ptr.next==null){
				(ptr.prev).next=null;
				ptr=ptr.next;
			}
			else if(ptr.data==n && ptr.prev==null ){
				ptr=ptr.next;
				head=ptr;
				(ptr).prev=null;
			}
			else if(ptr.data==n){
				(ptr.next).prev=ptr.prev;
				(ptr.prev).next=ptr.next;
				ptr=ptr.next;
			}
			else{
				ptr=ptr.next;
			}
		//ptr=ptr.next;
		}
	return head;
	}
//===================================================================================================================
//===========================================INSERTION AT Ith POSITION===============================================
Node deleteAt(int pos,Node head){
		Node ptr=head;
		while(pos > 1){
			ptr=ptr.next;
			pos-=1;
			if(ptr==null){System.out.println("position does not exist !");
					return head;
			}
		}
		if(ptr==head){
			head=ptr.next;
		}
		else if(ptr.next==null){
			(ptr.prev).next=null;
		}
		else{
			(ptr.prev).next=(ptr.next);
		}
		return head;
	}
//=================================================================================================================
	void print(Node head){
		Node ptr=head;
			while(ptr!=null){
				System.out.print(ptr.data+" ");
				ptr=ptr.next;
			}
	}
	public static void main(String[] args){
		Node head=null;
		DList ob=new DList();
		head=ob.insert(1,head);
		head=ob.insert(1,head);
		head=ob.insert(1,head);
		head=ob.insert(4,head);
		head=ob.insert(5,head);
		//head=ob.delete(1,head);
		head=ob.insertAt(5,99,head);
		head=ob.deleteAt(4,head);
		ob.print(head);
	}
}
