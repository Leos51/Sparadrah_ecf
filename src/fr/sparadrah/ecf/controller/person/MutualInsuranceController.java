package fr.sparadrah.ecf.controller.person;

import fr.sparadrah.ecf.model.person.MutualInsurance;
import fr.sparadrah.ecf.model.lists.person.MutualInsuranceList;
import fr.sparadrah.ecf.utils.exception.SaisieException;

public class MutualInsuranceController {
    public static void seedMutualInsuranceData() throws SaisieException {
        MutualInsuranceList.addInsuranceCompany(new MutualInsurance("Macif", "Marne", 30, "49 rue Verso", "51000", "Chalons", "0325426512", "contact@macif.com"));


//        for(MutualInsurance mi : MutualInsuranceList.getMutualInsuranceList()){
//            System.out.println(mi.toString());
//
//        }
    }


}
