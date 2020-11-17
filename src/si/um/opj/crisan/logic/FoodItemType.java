package si.um.opj.crisan.logic;

public class FoodItemType {


    private FoodItemTypes type;

    /**
     * Default constructor of FoodItemType class
     */
    public FoodItemType(){

    }
    /**
     * Parametrized constructor of FoodItemType class
     * @param type of FoodItemType
     */
    public FoodItemType(FoodItemTypes type){
        this.type = type;
    }


    /**
     * FoodItemType's type getter
     * @return type of FoodItemType
     */
    /*public String getType() {
        return type;
    }*/

    /**
     *FoodItemType's type setter
     * @param type  of FoodItemType
     */
    public void setType(FoodItemTypes type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "FoodItemType{" +
                "type='" + type + '\'' +
                '}';
    }

}
