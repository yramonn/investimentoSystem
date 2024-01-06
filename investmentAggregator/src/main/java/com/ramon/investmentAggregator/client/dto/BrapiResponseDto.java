package com.ramon.investmentAggregator.client.dto;

import java.util.List;

public record BrapiResponseDto(List<StockDto> results) {
}
