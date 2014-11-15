package com.lively.domain.entity;

import sun.util.resources.cldr.gv.LocaleNames_gv;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by franCiS on Oct 03, 2014.
 */
@Entity
@Table
public class SaleOrderItem extends AbstractPersistable<Long> {
    private int lineNo;

    @ManyToOne
    private Part part;
    private int orderedQty;
    private int invoicedQty;
    private int shippedQty;

    @ManyToOne
    private Uom uom;
    private BigDecimal price;
    private BigDecimal moneyAmount;
    private BigDecimal taxAmount;


    public SaleOrderItem() { }
}
