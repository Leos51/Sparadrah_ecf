package fr.sparadrah.ecf.view.swingview;

import fr.sparadrah.ecf.view.swingview.customerpanel.CustomerPanel;

import javax.swing.*;
import java.awt.*;

public  class MainMenu extends JPanel {
    private MainPanel mainPanel;
    private CustomersPanel customersPanel = new CustomersPanel();


    private JPanel menu;
    private JButton directPurchaseBtn;
    private JButton customerManagerBtn;
    private JButton presciptedPurchaseBtn;
    private JButton doctorsManagerBtn;
    private JButton medicineManagerBtn;



    public MainMenu(MainPanel mainPanel) {


        this.setBackground(Color.lightGray);
        this.mainPanel = mainPanel;
        this.add(menu);

        directPurchaseBtn.addActionListener(e -> {
            System.out.println(directPurchaseBtn.getText());
        });

        customerManagerBtn.addActionListener(e -> {
            showCustomersPanel();


        });



    }
    private void showCustomersPanel() {
        mainPanel.removeAll();
        mainPanel.add(new CustomerPanel());
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showDoctorPanel() {
        mainPanel.removeAll();
        mainPanel.add(new JLabel("Gestion medecins"));
        mainPanel.revalidate();
        mainPanel.repaint();
    }

}
