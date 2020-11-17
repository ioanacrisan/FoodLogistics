package si.um.opj.crisan.logic;

import java.time.LocalDate;

public class FoodItem {

    private String label;
    private double volume;
    private double weight;
    private java.time.LocalDate expirationDate;
    private FoodItemTypes foodItemType;

    /**
     * Default constructor of si.um.opj.crisan.logic.FoodItem class
     */
    public FoodItem(){

    }

    /**
     * Parametrized constructor of si.um.opj.crisan.logic.FoodItem class
     * @param label label of si.um.opj.crisan.logic.FoodItem
     */
    public FoodItem(String label){
        this.label = label;
    }

    /**
     * Parametrized constructor of si.um.opj.crisan.logic.FoodItem class
     * @param label label of si.um.opj.crisan.logic.FoodItem
     * @param volume volume of si.um.opj.crisan.logic.FoodItem
     * @param weight weight of si.um.opj.crisan.logic.FoodItem
     * @param expirationDate expiration date of si.um.opj.crisan.logic.FoodItem
     * @param foodItemType the type of si.um.opj.crisan.logic.FoodItem
     */
    public FoodItem(String label, double volume,  double weight, java.time.LocalDate expirationDate, FoodItemTypes foodItemType){

        this(label);
        this.volume = volume;
        this.weight = weight;
        this.expirationDate = expirationDate;
        this.foodItemType = foodItemType;
    }

    /**
     * si.um.opj.crisan.logic.FoodItem's label getter
     * @return label of si.um.opj.crisan.logic.FoodItem
     */
    public String getLabel() {
        return label;
    }

    /**
     *si.um.opj.crisan.logic.FoodItem's label setter
     * @param label label of si.um.opj.crisan.logic.FoodItem
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     *si.um.opj.crisan.logic.FoodItem's volume getter
     * @return volume of si.um.opj.crisan.logic.FoodItem
     */
    public double getVolume() {
        return volume;
    }

    /**
     *si.um.opj.crisan.logic.FoodItem's volume setter
     * @param volume volume of a si.um.opj.crisan.logic.FoodItem
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }

    /**
     *si.um.opj.crisan.logic.FoodItem's weight getter
     * @return weight of a si.um.opj.crisan.logic.FoodItem
     */
    public double getWeight() {
        return weight;
    }

    /**
     *si.um.opj.crisan.logic.FoodItem's weight setter
     * @param weight weight of a si.um.opj.crisan.logic.FoodItem
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     *si.um.opj.crisan.logic.FoodItem's expiration date getter
     * @return expiration date of a si.um.opj.crisan.logic.FoodItem
     */
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    /**
     *si.um.opj.crisan.logic.FoodItem's expiration date setter
     * @param expirationDate expirationDate of a si.um.opj.crisan.logic.FoodItem
     */
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     *si.um.opj.crisan.logic.FoodItem's type getter
     * @return foodItemType of a si.um.opj.crisan.logic.FoodItem
     */
    public FoodItemTypes getFoodItemType() {
        return foodItemType;
    }

    /**
     *si.um.opj.crisan.logic.FoodItem's type setter
     * @param foodItemType foodItemType of a si.um.opj.crisan.logic.FoodItem
     */
    public void setFoodItemType(FoodItemTypes foodItemType) {
        this.foodItemType = foodItemType;
    }



    @Override
    public String toString() {
        return "FoodItem{" +
                "label='" + label + '\'' +
                ", volume=" + volume +
                ", weight=" + weight +
                ", expirationDate=" + expirationDate +
                '}';
    }



}
