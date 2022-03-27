package com.interview.price.web;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @SneakyThrows
  public void notFoundUrl() {
    mockMvc.perform(get("/api/price/sadasdsadas")).andDo(print())
      .andExpect(status().is(404))
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.status").value("error"));
  }

  @Test
  public void wrongRequest() throws Exception {
    mockMvc.perform(get("/api/price/quotes")).andDo(print())
      .andExpect(status().is(400))
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.status").value("error"));
  }

  @Test
  public void notFoundProduct() throws Exception {
    var url = buildUrl("/api/price/quotes", Map.of(
      "productId", 35450, "brandId", 1, "date", "2020-06-14 10:00:00"
    ));
    mockMvc.perform(url).andDo(print())
      .andExpect(status().is(200))
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.status").value("error"))
      .andExpect(jsonPath("$.error").value("not.found"));
  }

  @Test
  public void test1() {
    testQuotes("2020-06-14 10:00:00", 1, 35.5);
  }

  @Test
  public void test2() {
    testQuotes("2020-06-14 16:00:00", 2, 25.45);
  }

  @Test
  public void test3() {
    testQuotes("2020-06-14 21:00:00", 1, 35.5);
  }

  @Test
  public void test4() {
    testQuotes("2020-06-15 10:00:00", 3, 30.5);
  }

  @Test
  public void test5() {
    testQuotes("2020-06-16 21:00:00", 4, 38.95);
  }

  @SneakyThrows
  private void testQuotes(String date, int expectedPriceList, double expectedPrice) {
    var url = buildUrl("/api/price/quotes", Map.of(
      "productId", 35455, "brandId", 1, "date", date
    ));
    mockMvc.perform(url).andDo(print())
      .andExpect(status().is(200))
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.status").value("ok"))
      .andExpect(jsonPath("$.data.priceList").value(expectedPriceList))
      .andExpect(jsonPath("$.data.price").value(expectedPrice));
  }

  private MockHttpServletRequestBuilder buildUrl(String url, Map<String, Object> params) {
    var builder = get(url);
    params.entrySet().forEach(p -> builder.param(p.getKey(), p.getValue().toString()));
    return builder;
  }
}
