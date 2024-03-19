package com.franco.supermegaapp.respositories;

import com.franco.supermegaapp.respositories.dtos.CarDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<CarDTO, Integer> {
}
