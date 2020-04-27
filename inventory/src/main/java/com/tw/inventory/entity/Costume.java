package com.tw.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tw.library.data.Status;
import com.tw.library.model.Condition;
import com.tw.library.model.SellStatus;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Document(collection = "costume")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Costume extends AbstractEntity {

    protected String refNo;
    protected Condition condition;
    protected SellStatus status;
    protected ZonedDateTime createdDateTime;

    public Costume(String refNo, Condition condition) {
        this.refNo = refNo;
        this.condition = condition;
        this.status = SellStatus.PENDING;
        this.createdDateTime = ZonedDateTime.now(ZoneOffset.UTC);
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getRefNo() {
        return this.refNo;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Condition getCondition() {
        return this.condition;
    }

    public void setStatus(SellStatus status) {
        this.status = status;
    }

    public SellStatus getStatus() {
        return this.status;
    }

    public void setCreatedDateTime(ZonedDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public ZonedDateTime getCreatedDateTime() {
        return this.createdDateTime;
    }
}