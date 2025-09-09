package fr.sparadrah.ecf.view.swingview;

import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.view.consoleview.MenuPanel;
import fr.sparadrah.ecf.view.swingview.customerpanel.CustomerPanel;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;


public class MainFrame extends JFrame {

    public MainFrame(){


        this.setTitle("Sparadrah Ecf");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        this.setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        MenuPanel menuPanel = new MenuPanel();
        contentPane.add(menuPanel,BorderLayout.WEST);



        CustomerPanel c = new CustomerPanel();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        String[] aze = {"test1, test2", "test3"};

        c.setBackground(Color.LIGHT_GRAY);
        c.add(new JLabel("test jlabel"));
        c.add(new JLabel("test jlabel2"));


for(Customer item : CustomersList.getCustomers()){
    c.add(new JLabel(item.getEmail()));
}
contentPane.add(new JScrollPane(c),  BorderLayout.CENTER);






    }



}
