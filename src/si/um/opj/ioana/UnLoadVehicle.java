package si.um.opj.ioana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import com.intellij.util.xml.EvaluatedXmlName;
import si.um.opj.crisan.logic.CapacityExceededException;
import si.um.opj.crisan.logic.FoodItem;
import si.um.opj.crisan.logic.FoodItemTypeException;
import si.um.opj.crisan.logic.VolumeExceededException;
import si.um.opj.crisan.logic.facility.BusinessFacility;
import si.um.opj.crisan.logic.facility.Store;
import si.um.opj.crisan.logic.facility.Warehouse;
import si.um.opj.crisan.logic.transport.Truck;
import si.um.opj.crisan.logic.transport.Van;
import si.um.opj.crisan.logic.transport.Vehicle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

class UnLoadVehicle implements ActionListener {

    private JComboBox<Warehouse> warehouseCombo;
    private JComboBox<Store> storeCombo;
    private JComboBox<Truck> truckCombo;
    private JComboBox<Van> vanCombo;


    public UnLoadVehicle(JComboBox<Warehouse> warehouseCombo, JComboBox<Store> storeCombo, JComboBox<Truck> truckCombo, JComboBox<Van> vanCombo) {
        this.warehouseCombo = warehouseCombo;
        this.storeCombo = storeCombo;
        this.truckCombo = truckCombo;
        this.vanCombo = vanCombo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        DefaultComboBoxModel<Warehouse> warehouseModel = (DefaultComboBoxModel<Warehouse>) warehouseCombo.getModel();
        DefaultComboBoxModel<Store> storeModel = (DefaultComboBoxModel<Store>) storeCombo.getModel();

        DefaultComboBoxModel<Truck> truckModel = (DefaultComboBoxModel<Truck>) truckCombo.getModel();
        DefaultComboBoxModel<Van> vanModel = (DefaultComboBoxModel<Van>) vanCombo.getModel();


    try{
        if(warehouseCombo.getSelectedIndex() >= 0){
            Warehouse warehouse = (Warehouse) warehouseCombo.getSelectedItem();

            if(vanCombo.getSelectedIndex() >= 0)
            {
                Van van = vanModel.getElementAt(vanCombo.getSelectedIndex());
                warehouse.acceptVehicle(van);
                System.out.println(van);
                warehouseCombo.setSelectedItem(warehouse);
                warehouseModel.setSelectedItem(warehouse);
                System.out.println(warehouse);

            }
            else if(truckCombo.getSelectedIndex() >= 0)
            {
                Truck truck = truckModel.getElementAt(truckCombo.getSelectedIndex());
                warehouse.acceptVehicle(truck);
                System.out.println(truck);


            }
            JOptionPane.showMessageDialog(null, "Yass, you loaded the food items!");

        }




    } catch(CapacityExceededException e1) {
        e1.printStackTrace();
    } catch (VolumeExceededException e1) {
        e1.printStackTrace();
    } catch (FoodItemTypeException e1) {
        e1.printStackTrace();
    }



    }

}