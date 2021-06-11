package com.company.business.concretes;

import com.company.business.abstracts.ProductService;
import com.company.core.utilities.results.DataResult;
import com.company.core.utilities.results.Result;
import com.company.core.utilities.results.SuccessDataResult;
import com.company.core.utilities.results.SuccessResult;
import com.company.dataAccess.abstracts.ProductDao;
import com.company.entities.concretes.Product;
import com.company.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductManager implements ProductService {


    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>
                (this.productDao.findAll(), "Data listed");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "productName");
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort), "success");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Product added");
    }

    @Override
    public DataResult<Product> getByProductName(String ProductName) {
        return new SuccessDataResult<Product>
                (this.productDao.getByProductName(ProductName), "Data listed");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String ProductName, int categoryId) {
        return new SuccessDataResult<Product>
                (this.productDao.getByProductNameAndCategory_CategoryId(ProductName, categoryId), "Data listed");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String ProductName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameOrCategory_CategoryId(ProductName, categoryId), "Data listed");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByCategoryIn(categories), "Data listed");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameContains(productName), "Data listed");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameStartsWith(productName), "Data listed");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByNameAndCategoryId(productName, categoryId), "Data listed");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>
                (this.productDao.getProductWithCategoryDetails(), "Data listed");
    }
}
