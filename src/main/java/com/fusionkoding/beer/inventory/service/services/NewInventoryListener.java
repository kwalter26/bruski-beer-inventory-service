package com.fusionkoding.beer.inventory.service.services;

import com.fusionkoding.beer.inventory.service.config.JmsConfig;
import com.fusionkoding.brewing.model.BeerDto;
import com.fusionkoding.brewing.model.NewInventoryEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewInventoryListener {

    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
    public void listen(@Payload NewInventoryEvent newInventoryEvent) {



        log.info("New beer inventory" + newInventoryEvent.getBeerDto().getBeerName() + ":" + newInventoryEvent.getBeerDto().getQuantityOnHand() );

    }

}
