package com.company.api.controllers;

import com.company.business.abstracts.ProductService;
import com.company.core.utilities.results.DataResult;
import com.company.core.utilities.results.Result;
import com.company.core.utilities.results.SuccessDataResult;
import com.company.entities.concretes.Product;
import com.company.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll() {
        return this.productService.getAll();
    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return this.productService.getProductWithCategoryDetails();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String ProductName) {
        return this.productService.getByProductName(ProductName);

    }


    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(
            @RequestParam("productName") String productName,
            @RequestParam("categoryId") int categoryId) {

        return this.productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
    }


//    public DataResult<List<Product>> getByProductNameOrCategoryId(String ProductName, int categoryId) {
//
//    }
//
//
//    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
//
//    }


    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
        return this.productService.getByProductNameContains(productName);

    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAllByPage(int pageNo, int pageSize) {
        return this.productService.getAll(pageNo, pageSize);

    }

    @GetMapping("/getAllDesc")
    public DataResult<List<Product>> getAllSorted() {

        return this.productService.getAllSorted();
    }


//    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
//
//    }
//
//
//    public DataResult<List<Product>> getByNameAndCategoryId(String productName, int categoryId) {
//
//    }


}
