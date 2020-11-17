import java.time.LocalDate;
import java.util.Arrays;

import si.um.opj.crisan.logic.*;
import si.um.opj.crisan.logic.facility.Store;
import si.um.opj.crisan.logic.facility.Warehouse;
import si.um.opj.crisan.logic.transport.Route;
import si.um.opj.crisan.logic.transport.Truck;
import si.um.opj.crisan.logic.transport.Van;
import si.um.opj.crisan.logic.transport.Vehicle;


public class Launcher {


   public static void main(String args[]) throws CapacityExceededException, VolumeExceededException {
      Location location = new Location("Maribor", "Slovenije");/* creates location(object) Maribor and sets it˙s country Slovenije.
                                                     *uses parameterized constructor in line 8 (class si.um.opj.crisan.logic.Location)*/

       String storeName = "Counts Kustom";
       String sCity = "Las Vegas", sCountry = "USA";
       String message = "Coolest personalised cars!";
       Location storeLocation = new Location(sCity, sCountry);
       Store store = new Store(storeName, storeLocation); // instantiates a new store object

       Location warehouseLocation = new Location("Las Vegas", "USA");
       Warehouse warehouse = new Warehouse("Gold & Silver Pawn Shop", warehouseLocation, 5);// https://youtu.be/6pQ-A6YPTvw


      Truck truck = new Truck("MB WIN 42", 100,1242, 100, 1, 2);
      Van van = new Van("CJ HIP 13", 100, 1242, 100,  1,FoodItemTypes.FRESH);

      FoodItem foodItemX = new FoodItem("X", 1000, 3, LocalDate.of(2030, 06, 16), FoodItemTypes.FRESH);


       System.out.println(warehouse);
       System.out.println(van);

       warehouse.addItem(foodItemX);
       warehouse.addItem(foodItemX);
       /*warehouse.addItem(foodItemX);
       warehouse.addItem(foodItemX);
       warehouse.addItem(foodItemX);
      warehouse.addItem(foodItemX);

      System.out.println(warehouse);
 */
      try {
		warehouse.acceptVehicle(van);
	} catch (CapacityExceededException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (VolumeExceededException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (FoodItemTypeException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
      System.out.println("+++"+van);

      
     /*  truck.loadFoodItem(foodItems);
         van.loadFoodItem(foodItems); */


       Route route = new Route(store, warehouse, 39);



         int travelDays = truck.calculateTravelTime(route);
         System.out.println("The number of travel days is " + travelDays);
         double maxVol = truck.getVehiclesMaxVolume();
         System.out.println("The maximum volume of the truck is " + maxVol);


         /*truck.loadFoodItem(foodItems);
         System.out.println(truck);*/

         double takenSpace = truck.getTakenSpace();
         System.out.println(takenSpace);
       /*
       truck.unloadFoodItems();
       System.out.println(truck);

       truck.loadFoodItem(foodItem);
       System.out.println(truck);
        */

         FoodItem foodItem = new FoodItem("ABC", 10, 3, LocalDate.of(2020, 06, 16), FoodItemTypes.FRESH);
         warehouse.addItem(foodItem);
         int theNumberOfFoodItems = warehouse.returnTheNumberOfFoodItems();
         System.out.println("The number of food items is " + theNumberOfFoodItems);
         boolean foodItemExists = warehouse.foodItemExists(foodItem.getLabel());
         System.out.println("The existence of the item is " + foodItemExists);
         warehouse.removeItem(foodItem);

         //     FoodItemType foodItemType = new FoodItemType(foodItemType);

         System.out.println(warehouse.toString());
         System.out.println(route.toString());
         System.out.println(location.toString());
         System.out.println(truck.toString());
         System.out.println(van.toString());
         System.out.println(foodItem.toString());
         System.out.println(store.toString());
      }


   }
