package doublyLinkedList;

public class DLL{
	class node{
		int data;
		node prev;
		node next;
		
	public node(int data) {
		this.data = data;
	}
	}
	
	node head = null;
	node tail = null;
	
	public void addNodetoStart(int data) {
		node newNode = new node(data);
		newNode.data = data;
		newNode.prev = null;
		newNode.next = null;
		
		if (head == null) {
			head = newNode;
		}
		else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
	}
	
	public void addNodetoEnd(int data) {
		node newNode = new node(data);
		
	
	if(head == null) {
		head = newNode;
		tail = newNode;
		head.prev = null;
		tail.next = null;
	}
	else {
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
		tail.next = null;
	}
	}
	
	public int getHeadNode() {
		System.out.println("\n The head is: " + head.data);
		return head.data;
	}
	
	public int getTailNode() {
		System.out.println("\n The tail is: " + tail.data);
		return tail.data;
	}
	
	public void deleteNode(int val) {
		node current = head;
		while (current.data != val) {
			current = current.next;
		}
		current.prev.next = current.next;
		if(current.next != null) {
			current.next.prev = current.prev;
		}
		current = null;
	}
	
	public void showList() {
		node current = head;
		if(head==null) {
			System.out.println("There is nothing in the list");
			return;
		}
		System.out.println("\n The current list contains: \n");
		while(current!= null) {
			System.out.print(current.data+" ");
			current = current.next;
		}
	}
	
	public static void main(String[]args) {
		
		DLL list = new DLL();
		//Adding 3 nodes to the end
		list.addNodetoEnd(4);
		list.addNodetoEnd(5);
		list.addNodetoEnd(6);
		
		//Showing the list
		list.showList();

		//Adding 3 nodes to the start
		list.addNodetoStart(3);
		list.addNodetoStart(2);
		list.addNodetoStart(1);
		
		//Showing the list
		list.showList();
		
		//Getting the head
		list.getHeadNode();
		
		//Getting the tail
		list.getTailNode();
		
		//Deleting a node
		list.deleteNode(2);
		list.showList();
	}
}
