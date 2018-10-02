package suwu.flowerapp.response.food;

import suwu.flowerapp.response.Response;

import java.util.List;

public class SupplierFoodLoadResponse extends Response {
    List<SupplierFoodItem> supplierFoodItems;

    public SupplierFoodLoadResponse() {
    }

    public SupplierFoodLoadResponse(List<SupplierFoodItem> supplierFoodItems) {
        this.supplierFoodItems = supplierFoodItems;
    }

    public List<SupplierFoodItem> getSupplierFoodItems() {
        return supplierFoodItems;
    }

    public void setSupplierFoodItems(List<SupplierFoodItem> supplierFoodItems) {
        this.supplierFoodItems = supplierFoodItems;
    }
}
