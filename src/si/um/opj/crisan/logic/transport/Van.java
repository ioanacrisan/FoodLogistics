package si.um.opj.crisan.logic.transport;
import si.um.opj.crisan.logic.FoodItemTypes;


public  class Van extends Vehicle {

    private FoodItemTypes foodItemType;

    /**
     * Default constructor of Van class
     */
    public Van(){
    }
    /**
     * Parametrized constructor of Van class
     * @param registrationNumber registrationNumber of Van
     * @param volume volume of Van
     */
    public Van(String registrationNumber, double volume){
        super(registrationNumber, volume);
    }
    /**
     * Parametrized constructor of Van class
     * @param registrationNumber registrationNumber of Van
     * @param volume volume of Van
     * @param maxWeight of Van
     * @param averageSpeed of Van
     * @param foodItemType of Van
     */
    public Van(String registrationNumber, double volume, double maxWeight, double averageSpeed,  int length, FoodItemTypes foodItemType){
        super(registrationNumber,volume, maxWeight,averageSpeed, length);
        this.setFoodItemType(foodItemType) ;
    }

    @Override
    public String toString() {
        return "Van"+
                super.toString();
    }
	@Override
	public double getVehiclesMaxVolume() {
		return super.volume;
	}
	public FoodItemTypes getFoodItemType() {
		return foodItemType;
	}
	public void setFoodItemType(FoodItemTypes foodItemType) {
		this.foodItemType = foodItemType;
	}
}
