package com.vikram.productservice.respositories;

import com.vikram.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
