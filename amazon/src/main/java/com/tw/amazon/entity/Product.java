package com.tw.amazon.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tw.library.model.Condition;
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
    protected ZonedDateTime deliveryDateTime;
    protected ZonedDateTime createdDateTime;

    public Product(String refNo, Condition condition) {
        this.refNo = refNo;
        this.condition = condition;
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