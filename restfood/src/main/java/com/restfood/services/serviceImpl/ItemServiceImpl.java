package com.restfood.services.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restfood.dto.MenuDto;
import com.restfood.models.entitties.Item;
import com.restfood.models.repos.ItemRepo;
import com.restfood.services.ItemService;


@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public Item findOne(Integer itemNo) {
        Optional<Item> item = itemRepo.findById(itemNo);
        if(!item.isPresent()){
            return null;
        }
        return itemRepo.findById(itemNo).get();
    }

    @Override
    public Item save(Item item) {
        if(item == null){
            return null;
        }
        return itemRepo.save(item);
    }

    @Override
    public List<MenuDto> findAllMenu() {
        List<Item> menus = itemRepo.findAll();
        List<MenuDto> allMenuFinal = new ArrayList<MenuDto>();
        if(menus == null){
            return null;
        }
        for (Item item : menus) {
            MenuDto menu = new MenuDto();
            menu.setCodeMenu(item.getItemNo());
            menu.setName(item.getDeskripsi());
            menu.setPrice(String.format("Rp. %.2f", item.getPrice()));
            allMenuFinal.add(menu);
        }
        return allMenuFinal;
    }
    
}
