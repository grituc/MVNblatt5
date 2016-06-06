package de.hfu;

public class Queue {
   int[] queue;  //int-array
   int head; //remove from here
   int tail; //insert here
   private final int maxqueuelength; //size of the queue

   public Queue(int max){
	   if (max < 1) throw new IllegalArgumentException("Queue Arraylength " + max);
	   maxqueuelength = max;
	   queue = new int[max];
	   head = 0;
	   tail = -1;
   }

   public void enqueue(int a){
	   if((tail - head) < maxqueuelength -1 )
		    tail++; //strange: full queue size 3, tail =  
		
	   queue[tail % maxqueuelength] = a; //why modulo? tail < maxqueuelength always!
   }

   public int dequeue(){
	   if(tail < head){
		    throw new IllegalStateException("dequeue on empty queue");
		  }
		  return queue[(head++) % maxqueuelength];
   }

}
//Problem: full queue, element with index 0 removed, still enqueue() will write on the last position (index 2 if size of the queue is 3)