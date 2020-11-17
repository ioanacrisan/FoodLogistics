package si.um.opj.ioana;

import si.um.opj.crisan.logic.FoodItem;
import si.um.opj.crisan.logic.FoodItemTypes;
import si.um.opj.crisan.logic.Location;
import si.um.opj.crisan.logic.facility.BusinessFacility;
import si.um.opj.crisan.logic.facility.Store;
import si.um.opj.crisan.logic.facility.Warehouse;
import si.um.opj.crisan.logic.transport.Truck;
import si.um.opj.crisan.logic.transport.Van;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class LogisticsGUI extends JFrame {

    private JPanel logistics;

    // menu of software
    private JPanel menu;
    private JButton buttonVehicle;
    private JButton buttonFoodItems;
    private JButton buttonAdding;
    private JButton buttonLoading;
    private JButton buttonBusiness;


    private JPanel cardLay;
    private JPanel hello;

    //vehicle
    private JPanel vehiclesManagement;
    private JRadioButton truckRadioButton;
    private JRadioButton vanRadioButton;
    private JTextField registrationNumber;
    private JTextField volumeVehicle;
    private JTextField maxWeight;
    private JTextField averageSpeed;
    private JButton createVehicleButton;
    private JButton editVehicleButton;
    private JButton deleteVehicleButton;
    private JTextField numberOfTrailers;
    private JTextField cargoLength;
    private JLabel trailersLabel;



    //business facility
    private JPanel businessFacilitiesManagement;
    private JTextField facilityCountry;
    private JButton createFacilityButton;
    private JButton deleteFacilityButton;
    private JButton editFacilityButton;
    private JTextField facilityName;
    private JRadioButton warehouseRadioButton;
    private JRadioButton storeRadioButton;

    private JTextField facilityCity;
    private JTextField capacityField;
    private JLabel warehouseCapLabel;
    private JRadioButton warehouseEditRadioButton;
    private JRadioButton storeEditRadioButton;

    //food item
    private JPanel foodItemsManagement;
    private JTextField labelFoodItem;
    private JTextField volumeFoodItem;
    private JTextField weightFoodItem;
    private JRadioButton freshFoodItemButton;
    private JRadioButton frozenFoodItemButton;
    private JRadioButton freshEditFoodItem;
    private JRadioButton frozenEditFoodItem;
    private JButton createFoodItemButton;
    private JButton editFoodItemButton;
    private JButton deleteFoodItemButton;
    private JPanel loading;
    private JPanel adding;
    private JTextField facilityLocation;
    private ButtonGroup buttonGroupBusinessFacility;
    private ButtonGroup buttonGroupBusinessFacilityEdit;
    private ButtonGroup buttonGroupFoodItem;
    private ButtonGroup buttonGroupFoodVehicle;
    private ButtonGroup buttonGroupVehicleEdit;
    private ButtonGroup buttonGroupVehicle;
    private JRadioButton freshRadioButton;
    private JRadioButton frozenRadioButton;
    private JLabel typeLabel;
    private JTextField expirationDate;
    private JRadioButton truckEditRadioButton;
    private JRadioButton vanEditRadioButton;





    //business facility - warehouse
    private DefaultComboBoxModel<Warehouse> storeModel = new DefaultComboBoxModel();
    private ArrayList<Warehouse> warehouseArrayList = new ArrayList();
    private JComboBox warehouseCombo;


    // - store
    private DefaultComboBoxModel<Store> warehouseModel = new DefaultComboBoxModel();
    private ArrayList<Store> storeArrayList = new ArrayList();
    private JComboBox storeCombo;


    // food item
    private DefaultComboBoxModel<FoodItem> foodItemModel = new DefaultComboBoxModel();
    private ArrayList<FoodItem> foodItemArrayList = new ArrayList();
    private JComboBox foodItemCombo;

    // vehicle - truck
    private DefaultComboBoxModel<Truck> truckModel = new DefaultComboBoxModel();
    private ArrayList<Truck> truckArrayList = new ArrayList();
    private JComboBox truckCombo;


    // van
    private DefaultComboBoxModel<Van> vanModel = new DefaultComboBoxModel();
    private ArrayList<Van> vanArrayList = new ArrayList();
    private JComboBox vanCombo;
    private JButton addFoodButton;
    private JComboBox warehouseAddCombo;
    private JComboBox foodAddCombo;
    private JComboBox warehouseUnLoadCombo;
    private JComboBox vanUnLoadCombo;
    private JComboBox truckUnLoadCombo;
    private JComboBox storeUnLoadCombo;
    private JButton loadFoodButton;
    private JButton unloadFoodButton;


    public void populateArrayList() {

        ArrayList<BusinessFacility> facility;
    }


    public LogisticsGUI(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(logistics);
        this.pack();


        warehouseCombo.removeAllItems();
        warehouseCombo.setModel(warehouseModel);

        storeCombo.removeAllItems(); //facility combo box
        storeCombo.setModel(storeModel);

        truckCombo.removeAllItems();
        truckCombo.setModel(truckModel);

        vanCombo.removeAllItems();
        vanCombo.setModel(vanModel);

        foodItemCombo.removeAllItems();
        foodItemCombo.setModel(foodItemModel);

        warehouseAddCombo.removeAllItems(); //warehouse adding  warehouse combo box
        warehouseAddCombo.setModel(warehouseModel);

        foodAddCombo.removeAllItems();
        foodAddCombo.setModel(foodItemModel);

        warehouseUnLoadCombo.removeAllItems(); //warehouse unload  combo box
        warehouseUnLoadCombo.setModel(warehouseModel);

        storeUnLoadCombo.removeAllItems();
        storeUnLoadCombo.setModel(storeModel);

        truckUnLoadCombo.removeAllItems();
        truckUnLoadCombo.setModel(truckModel);

        vanUnLoadCombo.removeAllItems();
        vanUnLoadCombo.setModel(vanModel);


        buttonGroupBusinessFacility = new ButtonGroup(); //radio buttons for creating
        buttonGroupBusinessFacility.add(storeRadioButton);
        buttonGroupBusinessFacility.add(warehouseRadioButton);

        buttonGroupBusinessFacilityEdit = new ButtonGroup(); //radio buttons for editing
        buttonGroupBusinessFacilityEdit.add(storeEditRadioButton);
        buttonGroupBusinessFacilityEdit.add(warehouseEditRadioButton);


        buttonGroupFoodItem = new ButtonGroup(); //radio buttons for Food Item attribute
        buttonGroupFoodItem.add(frozenFoodItemButton);
        buttonGroupFoodItem.add(freshFoodItemButton);


        buttonGroupVehicle = new ButtonGroup();
        buttonGroupVehicle.add(truckRadioButton);
        buttonGroupVehicle.add(vanRadioButton);

        buttonGroupFoodVehicle = new ButtonGroup(); //radio buttons for Vehicle attribute
        buttonGroupFoodVehicle.add(frozenRadioButton);
        buttonGroupFoodVehicle.add(freshRadioButton);

        buttonGroupVehicleEdit = new ButtonGroup(); //radio buttons for Vehicle editing
        buttonGroupVehicleEdit.add(truckEditRadioButton);
        buttonGroupVehicleEdit.add(vanEditRadioButton);


        //these fields will be shown only when needed
        warehouseCapLabel.setVisible(false);
        capacityField.setVisible(false);

        trailersLabel.setVisible(false);
        numberOfTrailers.setVisible(false);


        typeLabel.setVisible(false);
        freshRadioButton.setVisible(false);
        frozenRadioButton.setVisible(false);


       // registrationNumber.


        //navigates through the menu - user gets to business facility panel
        buttonBusiness.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                hello.setVisible(false);
                businessFacilitiesManagement.setVisible(true);
                vehiclesManagement.setVisible(false);
                foodItemsManagement.setVisible(false);
                adding.setVisible(false);
                loading.setVisible(false);

            }
        });

        buttonVehicle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                hello.setVisible(false);
                businessFacilitiesManagement.setVisible(false);
                vehiclesManagement.setVisible(true);
                foodItemsManagement.setVisible(false);
                adding.setVisible(false);
                loading.setVisible(false);

            }
        });

        buttonFoodItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                hello.setVisible(false);
                businessFacilitiesManagement.setVisible(false);
                vehiclesManagement.setVisible(false);
                foodItemsManagement.setVisible(true);
                adding.setVisible(false);
                loading.setVisible(false);

            }
        });
        buttonAdding.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                hello.setVisible(false);
                businessFacilitiesManagement.setVisible(false);
                vehiclesManagement.setVisible(false);
                foodItemsManagement.setVisible(false);
                adding.setVisible(true);
                loading.setVisible(false);

            }
        });
        buttonLoading.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                hello.setVisible(false);
                businessFacilitiesManagement.setVisible(false);
                vehiclesManagement.setVisible(false);
                foodItemsManagement.setVisible(false);
                adding.setVisible(false);
                loading.setVisible(true);

            }
        });


        warehouseRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (warehouseRadioButton.isSelected()) {
                    warehouseCapLabel.setVisible(true);
                    capacityField.setVisible(true);
                }

            }
        });


        storeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (storeRadioButton.isSelected()) {
                    warehouseCapLabel.setVisible(false);
                    capacityField.setVisible(false);
                }

            }
        });

        truckRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    if (truckRadioButton.isSelected()) {
                        trailersLabel.setVisible(true);
                        numberOfTrailers.setVisible(true);
                        typeLabel.setVisible(false);
                        freshRadioButton.setVisible(false);
                        frozenRadioButton.setVisible(false);
                    }
            }
        });

        vanRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (vanRadioButton.isSelected()) {
                    trailersLabel.setVisible(false);
                    numberOfTrailers.setVisible(false);
                    typeLabel.setVisible(true);
                    freshRadioButton.setVisible(true);
                    frozenRadioButton.setVisible(true);
                }
            }
        });



        //creates business facility when all data is introduced and button is pressed
        createFacilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {

                    boolean created = false;

                    if (storeRadioButton.isSelected()) {
                        if (facilityName.getText().length() > 0 && facilityCountry.getText().length() > 0 && facilityCity.getText().length() > 0) {
                            String name = facilityName.getText();
                            String country = facilityCountry.getText();
                            String city = facilityCity.getText();



                            Location location = new Location(country, city);
                            Store store = new Store(name, location);

                            //Creates Store

                            storeCombo.addItem(store);
                            storeArrayList.add(store);
                            storeCombo.setSelectedItem(store);
                            facilityName.setText("");
                            facilityCountry.setText("");
                            facilityCity.setText("");
                            buttonGroupBusinessFacility.clearSelection();
                            created = true;


                        }
                    } else if (warehouseRadioButton.isSelected()) {

                        if (capacityField.getText().length() > 0 && facilityName.getText().length() > 0 && facilityCountry.getText().length() > 0 && facilityCity.getText().length() > 0) {

                            String name = facilityName.getText();
                            String country = facilityCountry.getText();
                            String city = facilityCity.getText();
                            String capacity = capacityField.getText();


                            Location location = new Location(country, city);
                            Warehouse warehouse = new Warehouse(name, location, Integer.parseInt(capacity));

                            //Creates Warehouse

                            warehouseCombo.addItem(warehouse);
                            warehouseArrayList.add(warehouse);
                            warehouseArrayList.add(warehouse);
                            warehouseCombo.setSelectedItem(warehouse);
                            capacityField.setText("");
                            facilityName.setText("");
                            facilityCountry.setText("");
                            facilityCity.setText("");
                            buttonGroupBusinessFacility.clearSelection();
                            created = true;
                        }


                    }

                    if (!created)
                        throw new Exception();
                    JOptionPane.showMessageDialog(null, "Yass, you created the facility!");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Hmm, looks somebody is hungry and ate some data!");

                }
            }


        });



        //creates food item
        createFoodItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {
                    boolean created = false;
                    if (labelFoodItem.getText().length() > 0 && volumeFoodItem.getText().length() > 0 && weightFoodItem.getText().length() > 0 && expirationDate.getText().length() > 0) {


                        if (frozenFoodItemButton.isSelected()) {
                            String label = labelFoodItem.getText();
                            String volume = volumeFoodItem.getText();
                            String weight = weightFoodItem.getText();
                            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            LocalDate expiration = LocalDate.parse(expirationDate.getText(), format);
                            FoodItemTypes foodItemT  = FoodItemTypes.FROZEN;

                            FoodItem foodItem = new FoodItem(label, Double.parseDouble(volume), Double.parseDouble(weight), expiration , foodItemT);
                            // Creating FoodItem

                            foodItemCombo.addItem(foodItem);
                            foodItemArrayList.add(foodItem);
                            foodItemCombo.setSelectedItem(foodItem);

                            labelFoodItem.setText("");
                            volumeFoodItem.setText("");
                            weightFoodItem.setText("");
                            buttonGroupFoodItem.clearSelection();
                            created = true;
                            System.out.println("Hello");

                        } else if(freshRadioButton.isSelected()){
                            String label = labelFoodItem.getText();
                            String volume = volumeFoodItem.getText();
                            String weight = weightFoodItem.getText();
                            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            LocalDate expiration = LocalDate.parse(expirationDate.getText(), format);
                            FoodItemTypes foodItemT = FoodItemTypes.FRESH;

                            FoodItem foodItem = new FoodItem(label, Double.parseDouble(volume), Double.parseDouble(weight), expiration , foodItemT);

                            // Creating FoodItem

                            foodItemCombo.addItem(foodItem);
                            foodItemArrayList.add(foodItem);
                            foodItemCombo.setSelectedItem(foodItem);

                            labelFoodItem.setText("");
                            volumeFoodItem.setText("");
                            weightFoodItem.setText("");
                            buttonGroupFoodItem.clearSelection();
                            created = true;
                        }

                    }


                    if (!created)
                        throw new Exception();
                    JOptionPane.showMessageDialog(null, "Yass, you created the food item!");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Hmm, looks somebody is hungry and ate some data!");

                }
            }
        });

        createVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {

                    boolean created = false;

                    if (truckRadioButton.isSelected()) {
                        if (registrationNumber.getText().length() > 0 && volumeVehicle.getText().length() > 0 && maxWeight.getText().length() > 0 && averageSpeed.getText().length() > 0 && cargoLength.getText().length() > 0 && numberOfTrailers.getText().length()  > 0) {
                            String registration = registrationNumber.getText();
                            String volume = volumeVehicle.getText();
                            String weight = maxWeight.getText();
                            String speed = averageSpeed.getText();
                            String length = cargoLength.getText();
                            String trailers = numberOfTrailers.getText();


                            Truck truck = new Truck(registration, Double.parseDouble(volume), Double.parseDouble(weight), Double.parseDouble(speed), Integer.parseInt(length), Integer.parseInt(trailers));

                            //Creates truck

                            truckCombo.addItem(truck);
                            truckCombo.setSelectedItem(truck);
                            truckArrayList.add(truck);
                            registrationNumber.setText("");
                            volumeVehicle.setText("");
                            maxWeight.setText("");
                            averageSpeed.setText("");
                            cargoLength.setText("");
                            numberOfTrailers.setText("");
                            buttonGroupVehicle.clearSelection();
                            created = true;


                        }
                    } else if (vanRadioButton.isSelected()) {

                        if (registrationNumber.getText().length() > 0 && volumeVehicle.getText().length() > 0 && maxWeight.getText().length() > 0 && averageSpeed.getText().length() > 0 && cargoLength.getText().length() > 0 && (freshRadioButton.isSelected()||frozenRadioButton.isSelected())) {
                            String registration = registrationNumber.getText();
                            String volume = volumeVehicle.getText();
                            String weight = maxWeight.getText();
                            String speed = averageSpeed.getText();
                            String length = cargoLength.getText();
                            FoodItemTypes foodItemTypeV;

                            if (frozenFoodItemButton.isSelected()) {
                                foodItemTypeV = FoodItemTypes.FROZEN;

                            } else {
                                foodItemTypeV = FoodItemTypes.FRESH;
                            }


                            Van van = new Van(registration, Double.parseDouble(volume), Double.parseDouble(weight), Double.parseDouble(speed), Integer.parseInt(length), foodItemTypeV);


                            //Creates Van

                            vanCombo.addItem(van);
                            vanCombo.setSelectedItem(van);/**/
                            vanArrayList.add(van);
                            registrationNumber.setText("");
                            volumeVehicle.setText("");
                            maxWeight.setText("");
                            averageSpeed.setText("");
                            cargoLength.setText("");
                            buttonGroupVehicle.clearSelection();
                            buttonGroupFoodVehicle.clearSelection();
                            created = true;
                        }


                    }

                    if (!created)
                        throw new Exception();
                    JOptionPane.showMessageDialog(null, "Yass, you stored the facility!");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Hmm, looks somebody is hungry and ate some data!");

                }

            }

        });


        //Edits - Business Facility
        editFacilityButton.addActionListener(new EditBusinessFacility()); //inner class
        //Deletes - Business Facility
        deleteFacilityButton.addActionListener(
                new DeleteBusinessFacility(warehouseCombo, warehouseArrayList, storeCombo, storeArrayList, warehouseEditRadioButton, storeEditRadioButton));



        //Food Item
        editFoodItemButton.addActionListener(new

                EditFoodItem());

        deleteFoodItemButton.addActionListener((ActionListener) new

                DeleteFoodItem(foodItemCombo, foodItemArrayList));


        //Vehicle
        editVehicleButton.addActionListener(new

                EditVehicle());


        deleteVehicleButton.addActionListener((ActionListener) new

                    DeleteVehicle(truckCombo, truckArrayList, vanCombo, vanArrayList, truckEditRadioButton, vanEditRadioButton));



        //Add food in warehouse
        addFoodButton.addActionListener((ActionListener)
          new AddWarehouse(warehouseAddCombo, warehouseArrayList, foodAddCombo, foodItemArrayList));

        //Un-load food
        loadFoodButton.addActionListener(( ActionListener)
            new UnLoadVehicle( warehouseCombo, storeCombo,  truckCombo,  vanCombo));

        unloadFoodButton.addActionListener(( ActionListener)
                new ULoadVehicle( storeCombo,  truckCombo,  vanCombo));
    }


    public static void main(String[] args) {
        JFrame frame = new LogisticsGUI("Maribor Logistics");
        frame.setVisible(true);
    }



    class EditBusinessFacility implements ActionListener {

        // inner class
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                    boolean created = false;

                    if (storeEditRadioButton.isSelected()) {

                        if (facilityName.getText().length() > 0 && facilityCountry.getText().length() > 0 && facilityCity.getText().length() > 0) {
                            int index = storeCombo.getSelectedIndex();
                            Store selectedStore = storeArrayList.get(index);

                            String name = facilityName.getText();
                            String country = facilityCountry.getText();
                            String city = facilityCity.getText();


                            Location location = new Location(country, city);


                            selectedStore.setName(name);
                            selectedStore.setLocation(location);

                            storeCombo.setSelectedItem(selectedStore);
                            storeArrayList.set(index, selectedStore);
                            facilityName.setText("");
                            facilityCountry.setText("");
                            facilityCity.setText("");
                            buttonGroupBusinessFacilityEdit.clearSelection();
                            buttonGroupBusinessFacility.clearSelection();
                            created = true;



                        }
                    } else if (warehouseEditRadioButton.isSelected()) {

                        if (capacityField.getText().length() > 0 && facilityName.getText().length() > 0 && facilityCountry.getText().length() > 0 && facilityCity.getText().length() > 0) {
                            int index = warehouseCombo.getSelectedIndex();
                            Warehouse selectedWarehouse = warehouseArrayList.get(index);


                            String name = facilityName.getText();
                            String country = facilityCountry.getText();
                            String city = facilityCity.getText();
                            String capacity = capacityField.getText();


                            Location location = new Location(country, city);

                            selectedWarehouse.setName(name);
                            selectedWarehouse.setLocation(location);
                            selectedWarehouse.setFoodItems(new FoodItem[Integer.parseInt(capacity)]); //sets a new amount of food items

                            warehouseCombo.setSelectedItem(selectedWarehouse);
                            warehouseArrayList.set(index, selectedWarehouse);
                            capacityField.setText("");
                            facilityName.setText("");
                            facilityCountry.setText("");
                            facilityCity.setText("");
                            buttonGroupBusinessFacilityEdit.clearSelection();
                            buttonGroupBusinessFacility.clearSelection();


                            created = true;
                        }


                    }

                    if (!created)
                        throw new Exception();
                JOptionPane.showMessageDialog(null, "Yass, the dates are up and delicious!");

                } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Hmm, some dates are dropped!");

                }


        }
    }


    class EditFoodItem implements ActionListener {


            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    boolean created = false;
                    if (labelFoodItem.getText().length() > 0 && volumeFoodItem.getText().length() > 0 && weightFoodItem.getText().length() > 0 && (freshFoodItemButton.isSelected() || frozenFoodItemButton.isSelected())) {


                        if (frozenFoodItemButton.isSelected()) {
                            int index = foodItemCombo.getSelectedIndex();
                            FoodItem selectedFoodItem = foodItemArrayList.get(index);

                            String label = labelFoodItem.getText();
                            String volume = volumeFoodItem.getText();
                            String weight = weightFoodItem.getText();
                            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            LocalDate expiration = LocalDate.parse(expirationDate.getText(), format);
                            FoodItemTypes foodItemT  = FoodItemTypes.FROZEN;

                            FoodItem foodItem = new FoodItem(label, Double.parseDouble(volume), Double.parseDouble(weight), expiration , foodItemT);

                            selectedFoodItem.setLabel(label);
                            selectedFoodItem.setVolume(Double.parseDouble(volume));
                            selectedFoodItem.setWeight(Double.parseDouble(weight));
                            selectedFoodItem.setExpirationDate(expiration);

                            foodItemCombo.setSelectedItem(selectedFoodItem);
                            foodItemArrayList.set(index, selectedFoodItem);
                            foodItemCombo.setSelectedItem(foodItem);
                            labelFoodItem.setText("");
                            volumeFoodItem.setText("");
                            weightFoodItem.setText("");
                            buttonGroupFoodItem.clearSelection();
                            created = true;

                        } else {
                            int index = foodItemCombo.getSelectedIndex();
                            FoodItem selectedFoodItem = foodItemArrayList.get(index);

                            String label = labelFoodItem.getText();
                            String volume = volumeFoodItem.getText();
                            String weight = weightFoodItem.getText();
                            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            LocalDate expiration = LocalDate.parse(expirationDate.getText(), format);
                            FoodItemTypes foodItemT  = FoodItemTypes.FROZEN;

                            FoodItem foodItem = new FoodItem(label, Double.parseDouble(volume), Double.parseDouble(weight), expiration , foodItemT);

                            selectedFoodItem.setLabel(label);
                            selectedFoodItem.setVolume(Double.parseDouble(volume));
                            selectedFoodItem.setWeight(Double.parseDouble(weight));
                            selectedFoodItem.setExpirationDate(expiration);

                            foodItemCombo.setSelectedItem(selectedFoodItem);
                            foodItemArrayList.set(index, selectedFoodItem);
                            foodItemCombo.setSelectedItem(foodItem);
                            labelFoodItem.setText("");
                            volumeFoodItem.setText("");
                            weightFoodItem.setText("");
                            buttonGroupFoodItem.clearSelection();
                            created = true;
                        }

                    }


                    if (!created)
                        throw new Exception();
                    JOptionPane.showMessageDialog(null, "Yass, you stored the food item!");

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Hmm, looks somebody is hungry and ate some data!");

                }
            }
        }

    class EditVehicle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                boolean created = false;

                if (truckEditRadioButton.isSelected()) {
                    if (registrationNumber.getText().length() > 0 && volumeVehicle.getText().length() > 0 && maxWeight.getText().length() > 0 && averageSpeed.getText().length() > 0 && cargoLength.getText().length() > 0 && numberOfTrailers.getText().length()  > 0) {
                        int index = truckCombo.getSelectedIndex();
                         Truck selectedTruck = truckArrayList.get(index);

                        String registration = registrationNumber.getText();
                        String volume = volumeVehicle.getText();
                        String weight = maxWeight.getText();
                        String speed = averageSpeed.getText();
                        String length = cargoLength.getText();
                        String trailers = numberOfTrailers.getText();

                        selectedTruck.setRegistrationNumber(registration);
                        selectedTruck.setVolume(Double.parseDouble(volume));
                        selectedTruck.setMaxWeight(Double.parseDouble(weight));
                        selectedTruck.setAverageSpeed(Double.parseDouble(speed));
                        selectedTruck.setCargo(new FoodItem[Integer.parseInt(length)]);
                        selectedTruck.setNumberOfTrailers(Integer.parseInt(trailers));


                        truckCombo.setSelectedItem(selectedTruck);
                        truckArrayList.set(index, selectedTruck);
                        truckCombo.setSelectedItem(selectedTruck);
                        registrationNumber.setText("");
                        volumeVehicle.setText("");
                        maxWeight.setText("");
                        averageSpeed.setText("");
                        cargoLength.setText("");
                        numberOfTrailers.setText("");
                        buttonGroupVehicle.clearSelection();
                        buttonGroupVehicleEdit.clearSelection();
                        created = true;


                    }
                } else if (vanEditRadioButton.isSelected()) {

                    if (registrationNumber.getText().length() > 0 && volumeVehicle.getText().length() > 0 && maxWeight.getText().length() > 0 && averageSpeed.getText().length() > 0 && cargoLength.getText().length() > 0 && (freshRadioButton.isSelected()||frozenRadioButton.isSelected())) {
                        int index = vanCombo.getSelectedIndex();
                        Van selectedVan = vanArrayList.get(index);

                        String registration = registrationNumber.getText();
                        String volume = volumeVehicle.getText();
                        String weight = maxWeight.getText();
                        String speed = averageSpeed.getText();
                        String length = cargoLength.getText();
                        FoodItemTypes foodItemTypeV;

                        if (frozenFoodItemButton.isSelected()) {
                            foodItemTypeV = FoodItemTypes.FROZEN;

                        } else {
                            foodItemTypeV = FoodItemTypes.FRESH;
                        }


                        selectedVan.setRegistrationNumber(registration);
                        selectedVan.setVolume(Double.parseDouble(volume));
                        selectedVan.setMaxWeight(Double.parseDouble(weight));
                        selectedVan.setAverageSpeed(Double.parseDouble(speed));
                        selectedVan.setCargo(new FoodItem[Integer.parseInt(length)]);
                        selectedVan.setFoodItemType(foodItemTypeV);

                        vanCombo.setSelectedItem(selectedVan);
                        vanArrayList.set(index, selectedVan);
                        vanCombo.setSelectedItem(selectedVan);
                        registrationNumber.setText("");
                        volumeVehicle.setText("");
                        maxWeight.setText("");
                        averageSpeed.setText("");
                        cargoLength.setText("");
                        buttonGroupVehicle.clearSelection();
                        buttonGroupVehicleEdit.clearSelection();

                        created = true;
                    }


                }

                if (!created)
                    throw new Exception();
                JOptionPane.showMessageDialog(null, "Yass, you edited the vehicle!");

            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Hmm, looks somebody is hungry and ate some data!");

            }
        }



    }
    }




