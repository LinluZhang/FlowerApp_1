package suwu.flowerapp.springcontroller.food;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import suwu.flowerapp.blservice.food.FoodBlService;
import suwu.flowerapp.exception.FoodIdDoesNotExistException;
import suwu.flowerapp.publicdatas.account.Role;
import suwu.flowerapp.response.Response;
import suwu.flowerapp.response.WrongResponse;
import suwu.flowerapp.response.food.FoodDetailLoadResponse;
import suwu.flowerapp.response.food.FoodLoadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@PreAuthorize(value = "hasRole('" + Role.USER_NAME + "')")
@RestController
public class CustomerFoodController {
    private final FoodBlService foodBlService;

    @Autowired
    public CustomerFoodController(FoodBlService foodBlService) {
        this.foodBlService = foodBlService;
    }

    @ApiOperation(value = "加载菜品", notes = "加载所有现有菜品信息")
    @RequestMapping(value = "food", method = RequestMethod.GET)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = FoodLoadResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> loadFoods() {
        return new ResponseEntity<>(foodBlService.loadFoods(), HttpStatus.OK);
    }

    @ApiOperation(value = "加载某菜品", notes = "获得某菜品的详细信息")
    @RequestMapping(value = "food/{foodId}", method = RequestMethod.GET)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = FoodDetailLoadResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> loadFoodDetail(@PathVariable(name = "foodId") int foodId) {
        try {
            return new ResponseEntity<>(foodBlService.loadFoodDetail(foodId), HttpStatus.OK);
        } catch (FoodIdDoesNotExistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getResponse(), HttpStatus.NOT_FOUND);
        }
    }
}
