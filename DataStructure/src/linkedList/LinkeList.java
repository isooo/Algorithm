package linkedList;

public class LinkeList {
	private Node head;
	private int size = 0;

	// constructor
	public LinkeList() {
	}

	/*
	 * public LinkeList(Node head, int size) { super(); this.head = head;
	 * this.size = size; }
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
		printList("addFirst");
	}// addFirst()

	public void addLast(String newValue) {
		Node newNode = new Node(newValue);

		if (this.head == null) {
			this.head = newNode;
		} else {
			newNode.setNext(null);
			Node findLast = this.head;
			while (findLast.getNext() != null) {
				findLast = findLast.getNext();
			} // while

			findLast.setNext(newNode);
		}
		this.size++;
		printList("addLast");
	}// addLast

	public void insert(int index, String inputValue) {
		Node newNode = new Node(inputValue);

		if (this.head == null) {
			head = newNode;
		} else if (index == 1) {
			newNode.setNext(this.head);
			this.head = newNode;
		} else {
			Node prevNode = this.head;
			Node subsNode = null;
			int cnt = 1;

			while (cnt < index) {

				if (cnt == index - 1) {
					newNode.setNext(prevNode.getNext());
					prevNode.setNext(newNode);
					break;
				} else {
					prevNode = prevNode.getNext();
					cnt++;
				}
			} // for
		} // else
		this.size++;

		// StackTraceElement[] stacks = new Throwable().getStackTrace();
		// StackTraceElement currStack = stacks[0];
		// System.out.println("==" + currStack.getMethodName());

		printList("insert");

	}// insert()

	public Node removeFirst() {

		Node result = this.head;

		if (this.head == null) {
			System.out.println("There is no Node to remove");
			return null;
		} else {
			Node nextHead = this.head.getNext();
			this.head = nextHead;
		}
		this.size--;
		printList("removeFirst");
		return result;
	}// removeFirst()

	public Node removeLast() {
		Node result = null;

		if (this.head == null) {
			System.out.println("There is no Node to remove");
			return null;
		} else {
			Node nextLast = this.head;
			Node prevNode = null;
			while (nextLast.getNext() != null) {
				prevNode = nextLast;
				nextLast = nextLast;
				result = nextLast;
			}
			prevNode.setNext(null);
		}
		this.size--;
		printList("removeLast");
		return result;
	}// removeLast()

	public Node remove(int index) {

		this.size--;
	}

	public int size() {
		return this.size;
	}

	public Node get(int index) {

		Node result = null;
		int cnt = 0;
		while (cnt < index) {
			if (cnt == index) {

			}
			cnt++;
		}
		return result;
	}// get()

	public void printList(String method) {

		if (this.head == null) {
			System.out.println("There is no Node..");
		} else {
			Node node = this.head;
			System.out.print(method + " (current size : " + this.size + ") \n\t\t");
			while (node != null) {
				System.out.print(node.getValue() + "  ");
				node = node.getNext();
			}
		} // else
		System.out.println();

	}// printList()
}
