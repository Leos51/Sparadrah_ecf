package fr.sparadrah.ecf.view.swingview.doctor;

import fr.sparadrah.ecf.model.lists.person.DoctorList;
import fr.sparadrah.ecf.model.person.Doctor;
import fr.sparadrah.ecf.utils.DateFormat;
import fr.sparadrah.ecf.utils.exception.SaisieException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorFormPanel extends  JFrame {
    private JPanel editPanel;
    private JPanel formPanel;
    private JTextField lastNameField;
    private JTextField firstNameField;
    private JTextField addressField;
    private JTextField postCodeField;
    private JTextField cityField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextField birthDateField;
    private JButton submitButton;
    private JButton cancelButton;
    private JLabel titleLabel;
    private JLabel lastNameLabel;
    private JLabel addressLabel;
    private JLabel firstNameLabel;
    private JLabel postCodeLabel;
    private JLabel cityLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JTextField doctorField;
    private JTextField mutualField;
    private JTextField rppsField;
    private JLabel rppsLabel;
    private Doctor doctor;


    public DoctorFormPanel(Doctor currentDoctor, DoctorsPanel.FormModes mode) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setContentPane(formPanel);


        if(mode == DoctorsPanel.FormModes.EDIT && currentDoctor != null) {
            //remplissage du formulaire avec client selectionné
            this.setTitle("Modification du client");
            populateFields(currentDoctor);
        }

        if(mode == DoctorsPanel.FormModes.ADD) {
            this.setTitle("Nouveau client");
        }


        cancelButton.addActionListener( e ->{
           this.dispose();
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    submitForm(currentDoctor, mode);
                } catch (SaisieException exception) {
                    JOptionPane.showMessageDialog(DoctorFormPanel.this, exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }


            }
        });
    }


    private void submitForm(Doctor doctor ,DoctorsPanel.FormModes mode) throws SaisieException {
        String lastName = lastNameField.getText().trim();
        String firstName = firstNameField.getText().trim();
        String address = addressField.getText().trim();
        String postCode = postCodeField.getText().trim();
        String city = cityField.getText().trim();
        String phone = phoneField.getText().trim();
        String email = emailField.getText().trim();
        String rpps = rppsField.getText().trim();


            if (lastName.isEmpty() || firstName.isEmpty() || address.isEmpty() || postCode.isEmpty() || city.isEmpty() || phone.isEmpty() || email.isEmpty() || rpps.isEmpty()) {
                throw new SaisieException("Champs obligatoires manquants.");
            }


            if (mode == DoctorsPanel.FormModes.ADD) {
                doctor = new Doctor(lastName,firstName,address, postCode,city, phone, email, rpps);
                DoctorList.addDoctor(doctor);
                JOptionPane.showMessageDialog(this, "Client ajouté !");
            } else {

                doctor.setLastName(lastName);
                doctor.setFirstName(firstName);
                doctor.setAddress(address);
                doctor.setPostCode(postCode);
                doctor.setCity(city);
                doctor.setPhone(phone);
                doctor.setEmail(email);
                doctor.setRpps(rpps);



                JOptionPane.showMessageDialog(this, "Medecin mis à jour !");
            }
    }

    private void populateFields(Doctor c){
        titleLabel.setText("Modifier le medecin");
        submitButton.setText("Valider la modification");
        lastNameField.setText(c.getLastName());
        firstNameField.setText(c.getFirstName());
        addressField.setText(c.getAddress());
        postCodeField.setText(c.getPostCode());
        cityField.setText(c.getCity());
        phoneField.setText(c.getPhone());
        emailField.setText(c.getEmail());
        rppsField.setText(c.getRpps());
    }

}
