package linkedList;

public class LinkeList {
    private Node head;
    private int size = 0;

    // constructor
    public LinkeList() {
	}


/*	public LinkeList(Node head, int size) {
		super();
		this.head = head;
		this.size = size;
	}
*/
    
	public void addFirst(String newValue) {
		Node newNode = new Node(newValue);
		
		if (this.head == null) {
			this.head = newNode;
		} else {
			newNode.setNext(this.head);
			this.head = newNode;
		}
		this.size++;
		printList();
    }// addFirst()

    public void addLast(String newValue){
    	Node newNode = new Node(newValue);
    	
    	if (this.head == null) {
    		head = newNode;
    	} else {
    		newNode.setNext(null);
    		Node findLast = this.head;
    		while (findLast.getNext() != null) {
    			findLast = findLast.getNext();
    		}// while
    		
    		findLast.setNext(newNode);
    	}
    	this.size++;
    	printList();
    }// addLast

    public void insert(int index, String inputValue){
    	
    }// insert()

    public Node removeFirst(){
    	
    	this.size--;
    }

    public Node removeLast(){

    	this.size--;
    }

    public Node remove(int index){

    	this.size--;
    }

    public int size(){
    	return this.size;
    }

    public Node get(int index){

    }

    public boolean isEmpty(){

    }

    public void printList(){

    	if (this.head == null) {
    		System.out.println("There is no Node..");
    	} else {
    		Node node = this.head;
    		System.out.print(this.size + " : ");
    		while (node != null) {
    			System.out.print(node.getValue() + "  ");
    			node = node.getNext();
    		}
    	}// else
    	System.out.println();
    	
    }// printList()
}
