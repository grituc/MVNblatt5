package de.hfu;
import de.hfu.meldeauskunft.*;
import java.util.*;
import org.junit.Test;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

public class BaseResidentServiceMockTest {
	@Test
	public void testGetFilteredResidentsList() throws ResidentServiceException{
		ResidentRepository rrMock = createMock(ResidentRepository.class);
		BaseResidentService rs = new BaseResidentService();
		
		Resident r1, r2, r3, r4, r5;
		r1 = new Resident("Donald", "Duck", "Grieshaberstr. 7", "Furtwangen", null);
		r2 = new Resident("Daisie", "Duck", "Wilhelmstr. 11", "Furtwangen", null);
		r3 = new Resident("George", "Martin", "Blumentstr. 11", "Villingen", null);

		ArrayList<Resident> list1 = new ArrayList<Resident>();
		list1.add(r1);
		list1.add(r2);
		list1.add(r3);
				
		expect(rrMock.getResidents()).andReturn(list1);
		
		replay(rrMock); 

		rs.setResidentRepository(rrMock); //dynamische Integrierung des Mocks

		r4 = rs.getUniqueResident(r1);
		//rrMock.getResidents(); //Aufruf der zu testenden Methode

		
		verify(rrMock); //Verhalten ueberpruefen
		assertEquals(r4.getGivenName(), ("Donald"));
		
		
	}

}
