package si.um.opj.ioana;

import si.um.opj.crisan.logic.FoodItem;
import si.um.opj.crisan.logic.facility.Warehouse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

 class AddWarehouse implements ActionListener {
    private JComboBox<Warehouse> warehouseCombo;
    private ArrayList<Warehouse> warehouseList;

    private JComboBox<FoodItem> foodItemCombo;
    private ArrayList<FoodItem> foodItemList;

    public AddWarehouse(JComboBox<Warehouse> warehouseCombo,ArrayList<Warehouse> warehouseList, JComboBox<FoodItem> foodItemCombo, ArrayList<FoodItem> foodItemList){
        this.warehouseCombo = warehouseCombo;
        this.warehouseList = warehouseList;
        this.foodItemCombo = foodItemCombo;
        this.foodItemList = foodItemList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(foodItemCombo.getSelectedIndex() >=0 && warehouseCombo.getSelectedIndex()>=0) {
            FoodItem foodItem = foodItemList.get(foodItemCombo.getSelectedIndex());
            //Warehouse warehouse = warehouseList.get(warehouseCombo.getSelectedIndex());
            Warehouse warehouse = (Warehouse) warehouseCombo.getSelectedItem();
            warehouse.addItem(foodItem);
        }
    }
}
