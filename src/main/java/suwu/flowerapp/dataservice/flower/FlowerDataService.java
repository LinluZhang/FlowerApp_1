package suwu.flowerapp.dataservice.flower;

import suwu.flowerapp.entity.flower.Flower;
import suwu.flowerapp.exception.FlowerIdNotExistedException;
import suwu.flowerapp.exception.FlowerTypeDoesNotExistException;

import java.util.List;

public interface FlowerDataService {

    /**
     * get flower by flower type id
     * @param typeId
     * @return
     * @throws FlowerTypeDoesNotExistException
     */
    List<Flower> getFlowersByTypeId(int typeId) throws FlowerTypeDoesNotExistException;

    /**
     * get flower by flower id
     * @param flowerId
     * @return
     * @throws FlowerIdNotExistedException
     */
    Flower getFlowerByFlowerId(int flowerId)throws FlowerIdNotExistedException;

    /**
     * delete flower type by flower type id
     * @param id
     */
    void deleteFlowerType(int id);

    /**
     * delete flower by flower id
     * @param flowerId
     */
    void deleteFlowerByFlowerId(int flowerId);

    /**
     * save flower
     * @param flower
     * @return
     */
    Flower saveFlower(Flower flower);
}
