package fr.sparadrah.ecf.view.swingview;

import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.view.swingview.tablemodele.TableModele;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static fr.sparadrah.ecf.view.swingview.DisplayList.*;

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

    DisplayList tablecontainer;
    public enum FormModes{
        ADD,
        EDIT
    }

    public CustomersPanel(){


        this.setLayout(new GridLayout(1,1));
        this.add(customersPanel);
        tablecontainer = new DisplayList(0);
        customersPanel.add(tablecontainer);

        tablecontainer.getTable().getSelectionModel().addListSelectionListener(e -> {
            boolean selected = tablecontainer.getTable().getSelectedRow() != -1;
            showDetailsBtn.setEnabled(selected);
            editButton.setEnabled(selected);
            deleteButton.setEnabled(selected);
        });




        showDetailsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tablecontainer.getTable().getSelectedRow();
                TableModele<Customer> model = (TableModele<Customer>) tablecontainer.getTable().getModel();
                Customer selectedCustomer = model.getData().get(row);
                JOptionPane.showMessageDialog(customersPanel, selectedCustomer.showDetails());
            }
        });


        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer selectedCustomer = getSelectedItem(tablecontainer.getTable(), (TableModele<Customer>) tablecontainer.getTable().getModel());

                    CustomerFormPanel formPanel = new CustomerFormPanel(selectedCustomer, FormModes.EDIT);
                    formPanel.setVisible(true);
                    formPanel.pack();

            }
        });
        deleteButton.addActionListener(e-> {
                int row = tablecontainer.getTable().getSelectedRow();
                if (row != -1) {
                    TableModele<Customer> model = (TableModele<Customer>) tablecontainer.getTable().getModel();
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
                            repaint();
                            revalidate();
                            updateButtonsState();
                    }
                }


        });



        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchCustomers();
            }
        });


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerFormPanel c = new CustomerFormPanel(new Customer(), FormModes.ADD);

                repaint();
                revalidate();

                updateButtonsState();
            }
        });
    }

    private void searchCustomers() {
        String search = searchField.getText().trim();
        List<Customer> filteredList = CustomersList.filterCustomers(search);
        tablecontainer.configTable(filteredList,HEADER_CUSTOMERS, USER_COLUMN_CLASSES);
    }


    private void updateButtonsState() {
        boolean hasCustomers = !CustomersList.getCustomers().isEmpty();
        showDetailsBtn.setEnabled(hasCustomers);
        deleteButton.setEnabled(hasCustomers);
        editButton.setEnabled(hasCustomers);
        addButton.setEnabled(true);
    }



}
