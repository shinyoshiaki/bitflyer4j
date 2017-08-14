package com.after_sunrise.cryptocurrency.bitflyer4j.core.impl;

import com.after_sunrise.cryptocurrency.bitflyer4j.Bitflyer4j;
import com.after_sunrise.cryptocurrency.bitflyer4j.core.Environment;
import com.after_sunrise.cryptocurrency.bitflyer4j.core.ExecutorFactory;
import com.after_sunrise.cryptocurrency.bitflyer4j.service.AccountService;
import com.after_sunrise.cryptocurrency.bitflyer4j.service.MarketService;
import com.after_sunrise.cryptocurrency.bitflyer4j.service.OrderService;
import com.after_sunrise.cryptocurrency.bitflyer4j.service.RealtimeService;
import com.google.inject.Injector;
import com.pubnub.api.PubNub;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;

/**
 * Implementation using dependency injection.
 *
 * @author takanori.takase
 * @version 0.0.1
 */
@Slf4j
public class Bitflyer4jImpl implements Bitflyer4j {

    private final Injector injector;

    @Getter
    private final String version;

    @Getter
    private final MarketService marketService;

    @Getter
    private final AccountService accountService;

    @Getter
    private final OrderService orderService;

    @Getter
    private final RealtimeService realtimeService;

    @Inject
    public Bitflyer4jImpl(Injector i) {

        injector = i;

        version = injector.getInstance(Environment.class).getVersion();

        marketService = injector.getInstance(MarketService.class);

        accountService = injector.getInstance(AccountService.class);

        orderService = injector.getInstance(OrderService.class);

        realtimeService = injector.getInstance(RealtimeService.class);

        log.info("Initialized : {}", version);

    }

    @Override
    public void close() throws Exception {

        injector.getInstance(PubNub.class).destroy();

        injector.getInstance(ExecutorFactory.class).shutdown();

        log.info("Terminated.");

    }

}
