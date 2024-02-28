package org.sb.springbootcrudjpa.repository;

import org.sb.springbootcrudjpa.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products,Long> {

}
