package fr.sparadrah.ecf.view.swingview.doctor;

import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.model.person.Doctor;
import fr.sparadrah.ecf.view.swingview.DisplayList;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Collectors;

public class DoctorCustomersDialog extends JDialog {
    private Doctor doctor;
    private JPanel contentPane;
    private JPanel titlePanel;
    private JLabel titleLabel;

    private JTable customersTable;
    private DisplayList customersDisplayList;

    public DoctorCustomersDialog(Frame parent, Doctor doctor) {
        super(parent,"Patients du doctor " + doctor.getFullName() ,true);
        this.doctor = doctor;

        setupDialog();
        initializeComponents();
    }

    private void setupDialog() {
        this.setSize(800, 500);
        this.setLocationRelativeTo(getParent());
        this.setResizable(true);
    }

    private void initializeComponents() {
        titleLabel.setText("Patient du doctor " + doctor.getFullName());

        // Table des patients
        java.util.List<Customer> customers = getCustomersByDoctor();

        if (customers.isEmpty()) {
            JLabel noCustomersLabel = new JLabel("Aucun patient assigné à ce médecin.");
            noCustomersLabel.setHorizontalAlignment(JLabel.CENTER);
            contentPane.add(noCustomersLabel, BorderLayout.CENTER);
        } else {
                    customersDisplayList = new DisplayList(0);



            JScrollPane scrollPane = new JScrollPane(customersTable);
            scrollPane.setBorder(BorderFactory.createTitledBorder(
                    "Liste des patients (" + customers.size() + " patient(s))"));
            contentPane.add(customersDisplayList, BorderLayout.CENTER);


        }
    }

    private java.util.List<Customer> getCustomersByDoctor(){
        java.util.List<Customer> customers = CustomersList.getCustomers().stream()
                .filter(customer -> customer.getDoctor() != null && customer.getDoctor().equals(doctor))
                .toList();
        return customers;
    }

}
