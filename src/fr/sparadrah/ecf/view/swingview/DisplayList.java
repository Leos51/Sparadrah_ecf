package fr.sparadrah.ecf.view.swingview;

import javax.swing.*;

public class DisplayList extends JPanel {
    JScrollPane scrollPane =  new JScrollPane();

    private final String[] HEADER_CUSTOMERS = new String[] {"Nom", "Email", "Téléphone",  "Ville", "N° NIR"};
    private final String[] HEADER_DOCTORS = new String[] {"Nom", "Email", "Téléphone", "Ville", "N° agréement"};
    private final String[] HEADER_MEDICINE = new String[] {"Nom", "Categorie", "Prix", "Stock", "Pdv", "Date"};



    private final Class<?>[] USER_COLUMN_CLASSES = {String.class, String.class, String.class, Integer.class, Integer.class, Integer.class};

    private final String[] HEADER_GROUPE = new String[] {"Nom", "Nom du Guerrier", "Nom du Soigneur", "Date de création"};
    private final Class<?>[] GROUPE_COLUMN_CLASSES = {String.class, String.class, String.class, String.class};
}
