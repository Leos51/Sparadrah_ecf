package fr.sparadrah.ecf.model.entity;

public class InsuranceCompagny extends Entity {
    private String compagnyName;
    private String departementName;
    private double coverageRate;


    public InsuranceCompagny(String compagnyName, String departementName, double coverageRate, String adress, String postalCode, String city, String phone, String email) {
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
