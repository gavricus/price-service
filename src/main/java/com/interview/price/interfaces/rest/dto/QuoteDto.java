package com.interview.price.interfaces.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.interview.price.application.utils.MoneySerializer;

import java.time.Instant;

public record QuoteDto(
  long productId,
  long brandId,
  int priceList,
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
  Instant startDate,
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
  Instant endDate,
  @JsonSerialize(using = MoneySerializer.class)
  double price) {
}
