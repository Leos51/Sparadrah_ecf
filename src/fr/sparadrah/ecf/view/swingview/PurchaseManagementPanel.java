package fr.sparadrah.ecf.view.swingview;

import fr.sparadrah.ecf.model.lists.medicine.CategoriesList;
import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.model.lists.purchase.PurchasesList;
import fr.sparadrah.ecf.model.medicine.Category;
import fr.sparadrah.ecf.model.medicine.Medicine;
import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.model.purchase.Purchase;
import fr.sparadrah.ecf.model.purchase.CartItem;
import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.view.swingview.tablemod.TableMod;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static fr.sparadrah.ecf.view.swingview.DisplayList.getSelectedItem;

public class PurchaseManagementPanel extends  JPanel {
    private static List<CartItem> cart = new ArrayList<>();

    private Customer selectedCustomer;
    private Medicine selectedMedicine;


    Component PurchaseManagementPanel;
    private JPanel purchasePanel;
    private JPanel titlePanel;

    private JPanel centerPanel;
    private JPanel buttonPanel;
    private JPanel customerPanel;
    private JPanel customerSearchPanel;
    private JPanel cartPanel;
    private JPanel leftPanel;
    private JPanel medicinePanel;
    private JPanel cartButtonPanel;
    private JPanel bottomPanel;

    private JLabel titleLabel;

    private JButton validatePurchaseBtn, annulerButton;
    private JButton removeFromCartBtn;
    private JButton selectCustomerButton;

    private JTextField customerSearchField;

    private JSpinner quantitySpinner;


    private JComboBox categoryComboBox;
    private JPanel customerTablePanel;
    private JPanel medicineTablePanel;
    private JPanel medicineSearchPanel;
    private JPanel cartTablePanel;
    private JPanel totalPanel;
    private JLabel totalLabel;
    private JPanel InformationsPanel;
    private JTextArea infoArea;
    private JLabel customerSelectedLabel;
    private JButton addToCartBtn;
    private JButton searchMedicineBtn;
    private JButton searchCustomerBtn;


    // Panneaux avec DisplayList
    private DisplayList medicineDisplayList;
    DisplayList customerDisplayList;
    DisplayList cartDisplayList;

    JTable customerTable;
    JTable medicineTable;
    JTable cartTable;

    Boolean hasPrescription;


    Purchase currentPurchase = new Purchase();



