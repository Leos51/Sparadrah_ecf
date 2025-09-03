package fr.sparadrah.ecf.model.lists.person;

import fr.sparadrah.ecf.model.person.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorList {
    private static List<Doctor> doctors = new ArrayList<>();


    public static List<Doctor> getDoctors() {
        return doctors;
    }
    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
    public static void addDoctor(Doctor doctor) {
        getDoctors().add(doctor);
    }
    public void deleteDoctor(Doctor doctor) {
        this.doctors.remove(doctor);
    }
    public static Doctor findDoctorByCertifNum(String certificateNumber) {
        for (Doctor d : doctors) {
            if(certificateNumber.equals(d.getCertificationNumber())){
                return d;
            };
        }
        return null;
    }


}
