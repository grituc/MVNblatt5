package de.hfu;
import org.junit.Test;
import static org.junit.Assert.*;
import de.hfu.meldeauskunft.*;

import java.util.*;

/*Integrationstest for the methods   
*public List<Resident> getFilteredResidentsList(Resident filterResident) and
*public Resident getUniqueResident(Resident filterResident)
*from the class BaseResidentService
*/

public class BaseResidentServiceTest {
	@Test
	public void test1GetFilteredResidentsList(){
		BaseResidentService rs = new BaseResidentService();
		ResidentRepositoryStub rr = new ResidentRepositoryStub();
		rs.setResidentRepository(rr);
	
		Resident r1, r2, r3, r4;
		r1 = new Resident("Donald", "Duck", "Grieshaberstr. 7", "Furtwangen", null);
		r2 = new Resident("Daisie", "Duck", "Wilhelmstr. 11", "Furtwangen", null);
		r3 = new Resident("George", "Martin", "Blumentstr. 11", "Villingen", null);
		r4 = new Resident(null, "Duck", null, null, null);

		rr.addResident(r1);
		rr.addResident(r2);
		rr.addResident(r3);

		ArrayList<Resident> testList = new ArrayList<Resident>();
		testList.add(r1);
		testList.add(r2);
		
		assertEquals(testList, rs.getFilteredResidentsList(r4));
		//assertE
		
		
	}
	
	@Test
	public void test2GetFilteredResidentsList(){
		
	}
	
	@Test
	public void test3GetFilteredResidentsList(){
		
	}

}
