package fr.sparadrah.ecf.view.swingview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class MainMenu extends JPanel {
    private MainPanel mainPanel;
    private CustomersPanel customersPanel = new CustomersPanel();
    private PurchaseHistoryPanel purchaseHistoryPanel = new PurchaseHistoryPanel();
    private HomePanel homePanel = new HomePanel();





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
    private JButton homeBtn;
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
                resetBtnMenu();
                directPurchaseBtn.setEnabled(false);
            }
        });
        presciptedPurchaseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hasPrescription = true;
                PurchaseManagementPanel purchasePanel = new PurchaseManagementPanel(hasPrescription);
                mainPanel.showView(purchasePanel);
                resetBtnMenu();
                presciptedPurchaseBtn.setEnabled(false);

            }
        });

        purchaseHistoryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.showView(purchaseHistoryPanel);
                resetBtnMenu();
                purchaseHistoryBtn.setEnabled(false);

            }
        });

        customerManagerBtn.addActionListener(e -> {
            mainPanel.showView(customersPanel);
            resetBtnMenu();
            customerManagerBtn.setEnabled(false);

        });


        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        homeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.showView(homePanel);
                resetBtnMenu();
                homeBtn.setEnabled(false);

            }
        });
    }

    private void resetBtnMenu() {
        homeBtn.setEnabled(true);
        directPurchaseBtn.setEnabled(true);
        presciptedPurchaseBtn.setEnabled(true);

        purchaseHistoryBtn.setEnabled(true);

        customerManagerBtn.setEnabled(true);
        doctorsManagerBtn.setEnabled(true);
        medicineManagerBtn.setEnabled(true);


    }

}
