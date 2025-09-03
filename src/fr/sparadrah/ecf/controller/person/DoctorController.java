package fr.sparadrah.ecf.controller.person;

import fr.sparadrah.ecf.model.lists.person.DoctorList;
import fr.sparadrah.ecf.model.person.Doctor;
import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.view.consoleview.MainMenu;

public class DoctorController {

    public static void seedDoctorData() throws SaisieException {
        DoctorList.addDoctor(new Doctor("Nimous", "Ano","Adress 1", "51000", "Sanru","0123456987","ano@nimous.fr","123456789"));
    }

    public static void displayDoctors(){
        System.out.println("Liste des medecins");
        System.out.println("--------------");
        for(Doctor doctor : DoctorList.getDoctors()){
            System.out.println(doctor);
        }
        System.out.println("--------------");
    }
    public static void displayDetailDoctor(Doctor doctor){
        System.out.println(doctor.showDetails());
    }

}
