package fr.sparadrah.ecf.view.swingview.tablemodel;

import fr.sparadrah.ecf.model.medicine.Medicine;
import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.model.person.Doctor;
import fr.sparadrah.ecf.utils.DateFormat;

import javax.swing.table.AbstractTableModel;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TableModel<T> extends AbstractTableModel {
    private final List<T> data;
    private final String[] columnNames;
    private final Class<?>[] columnClasses;
    private final DateTimeFormatter FORMATTER_DATE_FRENCH = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public TableModel(List<T> data, String[] columnNames, Class<?>[] columnClasses) {
        this.data = data;
        this.columnNames = columnNames;
        this.columnClasses = columnClasses;
    }


    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClasses[columnIndex];
    }





    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        T item = data.get(rowIndex);
        // Add custom logic here to return the value based on the column index and the item type
        if (item instanceof Customer user) {
            return switch (columnIndex) {
                case 0 -> user.getFullName();
                case 1 -> user.getEmail();
                case 2 -> user.getPhone();
                case 3 -> user.getCity();
                case 4 -> user.getNir();
                default -> null;
            };
        } else if (item instanceof Doctor doctor) {
            return switch (columnIndex) {
                case 0 -> doctor.getFullName();
                case 1 -> doctor.getEmail();
                case 2 -> doctor.getPhone();
                case 3 -> doctor.getCity();
                case 4 -> doctor.getLicenseNumber();

                default -> null;
            };
        } else if (item instanceof Medicine medicine) {
            return switch (columnIndex) {
                case 0 -> medicine.getMedicineName();
                case 1 -> medicine.getCategoryName();
                case 2 -> medicine.getPrice();
                case 3 -> medicine.getStock();
                case 4 -> DateFormat.formatDate(medicine.getReleaseDate(), "dd/MM/yyyy");
                default -> null;

            };
        }
        return null;
    }



}
