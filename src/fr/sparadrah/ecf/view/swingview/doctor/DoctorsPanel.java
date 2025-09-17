package fr.sparadrah.ecf.view.swingview.doctor;

import fr.sparadrah.ecf.model.lists.person.DoctorList;
import fr.sparadrah.ecf.model.person.Doctor;
import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.view.swingview.DisplayList;
import fr.sparadrah.ecf.view.swingview.tablemodele.TableModele;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static fr.sparadrah.ecf.view.swingview.DisplayList.*;

public class DoctorsPanel extends JPanel {
    private JPanel doctorsPanel;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JPanel bottomBar;
    private JPanel topPanel;
    private JLabel titleLabel;
    private JPanel centerPanel;
    private JTextField searchField;
    private JButton searchButton;
    private JButton showDetailsBtn;
    private JPanel tableContainer;
    private JPanel titlePanel;
    private JPanel searchPanel;
    private JTable doctorsTable;
    private JScrollPane scrollPane;
    private JPanel tablePanel;
    private JPanel left;
    private JPanel right;
    private DisplayList doctorsDisplayList;
    public enum FormModes{
        ADD,
        EDIT
    }

    public DoctorsPanel(){
        this.setLayout(new GridLayout(1,1));
        this.add(doctorsPanel);
        doctorsDisplayList = new DisplayList(1);
        tablePanel.add(doctorsDisplayList);


        doctorsDisplayList.getTable().getSelectionModel().addListSelectionListener(e -> {
            boolean selected = doctorsDisplayList.getTable().getSelectedRow() != -1;
            showDetailsBtn.setEnabled(selected);
            editButton.setEnabled(selected);
            deleteButton.setEnabled(selected);
        });

        showDetailsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDoctorssDetails();

            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editDoctors();
            }
        });

        deleteButton.addActionListener(e-> {
            deleteDoctor();
        });


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchDoctor();
            }
        });


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    addDoctor();
            }
        });
    }

    private void searchDoctor() {
        String search = searchField.getText().trim();
        List<Doctor> filteredList = DoctorList.filterDoctor(search);
        doctorsDisplayList.configTable(filteredList,HEADER_DOCTORS, USER_COLUMN_CLASSES);
    }


    private void updateButtonsState() {
        boolean hasDoctors = !DoctorList.getDoctors().isEmpty();
        boolean hasSelection = doctorsTable.getSelectedRow() != -1;
        showDetailsBtn.setEnabled(hasSelection);
        deleteButton.setEnabled(hasSelection);
        editButton.setEnabled(hasSelection);
        searchButton.setEnabled(true);
        addButton.setEnabled(true);
    }

    private void showDoctorssDetails(){
        Doctor selectedDoctor = getSelectedDoctor();
        if(selectedDoctor == null){
            JOptionPane.showMessageDialog(this, "Selectionner d'abord un médecin","Aucun client selectionné",  JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(doctorsPanel, selectedDoctor.showDetails(), "Détails du Médecin",  JOptionPane.INFORMATION_MESSAGE);
    }

    private Doctor getSelectedDoctor(){
        return getSelectedItem(doctorsDisplayList.getTable(), (TableModele<Doctor>) doctorsDisplayList.getTable().getModel());

    }


    private void addDoctor() {
        DoctorFormPanel formPanel = new DoctorFormPanel(new Doctor(), FormModes.ADD);
        formPanel.setVisible(true);
        formPanel.pack();
    }


    private void editDoctors(){
        Doctor selectedDoctors = getSelectedDoctor();
        if(selectedDoctors == null){
            JOptionPane.showMessageDialog(this, "Selectionner d'abord un Medecin","Aucun médecin selectionné",  JOptionPane.ERROR_MESSAGE);
            return;
        }
        DoctorFormPanel formPanel = new DoctorFormPanel(selectedDoctors, FormModes.EDIT);
        formPanel.setVisible(true);
        formPanel.pack();
    }

    private void deleteDoctor(){
        Doctor selectedDoctors = getSelectedDoctor();
        if(selectedDoctors == null){
            JOptionPane.showMessageDialog(this, "Selectionner d'abord un médecin","Aucun médecin selectionné",  JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Voulez-vous vraiment supprimer le médecin \"" + selectedDoctors.getFullName() + "\" ?",
                "Confirmation de suppression",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
        if (confirm == JOptionPane.YES_OPTION) {
            DoctorList.removeDoctor(selectedDoctors);
            repaint();
            revalidate();
            updateButtonsState();
        }
    }

    private void refreshTable(){
        doctorsDisplayList.configTable(DoctorList.getDoctors(),HEADER_DOCTORS, USER_COLUMN_CLASSES);
    }
}


