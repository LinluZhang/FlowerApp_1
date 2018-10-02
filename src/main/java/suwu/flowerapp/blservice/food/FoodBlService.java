package suwu.flowerapp.blservice.food;

import suwu.flowerapp.exception.FoodIdDoesNotExistException;
import suwu.flowerapp.exception.PortDoesNotExistException;
import suwu.flowerapp.parameters.food.*;
import suwu.flowerapp.response.event.EventFoodLoadResponse;
import suwu.flowerapp.response.food.*;
import suwu.flowerapp.exception.FoodIdDoesNotExistException;
import suwu.flowerapp.exception.PortDoesNotExistException;
import suwu.flowerapp.parameters.food.*;

public interface FoodBlService {
    /**
     * load all foods
     *
     * @return
     */
    FoodLoadResponse loadFoods();

    /**
     * add food
     *
     * @return
     */
    FoodAddResponse addFood(FoodAddParameters foodAddParameters, String supplierUsername) throws PortDoesNotExistException;

    /**
     * load foods by supplier id
     *
     * @param username
     * @return
     */
    SupplierFoodLoadResponse loadSupplierFood(String username);

    /**
     * load food by food id
     *
     * @param foodId
     * @return
     */
    SupplierFoodDetailResponse loadSupplierFoodById(int foodId) throws FoodIdDoesNotExistException;

    /**
     * delete food by id
     *
     * @param foodId
     * @return
     */
    SupplierFoodDeleteResponse deleteSupplierFoodById(int foodId);

    /**
     * update food whole
     *
     * @param supplierFoodUpdateParameters
     * @param supplierUsername
     * @return
     */
    SupplierFoodUpdateResponse updateSupplierFoodById(SupplierFoodUpdateParameters supplierFoodUpdateParameters, String supplierUsername) throws PortDoesNotExistException, FoodIdDoesNotExistException;

    /**
     * shelf food by ids
     *
     * @param supplierFoodShelfParameters
     * @return
     */
    SupplierFoodShelfResponse shelfSupplierFood(SupplierFoodShelfParameters supplierFoodShelfParameters) throws FoodIdDoesNotExistException;

    /**
     * shelf off food by ids
     *
     * @param supplierFoodShelfOffParameters
     * @return
     */
    SupplierFoodShelfOffResponse shelfOffSupplierFood(SupplierFoodShelOffParameters supplierFoodShelfOffParameters) throws FoodIdDoesNotExistException;

    /**
     * load foods for event
     *
     * @param username
     * @return
     */
    EventFoodLoadResponse loadEventFood(String username);

    /**
     * add a port
     *
     * @param portAddParameters
     * @return
     */
    PortAddResponse addPort(PortAddParameters portAddParameters);

    /**
     * load all ports
     *
     * @return
     */
    PortLoadResponse loadPorts();

    /**
     * delete a port
     *
     * @param portId
     * @return
     */
    PortDeleteResponse deletePort(int portId) throws PortDoesNotExistException;

    /**
     * load a food's detail
     *
     * @param foodId
     * @return
     */
    FoodDetailLoadResponse loadFoodDetail(int foodId) throws FoodIdDoesNotExistException;
}
