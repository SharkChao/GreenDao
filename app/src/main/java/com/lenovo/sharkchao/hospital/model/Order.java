package com.lenovo.sharkchao.hospital.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by SharkChao on 2017/1/11.
 */

@Entity
public class Order {
    @Id
    private Long id;
    @Property
    private Date date;
    private long customerId;
    @Generated(hash = 171035120)
    public Order(Long id, Date date, long customerId) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
    }
    @Generated(hash = 1105174599)
    public Order() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDate() {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public long getCustomerId() {
        return this.customerId;
    }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}