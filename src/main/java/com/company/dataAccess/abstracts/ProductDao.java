package com.company.dataAccess.abstracts;

import com.company.entities.concretes.Product;
import com.company.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductDao extends JpaRepository<Product, Integer> {

    Product getByProductName(String ProductName);

    Product getByProductNameAndCategory_CategoryId(String ProductName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String ProductName, int categoryId);

    List<Product> getByCategoryIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategoryId(String productName, int categoryId);

    @Query("select new com.company.entities.dtos.ProductWithCategoryDto" +
            "(p.id, p.productName , c.categoryName)" +
            " from Category c INNER join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();


}
