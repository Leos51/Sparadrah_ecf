package fr.sparadrah.ecf.model.lists.person;

import fr.sparadrah.ecf.model.person.MutualInsurance;

import java.util.ArrayList;
import java.util.List;

public class MutualInsuranceList {
    private static List<MutualInsurance> mutualinsuranceList = new ArrayList<>();



    public static List<MutualInsurance> getMutualInsuranceList() {
        return mutualinsuranceList;
    }


    public static void addInsuranceCompany(MutualInsurance mutualInsurance) {
        getMutualInsuranceList().add(mutualInsurance);
    }
    public void removeInsuranceCompany(MutualInsurance mutualInsurance) {
        getMutualInsuranceList().remove(mutualInsurance);
    }

    public MutualInsurance findMutualInsuranceByName(String mutualInsuranceName) {
        for (MutualInsurance mutualInsurance : mutualinsuranceList) {
            if(mutualInsuranceName.equalsIgnoreCase(mutualInsurance.getCompagnyName())){
                return mutualInsurance;
            }
        }
        return null;
    }

}
