package de.hfu.meldeauskunft;

import java.util.List;

//import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;

/**
 * @author Stefan Betermieux
 */
public interface ResidentRepository {

  List<Resident> getResidents();

}