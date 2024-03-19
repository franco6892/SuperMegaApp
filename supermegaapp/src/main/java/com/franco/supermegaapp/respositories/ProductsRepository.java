package com.franco.supermegaapp.respositories;

import com.franco.supermegaapp.respositories.dtos.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ProductDTO, Integer> {
}
