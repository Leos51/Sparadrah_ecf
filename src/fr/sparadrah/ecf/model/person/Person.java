package fr.sparadrah.ecf.model.person;

import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.utils.validator.Validator;

import static fr.sparadrah.ecf.utils.UserInput.capitalize;

public class Person {
    private String firstName;
    private String lastName;
    private String address;
    private String postCode;
    private String city;
    private String phone;
    private String email;

    public Person() {

    }

    public Person(String lastName, String firstName, String address, String postCode, String city, String phone, String email) throws SaisieException {
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setAddress(address);
        this.setPostCode(postCode);
        this.setCity(city);
        this.setPhone(phone);
        this.setEmail(email);

    }


    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        firstName = firstName.trim();
        this.firstName = capitalize(firstName);
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        lastName = lastName.trim();
        this.lastName = capitalize(lastName);
    }

    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPostCode() {
        return postCode;
    }
    public void setPostCode(String postCode) throws SaisieException {
        if(!Validator.isValidPostalCode(postCode)){
            throw new SaisieException("Code postal non valide");
        }
        this.postCode = postCode;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {;
        this.city = city;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {

        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) throws SaisieException {
        email = email
                .trim()
                .toLowerCase();
        if(!Validator.isValidEmail(email)) {
            throw new SaisieException("Email invalide");
        }
        this.email = email;
    }


    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }



    public String showDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAdresse: " + this.getAddress());
        sb.append("\nCode Postal: " + this.getPostCode());
        sb.append("\nVille: " + this.getCity());
        sb.append("\nTéléphone: " + this.getPhone());
        sb.append("\nEmail: " + this.getEmail());
        return sb.toString();
    }


    @Override
    public String toString() {
        return this.getFullName();
    }
}
