package com.restfood.services;

import java.util.List;

import com.restfood.dto.MenuDto;
import com.restfood.models.entitties.Item;

public interface ItemService {
    public Item save(Item item);
    public Item findOne(Integer itemNo);
    public List<MenuDto> findAllMenu();
}
