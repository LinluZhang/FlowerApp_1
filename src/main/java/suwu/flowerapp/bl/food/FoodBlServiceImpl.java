package suwu.flowerapp.bl.food;

import suwu.flowerapp.blservice.food.FoodBlService;
import suwu.flowerapp.dataservice.account.UserDataService;
import suwu.flowerapp.dataservice.food.FoodDataService;
import suwu.flowerapp.dataservice.order.OrderDataService;
import suwu.flowerapp.dataservice.port.PortDataService;
import suwu.flowerapp.entity.food.Food;
import suwu.flowerapp.entity.port.Port;
import suwu.flowerapp.exception.FoodIdDoesNotExistException;
import suwu.flowerapp.exception.PortDoesNotExistException;
import suwu.flowerapp.parameters.food.*;
import suwu.flowerapp.publicdatas.food.FoodState;
import suwu.flowerapp.publicdatas.port.PortState;
import suwu.flowerapp.response.event.EventFoodItem;
import suwu.flowerapp.response.event.EventFoodLoadResponse;
import suwu.flowerapp.response.food.*;
import suwu.flowerapp.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FoodBlServiceImpl implements FoodBlService {
    private final PortDataService portDataService;
    private final FoodDataService foodDataService;
    private final UserDataService userDataService;
    private final OrderDataService orderDataService;

    @Autowired
    public FoodBlServiceImpl(PortDataService portDataService, FoodDataService foodDataService, UserDataService userDataService, OrderDataService orderDataService) {
        this.portDataService = portDataService;
        this.foodDataService = foodDataService;
        this.userDataService = userDataService;
        this.orderDataService = orderDataService;
    }

    /**
     * load all foods
     *
     * @return
     */
    @Override
    public FoodLoadResponse loadFoods() {
        List<PortItem> portItems = new ArrayList<>();
        List<Port> ports = portDataService.getAllPorts().stream().filter((port) -> port.getPortState() == PortState.ACTIVE).collect(ArrayList::new, (list, port) -> list.add(port), ArrayList::addAll);
        for (Port port : ports) {
            List<FoodItem> foodItems = port.getFoods().stream().filter((food -> food.getFoodState() == FoodState.SELLING)).collect(ArrayList::new, (list, food) -> list.add(Converter.fromFoodToFoodItem(food)), ArrayList::addAll);
            portItems.add(new PortItem(port.getName(), port.getId(), foodItems));
        }
        return new FoodLoadResponse(portItems);
    }

    /**
     * add food
     *
     * @param foodAddParameters
     * @return
     */
    @Override
    public FoodAddResponse addFood(FoodAddParameters foodAddParameters, String supplierUsername) throws PortDoesNotExistException {
        Food food = foodDataService.saveFood(new Food(foodAddParameters.getName(), foodAddParameters.getUrl(), foodAddParameters.getPrice(), foodAddParameters.getDescription(), FoodState.NOTSELL, foodAddParameters.isHasChoice(), foodAddParameters.getChoice(), portDataService.getPortByPortName(foodAddParameters.getPortName()), userDataService.getUserByUsername(supplierUsername)));
        return new FoodAddResponse(food.getId());
    }

    /**
     * load foods by supplier id
     *
     * @param username
     * @return
     */
    @Override
    public SupplierFoodLoadResponse loadSupplierFood(String username) {
        List<Food> foods = foodDataService.getFoodBySupplierUsername(username);
        List<SupplierFoodItem> supplierFoodItems = foods.stream().collect(ArrayList::new, (list, food) -> list.add(new SupplierFoodItem(food.getUrl(), food.getName(), food.getPrice(), food.getId())), ArrayList::addAll);
        return new SupplierFoodLoadResponse(supplierFoodItems);
    }

    /**
     * load food by food id
     *
     * @param foodId
     * @return
     */
    @Override
    public SupplierFoodDetailResponse loadSupplierFoodById(int foodId) throws FoodIdDoesNotExistException {
        Food food = foodDataService.getFoodById(foodId);
        return Converter.fromFoodToSupplierFoodDetailResponse(food);
    }

    /**
     * delete food by id
     *
     * @param foodId
     * @return
     */
    @Override
    public SupplierFoodDeleteResponse deleteSupplierFoodById(int foodId) {
        foodDataService.deleteFood(foodId);
        return new SupplierFoodDeleteResponse("success");
    }

    /**
     * update food whole
     *
     * @param supplierFoodUpdateParameters
     * @param supplierUsername
     * @return
     */
    @Override
    public SupplierFoodUpdateResponse updateSupplierFoodById(SupplierFoodUpdateParameters supplierFoodUpdateParameters, String supplierUsername) throws PortDoesNotExistException, FoodIdDoesNotExistException {
        Food food = new Food(supplierFoodUpdateParameters.getName(), supplierFoodUpdateParameters.getUrl(), supplierFoodUpdateParameters.getPrice(), supplierFoodUpdateParameters.getDescription(), FoodState.NOTSELL, supplierFoodUpdateParameters.isHasChoice(), supplierFoodUpdateParameters.getChoice(), portDataService.getPortByPortName(supplierFoodUpdateParameters.getPortName()), userDataService.getUserByUsername(supplierUsername));
        food.setId(supplierFoodUpdateParameters.getId());
        Food savedFood = foodDataService.saveFood(food);
        if (savedFood != null) {
            return new SupplierFoodUpdateResponse("success");
        } else {
            throw new FoodIdDoesNotExistException();
        }
    }

    /**
     * shelf food by ids
     *
     * @param supplierFoodShelfParameters
     * @return
     */
    @Override
    public SupplierFoodShelfResponse shelfSupplierFood(SupplierFoodShelfParameters supplierFoodShelfParameters) throws FoodIdDoesNotExistException {
        foodDataService.changeFoodState(supplierFoodShelfParameters.getSupplierFoodIds(), FoodState.SELLING);
        return new SupplierFoodShelfResponse("success");
    }

    /**
     * shelf off food by ids
     *
     * @param supplierFoodShelfOffParameters
     * @return
     */
    @Override
    public SupplierFoodShelfOffResponse shelfOffSupplierFood(SupplierFoodShelOffParameters supplierFoodShelfOffParameters) throws FoodIdDoesNotExistException {
        foodDataService.changeFoodState(supplierFoodShelfOffParameters.getSupplierFoodIds(), FoodState.NOTSELL);
        return new SupplierFoodShelfOffResponse("success");
    }

    /**
     * load foods for event
     *
     * @param username
     * @return
     */
    @Override
    public EventFoodLoadResponse loadEventFood(String username) {
        List<Food> foods = foodDataService.getFoodBySupplierUsername(username);
        List<EventFoodItem> supplierFoodItems = foods.stream().collect(ArrayList::new, (list, food) -> list.add(new EventFoodItem(food.getId(), food.getPort().getName() + "-" + food.getName())), ArrayList::addAll);
        return new EventFoodLoadResponse(supplierFoodItems);
    }

    /**
     * add a port
     *
     * @param portAddParameters
     * @return
     */
    @Override
    public PortAddResponse addPort(PortAddParameters portAddParameters) {
        Port port = portDataService.addPort(portAddParameters.getPortName());
        return new PortAddResponse(port.getId());
    }

    /**
     * load all ports
     *
     * @return
     */
    @Override
    public PortLoadResponse loadPorts() {
        List<Port> ports = portDataService.getAllPorts();
        List<SimplePortItem> simplePortItems = ports.stream().filter((port) -> port.getPortState() == PortState.ACTIVE).collect(ArrayList::new, (list, port) -> list.add(new SimplePortItem(port.getId(), port.getName())), ArrayList::addAll);
        return new PortLoadResponse(simplePortItems);
    }

    /**
     * delete a port
     *
     * @param portId
     * @return
     */
    @Override
    public PortDeleteResponse deletePort(int portId) throws PortDoesNotExistException {
        portDataService.deletePort(portId);
        return new PortDeleteResponse(portId);
    }

    /**
     * load a food's detail
     *
     * @param foodId
     * @return
     */
    @Override
    public FoodDetailLoadResponse loadFoodDetail(int foodId) throws FoodIdDoesNotExistException {
        Food food = foodDataService.getFoodById(foodId);
        List<String> pictures = new ArrayList<>();
        pictures.add(food.getUrl());
        FoodDetailLoadResponse response = new FoodDetailLoadResponse(pictures, food.getPort().getName(), food.getName(), orderDataService.getAmountOfLikePeople(foodId), food.getPrice(), food.getDescription(), food.isHasChoice(), food.getChoice());
        return response;
    }
}
