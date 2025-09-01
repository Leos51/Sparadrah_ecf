package fr.sparadrah.ecf.model.medication;

public class Category {
    private String categoryName;

    public Category(String categoryName) {
        this.setCategoryName(categoryName);
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return this.getCategoryName();
    }
}

