package com.lively.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by franCiS on Oct 04, 2014.
 */
@Entity
@Table
public class FinancialAccountJournalItem extends AbstractPersistable<Long> {
    private String brief;

    @ManyToOne
    private FinancialAccount account;

    private BigDecimal debit;
    private BigDecimal credit;

    public FinancialAccountJournalItem() {
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public FinancialAccount getAccount() {
        return account;
    }

    public void setAccount(FinancialAccount account) {
        this.account = account;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }
}
