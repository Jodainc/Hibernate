package com.dajo.run;

import com.dajo.model.Category;
import com.dajo.model.Stock;
import com.dajo.util.HibernateUtil;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LordKotan on 25/05/2017... Hibernate
 */
public class RunManyToMany {
    public static void main(String[] args) {
        System.out.println("Hibernate many to many (Annotation)");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Stock stock = new Stock();
        stock.setStockCode("7052");
        stock.setStockName("KOTAN");
        Category category1 = new Category("VENDEDORJR", "VENDEDOR COMPAÑIA");
        Category category2 = new Category("VENDEDORSR", "VENDEDOR SENIOR");
        Set<Category> categories = new HashSet<Category>();
        categories.add(category1);
        categories.add(category2);
        stock.setCategories(categories);
        session.save(stock);
        session.getTransaction().commit();
        System.out.println("Done");
        /*
        The Query "SELECT" is simimilar to
        SELECT `stock`.`stock_Name`,`stock`.`stock_Id`,`category`.`category_name` FROM `stock`
        INNER JOIN `stock_category` ON  `stock_category`.`stock_Id` =`stock`.`stock_Id`
        INNER JOIN `category` ON `category`.`category_id` = `stock_category`.`category_id`
        WHERE `stock`.`stock_Id`=3
         */
    }
}
