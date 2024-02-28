package org.sb.springbootcrudjpa.controller;

import jakarta.annotation.PostConstruct;
import org.sb.springbootcrudjpa.entity.Products;
import org.sb.springbootcrudjpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
//@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostConstruct
    public void init(){
        Products p = new Products();
        p.setName("test");
        p.setDescription("test desc");
        p.setPrice(1000.0);
    productService.createProduct(p);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Products>> findAll()
    {
        return ResponseEntity.ok().body(productService.findAllProducts());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Products> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(productService.findProductById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Products> createProduct(@RequestBody Products product)
    {
        return ResponseEntity.ok().body(productService.createProduct(product));
    }

    @PutMapping("/update")
    public ResponseEntity<Products> updateProduct(@RequestBody Products product)
    {
        return ResponseEntity.ok().body(productService.updateProduct(product));
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteProduct(@PathVariable Long id)
    {
        productService.deleteProductById(id);
        return HttpStatus.OK;
    }
}
