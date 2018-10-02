package suwu.flowerapp.blservice.flower;

import suwu.flowerapp.exception.*;
import suwu.flowerapp.parameters.flower.*;
import suwu.flowerapp.response.flower.*;

public interface FlowerBlService {
    /**
     * get all flower types
     * @return
     */
    FlowerTypesGetResponse getFlowerTypes();

    /**
     * get flower by flower id
     * @param typeId
     * @return
     * @throws FlowerTypeDoesNotExistException
     */
    FlowerGetByTypeResponse getFlowerByType(int typeId) throws FlowerTypeDoesNotExistException;

    /**
     * get flower detail by id
     * @param flowerId
     * @return
     * @throws FlowerIdNotExistedException
     */
    FlowerDetailResponse getFlowerDetailById(int flowerId) throws FlowerIdNotExistedException;

    /**
     * add flower type
     * @param flowerTypePutParameters
     * @return
     */
    FlowerTypeAddResponse addFlowerType(FlowerTypePutParameters flowerTypePutParameters);

    /**
     * delete flower type
     * @param flowerTypeDeleteParameters
     * @return
     */
    FlowerTypeDeleteResponse deleteFlowerType(FlowerTypeDeleteParameters flowerTypeDeleteParameters);

    /**
     * update flower type
     * @param flowerTypePostParameters
     * @return
     * @throws FlowerTypeDoesNotExistException
     */
    FlowerTypePostResponse postFlowerType(FlowerTypePostParameters flowerTypePostParameters) throws FlowerTypeDoesNotExistException;

    /**
     * delete flower by flower id
     * @param flowerId
     * @return
     */
    FlowerDeleteResponse deleteSupplierFlowerById(int flowerId);

    /**
     * add flower
     * @param flowerAddParameters
     * @return
     */
    SupplierFlowerAddResponse addSupplierFlower(FlowerAddParameters flowerAddParameters);

    /**
     * update flower
     * @param flowerPostParameters
     * @return
     * @throws FlowerIdNotExistedException
     */
    FlowerPostResponse postFlower(FlowerPostParameters flowerPostParameters) throws FlowerIdNotExistedException;
}
