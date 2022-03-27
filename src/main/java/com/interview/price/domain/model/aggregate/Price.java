package com.interview.price.domain.model.aggregate;

import com.interview.price.domain.model.entity.Brand;
import com.interview.price.domain.model.entity.Currency;
import com.interview.price.domain.model.entity.PriceList;
import com.interview.price.domain.model.entity.Product;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "prices")
@Data
public class Price {
  @Id
  @GeneratedValue
  private long id;
  @Column(name = "start_date")
  private Instant startDate;
  @Column(name = "end_date")
  private Instant endDate;
  @Embedded
  private Currency currency;
  @Embedded
  private PriceList priceList;
  @Embedded
  private Product product;
  @Embedded
  private Brand brand;
  private int priority;
  private int price;
}
