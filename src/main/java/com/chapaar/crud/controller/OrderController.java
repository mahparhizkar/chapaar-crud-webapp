package com.chapaar.crud.controller;

import com.chapaar.crud.dto.OrderItemDTO;
import com.chapaar.crud.model.Customer;
import com.chapaar.crud.model.Order;
import com.chapaar.crud.model.Product;
import com.chapaar.crud.service.CustomerService;
import com.chapaar.crud.service.OrderService;
import com.chapaar.crud.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.SystemException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @Autowired
    CustomerService customerService;

    // Add Item
    @GetMapping(value = {"/add-order-item", "/"})
    public String addOrderItem(ModelMap model) {
        log.info("Start GET Add Order Item");

        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customerItemList", customers);

        List<Product> products = productService.getProducts();
        model.addAttribute("productItemList", products);

        Order order = new Order();
        model.addAttribute("orderItem", order);

        log.info("End GET Add Order Item");
        return "add-order-item";
    }

    @Validated
    @PostMapping(value = "/add-order-item")
    public String addOrderItem(@ModelAttribute("orderItem") @Valid Order order, BindingResult bindingResult,
                                  ModelMap model) {
        log.info("Start POST Add Order Item");
        if (bindingResult.hasErrors()) {
            log.info("End POST Add Order Item");
            return "add-order-item";
        } else {
            orderService.save(order);
            model.addAttribute("headline", "Add Order Item Status");
            model.addAttribute("msg", "New Order Item saved successfully");
            model.addAttribute("orderItem", order);
            log.info("End POST Add Order Item");
            return "add-item-status";
        }
    }

    // List Items
    @GetMapping(value = "/show-orders")
    public String showOrders(ModelMap model) throws SystemException {
        log.info("Start Show Order List");
        List<Order> orders = orderService.getOrders();
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();
        for (Order order:orders) {
            orderItemDTOS.add(
                    new OrderItemDTO(
                            order.getId(),
                            order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName(),
                            order.getProduct().getName(), order.getProduct().getPrice(), order.getCount(),
                            order.getCount()*order.getProduct().getPrice()));
        }

        model.addAttribute("orderItemDTOS", orderItemDTOS);
        log.info("End Show Order List");
        return "order-item-list";
    }

    // Delete
    @GetMapping(value = "/delete-order-item")
    public String deleteItem(@RequestParam("orderItemId") long orderItemId, ModelMap model) {
        log.info("Start POST Delete Order Item");

        orderService.delete(orderItemId);
        model.addAttribute("headline", "Delete Order Item Status");
        model.addAttribute("msg", "Order Item deleted successfully");

        log.info("End POST Delete Order Item");
        return "add-item-status";
    }
}
