package com.interview.price.application.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Locale;

public class MoneySerializer extends JsonSerializer<Double> {
  @Override
  public void serialize(Double value, JsonGenerator generator, SerializerProvider serializers)
    throws IOException {
    generator.writeNumber(String.format(Locale.ENGLISH, "%.2f", value));
  }
}
