package com.restfood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.restfood.models.entitties.Item;
import com.restfood.services.ItemService;

@SpringBootApplication
public class RestfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfoodApplication.class, args);
	}

}
@Component
class DemoCommandLineRunner implements CommandLineRunner{

	@Autowired
	private ItemService itemService;

	@Override
	public void run(String... args) throws Exception {

		if(itemService.findAllMenu().isEmpty()){
			Item menu1 = new Item("Nasi Goreng Biasa", 12000.00);
			Item menu2 = new Item("Nasi Goreng Special", 20000.00);
			Item menu3 = new Item("Mie Goreng Biasa", 12000.00);
			Item menu4 = new Item("Miea Goreng Special", 20000.00);
	
			itemService.save(menu1);
			itemService.save(menu2);
			itemService.save(menu3);
			itemService.save(menu4);
		}
		
	}
}