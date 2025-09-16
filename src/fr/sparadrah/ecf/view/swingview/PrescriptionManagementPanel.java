package fr.sparadrah.ecf.view.swingview;

import fr.sparadrah.ecf.model.medicine.Prescription;
import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.model.person.Doctor;
import fr.sparadrah.ecf.utils.exception.SaisieException;

import javax.swing.*;
import java.util.ArrayList;

public class PrescriptionManagementPanel extends JPanel {
    private JPanel contentPane;
    private JComboBox customerComboBox;
    private JComboBox doctorComboBox;
    private JTextField prescriptionDateField1;


    public PrescriptionManagementPanel() {
        this.add(contentPane)
    }
    private void createPrescription() {
        try {
            Customer selectedCustomer = (Customer) customerComboBox.getSelectedItem();
            Doctor selectedDoctor = (Doctor) doctorComboBox.getSelectedItem();
            String prescriptionDate = prescriptionDateField1.getText();
            currentPrescription = new Prescription(prescriptionDate, selectedDoctor, selectedCustomer, new ArrayList<>());
        }catch (SaisieException e){
            JOptionPane.showMessageDialog(this, "Erreur : " + e.getMessage());
        }


    }
}
