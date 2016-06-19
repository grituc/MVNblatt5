package de.hfu.meldeauskunft;

import java.util.*;

public class ResidentRepositoryStub implements ResidentRepository{
	private List<Resident> residents;
	
	public ResidentRepositoryStub() {
		residents = new ArrayList<Resident>();
		/*
		Resident r1, r2, r3;
		r1 = new Resident("Donald", "Duck", "Grieshaberstr. 7", "Furtwangen", null);
		r2 = new Resident("Daisie", "Duck", "Wilhelmstr. 11", "Furtwangen", null);
		r3 = new Resident("George", "Martin", "Blumentstr. 11", "Villingen", null);
		addResident(r1);
		addResident(r2);
		addResident(r3);
		 */	
	}
	
	public void addResident(Resident r){
		residents.add(r);
	}

	@Override  //this protects me from typos - there would be a warning from the compiler
	public List<Resident> getResidents() {
		return residents;
	}
	

}
