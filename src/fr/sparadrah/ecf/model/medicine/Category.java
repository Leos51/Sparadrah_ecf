package fr.sparadrah.ecf.model.medicine;

import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.utils.validator.Validator;

public class Category {
    private String categoryName;

    public Category(String categoryName) throws SaisieException {
        this.setCategoryName(categoryName);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) throws SaisieException {
        if (categoryName == null || categoryName.isEmpty()){
            throw new SaisieException("Le nom de la categorie ne peut pas etre vide");
        }
        this.categoryName = categoryName;
    }



    @Override
    public String toString() {
        return this.getCategoryName();
    }
}

