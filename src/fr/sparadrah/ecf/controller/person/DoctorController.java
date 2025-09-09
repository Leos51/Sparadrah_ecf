package fr.sparadrah.ecf.controller.person;

import fr.sparadrah.ecf.model.lists.person.DoctorList;
import fr.sparadrah.ecf.model.person.Doctor;
import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.view.consoleview.MainMenu;

public class DoctorController {

    public static void seedDoctorData() throws SaisieException {
        DoctorList.addDoctor(new Doctor("Nimous", "Ano","Adress 1", "51000", "Sanru","0123456987","ano@nimous.fr","12345678913"));
        DoctorList.addDoctor(new Doctor("Doc", "Abi","10 Parru", "52000", "Parus","0123456997","ano@daim.fr","12345678076"));
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
