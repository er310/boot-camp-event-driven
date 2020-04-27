package com.tw.amazon.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tw.library.model.Condition;
import com.tw.library.model.SellStatus;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Document(collection = "product")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product extends AbstractEntity {

    protected String refNo;
    protected boolean isPublished;
    protected Condition condition;
    protected String description;
    protected SellStatus status;
    protected ZonedDateTime deliveryDateTime;
    protected ZonedDateTime createdDateTime;

    public Product() {
    }

    public Product(String refNo, Condition condition) {
        this.refNo = refNo;
        this.isPublished = false;
        this.condition = condition;
        this.status = SellStatus.SELL;
        this.createdDateTime = ZonedDateTime.now(ZoneOffset.UTC);
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getRefNo() {
        return this.refNo;
    }

    public void setIsPublished(boolean isPublished) {
        this.isPublished = isPublished;
    }

    public boolean getIsPublished(boolean published) {
        return this.isPublished;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Condition getCondition() {
        return this.condition;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setStatus(SellStatus status) {
        this.status = status;
    }

    public SellStatus getStatus() {
        return this.status;
    }

    public void setDeliveryDateTime(ZonedDateTime deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    public ZonedDateTime getDeliveryDateTime() {
        return this.deliveryDateTime;
    }

    public void setCreatedDateTime(ZonedDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public ZonedDateTime getCreatedDateTime() {
        return this.createdDateTime;
    }
}