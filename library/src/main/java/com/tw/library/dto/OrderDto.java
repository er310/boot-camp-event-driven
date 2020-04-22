package com.tw.library.dto;

import com.tw.library.model.OrderChannelCode;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class OrderDto implements Serializable {

    protected final CostumeDto costumeDto;
    protected final String refNo;
    protected final OrderChannelCode channelCode;
    protected final ZonedDateTime assignmentDateTime;

    public OrderDto() {
        this.costumeDto = null;
        this.refNo = null;
        this.channelCode = null;
        this.assignmentDateTime = null;
    }

    public OrderDto(final CostumeDto costumeDto) {
        this.costumeDto = costumeDto;
        this.refNo = null;
        this.channelCode = null;
        this.assignmentDateTime = null;
    }

    public OrderDto(final CostumeDto costumeDto,
                    final String refNo, final OrderChannelCode channelCode, final ZonedDateTime assignmentDateTime) {
        this.costumeDto = costumeDto;
        this.refNo = refNo;
        this.channelCode = channelCode;
        this.assignmentDateTime = assignmentDateTime;
    }

    public CostumeDto getCostumeDto() {
        return this.costumeDto;
    }

    public String getRefNo() {
        return this.refNo;
    }

    public OrderChannelCode getChannelCode() {
        return this.channelCode;
    }

    public ZonedDateTime getAssignmentDateTime() {
        return this.assignmentDateTime;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "costumeDto=" + costumeDto +
                ", refNo='" + refNo + '\'' +
                ", channelCode=" + channelCode +
                ", assignmentDateTime=" + assignmentDateTime +
                '}';
    }
}
