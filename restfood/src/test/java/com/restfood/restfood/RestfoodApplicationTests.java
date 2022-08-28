package com.restfood.restfood;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restfood.dto.ReqDetailTransactionDto;
import com.restfood.dto.ReqTransactionDto;
import com.restfood.dto.ResTransactionDto;
import com.restfood.models.entitties.Item;
import com.restfood.services.ItemService;
import com.restfood.services.TransactionService;

@SpringBootTest
class RestfoodApplicationTests {
	@Autowired
	private ItemService itemService;
	@Autowired
	private TransactionService transactionService;

	@Test
	void TestSaveItem() {
		itemService.save(new Item("Kwetiau", 12000));
		assertNotNull(itemService.findOne(5));
	}

	@Test
	void TestOrder(){
		ReqDetailTransactionDto menu1 = new ReqDetailTransactionDto();
		ReqDetailTransactionDto menu2 = new ReqDetailTransactionDto();
		List<ReqDetailTransactionDto> orders = new ArrayList<ReqDetailTransactionDto>();
		menu1.setQty(1);
		menu1.setCodeMenu(1);
		menu2.setQty(2);
		menu2.setCodeMenu(2);
		orders.add(menu1);
		orders.add(menu2);

		ReqTransactionDto order = new ReqTransactionDto();
		order.setNumberPhone("08012312312");
		order.setOrders(orders);

		ResTransactionDto res =  transactionService.order(order);

		assertNotNull(res.getPhoneNumberCustomer());
	}


}
