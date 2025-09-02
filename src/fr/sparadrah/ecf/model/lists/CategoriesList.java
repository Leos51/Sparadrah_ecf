package fr.sparadrah.ecf.model.lists;

import fr.sparadrah.ecf.model.medicine.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoriesList {
    private static List<Category> categories = new ArrayList<Category>();

    public static List<Category> getCategories() {
        return categories;
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public static void addCategory(Category category) {
        getCategories().add(category);
    }
    public void deleteCategory(Category category) {
        this.getCategories().remove(category);
    }

    public static Category findCategoryByName(String name){
        for (Category category : categories) {
            if(name.equals(category.getCategoryName())){
                return category;
            }
        }
        return null;
    }


}
