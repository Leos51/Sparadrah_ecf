package fr.sparadrah.ecf.view.swingview;

import javax.swing.*;

public class TablePanel extends JPanel {
    private JPanel tablePan;
    private JTable tableGeneral;
    private JLabel tableTitle;
    private JScrollPane scrollPane;


    public TablePanel(int i) {
        switch(i){
            case 1-> tableTitle.setText("Gestion des clients");
            case 2-> tableTitle.setText("Gestion des Medecins");
            case 3-> tableTitle.setText("Gestion stock");
            default -> tableTitle.setText("error");
        }





    }
}
