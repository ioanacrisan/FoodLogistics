package si.um.opj.crisan.logic.facility;

import si.um.opj.crisan.logic.*;
import si.um.opj.crisan.logic.transport.Truck;
import si.um.opj.crisan.logic.transport.Van;
import si.um.opj.crisan.logic.transport.Vehicle;
import java.util.Arrays;

public class Warehouse extends BusinessFacility implements Transportable {

	private FoodItem[] foodItems;

	/**
	 * Default constructor of si.um.opj.crisan.logic.facility.Warehouse class
	 */
	private Warehouse() {

	}

	/**
	 * Parametrized constructor of si.um.opj.crisan.logic.facility.Warehouse class
	 *
	 * @param name     of si.um.opj.crisan.logic.facility.Warehouse
	 * @param location of si.um.opj.crisan.logic.facility.Warehouse
	 */

	private Warehouse(String name, Location location) {
		super(name, location);
	}

	/**
	 * Parametrized constructor of si.um.opj.crisan.logic.facility.Warehouse class
	 *
	 * @param name     of si.um.opj.crisan.logic.facility.Warehouse
	 * @param location of si.um.opj.crisan.logic.facility.Warehouse
	 * @param capacity of si.um.opj.crisan.logic.facility.Warehouse
	 */
	public Warehouse(String name, Location location, int capacity) {
		super(name, location);
		this.foodItems = new FoodItem[capacity];
	}

	/**
	 * si.um.opj.crisan.logic.facility.Warehouse's foodItems getter
	 *
	 * @return foodItems number of si.um.opj.crisan.logic.facility.Warehouse
	 */
	public FoodItem[] getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(FoodItem[] foodItems) {
		this.foodItems = foodItems;
	}

	/**
	 * si.um.opj.crisan.logic.facility.Warehouse's method adding an item to the
	 * foodItems
	 *
	 * @param foodItem foodItem that will be added to the foodItems
	 */
	public void addItem(FoodItem foodItem) {
		for (int i = 0; i < foodItems.length; i++) {
			if (foodItems[i] == null) {
				foodItems[i] = foodItem; //  foodItems ~ shelves foodItem ~ broccoli
				break;
			}
		}
	}

	/**
	 * si.um.opj.crisan.logic.facility.Warehouse's method removing an item to the
	 * foodItems
	 *
	 * @param foodItem foodItem that will be removed to the foodItems
	 */
	public void removeItem(FoodItem foodItem) {
		for (int i = 0; i < foodItems.length; i++) {
			if (foodItems[i] == foodItem) {
				foodItems[i] = null;
			}
		}
	}

	/**
	 * si.um.opj.crisan.logic.facility.Warehouse's method returning the number of
	 * food items that are in the foodItems
	 *
	 * @return theNumberOfFoodItems that are on the foodItems
	 */
	public int returnTheNumberOfFoodItems() {
		int theNumberOfFoodItems = 0;
		for (int i = 0; i < foodItems.length; i++) {
			if (foodItems[i] != null) {
				theNumberOfFoodItems++;
			}
		}
		return theNumberOfFoodItems;

	}

	/**
	 * si.um.opj.crisan.logic.facility.Warehouse's method analysing the existence of
	 * the foodItem
	 *
	 * @param label label of the foodItems
	 * @return foodItemExists is a function returning if the food item exists
	 */
	public boolean foodItemExists(String label) {
		boolean foodItemExists = false;
		for (int i = 0; i < foodItems.length; i++) {
			if (foodItems[i] != null) {
				if (foodItems[i].getLabel() == label) {
					foodItemExists = true;

				}
			}
		}
		return foodItemExists;
	}

	@Override
	public String toString() {
		return super.toString() + ", foodItems=" + Arrays.toString(foodItems);
	}

	@Override
	public void acceptVehicle(Vehicle vehicle)
			throws CapacityExceededException, VolumeExceededException, FoodItemTypeException {

		if (vehicle instanceof Truck) {

			double fiVolume = 0, fiCapacity = 0;
			for (int i = 0; i < foodItems.length; i++) {
				if (foodItems[i] != null) {
					fiVolume = fiVolume + foodItems[i].getVolume();
					fiCapacity++;
				}
			}

			if (vehicle.getVehiclesMaxVolume() < vehicle.cargoTVolume() + fiVolume) {
				vehicle.unloadFoodItems();
				throw new VolumeExceededException("The volume is exceeded.");
			}
			if (vehicle.cargo.length < vehicle.cargoTCapacity() + fiCapacity) {
				vehicle.unloadFoodItems();
				throw new CapacityExceededException("The capacity is exceeded.");
			}
			vehicle.loadFoodItem(foodItems);

		}

		if (vehicle instanceof Van) {

			for (int i = 0; i < foodItems.length; i++) {

				if (foodItems[i] != null) {

					if (vehicle.getVolume() < vehicle.cargoTVolume() + foodItems[i].getVolume()) {
						throw new VolumeExceededException("The volume is exceeded.");
					}
					if (vehicle.cargo.length < vehicle.cargoTCapacity() + 1) {
						throw new CapacityExceededException("The capacity is exceeded.");
					}
					vehicle.loadFoodItem(foodItems[i]);
				}
			}
		}

	}
}