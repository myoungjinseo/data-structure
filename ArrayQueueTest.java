
public class ArrayQueueTest {

	public static void main(String args[]) {
		ArrayQueue Q = new ArrayQueue(3);

		
		Q.enQueue('A');
		Q.printQueue( );
		Q.enQueue('B');
		Q.printQueue();
		Q.enQueue('C');
		Q.printQueue( );
		Q.enQueue('D');
		Q.printQueue( );
		
		char peekedItem = Q.peek();
		if(peekedItem != 0) {
			System.out.println("peeked Item :" + peekedItem);
		}
		Q.printQueue();
		
		char dequeuedItem = Q.deQueue();
		if(dequeuedItem  != 0) {
			System.out.println("dequeued Item :" + dequeuedItem );
		}
		Q.printQueue();
	}

}
