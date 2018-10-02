package suwu.flowerapp.springcontroller.flower;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import suwu.flowerapp.blservice.flower.FlowerBlService;
import suwu.flowerapp.exception.*;
import suwu.flowerapp.response.Response;
import suwu.flowerapp.response.WrongResponse;
import suwu.flowerapp.response.flower.FlowerDetailResponse;
import suwu.flowerapp.response.flower.FlowerGetByTypeResponse;
import suwu.flowerapp.response.flower.FlowerTypesGetResponse;

@RestController
public class CustomerFlowerController {
    private final FlowerBlService flowerBlService;
    @Autowired
    public CustomerFlowerController(FlowerBlService flowerBlService) {
        this.flowerBlService = flowerBlService;
    }

    @ApiOperation(value = "获得花品种", notes = "获得所有花的大类")
    @RequestMapping(value = "flower/types", method = RequestMethod.GET)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = FlowerTypesGetResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> getFlowerTypes() {
        FlowerTypesGetResponse flowerTypesGetResponse = flowerBlService.getFlowerTypes();
        return new ResponseEntity<>(flowerTypesGetResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "根据品种获得花", notes = "根据具体品种id获得花")
    @RequestMapping(value = "flower/types/{typeId}", method = RequestMethod.GET)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = FlowerGetByTypeResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> getFlowersByTypeId(@PathVariable("typeId") int typeId) {
        try{
            FlowerGetByTypeResponse flowerGetByTypeResponse = flowerBlService.getFlowerByType(typeId);
            return new ResponseEntity<>(flowerGetByTypeResponse, HttpStatus.OK);
        }catch (FlowerTypeDoesNotExistException e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getResponse(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "获得花的详细信息", notes = "根据花ID获得花的详细信息")
    @RequestMapping(value = "flower/{flowerId}", method = RequestMethod.GET)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = FlowerDetailResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = WrongResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> getFlowerByFlowerId(@PathVariable("flowerId") int flowerId) {
        try {
            FlowerDetailResponse flowerDetailResponse = flowerBlService.getFlowerDetailById(flowerId);
            return new ResponseEntity<>(flowerDetailResponse, HttpStatus.OK);
        } catch (FlowerIdNotExistedException e) {
            return new ResponseEntity<>(e.getResponse(), HttpStatus.NOT_FOUND);
        }
    }
}
