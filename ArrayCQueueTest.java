public class ArrayCQueueTest {
	public static void main(String args[]) {
		ArrayCQueue cQ = new ArrayCQueue(3);
		cQ.enQueue('A');
		cQ.printQueue();
		cQ.enQueue('B');
		cQ.printQueue();
		cQ.enQueue('C');
		cQ.printQueue();
		cQ.enQueue('D');
		cQ.printQueue();
		char dequeuedItem = cQ.deQueue();
		if (dequeuedItem != 0)
			System.out.println("dequeued Item : " + dequeuedItem);
		cQ.printQueue();
		cQ.enQueue('E');
		cQ.printQueue();
	}
}