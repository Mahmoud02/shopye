package com.mahmoud.shopye.domain.port.in;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderCreationRequest(@NotNull @NotEmpty List<Integer> productsIds , @Min(1L) Long retailerId) {
}
