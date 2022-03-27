package com.interview.price.application.service;

import com.interview.price.infrastructure.repository.PriceRepository;
import com.interview.price.interfaces.rest.dto.ApiResponse;
import com.interview.price.interfaces.rest.dto.QuoteDto;
import com.interview.price.interfaces.rest.dto.QuoteRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;

@Service
@RequiredArgsConstructor
public class PriceService {
  private final PriceRepository repository;

  public ApiResponse<QuoteDto> getPrice(QuoteRequestDto request) {
    var price = repository.findActualPrice(
      request.productId(),
      request.brandId(),
      request.date().toInstant(ZoneOffset.UTC)
    );
    return price.map(p -> new ApiResponse<>(new QuoteDto(
      p.getProduct().getId(),
      p.getBrand().getId(),
      p.getPriceList().getId(),
      p.getStartDate(),
      p.getEndDate(),
      ((double) p.getPrice()) / 100
    ))).orElse(new ApiResponse<>("not.found"));
  }
}
