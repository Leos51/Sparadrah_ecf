package fr.sparadrah.ecf.view.swingview;

import javax.swing.*;

public class PurchasePanel extends JPanel {
    private JLabel purchaseTitle;
    private JPanel purchasePanel;
    private JPanel titlePanel;
    private JPanel bottomPanel;
    private JButton annulerButton;
    private JButton validerLAchatButton;
    private JPanel cartPanel;
    private JPanel centerPanel;
    private JTable table1;
    private JLabel selectCustomerLabel;
    private JTable table2;
    private JButton cancelSelectedClient;
    private JButton selectCustomerrButton;
    private JPanel filterPanel;
    private JLabel selectMedicinelabel;
    private JComboBox selectCategoryComboBox;
    private JTextField searchMedicineField;
    private JButton searchButton;
    private JTable medicineTableUI;
    private JButton addMedicineButton;
    private JSpinner quantitySpinner;
    private JLabel quantityLabel;
    private JLabel cartPanelTitle;

    public PurchasePanel(int type) {
        this.add(purchasePanel);
//        initComponents();
//        layoutComponents();
//        setupListeners();


        purchaseTitle.setText(
                switch(type) {
                    case 1->"Achat direct";
                    case 2->"Achat avec Ordonnance";
                    default -> "Achat de Médicaments";
                });



    }
}
