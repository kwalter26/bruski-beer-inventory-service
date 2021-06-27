package com.fusionkoding.beer.inventory.service.services;

import com.fusionkoding.brewery.model.BeerInventoryDto;

import java.util.List;
import java.util.UUID;

public interface BeerInventoryService {
    List<BeerInventoryDto> getInventoryForBeerId(UUID beerId);

    BeerInventoryDto createBeerInventory(BeerInventoryDto beerInventoryDto);
}
