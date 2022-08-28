package com.restfood.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restfood.dto.MenuDto;
import com.restfood.dto.ValidationDto;
import com.restfood.services.ItemService;

@RestController
@RequestMapping("/menu")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/all")
    public ResponseEntity<Object> allMenu(){
        List<MenuDto> check = itemService.findAllMenu();
        if(check.isEmpty()){
            ValidationDto empty = new ValidationDto();
            empty.setStatus(false);
            empty.setMessages("Menu Kosong");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(empty);
        }
        return ResponseEntity.ok().body(check);
    }
}
