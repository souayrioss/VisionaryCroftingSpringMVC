package org.souayrioss.visionarycroftingspringmvc.Repository;

import org.souayrioss.visionarycroftingspringmvc.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {
}
