package de.hfu;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
		
	@Test(expected = IllegalArgumentException.class)
	public void testQueue_createQueue(){
		new Queue(0);  //check the constraint in Constructor (length > 0): 0 is not allowed
	}
	
	@Test(expected = IllegalStateException.class)
	public void testQueue_dequeue(){
		Queue q = new Queue(3); //the length of the queue
		//q.enqueue(5); //Attention!
		//assertEquals(77, q.dequeue()); //!!! THIS ASSERT_EQUALS IS _NOT_ IGNORED! 
		q.dequeue();  //the queue is empty, should not be able to dequeue, an exception is expected
		q.enqueue(5); //Attention!
		assertEquals(77, q.dequeue()); //!!! THIS ASSERT_EQUALS IS IGNORED! 
	}
	
	@Test
	public void testQueue_enqueue() {
		Queue q = new Queue(3);
		q.enqueue(42);
		q.enqueue(-33);
		q.enqueue(7);
		assertEquals(42, q.dequeue());
		assertEquals(-33, q.dequeue());
		assertEquals(7, q.dequeue());
		
		Queue q1 = new Queue(3);
		q1.enqueue(42);
		q1.enqueue(-33);
		q1.enqueue(7);
		q1.enqueue(77);
		q1.enqueue(7007);
		assertEquals(42, q1.dequeue());
		assertEquals(-33, q1.dequeue());
		assertEquals(7007, q1.dequeue());
		//q1.dequeue(); //will not work!
		
		Queue q2 = new Queue(3);
		q2.enqueue(11);
		q2.enqueue(2);
		q2.enqueue(42);
		assertEquals(11, q2.dequeue());
		q2.enqueue(300);
		assertEquals(2, q2.dequeue());
		q2.enqueue(489);  //42 300 489
		q2.enqueue(75); //42 300 75

		assertEquals(42, q2.dequeue()); //300 75 free
		q2.enqueue(12); //300 75 12
		assertEquals(300, q2.dequeue());
		assertEquals(75, q2.dequeue());
		assertEquals(12, q2.dequeue());
		//q2.dequeue(); // does not work, as expected
		q2.enqueue(1);
		q2.enqueue(22);
		q2.enqueue(5);
		q2.enqueue(7);
		q2.enqueue(8);
		q2.enqueue(9);  //1 22 9 expected
		assertEquals(1, q2.dequeue());
		q2.enqueue(7);
		q2.enqueue(78);
		q2.enqueue(7009); //22 9 7009 expected
		assertEquals(22, q2.dequeue());
		assertEquals(9, q2.dequeue());
		assertEquals(7009, q2.dequeue());
		//q2.dequeue(); // does not work (should not either)

		
		
	}
	
	@Test(expected = IllegalStateException.class)
	public void testQueue_dequeue2(){
		Queue q = new Queue(3); 
		q.enqueue(42);
		q.enqueue(-33);
		q.enqueue(7);
		for (int i=0; i<3; ++i)
			q.dequeue();  //dequeued thrice
		//and one more time - should not work
		q.dequeue(); //exception thrown as expected
	}

}
