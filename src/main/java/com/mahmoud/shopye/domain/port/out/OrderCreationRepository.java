package com.mahmoud.shopye.domain.port.out;

import com.mahmoud.shopye.domain.model.Product;
import com.mahmoud.shopye.domain.model.Retailer;

import java.util.List;
import java.util.Optional;

public interface OrderCreationRepository {
    Optional<Retailer> getRetailerWithWriteLock(Long retailerId);
    List<Product> getProductsWithWriteLock(List<Long> productIds);
}
