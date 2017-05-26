package com.dajo.run;

import com.dajo.model.Stock;
import com.dajo.model.StockDetail;
import com.dajo.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

/**
 * Created by LordKotan on 26/05/2017... Hibernate
 */
public class RunOneToOne {
    public static void main(String[] args) {
        System.out.println("Hibernate one to one (Annotation)");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Stock stock = new Stock();
        stock.setStockCode("41");
        stock.setStockName("LORDI");
        StockDetail stockDetail = new StockDetail();
        stockDetail.setCompName("PADINI ");
        stockDetail.setCompDesc("one ");
        stockDetail.setRemark("Run Run");
        stockDetail.setListedDate(new Date());

        stock.setStockDetail(stockDetail);
        stockDetail.setStock(stock);

        session.save(stock);
        session.getTransaction().commit();

        System.out.println("Done");
    }
}
