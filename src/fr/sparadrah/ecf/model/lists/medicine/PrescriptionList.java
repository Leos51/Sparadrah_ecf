package fr.sparadrah.ecf.model.lists.medicine;

import fr.sparadrah.ecf.model.medicine.Prescription;

import java.util.ArrayList;
import java.util.List;

public class PrescriptionList {
    private static List<Prescription> prescriptionList = new ArrayList<>();

    public static List<Prescription> getPrescriptionList(){
        return prescriptionList;
    }
    public static void addPrescription(Prescription p){
        prescriptionList.add(p);
    }



}
