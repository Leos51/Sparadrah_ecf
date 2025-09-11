package fr.sparadrah.ecf.view.swingview;

import javax.swing.*;
import java.awt.*;


public class MainPanel extends JPanel {
    public MainPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);
    }

    public void showView(JComponent component) {
        this.removeAll();
        this.add(component, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }


}
