package com.after_sunrise.cryptocurrency.bitflyer4j.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * @author takanori.takase
 * @version 0.0.1
 */
public interface CoinOut {

    Long getId();

    String getOrderId();

    String getCurrency();

    BigDecimal getAmount();

    String getAddress();

    String getHash();

    BigDecimal getFee();

    BigDecimal getAdditionalFee();

    String getStatus();

    ZonedDateTime getEventDate();

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    class Request extends Entity implements Pagination {

        @SerializedName("count")
        private final Integer count;

        @SerializedName("before")
        private final Long before;

        @SerializedName("after")
        private final Long after;

    }

}
