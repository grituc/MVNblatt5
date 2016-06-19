package de.hfu.meldeauskunft;

import java.util.List;

public class ResidentRepositoryStub implements ResidentRepository{
	private List<Resident> residents;
	
	public ResidentRepositoryStub() {	
		residents = null;
	}
	
	public void addResident(Resident r){
		residents.add(r);
	}

	@Override  //this protects me from typos - there would be a warning from the compiler
	public List<Resident> getResidents() {
		return residents;
	}
	

}
