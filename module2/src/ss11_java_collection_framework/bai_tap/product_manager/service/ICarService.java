package ss11_java_collection_framework.bai_tap.product_manager.service;

import ss11_java_collection_framework.bai_tap.product_manager.model.Car;

public interface ICarService extends IProductService<Car>{
    boolean checkElementExistsById(int id);
    boolean checkElementExistsByName(String name);
}
