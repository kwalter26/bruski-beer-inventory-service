package com.fusionkoding.beer.inventory.service.web.mappers;

import com.fusionkoding.beer.inventory.service.domain.BeerInventory;
import com.fusionkoding.brewery.model.BeerInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {

    BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO);

    BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
