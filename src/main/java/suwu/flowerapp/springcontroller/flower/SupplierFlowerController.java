package suwu.flowerapp.springcontroller.flower;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import suwu.flowerapp.blservice.flower.FlowerBlService;
import suwu.flowerapp.exception.FlowerIdNotExistedException;
import suwu.flowerapp.exception.FlowerTypeDoesNotExistException;
import suwu.flowerapp.parameters.flower.*;
import suwu.flowerapp.publicdatas.account.Role;
import suwu.flowerapp.response.Response;
import suwu.flowerapp.response.WrongResponse;
import suwu.flowerapp.response.flower.*;

@PreAuthorize(value = "hasRole('" + Role.RESTAURANT_NAME + "')")
@RestController
public class SupplierFlowerController {
    private final FlowerBlService flowerBlService;
    @Autowired
    public SupplierFlowerController(FlowerBlService flowerBlService) {
        this.flowerBlService = flowerBlService;
    }

    @ApiOperation(value = "新增花品种", notes = "新增花的大类")
    @RequestMapping(value = "flower/types/addType", method = RequestMethod.PUT)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = FlowerTypeAddResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> putFlowerType(@RequestBody FlowerTypePutParameters flowerTypePutParameters) {
        return new ResponseEntity<>(flowerBlService.addFlowerType(flowerTypePutParameters), HttpStatus.CREATED);
    }

    @ApiOperation(value = "删除花品种", notes = "删除花的大类")
    @RequestMapping(value = "flower/types/deleteType", method = RequestMethod.DELETE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = FlowerTypeDeleteResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> deleteFlowerType(@RequestBody FlowerTypeDeleteParameters flowerTypeDeleteParameters) {
        return new ResponseEntity<>(flowerBlService.deleteFlowerType(flowerTypeDeleteParameters), HttpStatus.OK);
    }

    @ApiOperation(value = "修改花品种", notes = "修改花的大类")
    @RequestMapping(value = "flower/type/postType", method = RequestMethod.POST)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = FlowerTypePostResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> postFlowerType(@RequestBody FlowerTypePostParameters flowerTypePostParameters) {
        try {
            return new ResponseEntity<>(flowerBlService.postFlowerType(flowerTypePostParameters), HttpStatus.OK);
        } catch (FlowerTypeDoesNotExistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getResponse(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "删除花", notes = "根据id删除花")
    @RequestMapping(value = "flower/supplier/deleteType/{flowerId}", method = RequestMethod.DELETE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = FlowerDeleteResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> deleteFlower(@PathVariable(name = "flowerId") int flowerId) {
            return new ResponseEntity<>(flowerBlService.deleteSupplierFlowerById(flowerId), HttpStatus.OK);
    }

    @ApiOperation(value = "新增花", notes = "新增花")
    @RequestMapping(value = "flower/supplier/add", method = RequestMethod.PUT)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = SupplierFlowerAddResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> putFlower(@RequestBody FlowerAddParameters flowerAddParameters) {
        return new ResponseEntity<>(flowerBlService.addSupplierFlower(flowerAddParameters), HttpStatus.OK);
    }

    @ApiOperation(value = "修改花", notes = "根据id修改花")
    @RequestMapping(value = "flower/type/postFlower", method = RequestMethod.POST)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = FlowerPostResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> postFlower(@RequestBody FlowerPostParameters flowerPostParameters) {
        try {
            return new ResponseEntity<>(flowerBlService.postFlower(flowerPostParameters), HttpStatus.OK);
        } catch (FlowerIdNotExistedException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getResponse(), HttpStatus.NOT_FOUND);
        }
    }
}
