package com.tw.library.dto;

import com.tw.library.model.OrderChannelCode;
import com.tw.library.model.SellStatus;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class OrderDto implements Serializable {

    protected final CostumeDto costumeDto;
    protected final String refNo;
    protected final OrderChannelCode channelCode;
    protected final SellStatus status;
    protected final ZonedDateTime assignmentDateTime;

    public OrderDto(final CostumeDto costumeDto) {
        this.costumeDto = costumeDto;
        this.refNo = null;
        this.channelCode = null;
        this.status = SellStatus.PENDING;
        this.assignmentDateTime = null;
    }

    public OrderDto(final CostumeDto costumeDto,
                    final String refNo, final OrderChannelCode channelCode, final ZonedDateTime assignmentDateTime) {
        this.costumeDto = costumeDto;
        this.refNo = refNo;
        this.channelCode = channelCode;
        this.status = SellStatus.PENDING;
        this.assignmentDateTime = assignmentDateTime;
    }

    public OrderDto(final String refNo, final OrderChannelCode channelCode, final SellStatus status) {
        this.costumeDto = null;
        this.refNo = refNo;
        this.channelCode = channelCode;
        this.status = status;
        this.assignmentDateTime = null;
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

    public SellStatus getStatus() {
        return this.status;
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
