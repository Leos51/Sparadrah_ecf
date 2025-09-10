package fr.sparadrah.ecf.view.swingview;

import fr.sparadrah.ecf.model.lists.medicine.MedicineList;
import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.model.lists.person.DoctorList;
import fr.sparadrah.ecf.view.swingview.tablemod.TableMod;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.List;

public class DisplayList extends JPanel {
    JPanel listTitlePanel;
    JScrollPane scrollPane = new JScrollPane();
    JTable table = new JTable();
    JLabel tableLabel = new JLabel();


    private final String[] HEADER_CUSTOMERS = new String[]{"Nom", "Email", "Téléphone", "Ville", "N° NIR"};
    private final String[] HEADER_DOCTORS = new String[]{"Nom", "Email", "Téléphone", "Ville", "N° agréement"};
    private final String[] HEADER_MEDICINE = new String[]{"Nom", "Categorie", "Prix", "Stock", "Date"};


    private final Class<?>[] USER_COLUMN_CLASSES = {String.class, String.class, String.class, String.class, String.class};

    private final Class<?>[] MEDICINE_COLUMN_CLASSES = {String.class, String.class, Double.class, Integer.class, String.class};


    public DisplayList(int type) {
        this.setBackground(Color.red);
        this.setLayout(new BorderLayout());
        JLabel tableLabel = new JLabel();
        tableLabel.setForeground(Color.white);
       this.add(tableLabel, BorderLayout.NORTH);
       this.add(scrollPane, BorderLayout.CENTER);
       scrollPane.setViewportView(table);



        switch (type) {
            case 0:
                tableLabel.setText("Liste des Clients:");
                configTable(CustomersList.getCustomers(),HEADER_CUSTOMERS,USER_COLUMN_CLASSES);
                break;

            case 1:
                tableLabel.setText("Liste des Medecins:");
                configTable(DoctorList.getDoctors(),HEADER_DOCTORS,USER_COLUMN_CLASSES);
                break;
            case 2:
                tableLabel.setText("Liste des médicaments:");
                configTable(MedicineList.getMedicines(),HEADER_MEDICINE,MEDICINE_COLUMN_CLASSES);
                break;
            default:
                break;
        }
    }



    private <T> void configTable(List<T> list, String[] headers, Class<?>[] columnClasses) {
        TableModel model = new TableMod<>(list, headers, columnClasses);
        this.table.setModel(model);
        this.table.revalidate();
        this.table.repaint();

    }






}
