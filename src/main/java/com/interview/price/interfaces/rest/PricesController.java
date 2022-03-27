package com.interview.price.interfaces.rest;

import com.interview.price.application.service.PriceService;
import com.interview.price.interfaces.rest.dto.ApiResponse;
import com.interview.price.interfaces.rest.dto.QuoteDto;
import com.interview.price.interfaces.rest.dto.QuoteRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/price")
public class PricesController {
  private final PriceService service;

  @GetMapping("/quotes")
  public ApiResponse<QuoteDto> getPricesController(@Valid QuoteRequestDto request) {
    return service.getPrice(request);
  }
}
