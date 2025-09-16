package fr.sparadrah.ecf.view.swingview;

import fr.sparadrah.ecf.model.lists.purchase.PurchasesList;
import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.model.purchase.CartItem;
import fr.sparadrah.ecf.model.purchase.Purchase;
import fr.sparadrah.ecf.utils.DateFormat;
import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.view.swingview.tablemodele.TableModele;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import static fr.sparadrah.ecf.model.lists.purchase.PurchasesList.getOldestPurchaseDate;
import static fr.sparadrah.ecf.view.swingview.DisplayList.*;

public class PurchaseHistoryPanel extends JPanel {
    private JPanel contentPane;
    private JPanel titlePanel;
    private JPanel topPanel;
    private JPanel filterPanel;
    private JComboBox periodComboBox;
    private JButton filterBtn;
    private JPanel centerPanel;
    private JPanel buttonPanel;
    private JButton detailsBtn;
    private JButton returnBtn;
    private JButton exitBtn;
    private JPanel tablePanel;
    private JPanel detailsContainer;
    private JTable table1;
    private JPanel detailsTitlePanel;
    private JPanel detailsPanel;
    private JLabel detailsTitle;
    private JLabel dateLabel;
    private JLabel customerNameLabel;
    private JLabel typeLabel;
    private JLabel doctorNameLabel;
    private JLabel totalAmount;
    private JLabel medicinesLabel;
    private JLabel purchasesHistoryTitleLabel;
    private JLabel dateLabelDetail;
    private JLabel customerLabelDetail;
    private JLabel typeDetail;
    private JLabel doctorDetail;
    private JLabel totatAmountDetail;
    private JTextArea detailMedicinesArea;
    private JTextField dateField;
    private JTextField periodStartField;
    private JTextField periodEndField;
    DisplayList purchases;

    JTable purchasesTable;

    public PurchaseHistoryPanel() {
        this.add(contentPane);

        purchases = new DisplayList(4);
        purchasesTable = purchases.getTable();
        tablePanel.add(purchases);


        // purchasesTable = purchases.getTable();
        //purchasesHistoryTitleLabel.setText("Historique des Achats (" + purchasesTable.getRowCount() + " achats)");


        detailsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPurchaseDetails();
            }
        });
        periodComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) periodComboBox.getSelectedItem();
                dateField.setVisible(selected.equalsIgnoreCase("Date personnalisée"));
                periodStartField.setVisible(selected.equalsIgnoreCase("Période personnalisée"));
                periodEndField.setVisible(selected.equalsIgnoreCase("Période personnalisée"));
                revalidate();
                repaint();
            }
        });
        filterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    List<Purchase> filteredPurchases;
                    switch (periodComboBox.getSelectedItem().toString()) {
                        case "Aujourd'hui":
                            filteredPurchases = PurchasesList.findPurchaseOfDay();
                            System.out.println(filteredPurchases);
                            break;
                        case "Date personnalisée":
                            if (dateField.getText().trim().equals("")) {
                                    throw new SaisieException("Remplir le champ date avant de filtrer les achats");
                            }
                            filteredPurchases = PurchasesList.findPurchaseByDate(dateField.getText());
                            break;
                        case "Période personnalisée":
                            if (periodStartField.getText().trim().equals("") && periodEndField.getText().trim().equals("")) {
                                throw new SaisieException("Remplir les champs date avant de filtrer les achats");
                            }
                            if(periodEndField.getText().trim().equals("")){
                                periodEndField.setText(DateFormat.formatDate(LocalDate.now(), "dd/MM/yyyy"));
                            }
                            if(periodStartField.getText().trim().equals("")){
                                periodStartField.setText(DateFormat.formatDate(getOldestPurchaseDate(), "dd/MM/yyyy"));
                            }
                            filteredPurchases = PurchasesList.findPurchasebyPeriod(periodStartField.getText(), periodEndField.getText());
                            break;
                        default:
                            filteredPurchases = PurchasesList.getPurchases();
                            System.out.println("Aucun filtre appliqué");
                            break;
                    }
                    purchases.configTable(filteredPurchases, HEADER_PURCHASES, PURCHASE_COLUMN_CLASSES );
                }catch (SaisieException ex){
                    JOptionPane.showMessageDialog(null,"Erreur de saisie : " + ex.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
                }



            }
        });
    }


    private Purchase  selectPurchase(){
        Purchase selectedPurchase = getSelectedItem(purchasesTable, (TableModele<Purchase>) purchasesTable.getModel());
        return selectedPurchase;
    };




    private void displayPurchaseDetails() {

        if(selectPurchase()!=null){
            detailsPanel.setVisible(true);
            Purchase selectedPurchase = selectPurchase();
            Customer customer = selectedPurchase.getCustomer();

            detailsTitle.setText("Détails de l'achat");
            customerLabelDetail.setText( customer.getFullName());
            dateLabelDetail.setText(DateFormat.formatDate(selectedPurchase.getPurchaseDate(), "dd/MM/yyyy"));
            typeDetail.setText(selectedPurchase.isPrescriptionBased()? "Achat sur ordonnance" : "Achat direct");
            if (selectedPurchase.getCustomer().getDoctor() != null) {
                doctorDetail.setText(selectedPurchase.getCustomer().getDoctor().getFullName());
            } else {
                doctorDetail.setText("Aucun médecin");
            }
            totatAmountDetail.setText(selectedPurchase.getTotal() + "");

            StringBuilder medicinesList = new StringBuilder();
            for (CartItem med : selectedPurchase.getMedicines()) {
                medicinesList.append("• ").append(med.getMedicine().getMedicineName())
                        .append(" (").append(med.getMedicine().getCategory()).append(")")
                        .append("\n  Prix : ").append((med.getPrice()))
                        .append("\n  Quantité : ").append(med.getQuantity())
                        .append("\n\n");
            }
            detailMedicinesArea.setText(medicinesList.toString());

        }else{
            detailsPanel.setVisible(false);
        }
    }




}
