package org.souayrioss.visionarycroftingspringmvc.Repository;

import org.souayrioss.visionarycroftingspringmvc.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
