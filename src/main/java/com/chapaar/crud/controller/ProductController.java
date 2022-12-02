package com.chapaar.crud.controller;

import com.chapaar.crud.exception.NotFoundException;
import com.chapaar.crud.model.Customer;
import com.chapaar.crud.model.Product;
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
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    // Add Item
    @GetMapping(value = "/add-product-item")
    public String addProductItem(ModelMap model) {
        log.info("Start GET Add Product Item");
        Product product = new Product();
        model.addAttribute("productItem", product);
        log.info("End GET Add Product Item");
        return "add-product-item";
    }

    @Validated
    @PostMapping(value = "/add-product-item")
    public String addProductItem(@ModelAttribute("productItem") @Valid Product product, BindingResult bindingResult,
                                  ModelMap model) {
        log.info("Start POST Add Product Item");
        if (bindingResult.hasErrors()) {
            log.info("End POST Add Product Item");
            return "add-product-item";
        } else {
            productService.save(product);
            model.addAttribute("headline", "Add Product Item Status");
            model.addAttribute("msg", "New Product Item saved successfully");
            model.addAttribute("productItem", product);
            log.info("End POST Add Product Item");
            return "add-item-status";
        }
    }

    // List Items
    @GetMapping(value = "/show-products")
    public String showProducts(ModelMap model) throws SystemException {
        log.info("Start Show Product List");
        List<Product> products = productService.getProducts();
        model.addAttribute("productItemList", products);
        log.info("End Show Product List");
        return "product-item-list";
    }

    // Edit
    @GetMapping(value = "/show-edit-product-item")
    public String showEditItem(@RequestParam("productItemId") long productItemId, ModelMap model) throws NotFoundException {
        log.info("Start GET Show Edit Product Item");

        Product product = productService.getProduct(productItemId);
        model.addAttribute("productItem", product);

        log.info("End GET Show Edit Product Item");
        return "add-product-item";
    }

    // Delete
    @GetMapping(value = "/delete-product-item")
    public String deleteItem(@RequestParam("productItemId") long productItemId, ModelMap model) {
        log.info("Start POST Delete Product Item");

        productService.delete(productItemId);
        model.addAttribute("headline", "Delete Product Item Status");
        model.addAttribute("msg", "Product Item deleted successfully");

        log.info("End POST Delete Product Item");
        return "add-item-status";
    }
}
