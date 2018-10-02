package suwu.flowerapp.springcontroller.order;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import suwu.flowerapp.blservice.order.OrderBlService;
import suwu.flowerapp.exception.OrderIdDoesNotExistException;
import suwu.flowerapp.publicdatas.account.Role;
import suwu.flowerapp.response.Response;
import suwu.flowerapp.response.WrongResponse;
import suwu.flowerapp.response.order.OrderAcceptResponse;
import suwu.flowerapp.response.order.OrderConfirmArriveResponse;
import suwu.flowerapp.response.order.OrderRejectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@PreAuthorize(value = "hasRole('" + Role.RESTAURANT_NAME + "')")
@RestController
public class SupplierOrderController {
    private final OrderBlService orderBlService;

    @Autowired
    public SupplierOrderController(OrderBlService orderBlService) {
        this.orderBlService = orderBlService;
    }

    @ApiOperation(value = "接受订单", notes = "商户接受某订单")
    @RequestMapping(value = "order/supplier/accept/{orderId}", method = RequestMethod.POST)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = OrderAcceptResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 404, message = "order does not found", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> acceptOrder(@PathVariable(name = "orderId") int orderId) {
        try {
            return new ResponseEntity<>(orderBlService.acceptOrder(orderId), HttpStatus.OK);
        } catch (OrderIdDoesNotExistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getResponse(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "拒绝订单", notes = "商户拒绝某订单")
    @RequestMapping(value = "order/supplier/reject/{orderId}", method = RequestMethod.POST)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = OrderRejectResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 404, message = "order does not found", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> rejectOrder(@PathVariable(name = "orderId") int orderId) {
        try {
            return new ResponseEntity<>(orderBlService.rejectOrder(orderId), HttpStatus.OK);
        } catch (OrderIdDoesNotExistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getResponse(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "确认订单送达", notes = "确认某订单已送达")
    @RequestMapping(value = "order/supplier/confirmArrive/{orderId}", method = RequestMethod.POST)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = OrderConfirmArriveResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 404, message = "order does not found", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> confirmArriveOrder(@PathVariable(name = "orderId") int orderId) {
        try {
            return new ResponseEntity<>(orderBlService.confirmArriveOrder(orderId), HttpStatus.OK);
        } catch (OrderIdDoesNotExistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getResponse(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "加载所有订单", notes = "商户加载所有订单")
    @RequestMapping(value = "order/supplier", method = RequestMethod.GET)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = OrderAcceptResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 404, message = "order does not found", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> loadAllOrders() {
        return new ResponseEntity<>(orderBlService.loadAllOrders(), HttpStatus.OK);
    }
}
