package fr.sparadrah.ecf.model.person;

import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.utils.validator.Validator;

public class MutualInsurance {
    private String compagnyName;
    private String address;
    private String postCode;
    private String city;
    private String phone;
    private String email;
    private String departementName;
    private double reimbursementRate;



    public MutualInsurance(String compagnyName, String departementName, double reimbursementRate, String address, String postalCode, String city, String phone, String email) throws SaisieException {
        this.setCompagnyName(compagnyName);
        this.setAddress(address);
        this.setPostCode(postalCode);
        this.setCity(city);
        this.setPhone(phone);
        this.setEmail(email);
        this.setDepartementName(departementName);
        this.setReimbursementRate(reimbursementRate);

    }


    public void setCompagnyName(String compagnyName) {
        this.compagnyName = compagnyName;
    }

    public String getAddress() {
        return address;
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
    public void setCity(String city)  {
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

    public void setDepartementName(String departementName) {
        this.departementName = departementName;
    }
    public void setReimbursementRate(double reimbursementRate) {
        this.reimbursementRate = reimbursementRate;
    }
    public String getCompagnyName() {
        return compagnyName;
    }
    public String getDepartementName() {
        return departementName;
    }
    public double getReimbursementRate() {
        return reimbursementRate;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MutualInsurance{");
        sb.append("compagnyName='").append(compagnyName).append('\'');
        sb.append(", reimbursementRate=").append(reimbursementRate);
        sb.append('}');
        return sb.toString();
    }
}
