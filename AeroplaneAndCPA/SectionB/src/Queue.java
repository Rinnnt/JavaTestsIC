public class Queue<T> implements QueueInterface<T>{
	
	private Node<T> first;
	private Node<T> last;
	
	public boolean isEmpty() {
		return last == null;
	}
	
	//post: Adds the given item to the queue
	public void enqueue(T item) {
		if (isEmpty()) {
			first = new Node(item);
			last = first;
		}
		else {
			last.setNext(new Node(item));
			last = last.getNext();
		}
	}
	
	//post: Removes and returns the head of the queue. It throws an 
	//      exception if the queue is empty.
	public T dequeue() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("Queue is empty");
		}
		T result = first.getItem();
		first = first.getNext();
		if (first == last.getNext()) {
			last = first;
		}
		return result;
	}
	
}
