// Morgan Evans, 1124703, mnevans

import java.util.*;

public class ListQueue {
	
	private int size;
	private ListQueueNode front;
	private ListQueueNode back;
   private List<String> list; 
	
	public ListQueue(){
		list = new LinkedList<String>();
      front = null;
		back = null;
		size = 0;
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
      ListQueueNode newNode = new ListQueueNode(toEnqueue);
      if (isEmpty()) {
         front = newNode;
      } else {   
         back.next = newNode;
      }   
      back = newNode;
      back.next = null;
      size++;  
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
         toDequeue = front.data;
         front = front.next;
         size--;
  
         if (isEmpty()) {
            back = null;
         }
      }
      return toDequeue;
	}
	
	/**
	 * 
	 * @return returns true if the queue is empty, false otherwise
	 */
	public boolean isEmpty(){
		return front == null;
	}
}
