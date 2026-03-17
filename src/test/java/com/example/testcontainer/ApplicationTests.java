package com.example.testcontainer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class ApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void testCustomerTable() {
		List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from Customer");
		Assertions.assertTrue(maps.isEmpty());

		jdbcTemplate.update("insert into Customer " +
				"(customer_name, last_name, country, age , phone) " +
				"values('customer_name1', 'last_name1', 'country1', 9, '123456789')");
		maps = jdbcTemplate.queryForList("select * from Customer");
		Assertions.assertEquals(1, maps.size());
		Assertions.assertEquals("customer_name1", maps.get(0).get("customer_name"));
		Assertions.assertEquals("last_name1", maps.get(0).get("last_name"));
		Assertions.assertEquals("country1", maps.get(0).get("country"));
		Assertions.assertEquals(9, maps.get(0).get("age"));
		Assertions.assertEquals("123456789", maps.get(0).get("phone"));
	}

}
