package com.ltp.globalsuperstore;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class GlobalSuperstoreApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertNotNull(mockMvc);
	}

	@Test
	public void testSuccessfulSubmission() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.post("/submitItem")
				.param("category", "Furniture")
				.param("name", "Bed")
				.param("price", "1000.00")
				.param("discount", "200.00")
				.param("date", "2023-01-10");

		mockMvc.perform(request)
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/inventory"));
	}

}
