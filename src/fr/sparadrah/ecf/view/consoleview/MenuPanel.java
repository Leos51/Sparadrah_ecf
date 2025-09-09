package fr.sparadrah.ecf.view.consoleview;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    public MenuPanel() {
        this.setBackground(Color.red);
        this.setLayout(new GridLayout(1,1));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setVisible(true);
        this.setSize(200,400);

        JButton btnNewButton = new JButton("New Customer");
        btnNewButton.setBackground(Color.black);
        btnNewButton.setForeground(Color.white);

        this.add(btnNewButton);

    }
}
