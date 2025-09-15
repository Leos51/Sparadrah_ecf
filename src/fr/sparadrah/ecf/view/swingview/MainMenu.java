package fr.sparadrah.ecf.view.swingview;

import fr.sparadrah.ecf.view.swingview.customerpanel.CustomerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class MainMenu extends JPanel {
    private MainPanel mainPanel;
    private CustomersPanel customersPanel = new CustomersPanel();
    private PurchaseHistoryPanel purchaseHistoryPanel = new PurchaseHistoryPanel();





    private JPanel containerMenu;
    private JButton directPurchaseBtn;
    private JButton customerManagerBtn;
    private JButton presciptedPurchaseBtn;
    private JButton doctorsManagerBtn;
    private JButton medicineManagerBtn;
    private JButton exitButton;
    private JLabel purchaseLabel;
    private JPanel menu;
    private JButton purchaseHistoryBtn;
    private Boolean hasPrescription = false;


    public MainMenu(MainPanel mainPanel) {

        this.setBackground(Color.lightGray);
        this.mainPanel = mainPanel;
        this.add(containerMenu);


        directPurchaseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hasPrescription = false;
                PurchaseManagementPanel purchasePanel = new PurchaseManagementPanel(hasPrescription);
                mainPanel.showView(purchasePanel);
            }
        });
        presciptedPurchaseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hasPrescription = true;
                PurchaseManagementPanel purchasePanel = new PurchaseManagementPanel(hasPrescription);
                mainPanel.showView(purchasePanel);

            }
        });

        purchaseHistoryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.showView(purchaseHistoryPanel);

            }
        });

        customerManagerBtn.addActionListener(e -> {
            mainPanel.showView(customersPanel);
        });


        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
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
