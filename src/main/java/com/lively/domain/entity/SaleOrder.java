package com.lively.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by franCiS on Oct 03, 2014.
 */
@Entity
@Table
public class SaleOrder extends BusinessActivity {

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private CustomerManager customerMgr;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_fk")
    private Set<SaleOrderItem> items = new HashSet<SaleOrderItem>();

    private BigDecimal moneyAmount;
    private BigDecimal taxAmount;

    private SaleOrderStatus orderStatus;

    public SaleOrder() {
        super();
        setType(ActivityType.SALE_ORDER);
    }

}
