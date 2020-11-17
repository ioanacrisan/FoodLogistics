package si.um.opj.crisan.logic.facility;


import si.um.opj.crisan.logic.Location;
import si.um.opj.crisan.logic.Transportable;
import si.um.opj.crisan.logic.transport.Vehicle;

/**
 * Represenation of warehouse
 *
 * @author  Ioana
 * @since   2020-04-08
 * @version 4.0
 */

public class Store extends BusinessFacility implements Transportable {
   
     /**
     * Parametrized constructor of si.um.opj.crisan.logic.facility.Store class
     * @param name storeName of si.um.opj.crisan.logic.facility.Store
     * @param location storeLocation of si.um.opj.crisan.logic.facility.Store
     */
    public Store(String name, Location location){
        super(name,location);
    }


 
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void acceptVehicle(Vehicle vehicle) {
        vehicle.unloadFoodItems();

    }
}
