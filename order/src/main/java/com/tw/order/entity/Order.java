package com.tw.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tw.library.model.Condition;
import com.tw.library.model.OrderChannelCode;

import javax.persistence.Entity;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Random;
import java.util.UUID;

@Entity(name = "`order`")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order extends AbstractEntity {

    protected String refNo;
    protected OrderChannelCode channelCode;
    protected ZonedDateTime assignmentDateTime;

    public Order() {
        if (super.isNew) {
            this.refNo = UUID.randomUUID().toString();
            this.assignmentDateTime = ZonedDateTime.now(ZoneOffset.UTC);
        }
    }

    public Order(String refNo, OrderChannelCode channelCode) {
        this.refNo = refNo;
        this.channelCode = channelCode;
        this.assignmentDateTime = ZonedDateTime.now(ZoneOffset.UTC);
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getRefNo() {
        return this.refNo;
    }

    public void setChannelCode(OrderChannelCode channelCode) {
        this.channelCode = channelCode;
    }

    public OrderChannelCode getChannelCode() {
        return this.channelCode;
    }

    public void setAssignmentDateTime(ZonedDateTime assignmentDateTime) {
        this.assignmentDateTime = assignmentDateTime;
    }

    public ZonedDateTime getAssignmentDateTime() {
        return assignmentDateTime;
    }
}