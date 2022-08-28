package com.restfood.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restfood.models.entitties.Item;

public interface ItemRepo extends JpaRepository<Item,Integer>{
    
}
