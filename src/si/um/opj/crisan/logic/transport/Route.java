package si.um.opj.crisan.logic.transport;

import si.um.opj.crisan.logic.facility.Store;
import si.um.opj.crisan.logic.facility.Warehouse;

public class Route {
    private Store store;
    private Warehouse warehouse;
    public double distance;
    /**
     * Default constructor of si.um.opj.crisan.logic.transport.Route class
     */
    public Route(){

    }
    /**
     * Parametrized constructor of si.um.opj.crisan.logic.FoodItem class
     * @param store store of si.um.opj.crisan.logic.transport.Route
     * @param warehouse warehouse of si.um.opj.crisan.logic.transport.Route
     * @param distance distance of si.um.opj.crisan.logic.transport.Route
     */
    public Route(Store store, Warehouse warehouse, double distance){
        this.store = store;
        this.warehouse = warehouse;
        this.distance = distance;
    }
    /**
     * si.um.opj.crisan.logic.facility.Warehouse's store getter
     * @return store of si.um.opj.crisan.logic.facility.Warehouse
     */
    public Store getStore() {
        return store;
    }
    /**
     * si.um.opj.crisan.logic.facility.Warehouse's warehouse getter
     * @return warehouse of si.um.opj.crisan.logic.facility.Warehouse
     */
    public Warehouse getWarehouse() {
        return warehouse;
    }
    /**
     * si.um.opj.crisan.logic.facility.Warehouse's distance getter
     * @return distance of si.um.opj.crisan.logic.facility.Warehouse
     */
    public double getDistance(){
        if(distance<0) throw new java.lang.IllegalArgumentException("You're not travelling in the past, wrong distance given!");
        return distance;
    }
    /**
     *si.um.opj.crisan.logic.transport.Route's store setter
     * @param store store of si.um.opj.crisan.logic.transport.Route
     */
    public void setStore(Store store) {
        this.store = store;
    }
    /**
     *si.um.opj.crisan.logic.facility.Warehouse's warehouse setter
     * @param warehouse warehouse of si.um.opj.crisan.logic.transport.Route
     */
    public void setWarehouse (Warehouse warehouse){
        this.warehouse = warehouse;
    }
    /**
     *si.um.opj.crisan.logic.transport.Route's distance setter
     * @param distance distance of si.um.opj.crisan.logic.transport.Route
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Route{" +
                "store=" + store +
                ", warehouse=" + warehouse +
                ", distance=" + distance +
                '}';
    }
}
