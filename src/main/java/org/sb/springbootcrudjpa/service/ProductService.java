package org.sb.springbootcrudjpa.service;

import org.sb.springbootcrudjpa.entity.Products;
import org.sb.springbootcrudjpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @SuppressWarnings("null")
    public Products createProduct(Products product)
    {
        return productRepository.save(product);
    }

    public Products updateProduct(Products product)
    {
        @SuppressWarnings("null")
        Optional<Products> optionalProduct = productRepository.findById(product.getId());

        if(optionalProduct.isPresent())
        {
            Products updateProd = optionalProduct.get();
            updateProd.setName(product.getName());
            updateProd.setDescription(product.getDescription());
            productRepository.save(updateProd);
            return updateProd;
        }

        throw new RuntimeException("Product Not Found "+product.getId());

    }

    public List<Products> findAllProducts()
    {
        return productRepository.findAll();
    }

    public Products findProductById(Long id)
    {
        @SuppressWarnings("null")
        Optional<Products> optionalProduct =  productRepository.findById(id);

        if(optionalProduct.isPresent())
        {
            return optionalProduct.get();
        }

        throw new RuntimeException("Product Not Found " + id);
    }

    @SuppressWarnings("null")
    public void deleteProductById(Long id)
    {
        Optional<Products> optionalProducts = productRepository.findById(id);

        if(optionalProducts.isPresent())
        {
            productRepository.deleteById(id);
            System.out.println("Product "+id+" is deleted");
        }

        throw new RuntimeException("Product Not Found " + id);
    }


}
