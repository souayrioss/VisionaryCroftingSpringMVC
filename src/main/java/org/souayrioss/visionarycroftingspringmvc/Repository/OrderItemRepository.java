package org.souayrioss.visionarycroftingspringmvc.Repository;

import org.souayrioss.visionarycroftingspringmvc.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
