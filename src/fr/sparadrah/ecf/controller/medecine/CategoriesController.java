package fr.sparadrah.ecf.controller.medecine;


import fr.sparadrah.ecf.model.lists.medicine.CategoriesList;
import fr.sparadrah.ecf.model.medicine.Category;

public class CategoriesController {
    public static void seedCategoriesData(){
        CategoriesList.addCategory(new Category("Analgésiques"));
        CategoriesList.addCategory(new Category("Anti-inflammatoires"));
        CategoriesList.addCategory(new Category("Antiviraux"));
        CategoriesList.addCategory(new Category("Antibiotiques"));

    }


}
