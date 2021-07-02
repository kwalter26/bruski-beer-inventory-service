package com.fusionkoding.brewery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllocateBeerOrderResult {
    private BeerOrderDto beerOrder;
    private boolean allocationError;
    private boolean pendingInventory;
}
