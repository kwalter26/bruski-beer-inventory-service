package com.fusionkoding.beer.inventory.service.services;

import com.fusionkoding.beer.inventory.service.repositories.BeerInventoryRepository;
import com.fusionkoding.beer.inventory.service.web.mappers.BeerInventoryMapper;
import com.fusionkoding.brewery.model.BeerInventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class BeerInventoryServiceImpl implements BeerInventoryService {

    private final BeerInventoryRepository beerInventoryRepository;
    private final BeerInventoryMapper beerInventoryMapper;

    @Override
    public List<BeerInventoryDto> getInventoryForBeerId(UUID beerId) {
        return beerInventoryRepository.findAllByBeerId(beerId)
                .stream()
                .map(beerInventoryMapper::beerInventoryToBeerInventoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public BeerInventoryDto createBeerInventory(BeerInventoryDto beerInventoryDto) {
        return beerInventoryMapper.beerInventoryToBeerInventoryDto(beerInventoryRepository.save(beerInventoryMapper.beerInventoryDtoToBeerInventory(beerInventoryDto)));
    }
}
