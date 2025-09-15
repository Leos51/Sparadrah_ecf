package fr.sparadrah.ecf.model.medicine;

import fr.sparadrah.ecf.utils.DateFormat;
import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.utils.exception.StockInsuffisantException;
import fr.sparadrah.ecf.utils.validator.Validator;

import java.time.LocalDate;

public class Medicine {
    private String medicineName;
    private Category category;
    private double price;
    private LocalDate releaseDate;
    private int stockQuantity;
    private int threshold = 10;


    public Medicine(String medicineName, Category category, double price, String releaseDate, int stockQuantity) throws SaisieException {
        this.setMedicineName(medicineName);
        this.setCategory(category);
        this.setPrice(price);
        this.setReleaseDate(releaseDate);
        this.setStock(stockQuantity);
    }

    public String getMedicineName() {
        return medicineName;
    }
    public void setMedicineName(String medicineName) throws SaisieException {
        if(medicineName == null || medicineName.isEmpty()){
            throw new SaisieException("Le nom du médicament ne doit pas etre vide");
        }
        if (!Validator.isValidName(medicineName)) {
            throw new SaisieException("Nom de medicament invalide");
        }
        this.medicineName = medicineName;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) throws SaisieException {
        if(category == null){
            throw new SaisieException("La categorie ne peut pas etre vide");
        }
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) throws SaisieException {
        if(!(price > 0)){
            throw new SaisieException("Prix invalide");
        }
        this.price = price;
    }
    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) throws SaisieException {
        if(releaseDate == null || releaseDate.isEmpty()){
            throw new SaisieException("La date de sortie ne peut pas etre vide");
        }
        this.releaseDate = DateFormat.parseDateFromString(releaseDate);
    }
    public int getStock() {
        return stockQuantity;
    }
    public void setStock(int quantity) throws SaisieException {
        if(!(quantity >= 0)){
            throw new SaisieException("Saisie de la quantité de medicament invalide");
        }
        this.stockQuantity = quantity;
    }

    public void reduceStock(int quantityToReduce)  {
        if (quantityToReduce > this.stockQuantity) {
            throw new StockInsuffisantException("Stock insuffisant !");
        }
        this.stockQuantity -= quantityToReduce;
        if(isLowStock(threshold)) {
            System.out.println("Stock bas - A restocker : " + this.getMedicineName());
        }
    }

    public void reduceQuantityByOne() {
        if (stockQuantity > 0) {
            stockQuantity --;
        }
        if(isLowStock(threshold)) {
            System.out.println("Stock bas - A restocker : " + this.getMedicineName());
        }
    }

    public void restock(int quantity) throws SaisieException {
        if (!(quantity > 0)) {
            throw new SaisieException("Saisie de quantité invalide !");
        }

        this.stockQuantity += quantity;
    }


    public boolean isOutOfStock(){
        return this.stockQuantity == 0;
    }

    public boolean isLowStock(int threshold) {
       return this.getStock() <= threshold ;
    }




    @Override
    public String toString() {
        return "nom : " + medicineName + " " +
                ", Prix : " + price +
                ", Quantité Stock : " + this.getStock() +"\n";
    }
}
