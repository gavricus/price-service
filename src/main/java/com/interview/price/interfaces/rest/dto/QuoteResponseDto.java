package com.interview.price.interfaces.rest.dto;

public record QuoteResponseDto(
  String status,
  QuoteResponseDto quote) {
}
