package com.interview.price.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Currency {

  @Column(name = "curr", insertable = false, updatable = false)
  @Enumerated(EnumType.STRING)
  private CurrencyId id;

  public enum CurrencyId {
    EUR
  }
}
