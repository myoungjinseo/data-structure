
public class ArrayQueue implements Queue{
	
	private int front;
	private int rear;
	private int queueSize;
	private char itemArray[];
	
	public ArrayQueue(int queueSize) {
		this.front = -1;
		this.rear = -1;
		this.queueSize = queueSize;
		itemArray = new char[this.queueSize];
	}
	
	public boolean isFull() {
		return(this.rear == this.queueSize -1);
	}
	
	public void enQueue(char item) {
		if(isFull()) {
			System.out.println("Inserting faul! Array Queue is full!!");
		} else {
			itemArray[++rear] = item;
			System.out.println("Inserted Item :" + item);
		}
	}
	
	public boolean isEmpty() {
		return (this.front == this.rear);
	}
	
	public void delete() {
		if(isEmpty()) {
			System.out.println("Deleting faul! Array Queue is empty!!");
		} else {
			++front;
		}
	}
	
	public char deQueue() {
		if(isEmpty()) {
			System.out.println("Dequeuing fail! Array Queue is empty!!");
			return 0;
		} else {
			return itemArray[++front];
		}
	}
	
	public char peek() {
		if(isEmpty()) {
			System.out.println("Peeking fail! Array Queue is empty!!");
			return ;
		} else {
			return itemArray[front+1];
		}
	}
	
	public void printQueue(){
		if(isEmpty()) {
			System.out.printf("Array Queue is empty!! %n %n");
		} else {
			System.out.printf("Array Queue>> ");
			for(int i=front+1; i<=rear; i++) {
				System.out.printf("%c",itemArray[i]);
			}
			System.out.println();
			System.out.println();
		}
	}
}
