package de.hfu;
//noch in Entwicklung
/*

public class Queue2 {
   int[] queue;  //int-array
   int head; //remove from here
   int tail; //insert here
   private final int maxqueuelength; //size of the queue

   public Queue2(int max){
	   if (max < 1) throw new IllegalArgumentException("Queue Arraylength " + max);
	   maxqueuelength = max;
	   queue = new int[max];
	   head = 0;
	   tail = -1;
   }

   public void enqueue(int a){
	   //it is always possible to enqueue. If the queue is full - the last element overwritten
	   //the new element will be written at the index "tail"
	 if (tail == -1){
		   queue[0] = a; //will only happen once
	   	   tail = 1;
	   }
	 else
	   if ((tail + 1) % maxqueuelength == head)
		   //this means the queue is full
		   queue[tail] = a;
	   else {
		   queue[tail] = a;
		   tail = (tail + 1) % maxqueuelength;
	   }   
   }



   public int dequeue(){
	   //dequeuing an empty queue should result in throwing an exception
	   if (tail == -1 || head == tail)
		   throw new IllegalStateException("dequeue on empty queue");
	   int temp = head;
	   head = (head + 1) % maxqueuelength;
	   return queue[temp];		   
   }

}
*/