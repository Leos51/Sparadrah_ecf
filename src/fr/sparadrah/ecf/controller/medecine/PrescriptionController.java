package fr.sparadrah.ecf.controller.medecine;

import fr.sparadrah.ecf.model.lists.medicine.MedicineList;
import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.model.lists.person.DoctorList;
import fr.sparadrah.ecf.model.lists.medicine.PrescriptionList;
import fr.sparadrah.ecf.model.medicine.Medicine;
import fr.sparadrah.ecf.model.medicine.Prescription;
import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.model.person.Doctor;
import fr.sparadrah.ecf.model.purchase.Purchase;

import java.util.Arrays;
import java.util.List;

public class PrescriptionController {

    public static void seedPrecriptionData(){
        try{
            // Récupérer des clients et médecins existants
            Customer customer1 = CustomersList.findByNir("1885621486527");
            Customer customer2 = CustomersList.findByNir("1885621486522");
            Doctor doctor1 = DoctorList.findDoctorByLicenseNumber("12345678913");
            Doctor doctor2 = DoctorList.findDoctorByLicenseNumber("12345678076");

            // Créer des listes de médicaments pour les ordonnances
            List<Medicine> medicines1 = Arrays.asList(
                    MedicineList.findMedicineByName("Doliprane"),
                    MedicineList.findMedicineByName("Ibuprofen")
            );

            List<Medicine> medicines2 = Arrays.asList(
                    MedicineList.findMedicineByName("Paracétamol"),
                    MedicineList.findMedicineByName("Advil")
            );

            // Créer les ordonnances
            Prescription prescription1 = new Prescription("15/09/2025", doctor1, customer1, medicines1);
            Prescription prescription2 = new Prescription("14/09/2025", doctor2, customer2, medicines2);

            PrescriptionList.addPrescription(prescription1);
            PrescriptionList.addPrescription(prescription2);

        }catch(Exception e){
            System.err.println("Erreur init ordonnances: " + e.getMessage());
        }
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
