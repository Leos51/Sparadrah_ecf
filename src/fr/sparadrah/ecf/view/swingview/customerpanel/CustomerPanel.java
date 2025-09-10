package fr.sparadrah.ecf.view.swingview.customerpanel;

import javax.swing.*;
import java.awt.*;

public class CustomerPanel extends JPanel {
  public CustomerPanel() {
      this.setBackground(Color.cyan);
    this.setLayout(new CardLayout());
      DisplayTable table = new DisplayTable();
      table.setVisible(true);


      this.add(table, "CustomerTable");
      CardLayout cl = (CardLayout) this.getLayout();
      cl.show(this, "CustomerTable");



  }
}
