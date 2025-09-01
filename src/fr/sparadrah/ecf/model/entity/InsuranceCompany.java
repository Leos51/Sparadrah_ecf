package fr.sparadrah.ecf.model.entity;

import fr.sparadrah.ecf.utils.exception.SaisieException;

public class InsuranceCompany extends Entity {
    private String compagnyName;
    private String departementName;
    private double coverageRate;


    public InsuranceCompany(String compagnyName, String departementName, double coverageRate, String adress, String postalCode, String city, String phone, String email) throws SaisieException {
        super(adress, postalCode, city, phone, email);
        this.setCompagnyName(compagnyName);
        this.setDepartementName(departementName);
        this.setCoverageRate(coverageRate);
    }


    public void setCompagnyName(String compagnyName) {
        this.compagnyName = compagnyName;
    }
    public void setDepartementName(String departementName) {
        this.departementName = departementName;
    }
    public void setCoverageRate(double coverageRate) {
        this.coverageRate = coverageRate;
    }
    public String getCompagnyName() {
        return compagnyName;
    }
    public String getDepartementName() {
        return departementName;
    }
    public double getCoverageRate() {
        return coverageRate;
    }

}
