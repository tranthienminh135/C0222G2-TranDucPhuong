package ss11_java_collection_framework.bai_tap.product_manager.service;

public interface IProductService<T> {
    void addNewProduct();
    void displayProduct();
    void deleteById();
    void updateById();
    void searchByName();
    void sortAscendingByPrice();
    void sortDescendingByPrice();

}
