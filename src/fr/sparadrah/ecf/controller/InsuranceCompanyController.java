package fr.sparadrah.ecf.controller;

import fr.sparadrah.ecf.model.entity.InsuranceCompany;
import fr.sparadrah.ecf.model.lists.InsuranceCompanyList;
import fr.sparadrah.ecf.utils.exception.SaisieException;

public class InsuranceCompanyController {
    public static void seedInsuranceCompanyData() throws SaisieException {
        InsuranceCompanyList.addInsuranceCompany(new InsuranceCompany("Macif", "Marne", 30, "49 rue Verso", "51000", "Chalons", "0325426512", "contact@macif.com"));
    }


}
