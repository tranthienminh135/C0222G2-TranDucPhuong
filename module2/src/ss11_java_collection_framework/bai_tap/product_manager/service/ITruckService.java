package ss11_java_collection_framework.bai_tap.product_manager.service;

import ss11_java_collection_framework.bai_tap.product_manager.service.IProductService;

public interface ITruckService extends IProductService {
    boolean checkElementExistsById(int id);
    boolean checkElementExistsByName(String name);
}
