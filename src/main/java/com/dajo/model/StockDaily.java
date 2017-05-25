package com.dajo.model;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by LordKotan on 25/05/2017... Hibernate
 */
@Entity
@Table(name = "stock_daily",catalog = "mstock",uniqueConstraints =
@UniqueConstraint(columnNames = "record_Date"))
public class StockDaily implements java.io.Serializable {

    private Integer recordId;
    private Stock stock;
    private Float priceOpen;
    private Float priceClose;
    private Float priceChange;
    private Long volume;
    private Date date;

    public StockDaily() {
    }

    public StockDaily(Stock stock, Date date) {
        this.stock = stock;
        this.date = date;
    }

    public StockDaily(Stock stock, Float priceOpen, Float priceClose,
                            Float priceChange, Long volume, Date date) {
        this.stock = stock;
        this.priceOpen = priceOpen;
        this.priceClose = priceClose;
        this.priceChange = priceChange;
        this.volume = volume;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "record_Id", unique = true, nullable = false)
    public Integer getRecordId() {
        return this.recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_Id", nullable = false)
    public Stock getStock() {
        return this.stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Column(name = "record_Price_Open", precision = 6)
    public Float getPriceOpen() {
        return this.priceOpen;
    }

    public void setPriceOpen(Float priceOpen) {
        this.priceOpen = priceOpen;
    }

    @Column(name = "record_Price_Close", precision = 6)
    public Float getPriceClose() {
        return this.priceClose;
    }

    public void setPriceClose(Float priceClose) {
        this.priceClose = priceClose;
    }

    @Column(name = "record_Price_Change", precision = 6)
    public Float getPriceChange() {
        return this.priceChange;
    }

    public void setPriceChange(Float priceChange) {
        this.priceChange = priceChange;
    }

    @Column(name = "record_Volume")
    public Long getVolume() {
        return this.volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "record_Date", unique = true, nullable = false, length = 10)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
