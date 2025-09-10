package fr.sparadrah.ecf.view.swingview;

import javax.swing.*;
import java.awt.*;

public class CustomersPanel {
    private JPanel customersPanel;
    private JButton addButton;
    private JButton editButton;
    private JButton removeButton;

    public CustomersPanel(){
        customersPanel.setBorder(BorderFactory.createTitledBorder("Customers"));

        addButton.addActionListener(e -> {
            System.out.println("CustomersPanel addButton");
        });



    }
}
