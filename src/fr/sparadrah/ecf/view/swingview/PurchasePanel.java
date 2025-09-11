package fr.sparadrah.ecf.view.swingview;

import javax.swing.*;

public class PurchasePanel extends JPanel {
    private JLabel purchaseTitle;
    private JTextField nirField;
    private JTextField licenceField;
    private JPanel purchasePanel;
    private JLabel nirCustomerLabel;
    private JLabel licenseDoctorLabel;
    private JLabel medicineListLabel;
    private JPanel ListContainer;
    private JButton addMedicineButton;
    private JComboBox comboBox1;

    public PurchasePanel(int type) {

        purchaseTitle.setText(
                switch(type) {
                    case 1->"Achat direct";
                    case 2->"Achat avec Ordonnance";
                    default -> "Achat de Médicaments";
                });



    }
}
