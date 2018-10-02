package suwu.flowerapp.bl.flower;

import org.springframework.beans.factory.annotation.Autowired;
import suwu.flowerapp.blservice.flower.FlowerBlService;
import suwu.flowerapp.dataservice.account.UserDataService;
import suwu.flowerapp.dataservice.flower.FlowerDataService;
import suwu.flowerapp.dataservice.flower.FlowerTypeDataService;
import suwu.flowerapp.dataservice.order.OrderDataService;
import suwu.flowerapp.entity.flower.Flower;
import suwu.flowerapp.entity.flower.FlowerType;
import suwu.flowerapp.exception.*;
import suwu.flowerapp.parameters.flower.*;
import suwu.flowerapp.publicdatas.flower.FlowerState;
import suwu.flowerapp.publicdatas.flower.FlowerTypeState;
import suwu.flowerapp.response.flower.*;
import suwu.flowerapp.util.UserInfoUtil;
import java.util.ArrayList;
import java.util.List;

public class FlowerBlServiceImpl implements FlowerBlService {
    private final FlowerTypeDataService flowerTypeDataService;
    private final FlowerDataService flowerDataService;
    private final UserDataService userDataService;
    private final OrderDataService orderDataService;

    @Autowired
    public FlowerBlServiceImpl(FlowerTypeDataService _flowerTypeDataService, FlowerDataService _flowerDataService, UserDataService _userDataService, OrderDataService _orderDataService) {
        this.flowerTypeDataService = _flowerTypeDataService;
        this.flowerDataService = _flowerDataService;
        this.userDataService = _userDataService;
        this.orderDataService = _orderDataService;
    }

    /**
     * load all flower types
     * @return
     */
    @Override
    public FlowerTypesGetResponse getFlowerTypes(){
        List<FlowerType> types = flowerTypeDataService.getAllFlowerTypes();
        List<SimpleFlowerTypeItem> simpleTypeItems = types.stream().filter((type) -> type.getTypeState() == FlowerTypeState.ACTIVE).collect(ArrayList::new, (list, type) -> list.add(new SimpleFlowerTypeItem(type.getId(), type.getName())), ArrayList::addAll);
        return new FlowerTypesGetResponse(simpleTypeItems);
    }

    /**
     * get flower by flower type
     * @param typeId
     * @return
     * @throws FlowerTypeDoesNotExistException
     */
    @Override
    public FlowerGetByTypeResponse getFlowerByType(int typeId) throws FlowerTypeDoesNotExistException {
        List<Flower> flowers = flowerDataService.getFlowersByTypeId(typeId);
        List<FlowerItem> flowerItems = flowers.stream().filter((flower) -> flower.getFlowerState() == FlowerState.SELLING).collect(ArrayList::new, (list, flower) -> list.add(new FlowerItem(flower.getId(), flower.getName(), flower.getCoverUrl(), flower.getPrice())), ArrayList::addAll);
        return new FlowerGetByTypeResponse(flowerItems);
    }

    /**
     * get flower detail by flower id.
     * @param flowerId
     * @return
     * @throws FlowerIdNotExistedException
     */
    @Override
    public FlowerDetailResponse getFlowerDetailById(int flowerId) throws FlowerIdNotExistedException{
        Flower flower = flowerDataService.getFlowerByFlowerId(flowerId);
        FlowerDetailResponse response = new FlowerDetailResponse(flower.getName(), orderDataService.getAmountOfLikePeople(flowerId), flower.getPrice(),  flower.getDescription(), flower.getImageUrls(), flowerTypeDataService.getFlowerTypeByFlowerId(flowerId).getName(), flower.getHasChoice(), flower.getChoice());
        return response;
    }

    /**
     * add flower type.
     * @param flowerTypePutParameters
     * @return
     */
    @Override
    public FlowerTypeAddResponse addFlowerType(FlowerTypePutParameters flowerTypePutParameters) {
        FlowerType type = flowerTypeDataService.addType(flowerTypePutParameters.getName());
        return new FlowerTypeAddResponse(type.getId());
    }

    /**
     * delete flower type
     * @param flowerTypeDeleteParameters
     * @return
     */
    @Override
    public FlowerTypeDeleteResponse deleteFlowerType(FlowerTypeDeleteParameters flowerTypeDeleteParameters) {
        flowerDataService.deleteFlowerType(flowerTypeDeleteParameters.getId());
        return new FlowerTypeDeleteResponse(flowerTypeDeleteParameters.getId());
    }

    /**
     * update flower type.
     * @param flowerTypePostParameters
     * @return
     * @throws FlowerTypeDoesNotExistException
     */
    @Override
    public FlowerTypePostResponse postFlowerType(FlowerTypePostParameters flowerTypePostParameters) throws FlowerTypeDoesNotExistException {
        FlowerType flowerType = new FlowerType(flowerTypePostParameters.getName(),  FlowerTypeState.INACTIVE, flowerTypePostParameters.getFlowers());
        flowerType.setId(flowerTypePostParameters.getId());
        FlowerType savedFlowerType = flowerTypeDataService.saveFlowerType(flowerType);
        if (savedFlowerType != null) {
            return new FlowerTypePostResponse("success");
        } else {
            throw new FlowerTypeDoesNotExistException();
        }
    }

    /**
     * delete flower by flower id.
     * @param flowerId
     * @return
     */
    @Override
    public FlowerDeleteResponse deleteSupplierFlowerById(int flowerId) {
        flowerDataService.deleteFlowerByFlowerId(flowerId);
        return new FlowerDeleteResponse("success");
    }

    /**
     * add flower
     * @param flowerAddParameters
     * @return
     */
    @Override
    public SupplierFlowerAddResponse addSupplierFlower(FlowerAddParameters flowerAddParameters){
        Flower flower = flowerDataService.saveFlower(new Flower(flowerAddParameters.getName(), flowerAddParameters.getCoverUrl(), flowerAddParameters.getPrice(), flowerAddParameters.getDescription(), flowerAddParameters.getImageUrls(), FlowerState.NOTSELL, flowerAddParameters.getHasChoice(), flowerAddParameters.getChoice(), flowerAddParameters.getFlowerType(), userDataService.getUserByUsername(UserInfoUtil.getUsername())));
        return new SupplierFlowerAddResponse(flower.getId());
    }

    /**
     * update flower
     * @param flowerPostParameters
     * @return
     * @throws FlowerIdNotExistedException
     */
    @Override
    public FlowerPostResponse postFlower(FlowerPostParameters flowerPostParameters) throws FlowerIdNotExistedException{
        Flower flower = new Flower(flowerPostParameters.getName(), flowerPostParameters.getCoverUrl(), flowerPostParameters.getPrice(), flowerPostParameters.getDescription(), flowerPostParameters.getImageUrls(), FlowerState.NOTSELL, flowerPostParameters.getHasChoice(),flowerPostParameters.getChoice(),flowerPostParameters.getFlowerType(), userDataService.getUserByUsername(UserInfoUtil.getUsername()));
        flower.setId(flowerPostParameters.getId());
        Flower savedFlower = flowerDataService.saveFlower(flower);
        if (savedFlower != null) {
            return new FlowerPostResponse("success");
        } else {
            throw new FlowerIdNotExistedException();
        }
    }
}
