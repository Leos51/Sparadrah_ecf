package fr.sparadrah.ecf.view.swingview.customerpanel;

import fr.sparadrah.ecf.view.swingview.DisplayList;

import javax.swing.*;

public class DisplayTable extends JTable{
    static DisplayList displayList;

    public static void displayCustomers(JPanel parent){

        displayList = new DisplayList(0);
        displayList.revalidate();
        displayList.repaint();
        displayList.setVisible(true);
        parent.add(displayList);
    }
    public static void displayDoctors(JPanel parent){
        displayList = new DisplayList(1);
        displayList.revalidate();
        displayList.repaint();
        displayList.setVisible(true);
        parent.add(displayList);
    }

    private void displayMedicines(JPanel parent){
        displayList = new DisplayList(2);
        displayList.revalidate();
        displayList.repaint();
        displayList.setVisible(true);
        parent.add(displayList);
    }

}
