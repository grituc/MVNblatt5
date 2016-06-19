package de.hfu;
import org.junit.Test;
import static org.junit.Assert.*;
import de.hfu.meldeauskunft.*;

import java.awt.image.RescaleOp;
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
		ResidentRepositoryStub rrStub = new ResidentRepositoryStub();
		rs.setResidentRepository(rrStub);
	
		Resident r1, r2, r3, r4;
		r1 = new Resident("Donald", "Duck", "Grieshaberstr. 7", "Furtwangen", null);
		r2 = new Resident("Daisie", "Duck", "Wilhelmstr. 11", "Furtwangen", null);
		r3 = new Resident("George", "Martin", "Blumentstr. 11", "Villingen", null);

		rrStub.addResident(r1);
		rrStub.addResident(r2);
		rrStub.addResident(r3);
		
		r4 = new Resident(null, "Duck", null, null, null);

		ArrayList<Resident> testList = new ArrayList<Resident>();
		testList.add(r1);
		testList.add(r2);
		
		assertEquals(testList, rs.getFilteredResidentsList(r4));		
		
	}
	
	@Test
	public void test2GetFilteredResidentsList(){
		BaseResidentService rs = new BaseResidentService();
		ResidentRepositoryStub rrStub = new ResidentRepositoryStub();
		rs.setResidentRepository(rrStub);	
	
		Resident r1, r2, r3, r4, r5;
		r1 = new Resident("Donald", "Duck", "Grieshaberstr. 7", "Furtwangen", null);
		r2 = new Resident("Daisie", "Martin", "Wilhelmstr. 11", "Furtwangen", null);
		r3 = new Resident("George", "Martin", "Blumentstr. 11", "Villingen", null);

		rrStub.addResident(r1);
		rrStub.addResident(r2);
		rrStub.addResident(r3);
		
		r4 = new Resident("D*", null, null, null, null);
		r5 = new Resident("Do*", null, null, null, null);


		ArrayList<Resident> testList = new ArrayList<Resident>();
		testList.add(r1);
		testList.add(r2);
		
		assertEquals(testList, rs.getFilteredResidentsList(r4));
		assertNotEquals(testList, rs.getFilteredResidentsList(r5));
		
		ArrayList<Resident> testList2 = new ArrayList<Resident>();
		testList2.add(r2);
		testList2.add(r3);

		assertEquals(testList2, rs.getFilteredResidentsList(new Resident(null , "Ma*", null, null, null)));
		assertEquals(testList2, rs.getFilteredResidentsList(new Resident(null , null, "*11", null, null)));
		
		assertEquals(testList2, rs.getFilteredResidentsList(new Resident(null , null, "*11", "Fu*", null))); //???
											//Erklaerung: "City"-attribute vom Resident wird bei dem Vergleich ignoriert
		assertNotEquals(testList2, rs.getFilteredResidentsList(new Resident("D*" , null, "*11", null, null)));
		
	}
	
	@Test //die Klasse wirft keine Ausnahme
	public void test3GetFilteredResidentsList(){
		BaseResidentService rs = new BaseResidentService();
		ResidentRepositoryStub rrStub = new ResidentRepositoryStub();
		rs.setResidentRepository(rrStub);	
	
		Resident r1, r2, r3, r4, r5, r6;
		r1 = new Resident("Donald", "Duck", "Grieshaberstr. 7", "Furtwangen", null);
		r2 = new Resident("Daisie", "Martin", "Wilhelmstr. 11", "Furtwangen", null);
		r3 = new Resident("George", "Martin", "Blumentstr. 11", "Villingen", null);

		rrStub.addResident(r1);
		rrStub.addResident(r2);
		rrStub.addResident(r3);
		
		ArrayList<Resident> testList = new ArrayList<Resident>();
		testList.add(r1);
		testList.add(r2);
		
		assertNotEquals(testList, rs.getFilteredResidentsList(new Resident(null, null, null, null, null))); //a list with 3 objects on the right side
		assertEquals(testList, rs.getFilteredResidentsList(new Resident("*a*" , null, null, null, null)));

	}
	
	@Test
	public void test1GetUniqueResident() throws ResidentServiceException{
		BaseResidentService rs = new BaseResidentService();
		ResidentRepositoryStub rrStub = new ResidentRepositoryStub();
		rs.setResidentRepository(rrStub);
		
		Resident r1, r2, r3;
		r1 = new Resident("Donald", "Duck", "Grieshaberstr. 7", "Furtwangen", null);
		r2 = new Resident("Daisie", "Martin", "Wilhelmstr. 11", "Furtwangen", null);
		
		rrStub.addResident(r1);
		rrStub.addResident(r2);
		
		assertSame(r1, rs.getUniqueResident(r1)); //Same staerker als Equals
		assertEquals(r1, rs.getUniqueResident(r1));
		assertEquals(r1, rs.getUniqueResident(new Resident("Donald", "Duck", "Grieshaberstr. 7", "Furtwangen", null)));


		
		assertEquals(r1, rs.getUniqueResident(new Resident("Donald", null, null, "Furtwangen", null)));
		assertEquals(r1, rs.getUniqueResident(new Resident("Donald", "Duck", "Grieshaberstr. 7", "Furt", null))); //soll nicht gehen, aber die Stadt ist ignoriert

		assertNotEquals(r1, rs.getUniqueResident(r2));

		
	}

	@Test(expected = ResidentServiceException.class)

	public void test2GetUniqueResident() throws ResidentServiceException{
		BaseResidentService rs = new BaseResidentService();
		ResidentRepositoryStub rrStub = new ResidentRepositoryStub();
		rs.setResidentRepository(rrStub);
		
		Resident r1, r2, r3;
		r1 = new Resident("Donald", "Duck", "Grieshaberstr. 7", "Furtwangen", null);
		r2 = new Resident("Daisie", "Duck", "Wilhelmstr. 11", "Furtwangen", null);
		
		r3 = new Resident(null, "Duck", null, null, null); //wird nicht im Repository gespeichert

		rs.getUniqueResident(r3);

		
	}
	
	@Test(expected = ResidentServiceException.class)
	public void test3GetUniqueResident() throws ResidentServiceException{ //why "throws..." ???
		BaseResidentService rs = new BaseResidentService();
		ResidentRepositoryStub rrStub = new ResidentRepositoryStub();
		rs.setResidentRepository(rrStub);
		
		Resident r1, r2, r3;
		r1 = new Resident("Donald", "Duck", "Grieshaberstr. 7", "Furtwangen", null);
		r2 = new Resident("Daisie", "Martin", "Wilhelmstr. 11", "Furtwangen", null);
		
		r3 = new Resident("*", "Martin", "Blumentstr. 11", "Villingen", null); //wird nicht im Repository gespeichert

		rrStub.addResident(r1);
		rrStub.addResident(r2);
		rs.getUniqueResident(r3);
		
		/*
		try {
			rs.getUniqueResident(r3);
		} catch (ResidentServiceException e){throw new ResidentServiceException("ResServExc");}  //ResidentServiceException
		*/
	}
}
