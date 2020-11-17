package si.um.opj.crisan.logic.transport;

import java.time.LocalDate;
import java.util.Arrays;

import si.um.opj.crisan.logic.CapacityExceededException;
import si.um.opj.crisan.logic.FoodItem;
import si.um.opj.crisan.logic.FoodItemTypes;
import si.um.opj.crisan.logic.VolumeExceededException;


public abstract class Vehicle {
    private String registrationNumber;
    protected double volume;
    private double maxWeight;
    private double averageSpeed;
    public FoodItem[] cargo;

    /**
     * Default constructor of Vehicle class
     */
    public Vehicle() {

    }

    /**
     * Parametrized constructor of Vehicle class
     *
     * @param registrationNumber registrationNumber of Vehicle
     * @param averageSpeed       averageSpeed of Vehicle
     */
    public Vehicle(String registrationNumber, double averageSpeed) {
        this.registrationNumber = registrationNumber;
        this.averageSpeed = averageSpeed;

    }

    /**
     * Parametrized constructor of Vehicle class
     *
     * @param registrationNumber Vehicle
     * @param volume             volume of Vehicle
     * @param maxWeight          maxWeight of Vehicle
     * @param averageSpeed       averageSpeed of Vehicle
     * @param length             length of Vehicle
     */
    public Vehicle(String registrationNumber, double volume, double maxWeight, double averageSpeed, int length) {
        this(registrationNumber, averageSpeed);
        this.volume = volume;
        this.maxWeight = maxWeight;
        this.cargo = new FoodItem[length];
    }


    /**
     * Vehicle's registration number getter
     *
     * @return registration number of Vehicle
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Vehicle's volume getter
     *
     * @return volume of Vehicle
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Vehicle's maximum weight getter
     *
     * @return maxWeight Vehicle
     */
    public double getMaxWeight() {
        return maxWeight;
    }

    /**
     * Vehicle's registration number getter
     *
     * @return averageSpeed Vehicle
     */
    public double getAverageSpeed() {
        return averageSpeed;
    }

    /**
     * Vehicle's cargo getter
     *
     * @return cargo Vehicle
     */
    public FoodItem[] getCargo() {
        return cargo;
    }

    /**
     * Vehicle's registration number setter
     *
     * @param registrationNumber registrationNumber of Vehicle
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
     * Vehicle's volume setter
     *
     * @param volume volume of Vehicle
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }

    /**
     * Vehicle's maximum weight setter
     *
     * @param maxWeight maxWeight of Vehicle
     */
    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    /**
     * Vehicle's average speed setter
     *
     * @param averageSpeed averageSpeed of Vehicle
     */
    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }


    /**
     * Vehicle's cargo setter
     *
     * @param cargo cargo of Vehicle
     */
    public void setCargo(FoodItem[] cargo) {
        this.cargo = cargo;
    }

    /**
     * Vehicle's method counting number of days needed to travel through given route
     *
     * @param route route that vehicle will need to drive through given route
     * @return number of days needed to travel through given route
     */

    public int calculateTravelTime(Route route) {

        double travelDays;

        travelDays = (route.getDistance() / this.averageSpeed) / 24;

        return (int) Math.ceil(travelDays);


    }

    /*
     */
    public void loadFoodItem(FoodItem foodItem) {
        if (this instanceof Van)

            for (int i = 0; i < cargo.length; i++) {
                if (cargo[i] == null) {
                    cargo[i] = foodItem;


                }
            }
    }


    public void loadFoodItem(FoodItem[] foodItems) {
        int i;
        int fiCap = foodItems.length;


        //cargo = foodItems;


        for (i = 0; i < cargo.length & fiCap != 0; i++) {
            cargo[i] = foodItems[i];
            fiCap--;
        }

    }


    public void unloadFoodItems() {
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] != null) {
                cargo[i] = null;

            }
        }

    }

    public double getTakenSpace() {
        double takenSpace = 0;

        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] != null) {

                takenSpace = takenSpace + cargo[i].getVolume();
            }
        }
        takenSpace = takenSpace * 100 / (getVehiclesMaxVolume());

        return takenSpace;

    }

    public int cargoTCapacity() {
        int vCapacity = 0;
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] != null) {
                vCapacity++;
            }

        }
        return vCapacity;
    }

    public double cargoTVolume() {
        double vVolume = 0;
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] != null) {
                vVolume = vVolume + cargo[i].getVolume();
            }

        }
        return vVolume;
    }

    public abstract double getVehiclesMaxVolume();


    @Override
    public String toString() {
        return "{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", volume=" + volume +
                ", maxWeight=" + maxWeight +
                ", averageSpeed=" + averageSpeed +
                ", foodItems=" + Arrays.toString(cargo);
    }
}

