package si.um.opj.ioana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import a.j.J;
import si.um.opj.crisan.logic.facility.Store;
import si.um.opj.crisan.logic.facility.Warehouse;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

class DeleteBusinessFacility implements ActionListener {

    private JComboBox<Warehouse> warehouseCombo;
    private ArrayList<Warehouse> warehouseList;


    private JComboBox<Store> storeCombo;
    private ArrayList<Store> storeList;

    private JRadioButton warehouseEditRadioButton;
    private JRadioButton storeEditRadioButton;

    private ButtonGroup buttonGroupBusinessFacilityEdit;

    public DeleteBusinessFacility(JComboBox<Warehouse> warehouseCombo, ArrayList<Warehouse> warehouseList, JComboBox<Store> storeCombo, ArrayList<Store> storeList, JRadioButton warehouseEditRadioButton, JRadioButton storeEditRadioButton) {
        this.warehouseCombo = warehouseCombo;
        this.warehouseList = warehouseList;
        this.storeCombo = storeCombo;
        this.storeList = storeList;
        this.warehouseEditRadioButton = warehouseEditRadioButton;
        this.storeEditRadioButton = storeEditRadioButton;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        DefaultComboBoxModel<Warehouse> warehouseModel = (DefaultComboBoxModel<Warehouse>) warehouseCombo.getModel();
        DefaultComboBoxModel<Store> storeModel = (DefaultComboBoxModel<Store>) storeCombo.getModel();


        try {
            boolean created = false;

            if (warehouseCombo.getSelectedIndex() >= 0 && warehouseEditRadioButton.isSelected()) {
                warehouseList.remove(warehouseCombo.getSelectedIndex());
                warehouseModel.removeElementAt(warehouseCombo.getSelectedIndex());
                warehouseEditRadioButton.setSelected(false);
                created = true;

            } else if (storeCombo.getSelectedIndex() >= 0 && storeEditRadioButton.isSelected()) {
                storeList.remove(storeCombo.getSelectedIndex());
                storeModel.removeElementAt(storeCombo.getSelectedIndex());
                storeEditRadioButton.setSelected(false);
                created = true;

            }
            if (!created)
                throw new Exception();
            JOptionPane.showMessageDialog(null, "Yass, you deleted the facility!");

        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, "Hmm, looks somebody is hungry and ate some data!");

        }

    }

}