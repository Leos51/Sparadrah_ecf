package fr.sparadrah.ecf.model.person;

import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.utils.validator.Validator;

public class Person {
    private String firstName;
    private String lastName;
    private String adress;
    private String postCode;
    private String city;
    private String phone;
    private String email;


    public Person(String lastName, String firstName, String adress, String postCode, String city, String phone, String email) throws SaisieException {
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setAdress(adress);
        this.setPostCode(postCode);
        this.setCity(city);
        this.setPhone(phone);
        this.setEmail(email);

    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
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
        if(!Validator.isValidEmail(email)) {
            throw new SaisieException("Email invalide");
        }
        this.email = email;
    }
}
