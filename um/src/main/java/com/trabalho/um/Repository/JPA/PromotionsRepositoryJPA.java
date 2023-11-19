package com.trabalho.um.Repository.JPA;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.trabalho.um.domain.entity.PromotionJPA;

public interface PromotionsRepositoryJPA extends CrudRepository<PromotionJPA, Integer> {
    List<PromotionJPA> findByValid(boolean valid);

    List<PromotionJPA> findAll();
}
