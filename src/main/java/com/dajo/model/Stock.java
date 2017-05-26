package com.dajo.model;
import javax.persistence.*;
import  java.util.HashSet;
import java.util.Set;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by LordKotan on 25/05/2017... Hibernate
 */

@Entity
    @Table(name = "stock",catalog = "mstock",uniqueConstraints = {
        @UniqueConstraint(columnNames = "stock_Name"),
        @UniqueConstraint(columnNames = "stock_Code")})
public class Stock implements java.io.Serializable {

    private Integer stockId;
    private String stockCode;
    private String stockName;
    private Set<StockDaily> stockDailySet = new HashSet<StockDaily>(0);
    private Set<Category> categories = new HashSet<Category>(0);
    private StockDetail stockDetail;

    //constructors
    public Stock(){};
    public Stock(String stock_Name, String stock_Code ){
        this.stockCode = stock_Code;
        this.stockName = stock_Name;
    }
    public Stock(String stock_Name, String stock_Code,Set<StockDaily> stockDailies ){
        this.stockCode = stock_Code;
        this.stockName = stock_Name;
        this.stockDailySet = stockDailies;
    }
    public Stock(String stockCode, String stockName, StockDetail stockDetail) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.stockDetail = stockDetail;
    }

    //Set And Getters

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="stock_Id",unique = true,nullable = false)
    public Integer getStockId() {
        return stockId;
    }
    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }
    @Column(name = "stock_Code", unique = true, nullable = false, length = 10)
    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }
    @Column(name = "stock_Name", unique = true, nullable = false, length = 20)
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
    public Set<StockDaily> getStockDailySet() {
        return stockDailySet;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "stock_category", catalog = "mstock", joinColumns = {
            @JoinColumn(name = "stock_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "category_id",
                    nullable = false, updatable = false) })

    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void setStockDailySet(Set<StockDaily> stockDailySet) {
        this.stockDailySet = stockDailySet;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "stock", cascade = CascadeType.ALL)
    public StockDetail getStockDetail() {
        return this.stockDetail;
    }

    public void setStockDetail(StockDetail stockDetail) {
        this.stockDetail = stockDetail;
    }


}



