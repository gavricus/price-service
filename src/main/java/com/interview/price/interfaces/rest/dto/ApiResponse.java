package com.interview.price.interfaces.rest.dto;

public record ApiResponse<T>(String status, String error, T data) {

  public static final ApiResponse UNKNOWN_ERROR = new ApiResponse("unknown.error");

  public ApiResponse(String error) {
    this("error", error, null);
  }

  public ApiResponse(T data) {
    this("ok", null, data);
  }
}
