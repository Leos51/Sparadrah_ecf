package fr.sparadrah.ecf.controller;


import fr.sparadrah.ecf.model.lists.CategoriesList;
import fr.sparadrah.ecf.model.medication.Category;

public class CategoriesController {
    public static void seedCategoriesData(){
        CategoriesList.addCategory(new Category("Analgésiques"));
        CategoriesList.addCategory(new Category("Anti-inflammatoires"));
        CategoriesList.addCategory(new Category("Antiviraux"));
        CategoriesList.addCategory(new Category("Antibiotiques"));
        CategoriesList.addCategory(new Category("Antibiotiques"));
    }
}
