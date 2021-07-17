package com.fusionkoding.beer.inventory.service.services;

import com.fusionkoding.beer.inventory.service.config.JmsConfig;
import com.fusionkoding.brewery.model.AllocateBeerOrderRequest;
import com.fusionkoding.brewery.model.AllocateBeerOrderResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AllocationRequestListener {

    private final JmsTemplate jmsTemplate;
    private final AllocationService allocationService;

    @Transactional
    @JmsListener(destination = JmsConfig.ALLOCATE_ORDER_QUEUE)
    public void listen(@Payload AllocateBeerOrderRequest allocateBeerOrderRequest) {

        Optional.ofNullable(allocateBeerOrderRequest.getBeerOrder()).ifPresent(beerOrderDto -> {

            AllocateBeerOrderResult.AllocateBeerOrderResultBuilder builder = AllocateBeerOrderResult.builder().beerOrder(beerOrderDto);
            builder.beerOrder(beerOrderDto);

            try {
                boolean allocated = allocationService.allocateOrder(beerOrderDto);

                builder.pendingInventory(!allocated);
            } catch (Exception e) {
                log.error("Allocation failed for order: " + allocateBeerOrderRequest.getBeerOrder().getId());
                builder.allocationError(true);
            }

            jmsTemplate.convertAndSend(JmsConfig.ALLOCATE_ORDER_RESULT_QUEUE, builder.build());
        });


    }

}
