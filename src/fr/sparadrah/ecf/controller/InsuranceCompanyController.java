package fr.sparadrah.ecf.controller;

import fr.sparadrah.ecf.model.MutualInsurance;
import fr.sparadrah.ecf.model.lists.MutualInsuranceList;
import fr.sparadrah.ecf.utils.exception.SaisieException;

public class InsuranceCompanyController {
    public static void seedInsuranceCompanyData() throws SaisieException {
        MutualInsuranceList.addInsuranceCompany(new MutualInsurance("Macif", "Marne", 30, "49 rue Verso", "51000", "Chalons", "0325426512", "contact@macif.com"));
    }


}
