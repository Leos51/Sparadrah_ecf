package fr.sparadrah.ecf.controller;

import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.model.lists.person.DoctorList;
import fr.sparadrah.ecf.model.lists.medicine.PrescriptionList;
import fr.sparadrah.ecf.model.medicine.Prescription;

public class PrescriptionController {

    public static void seedPrecriptionData(){

        PrescriptionList.addPrescription(new Prescription(
                "18/08/2025", DoctorList.getDoctors().getFirst(), CustomersList.getCustomers().getFirst(), Prescription.getPrescriptedMedicines() ));

    }

    public static void displayPrescription(){

        System.out.println("Liste Ordonnances");
        System.out.println("-------------------");
        for(Prescription p : PrescriptionList.getPrescriptionList()){
            System.out.println(p.toString());
        }
        System.out.println("------------------------------");
    }

}
