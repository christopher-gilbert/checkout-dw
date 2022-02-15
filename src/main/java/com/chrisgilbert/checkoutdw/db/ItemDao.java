package com.chrisgilbert.checkoutdw.db;

import com.chrisgilbert.checkoutdw.api.Item;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import ru.vyarus.guicey.jdbi3.installer.repository.JdbiRepository;
import ru.vyarus.guicey.jdbi3.tx.InTransaction;

@JdbiRepository
@InTransaction
public interface ItemDao {

    @SqlUpdate("create table item(id varchar(50) primary key, sku varchar(10), description varchar(255), unit_price int)")
    void createItemTable();

    @SqlUpdate("insert into item(id, sku, description, unit_price) values (:id, :sku, :description, :unit_price)")
    void insert(@Bind("id") String id,
                @Bind("sku") String sku,
                @Bind("description") String description,
                @Bind("unit_price") int unitPrice);


    @SqlQuery("select * from item where sku = :sku")
    @RegisterConstructorMapper(Item.class)
    Item findBySku(@Bind("sku") String sku);

}
