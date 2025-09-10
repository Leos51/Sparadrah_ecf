package fr.sparadrah.ecf.view.swingview;

import javax.swing.*;

public class PurchasePanel extends JPanel {
    private JLabel purchaseTitle;
    private JTextField textField1;
    private JTextField textField2;
    private JList list1;

    PurchasePanel(int type) {

        purchaseTitle.setText(
                switch(type) {
                    case 1->"Achat direct";
                    case 2->"Achat avec Ordonnance";
                    default -> "Achat de Médicaments";
                });



    }
}
