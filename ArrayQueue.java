// Morgan Evans, 1124703, mnevans

public class ArrayQueue {
	private String[] queueArray;
	private int size;
	private int front;
	private int back;
	
	public ArrayQueue(){
		queueArray = new String[100];
		size = 0;
		front = 0;
		back = -1;
	}
	
	public ArrayQueue(int startSize){
		queueArray = new String[startSize];
		size = 0;
		front = 0;
		back = -1;
	}
	/**
	 * @function returns the number of elements in the queue
	 * @return size
	 */
	public int getSize(){
		return size;
	}
	/**
	 * @function adds a string to the end of the queue
	 * @param toEnqueue: the input to be inserted
	 */
	public void enqueue(String toEnqueue){
      if (isFull()) {
         System.out.print("Cannot enqueue, the ArrayQueue is full.");
      } else {
         queueArray[back + 1] = toEnqueue;
         size++;
         back = (back + 1) % 100;
      }   
	}
	
	/**
	 * @function removes the string from the front of the queue
	 * @return the string from the front of the queue
	 */
	
   	public String dequeue(){
      String toDequeue = "";
      
      if (isEmpty()) {
         System.out.print("There is nothing to dequeue.");
      } else {
         toDequeue = queueArray[front];
         size--;
         front = (front + 1) % 100;
      }   
		return toDequeue;
	}
	
	/**
	 * 
	 * @return returns true if the queue is empty, false otherwise
	 */
	public boolean isEmpty(){
      return queueArray.length == 0;
	}

	/**
	 * 
	 * @return returns true if the queue is full, false otherwise
	 */
	public boolean isFull(){
      return size == 100; 
	}
	
}
