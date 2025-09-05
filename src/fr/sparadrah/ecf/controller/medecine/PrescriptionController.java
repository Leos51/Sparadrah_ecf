package fr.sparadrah.ecf.controller.medecine;

import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.model.lists.person.DoctorList;
import fr.sparadrah.ecf.model.lists.medicine.PrescriptionList;
import fr.sparadrah.ecf.model.medicine.Prescription;
import fr.sparadrah.ecf.model.purchase.Purchase;

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

    public static double calculateReimbursement(Purchase p, double totalPrice){

        double reimbursementRate = p.getCustomer().getMutualInsurance().getReimbursementRate();
        double reimbursement = totalPrice * reimbursementRate;
        return reimbursement;
    }

}
