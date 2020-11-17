package si.um.opj.crisan.logic.transport;


public class Truck extends Vehicle {
    private int numberOfTrailers;
    /**
     * Default constructor of Truck class
     */
    public Truck(){
        super();//call empty constr

    }
    /**
     * Parametrized constructor of Truck class
     * @param registrationNumber registrationNumber of Truck
     * @param volume volume of Truck
     */
    public Truck(String registrationNumber, double volume){
        super(registrationNumber, volume);
    }
    /**
     * Parametrized constructor of Truck class
     * @param registrationNumber registrationNumber of Truck
     * @param volume volume of Truck
     * @param maxWeight of Truck
     * @param averageSpeed Truck
     * @param length Truck
     */
    public Truck(String registrationNumber, double volume, double maxWeight, double averageSpeed, int length){
        super(registrationNumber,volume, maxWeight,averageSpeed, length);
    }
    /**
     * Parametrized constructor of Truck class
     * @param registrationNumber Truck
     * @param volume volume of Truck
     * @param maxWeight of Truck
     * @param averageSpeed of Truck
     * @param length of Truck
     * @param numberOfTrailers of Truck
     */
    public Truck(String registrationNumber, double volume, double maxWeight, double averageSpeed, int length, int numberOfTrailers){
        super(registrationNumber,volume, maxWeight,averageSpeed, length);
        this.numberOfTrailers= numberOfTrailers;
    }
    /**
     * Truck's numberOfTrailers getter
     * @return numberOfTrailers of Truck
     */
    public int getNumberOfTrailers() {
        return numberOfTrailers;
    }
    /**
     *Truck's number of trailers setter
     * @param numberOfTrailers of Truck
     */
    public void setNumberOfTrailers(int numberOfTrailers){
        this.numberOfTrailers= numberOfTrailers;
    }


    @Override
    public String toString() {
        return  "Truck" + super.toString()+
                ", numberOfTrailers= " + numberOfTrailers +'}';
    }
	@Override
	public double getVehiclesMaxVolume() {
		return super.volume*numberOfTrailers;
	}
}
