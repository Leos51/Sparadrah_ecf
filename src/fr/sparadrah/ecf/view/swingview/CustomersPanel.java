package fr.sparadrah.ecf.view.swingview;

import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.view.swingview.tablemod.TableMod;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomersPanel extends JPanel {
    private JPanel customersPanel;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JPanel bottomBar;
    private JPanel topPanel;
    private JLabel titleLabel;
    private JPanel containerList;

    public CustomersPanel(){
        this.setLayout(new BorderLayout());
    this.add(customersPanel);
        DisplayList tablecontainer = new DisplayList(0);
        JTable table = tablecontainer.getTable();
         customersPanel.add(table, BorderLayout.CENTER);

        table.getSelectionModel().addListSelectionListener(e -> {
            boolean selected = table.getSelectedRow() != -1;
            editButton.setEnabled(selected);
            deleteButton.setEnabled(selected);
        });




        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteButton.addActionListener(e-> {

                int row = table.getSelectedRow();
                if (row != -1) {
                    TableMod<Customer> model = (TableMod<Customer>) table.getModel();
                    Customer selectedCustomer = model.getData().get(row);

                    AtomicInteger confirm = new AtomicInteger(JOptionPane.showConfirmDialog(
                            this,
                            "Voulez-vous vraiment supprimer le client \"" + selectedCustomer.getFullName() + "\" ?",
                            "Confirmation de suppression",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                    ));


                    if (confirm.get() == JOptionPane.YES_OPTION) {
                            CustomersList.removeCustomer(selectedCustomer);
                            table.repaint();
                            table.revalidate();

                    }
                }



        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });



    }





}
