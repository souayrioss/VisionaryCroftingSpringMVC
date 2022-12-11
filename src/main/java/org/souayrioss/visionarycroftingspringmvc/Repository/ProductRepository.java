package org.souayrioss.visionarycroftingspringmvc.Repository;

import org.souayrioss.visionarycroftingspringmvc.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
