package com.fusionkoding.beer.inventory.service.web.controllers;

import com.fusionkoding.beer.inventory.service.services.BeerInventoryService;
import com.fusionkoding.beer.inventory.service.web.mappers.BeerInventoryMapper;
import com.fusionkoding.brewery.model.BeerInventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BeerInventoryController {

    private final BeerInventoryService beerInventoryService;
    private final BeerInventoryMapper beerInventoryMapper;

    @GetMapping("api/v1/beer/{beerId}/inventory")
    List<BeerInventoryDto> listBeersById(@PathVariable UUID beerId) {
        log.debug("Finding Inventory for beerId:" + beerId);

        return beerInventoryService.getInventoryForBeerId(beerId);
    }
}
