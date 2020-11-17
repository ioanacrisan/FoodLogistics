package si.um.opj.crisan.logic.facility;
import  si.um.opj.crisan.logic.Location;

import java.util.Arrays;

public class BusinessFacility {
    private String name;
    private Location location;

    /**
     * Default constructor of si.um.opj.crisan.logic.facility.BusinessFacility class
     */
    public BusinessFacility(){

    }
    /**
     * Parametrized constructor of si.um.opj.crisan.logic.facility.BusinessFacility class
     * @param name warehouseName of si.um.opj.crisan.logic.facility.BusinessFacility
     * @param location warehouseLocation of si.um.opj.crisan.logic.facility.BusinessFacility
     */

    public BusinessFacility(String name, Location location){
        this.name = name;
        this.location = location;
    }

    /**
     * si.um.opj.crisan.logic.facility.BusinessFacility's name getter
     * @return warehouseName number of si.um.opj.crisan.logic.facility.BusinessFacility
     */
    public String getName() { return name; }
    /**
     * si.um.opj.crisan.logic.facility.BusinessFacility's location getter
     * @return warehouseLocation of si.um.opj.crisan.logic.facility.BusinessFacility
     */
    public Location getLocation(){
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "BusinessFacility{" +
                "name='" + name + '\'' +
                ", location=" + location +
                '}';
    }


}
