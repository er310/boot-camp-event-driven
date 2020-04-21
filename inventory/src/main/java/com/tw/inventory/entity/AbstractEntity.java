package com.tw.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;

@MappedSuperclass
public class AbstractEntity implements BaseEntity {

    @Id
    protected String id;

    @JsonIgnore
    @Transient
    protected boolean isNew;

    protected String name;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public boolean getIsNew() {
        return this.isNew = (this.id == null);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
