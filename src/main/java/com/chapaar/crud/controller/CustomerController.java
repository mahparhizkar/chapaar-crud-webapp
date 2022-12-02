package com.chapaar.crud.controller;

import com.chapaar.crud.exception.NotFoundException;
import com.chapaar.crud.model.Customer;
import com.chapaar.crud.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
public class CustomerController {

    @Autowired
    CustomerService customerService;

    // Add Item
    @GetMapping(value = "/add-customer-item")
    public String addCustomerItem(ModelMap model) {
        log.info("Start GET Add Customer Item");

        Customer customer = new Customer();
        model.addAttribute("customerItem", customer);

        log.info("End GET Add Customer Item");
        return "add-customer-item";
    }

    @PostMapping(value = "/add-customer-item")
    public String addCustomerItem(@ModelAttribute("customerItem") @Valid Customer customer, BindingResult bindingResult,
                                  ModelMap model) {
        log.info("Start POST Add Customer Item");

        if (bindingResult.hasErrors()) {
            log.info("End POST Add Customer Item");
            return "add-customer-item";
        } else {
            customerService.save(customer);
            model.addAttribute("headline", "Add Customer Item Status");
            model.addAttribute("msg", "New Customer Item saved successfully");
            model.addAttribute("customerItem", customer);

            log.info("End POST Add Customer Item");
            return "add-item-status";
        }
    }

    // List Items
    @GetMapping(value = "/show-customers")
    public String showCustomers(ModelMap model) {
        log.info("Start Show Customer List");

        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customerItemList", customers);

        log.info("End Show Customer List");
        return "customer-item-list";
    }

    // Edit
    @GetMapping(value = "/show-edit-customer-item")
    public String showEditItem(@RequestParam("customerItemId") long customerItemId, ModelMap model) throws NotFoundException {
        log.info("Start GET Show Edit Customer Item");

        Customer customer = customerService.getCustomer(customerItemId);
        model.addAttribute("customerItem", customer);

        log.info("End GET Show Edit Customer Item");
        return "add-customer-item";
    }

    // Delete
    @GetMapping(value = "/delete-customer-item")
    public String deleteItem(@RequestParam("customerItemId") long customerItemId, ModelMap model) {
        log.info("Start POST Delete Customer Item");

        customerService.delete(customerItemId);
        model.addAttribute("headline", "Delete Customer Item Status");
        model.addAttribute("msg", "Customer Item deleted successfully");

        log.info("End POST Delete Menu Item");
        return "add-item-status";
    }
}
