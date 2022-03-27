package com.interview.price.interfaces.rest.dto;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record QuoteRequestDto(
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", fallbackPatterns = {"yyyy-MM-dd", "yyyy-MM-dd-HH:mm:ss"})
  LocalDateTime date,
  @NotNull @Min(1)
  Long productId,
  @NotNull @Min(1)
  Long brandId
) {
}
