package com.sparta.restocknotificationsystem.product;

import com.sparta.restocknotificationsystem.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    //재입고 회차 증가

    // 재입고 회차 증가 로직
    public void increaseRestockCount(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        // 재입고 회차를 1 증가시킴
        product.setRestockCount(product.getRestockCount() + 1);

        productRepository.save(product); // 변경된 정보 저장

    }

}