    public PurchaseManagementPanel(Boolean hasPrescription){
        this.hasPrescription = hasPrescription;

        this.add(purchasePanel);
        if(hasPrescription){
            this.titleLabel.setText("Achat avec ordonnance!");
        }else{
            this.titleLabel.setText("Achat direct!");
        }
try{
    initialize();
}catch(Exception e){
    System.out.println("Erreur init" + e.getMessage());
}


        selectCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectCustomer();
                updateCustomerInfo(selectedCustomer);
                updateButtonStates();
            }
        });
        addToCartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToCart();
                updateButtonStates();
            }
        });
        removeFromCartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeFromCart();
                updateButtonStates();
            }
        });
        annulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelPurchase();
            }
        });
        validatePurchaseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validatePurchase();
            }
        });
    }

    public static List<CartItem> getCart() {
        return cart;
    }

    public void setCart(List<CartItem> cart) {
        this.cart = cart;
    }


    private void initialize() throws SaisieException {
        //Combobox Selection des categories des médicaments
        Category allCategories = new Category("Catégorie : Toutes");
        categoryComboBox.addItem(allCategories);
        CategoriesList.getCategories().forEach(category -> {
            categoryComboBox.addItem(category);
        });

        // Utilisation de DisplayList pour les clients (type 0)
        customerDisplayList = new DisplayList(0);


        customerTablePanel.add(customerDisplayList);
        // Utilisation de DisplayList pour les médicaments (type 2)
        medicineDisplayList = new DisplayList(2);
        medicineTablePanel.add(medicineDisplayList);
        // Utilisation de DisplayList pour le panier (type 3)
        cartDisplayList = new DisplayList(3);
        cartTablePanel.add(cartDisplayList);

        customerTable = customerDisplayList.getTable();
        medicineTable = medicineDisplayList.getTable();
        cartTable = cartDisplayList.getTable();

    }

    private void updateCustomerInfo(Customer selectedCustomer) {

        if (selectedCustomer != null) {

            if (infoArea != null) {
                StringBuilder info = new StringBuilder();
                info.append("Client: ").append(selectedCustomer.getFullName()).append("\n");

                if (hasPrescription) {
                    if (selectedCustomer.getMutualInsurance() != null) {
                        double rate = selectedCustomer.getMutualInsurance().getReimbursementRate();
                        info.append("Mutuelle: ").append(selectedCustomer.getMutualInsurance().getCompagnyName()).append("\n");
                        info.append("Taux de remboursement: ").append((int)(rate * 100)).append("%");
                    } else {
                        info.append("Aucune mutuelle\n");
                        info.append("Pas de remboursement");
                    }
                } else {
                    if (selectedCustomer.getMutualInsurance() != null) {
                        info.append("Mutuelle: ").append(selectedCustomer.getMutualInsurance().getCompagnyName()).append("\n");
                        info.append("Pas de remboursement (Pas de prescription)");
                    } else {
                        info.append("Aucune mutuelle\n");
                        info.append("Pas de remboursement");
                    }
                }


                infoArea.setText(info.toString());
            }
        }
    }

    private void selectCustomer(){
            selectedCustomer = getSelectedItem(customerTable, (TableMod<Customer>) customerTable.getModel());
            if(selectedCustomer != null){
                customerSelectedLabel.setText("Client: " + selectedCustomer);
                customerSelectedLabel.setForeground(new Color(0, 128, 0));

                // Créer un nouvel achat

                currentPurchase.setCustomer(selectedCustomer);
                currentPurchase.setPrescriptionBased(hasPrescription);
            }
    }

    private void addToCart(){
        selectedMedicine = getSelectedItem(medicineDisplayList.getTable(), (TableMod<Medicine>) medicineDisplayList.getTable().getModel());
        int quantity = (Integer) quantitySpinner.getValue();

        // Vérifier le stock
        if(quantity > selectedMedicine.getStock()){
            JOptionPane.showMessageDialog(this,
                    "Stock insuffisant! Stock disponible: " + selectedMedicine.getStock(),
                    "Stock insuffisant", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Verifier si Item deja au panier
        CartItem existingItem = cart.stream()
                .filter(item-> item.getMedicine().equals(selectedMedicine))
                .findFirst()
                .orElse(null);

        if(existingItem != null){
            int newQuantity = existingItem.getQuantity() + quantity;
            if(newQuantity > selectedMedicine.getStock()){
                JOptionPane.showMessageDialog(this,
                        "Stock insuffisant! Stock disponible: " + selectedMedicine.getStock() +
                                ", Quantité déjà dans le panier: " + existingItem.getQuantity(),
                        "Stock insuffisant", JOptionPane.WARNING_MESSAGE);
                return;
            }
            existingItem.setQuantity(newQuantity);
            updateTotal();


        }else{
            cart.add(new CartItem(selectedMedicine, quantity));
            updateTotal();
        }
        medicineTable.repaint();
        medicineTable.revalidate();
        cartTable.repaint();
        cartTable.revalidate();
    }

    private void removeFromCart() {
        CartItem selectedItem = getSelectedItem(cartTable, (TableMod<CartItem>) cartTable.getModel());
        int selectedRow = cartTable.getSelectedRow();
        if (selectedRow != -1) {
            CartItem removed = cart.remove(selectedRow);
            updateTotal();

            JOptionPane.showMessageDialog(this,
                    removed.getMedicine().getMedicineName() + " retiré du panier!",
                    "Suppression réussie", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private double calculateTotal(){
        return cart.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    private void updateTotal() {
        double total = calculateTotal();
        totalLabel.setText("Total: " + total);

        // Afficher aussi le montant après remboursement
        if (selectedCustomer != null && selectedCustomer.getMutualInsurance() != null && currentPurchase.isPrescriptionBased()) {
            double reimbursement = total * selectedCustomer.getMutualInsurance().getReimbursementRate();
            double finalAmount = total - reimbursement;
            totalLabel.setText("Total: " + (total) +
                    "\nÀ payer: " + finalAmount);
        }
    }

    private void validatePurchase(){
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Le panier est vide!", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Calculer le total et créer le résumé
        double total = calculateTotal();
        double reimbursement = 0;
        if (selectedCustomer.getMutualInsurance() != null && currentPurchase.isPrescriptionBased()) {
            reimbursement = total * selectedCustomer.getMutualInsurance().getReimbursementRate();
        }

        double finalAmount = total - reimbursement;

        StringBuilder summary = new StringBuilder();
        summary.append("=== RÉSUMÉ DE L'ACHAT ===\n\n");
        summary.append("Client: ").append(selectedCustomer.getFullName()).append("\n");
        summary.append("Type d'achat: ").append(titleLabel).append("\n\n");

        summary.append("Détail des articles:\n");
        for (CartItem item : cart) {
            summary.append(String.format("• %s x%d = %s\n",
                    item.getMedicine().getMedicineName(),
                    item.getQuantity(),
                    item.getTotalPrice()));
        }
        summary.append("\n");
        summary.append("Sous-total: ").append(total).append("\n");

        if (reimbursement > 0) {
            summary.append("Remboursement mutuelle: ").append(reimbursement).append("\n");
            summary.append("TOTAL À PAYER: ").append(finalAmount).append("\n");
        } else {
            summary.append("TOTAL À PAYER: ").append(total).append("\n");
        }
        int result = JOptionPane.showConfirmDialog(this,
                summary.toString(),
                "Confirmer l'achat",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            processPurchase();
        }


    }


    private void processPurchase(){
        // Ajouter les médicaments à l'achat et réduire les stocks
        for(CartItem item : cart){
            currentPurchase.addMedicine(item.getMedicine(), item.getQuantity());
        }
        // Ajouter l'achat à la liste des achats
        PurchasesList.addPurchase(currentPurchase);
        JOptionPane.showMessageDialog(this, "Achat validé avec succès!", "Succès", JOptionPane.INFORMATION_MESSAGE);
        resetForm();

    }



    private void cancelPurchase() {
        if (!cart.isEmpty() || selectedCustomer != null) {
            int result = JOptionPane.showConfirmDialog(this,
                    "Êtes-vous sûr de vouloir annuler cet achat?",
                    "Confirmation", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                resetForm();
            }
        }
    }

    private void resetForm() {
        selectedCustomer = null;
        currentPurchase = new Purchase();
        for(CartItem cartItem : cart){
            cart.remove(cartItem);
        }
        customerSelectedLabel.setText("Aucun client sélectionné");
        customerSelectedLabel.setForeground(Color.RED);
        updateTotal();
        customerTable.clearSelection();
        medicineTable.clearSelection();
        quantitySpinner.setValue(1);

        // Reset info area
        if (infoArea != null) {
            infoArea.setText("Sélectionnez un client pour voir les informations de remboursement.");
        }
    }

    private void searchCustomers() {
        String search = customerSearchField.getText().trim();
        List<Customer> filteredList = CustomersList.searchCustomer(search);


    }

    private void updateButtonStates() {
        boolean hasCustomer = selectedCustomer != null;
        boolean hasItemsInCart = !cart.isEmpty();

        addToCartBtn.setEnabled(hasCustomer);
        validatePurchaseBtn.setEnabled(hasCustomer && hasItemsInCart);
    }



}
