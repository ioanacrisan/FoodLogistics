package si.um.opj.crisan.logic;

import si.um.opj.crisan.logic.transport.Vehicle;

public interface  Transportable{

    public void acceptVehicle(Vehicle vehicle) throws CapacityExceededException, VolumeExceededException, FoodItemTypeException;

}
