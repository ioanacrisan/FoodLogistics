package si.um.opj.ioana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import si.um.opj.crisan.logic.FoodItem;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class DeleteFoodItem implements ActionListener{
    private JComboBox<FoodItem> foodItemCombo;
    private ArrayList<FoodItem> foodItemList;

    public DeleteFoodItem(JComboBox foodItemCombo, ArrayList foodItemList)
    {
        this.foodItemCombo = foodItemCombo;
        this.foodItemList = foodItemList;
    }


@Override
    public void actionPerformed(ActionEvent e){
        DefaultComboBoxModel<FoodItem> model = (DefaultComboBoxModel<FoodItem>) foodItemCombo.getModel();

if(foodItemCombo.getSelectedIndex() >=0 ) {
    foodItemList.remove(foodItemCombo.getSelectedIndex());
    model.removeElementAt(foodItemCombo.getSelectedIndex());
}

}/**/
}
