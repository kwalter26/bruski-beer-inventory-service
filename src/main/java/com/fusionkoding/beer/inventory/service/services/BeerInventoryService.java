package com.fusionkoding.beer.inventory.service.services;

import com.fusionkoding.beer.inventory.service.web.model.BeerInventoryDto;

import java.util.List;
import java.util.UUID;

public interface BeerInventoryService {
    List<BeerInventoryDto> getInventoryForBeerId(UUID beerId);
}
