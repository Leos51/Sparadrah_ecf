package fr.sparadrah.ecf.model.lists;

import fr.sparadrah.ecf.model.entity.person.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorList {
    private List<Doctor> doctors = new ArrayList<>();


    public List<Doctor> getDoctors() {
        return doctors;
    }
    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }
    public void deleteDoctor(Doctor doctor) {
        this.doctors.remove(doctor);
    }
}
