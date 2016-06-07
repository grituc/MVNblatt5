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
		    tail++; 
		
	   queue[tail % maxqueuelength] = a; //why modulo? because tail can be equal or bigger than size 
   }

   public int dequeue(){
	   if(tail < head){
		    throw new IllegalStateException("dequeue on empty queue");
		  }
		  return queue[(head++) % maxqueuelength];
   }

}
//Critic: tail and head might one day achieve the INT_MAX (the value will jump from + to a negative number!) 