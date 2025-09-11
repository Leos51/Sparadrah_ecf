package fr.sparadrah.ecf.view.swingview;

import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.view.swingview.tablemod.TableMod;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomersPanel extends JPanel {
    private JPanel customersPanel;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JPanel bottomBar;
    private JPanel topPanel;
    private JLabel titleLabel;
    private JPanel centerPanel;
    private JTextField searchField;
    private JButton searchButton;
    private JTable customersTable;
    private JButton showDetailsBtn;
    private JPanel tableContainer;
    private JScrollPane scrollPane1;
    private JRadioButton parNomRadioButton;
    private JRadioButton villeRadioButton;
    private JRadioButton parPrenomRadioButton;
    private JRadioButton nirRadioButton;

    public CustomersPanel(){

        this.setLayout(new GridLayout(1,1));
        this.add(customersPanel);
        DisplayList tablecontainer = new DisplayList(0);
        customersTable = tablecontainer.getTable();
        customersPanel.add(customersTable);

        customersTable.getSelectionModel().addListSelectionListener(e -> {
            boolean selected = customersTable.getSelectedRow() != -1;
            showDetailsBtn.setEnabled(selected);
            editButton.setEnabled(selected);
            deleteButton.setEnabled(selected);
        });





        showDetailsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = customersTable.getSelectedRow();
                TableMod<Customer> model = (TableMod<Customer>) customersTable.getModel();
                Customer selectedCustomer = model.getData().get(row);
                JOptionPane.showMessageDialog(customersPanel, selectedCustomer.showDetails());

            }
        });


        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = customersTable.getSelectedRow();
                if (row != -1) {
                    TableMod<Customer> model = (TableMod<Customer>) customersTable.getModel();
                    Customer selectedCustomer = model.getData().get(row);
                    CustomerFormPanel formPanel = new CustomerFormPanel(selectedCustomer);
                    formPanel.setVisible(true);
                    formPanel.pack();
                }
            }
        });
        deleteButton.addActionListener(e-> {
                int row = customersTable.getSelectedRow();
                if (row != -1) {
                    TableMod<Customer> model = (TableMod<Customer>) customersTable.getModel();
                    Customer selectedCustomer = model.getData().get(row);

                    int confirm = JOptionPane.showConfirmDialog(
                            this,
                            "Voulez-vous vraiment supprimer le client \"" + selectedCustomer.getFullName() + "\" ?",
                            "Confirmation de suppression",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                    );


                    if (confirm == JOptionPane.YES_OPTION) {
                            CustomersList.removeCustomer(selectedCustomer);
                    }
                }


        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerFormPanel formPanel = new CustomerFormPanel(null);
                formPanel.setVisible(true);
                formPanel.pack();


            }
        });





    }





}
