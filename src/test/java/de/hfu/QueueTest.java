package de.hfu;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
	@Test
	public void testQueue_enqueue(){
		Queue q = new Queue(3); //the length of the queue
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testQueue_createQueue(){
		Queue q = new Queue(0);  //check the constraint in Constructor (length > 0)
	}

}
