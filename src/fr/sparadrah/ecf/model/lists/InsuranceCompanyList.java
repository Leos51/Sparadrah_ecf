package fr.sparadrah.ecf.model.lists;

import fr.sparadrah.ecf.model.entity.InsuranceCompany;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InsuranceCompanyList {
    private static List<InsuranceCompany> insuranceCompanyList = new ArrayList<>();



    public static List<InsuranceCompany> getInsuranceCompanyList() {
        return insuranceCompanyList;
    }
    public void setInsuranceCompanyList(List<InsuranceCompany> insuranceCompanyList) {
        this.insuranceCompanyList = insuranceCompanyList;
    }

    public static void addInsuranceCompany(InsuranceCompany insuranceCompany) {
        getInsuranceCompanyList().add(insuranceCompany);
    }
    public void deleteInsuranceCompany(InsuranceCompany insuranceCompany) {
        getInsuranceCompanyList().remove(insuranceCompany);
    }

    public InsuranceCompany findInsuranceCompanyByName(String insuranceCompanyName) {
        for (InsuranceCompany insuranceCompany : insuranceCompanyList) {
            if(insuranceCompanyName.equalsIgnoreCase(insuranceCompany.getCompagnyName())){
                return insuranceCompany;
            }
        }
        return null;
    }

}
