package com.tw.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tw.library.model.Condition;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("costume")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Costume extends AbstractEntity {

    protected String refNo;
    protected Condition condition;

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
}