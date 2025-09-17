package fr.sparadrah.ecf.model.lists.person;

import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.model.person.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorList {
    private static List<Doctor> doctors = new ArrayList<>();


    public static List<Doctor> getDoctors() {
        return doctors;
    }

    public static List<Doctor> filterDoctor(String pSearch) {
        String search = pSearch.toLowerCase().trim();
        List<Doctor> filteredDoctors = getDoctors().stream()
                .filter(doctor ->
                        doctor.getFullName().toLowerCase().contains(search) ||
                                doctor.getRpps().contains(search) ||
                                doctor.getEmail().contains(search) ||
                                doctor.getCity().toLowerCase().contains(search)

                ).toList();
        return filteredDoctors;
    }

    public void setDoctors(List<Doctor> doctors) {

        this.doctors = doctors;
    }
    public static void addDoctor(Doctor doctor) {
        getDoctors().add(doctor);
    }
    public static void removeDoctor(Doctor doctor) {

        doctors.remove(doctor);
    }
    public static Doctor findDoctorByLicenseNumber(String certificateNumber) {
        for (Doctor d : doctors) {
            if(certificateNumber.equals(d.getRpps())){
                return d;
            };
        }
        return null;
    }
    public static Doctor findByFullName(String fullName) {
        String search = fullName.toLowerCase().trim();
        for(Doctor doctor : getDoctors()) {
            if(doctor.getFullName().toLowerCase().equalsIgnoreCase(search)) {
                return doctor;
            }
        }
        return null;
    };


}
