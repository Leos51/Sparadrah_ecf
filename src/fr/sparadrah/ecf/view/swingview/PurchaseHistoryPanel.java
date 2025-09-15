package fr.sparadrah.ecf.view.swingview;

import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.model.purchase.CartItem;
import fr.sparadrah.ecf.model.purchase.Purchase;
import fr.sparadrah.ecf.utils.DateFormat;
import fr.sparadrah.ecf.view.swingview.tablemod.TableMod;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static fr.sparadrah.ecf.view.swingview.DisplayList.getSelectedItem;

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
    DisplayList purchases;

    JTable purchasesTable;

    public PurchaseHistoryPanel() {
        this.add(contentPane);

        purchases = new DisplayList(4);
        tablePanel.add(purchases);


        // purchasesTable = purchases.getTable();
        //purchasesHistoryTitleLabel.setText("Historique des Achats (" + purchasesTable.getRowCount() + " achats)");




        // ComboBox pour la période
        String[] periodes = {
                "Aujourd'hui",
                "Cette semaine",
                "Ce mois",
                "Période personnalisée"
        };
        for(String periode : periodes){
            periodComboBox.addItem(periode);
        }

        detailsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //displayPurchaseDetails();
            }
        });


    }


    private Purchase  selectPurchase(){
        Purchase selectedPurchase = getSelectedItem(purchasesTable, (TableMod<Purchase>) purchasesTable.getModel());
        return selectedPurchase;
    };




    private void displayPurchaseDetails() {

        if(selectPurchase()!=null){
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
                        .append(" (").append(med.getMedicine().getCategoryName()).append(")")
                        .append("\n  Prix : ").append((med.getMedicine().getPrice()))
                        .append("\n  Quantité disponible : ").append(med.getMedicine().getStock())
                        .append("\n\n");
            }
            detailMedicinesArea.setText(medicinesList.toString());

        }
    }




}
