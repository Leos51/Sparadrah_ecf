package fr.sparadrah.ecf.view.swingview;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {

    public MainFrame() {
        this.setTitle("Sparadrah Ecf");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1600, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        this.setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        MainPanel mainPanel = new MainPanel();
        MainMenu menuPanel = new MainMenu(mainPanel);

        contentPane.add(menuPanel, BorderLayout.WEST);
        contentPane.add(mainPanel, BorderLayout.CENTER);

    }



}
