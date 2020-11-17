/**/
package si.um.opj.ioana;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


import a.j.S;
import com.intellij.ui.JreHiDpiUtil;
import si.um.opj.crisan.logic.transport.Truck;
import si.um.opj.crisan.logic.transport.Van;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

class DeleteVehicle implements ActionListener{

    private JComboBox<Truck> truckCombo;
    private ArrayList<Truck> truckList;


    private JComboBox<Van> vanCombo;
    private ArrayList<Van> vanList;

    private JRadioButton truckEditRadioButton;
    private JRadioButton vanEditRadioButton;

    public DeleteVehicle(JComboBox<Truck> truckCombo, ArrayList<Truck> truckList, JComboBox<Van> vanCombo, ArrayList<Van> vanList, JRadioButton truckEditRadioButton, JRadioButton vanEditRadioButton) {
        this.truckCombo = truckCombo;
        this.truckList = truckList;
        this.vanCombo = vanCombo;
        this.vanList = vanList;
        this.truckEditRadioButton = truckEditRadioButton;
        this.vanEditRadioButton = vanEditRadioButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        DefaultComboBoxModel<Truck> truckModel = (DefaultComboBoxModel<Truck>) truckCombo.getModel();
        DefaultComboBoxModel<Van> vanModel = (DefaultComboBoxModel<Van>) vanCombo.getModel();


        try {
            boolean created = false;
            if (truckCombo.getSelectedIndex() >= 0 && truckEditRadioButton.isSelected()) {
                truckList.remove(truckCombo.getSelectedIndex());
                truckModel.removeElementAt(truckCombo.getSelectedIndex());
                truckEditRadioButton.setSelected(false);
                created = true;


            } else if (vanCombo.getSelectedIndex() >= 0 && vanEditRadioButton.isSelected()) {
                vanList.remove(vanCombo.getSelectedIndex());
                vanModel.removeElementAt(vanCombo.getSelectedIndex());
                vanEditRadioButton.setSelected(false);
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

