package org.souayrioss.visionarycroftingspringmvc.service.Imp;

import org.souayrioss.visionarycroftingspringmvc.Repository.ProductRepository;
import org.souayrioss.visionarycroftingspringmvc.entity.Product;
import org.souayrioss.visionarycroftingspringmvc.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductService implements IService<Product> {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        boolean ProductIsValid = validateProduct(product);
        if (ProductIsValid) {
            productRepository.save(product);
            return this.getOne(product.getReference());
        }
        return null;
    }

    @Override
    public Page<Product> getAll(String keyword, Pageable pageable) {
        Page<Product> products = productRepository.findByTitleContainsIgnoreCase(keyword,pageable);
        return products;
    }

    @Override
    public Product getOne(String ref) {
        Product product = productRepository.findByReference(ref);
        return product;
    }

    public boolean validateProduct(Product product){
        if (!Objects.isNull(product) || !product.equals(new Product())) {
            if (product.getReference().isEmpty() || product.getReference().isBlank()) {
                return false;
            }
            if (product.getTitle().isEmpty() || product.getTitle().isBlank()) {
                return false;
            }
            if (product.getDescription().isEmpty() || product.getDescription().isBlank()) {
                return false;
            }
            if (product.getInitialPrice() == 0.0f) {
                return false;
            }
            if (product.getQuantity() <= 0 ) {
                return false;
            }
            return true;

        }else {
            return false;
        }
    }

}
