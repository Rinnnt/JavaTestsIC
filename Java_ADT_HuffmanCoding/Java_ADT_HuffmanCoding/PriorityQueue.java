public class PriorityQueue<E extends Comparable<E>> implements PriorityQueueInterface<E>{

	private E[] items;    //a heap of HuffmanTrees
	private final static int max_size = 256;
	private int size;    //number of HuffManTrees in the heap.
	
	
	public PriorityQueue( ) {
        // constructor which creates an empty heap
		items = (E[]) new Comparable[max_size];
		size = 0;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int getSize(){
		return size;
	}

	public E getMin(){
		E root = null;
		if (!isEmpty()) root = items[0];
		return root;
	}
	
	public void add(E newEntry) throws PriorityQueueException{
	// post: Adds a new entry to the priority queue according to 
        // the priority value.
	// ADD YOUR CODE HERE
		if (size >= max_size) {
			throw new PriorityQueueException("Queue is full");
		}
		items[size] = newEntry;
		size++;
		percolateUp(size - 1);
	}

	private void percolateUp(int index) {
		if (index > 0) {
			int parent = (index - 1) / 2;
			if (items[parent].compareTo(items[index]) > 0) {
				E item = items[parent];
				items[parent] = items[index];
				items[index] = item;
				percolateUp(parent);
			}
		}
	}
 				
 	public E removeMin(){
	// post: Removes the minimum valued item from the PriorityQueue
		E root = null;
		if (!isEmpty()){
			root = items[0];
			items[0] = items[size-1];
			size--;
			heapRebuild(0);
		}
		return root;
	}
	
	private void heapRebuild(int root){
	// Rebuild heap to keep it ordered
	// ADD YOUR CODE HERE
		int leftChild = 2 * root + 1;
		if (leftChild < size) {
			int minChild = leftChild + ((leftChild + 1 < size && items[leftChild + 1].compareTo(items[leftChild]) < 0) ? 1 : 0);
			if (items[root].compareTo(items[minChild]) > 0) {
				E item = items[root];
				items[root] = items[minChild];
				items[minChild] = item;
				heapRebuild(minChild);
			}
		}
	}
}
