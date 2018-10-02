package suwu.flowerapp.dataservice.flower;

import suwu.flowerapp.entity.flower.FlowerType;
import suwu.flowerapp.exception.FlowerTypeDoesNotExistException;
import suwu.flowerapp.exception.FlowerTypeIdNotExistedException;

import java.util.List;

public interface FlowerTypeDataService {
    /**
     * get all flower types
     * @return
     */
    List<FlowerType> getAllFlowerTypes();

    /**
     * add flower type
     * @param name
     * @return
     */
    FlowerType addType(String name);

    /**
     * save flower type
     * @param flowerType
     * @return
     */
    FlowerType saveFlowerType(FlowerType flowerType);

    /**
     * get flower type by flower type id
     * @param flowerId
     * @return
     */
    FlowerType getFlowerTypeByFlowerId(int flowerId);

}
