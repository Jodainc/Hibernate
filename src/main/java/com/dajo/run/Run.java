package com.dajo.run;
import java.util.Date;
import com.dajo.model.Stock;
import com.dajo.model.StockDaily;
import com.dajo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by LordKotan on 25/05/2017... Hibernate
 */
public class Run {
        public static void main(String[] args) {
            System.out.println("Hibernate one to many (Annotation)");
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Stock stock = new Stock();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                stock =  (Stock) session.get(Stock.class, 1);
                session.save(stock);
            } catch (Exception e) {
                System.out.println(e.getCause());
            }
            System.out.println("Hola");
               /*
            stock.setStockCode("1");
            stock.setStockName("PADINI");
            session.save(stock);
            */
            StockDaily stockDailyRecords = new StockDaily();
            stockDailyRecords.setPriceOpen(new Float("1.5"));
            stockDailyRecords.setPriceClose(new Float("1.8"));
            stockDailyRecords.setPriceChange(new Float("20.0"));
            stockDailyRecords.setVolume(4000000L);
            stockDailyRecords.setDate(new Date());

            stockDailyRecords.setStock(stock);
            stock.getStockDailySet().add(stockDailyRecords);
            session.save(stockDailyRecords);

            //session.getTransaction().commit();
            System.out.println("Done");
            Transaction tx=null;
            try{
                tx = session.beginTransaction();
                session.save(stockDailyRecords);
                tx.commit();
            } catch (Exception e){
                System.out.println(e);
                tx.rollback();
                session.close();
            }
        }
    }

