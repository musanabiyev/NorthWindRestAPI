package com.company.business.abstracts;

import com.company.core.utilities.results.DataResult;
import com.company.core.utilities.results.Result;
import com.company.entities.concretes.Product;
import com.company.entities.dtos.ProductWithCategoryDto;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();

    DataResult<List<Product>> getAll(int pageNo, int pageSize);

    DataResult<List<Product>> getAllSorted();

    Result add(Product product);

    DataResult<Product> getByProductName(String ProductName);

    DataResult<Product> getByProductNameAndCategory_CategoryId(String ProductName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String ProductName, int categoryId);

    DataResult<List<Product>> getByCategoryIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategoryId(String productName, int categoryId);

    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}
