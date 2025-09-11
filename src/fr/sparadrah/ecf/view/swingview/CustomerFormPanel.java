package fr.sparadrah.ecf.view.swingview;

import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.model.lists.person.DoctorList;
import fr.sparadrah.ecf.model.lists.person.MutualInsuranceList;
import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.model.person.Doctor;
import fr.sparadrah.ecf.model.person.MutualInsurance;
import fr.sparadrah.ecf.utils.DateFormat;
import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.utils.validator.Validator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class CustomerFormPanel extends  JFrame {
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
    private JLabel birthDateLabel;
    private JLabel mutualInsurranceLabel;
    private JLabel doctorLabel;
    private JTextField doctorField;
    private JTextField mutualField;
    private JTextField nirField;
    private JLabel nirLabel;


    public CustomerFormPanel() {
        this.setTitle("Nouveau client");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setContentPane(formPanel);
    }

    public CustomerFormPanel(Customer currentCustomer) {
        this.setTitle("Ajout client");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setContentPane(formPanel);


        if(currentCustomer != null) {
            //remplissage du formulaire avec client selectionné
            this.setTitle("Modification du client");
            populateForm(currentCustomer);
        }






        cancelButton.addActionListener( e ->{
           this.dispose();
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentCustomer.setFirstName(firstNameField.getText());
                currentCustomer.setLastName(lastNameField.getText());

            }
        });
    }

    private void submitForm(Customer currentCustomer) {
        try{
            String lastName = lastNameField.getText();
            if(lastName.isEmpty()){
                throw new SaisieException("Le nom est obligatoire");
            }
            String firstName = firstNameField.getText();
            if(firstName.isEmpty()){
                throw new SaisieException("Le prenom est obligatoire");
            }
            String address = addressField.getText();
            if(address.isEmpty()){
                throw new SaisieException("Le adresse est obligatoire");
            }
            String postCode = postCodeField.getText();
            if(postCode.isEmpty()){
                throw new SaisieException("Le postcode est obligatoire");
            }
            String city = cityField.getText();
            if(city.isEmpty()){
                throw new SaisieException("Saisir la ville est obligatoire");
            }
            String phone = phoneField.getText();
            if(phone.isEmpty()){
                throw new SaisieException("Le numero de telephone est obligatoire");
            }
            String email = emailField.getText();
            if(email.isEmpty()){
                throw new SaisieException("L'adresse email est obligatoire");
            }
            String birthDate = birthDateField.getText();
            if(birthDate.isEmpty() && birthDate.length() != 10){
                throw new SaisieException("Le client n'as pas de date de naissance ?");
            }

            String nir = nirField.getText();
            if(nir.isEmpty()){
                throw new SaisieException("Le n° de décurité social est obligatoire");
            }
            String mutualInsuranceName = mutualField.getText();
            MutualInsurance mutualInsurance = MutualInsuranceList.findMutualInsuranceByName(mutualInsuranceName);
            String doctorNir = doctorField.getText();
            Doctor doctor = DoctorList.findDoctorByLicenseNumber(doctorNir);

            if (currentCustomer == null) {
                Customer newCustomer = new Customer(lastName,firstName,address, postCode,city, phone, email, nir, birthDate, mutualInsurance, doctor);
                CustomersList.addCustomer(newCustomer);
                JOptionPane.showMessageDialog(this, "Client ajouté avec succès !");
            } else {
                currentCustomer.setLastName(lastName);
                currentCustomer.setFirstName(firstName);
                currentCustomer.setAddress(address);
                currentCustomer.setPostCode(postCode);
                currentCustomer.setCity(city);
                currentCustomer.setPhone(phone);
                currentCustomer.setEmail(email);
                currentCustomer.setNir(nir);
                currentCustomer.setBirthDate(DateFormat.parseDateFromString(birthDate));
                currentCustomer.setDoctorByLicenseNumber( doctorNir);
                currentCustomer.setMutualInsurance(mutualInsurance);

                JOptionPane.showMessageDialog(this, "Client mis à jour !");
            }



        }catch (SaisieException e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }

    }
    private void populateForm(Customer c){
        titleLabel.setText("Modifier le client");
        submitButton.setText("Valider la modification");

        lastNameField.setText(c.getLastName());
        firstNameField.setText(c.getFirstName());
        addressField.setText(c.getAddress());
        postCodeField.setText(c.getPostCode());
        cityField.setText(c.getCity());
        phoneField.setText(c.getPhone());
        emailField.setText(c.getEmail());
        birthDateField.setText(DateFormat.formatDate(c.getBirthDate(),  "dd/MM/yyyy"));
        mutualField.setText(c.getMutualInsurance().getCompagnyName());
        doctorField.setText(c.getDoctor().getLicenseNumber());
        nirField.setText(c.getNir());
    }

}
