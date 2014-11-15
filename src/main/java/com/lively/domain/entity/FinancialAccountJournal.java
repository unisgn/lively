package com.lively.domain.entity;

import com.lively.exception.BusinessException;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by franCiS on Oct 04, 2014.
 */
@Entity
@Table
public class FinancialAccountJournal extends AbstractEnhancedAuditable<Long> {
    private DateTime date;
    private String number;
    private String brief;
    private BigDecimal totalAmount;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "journal_fk")
    private Set<FinancialAccountJournalItem> items = new HashSet<FinancialAccountJournalItem>();

    public FinancialAccountJournal() {
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Set<FinancialAccountJournalItem> getItems() {
        return items;
    }

    public void setItems(Set<FinancialAccountJournalItem> items) {

        this.items = items;
    }

    public void updateItems(Collection<FinancialAccountJournalItem> items) throws BusinessException {
        checkItems(items);

    }

    public void checkItems(Collection<FinancialAccountJournalItem> items) throws BusinessException {
        if (items == null || items.size() == 0) {
            throw new BusinessException("Items Can't be null or empty.");
        }
        if (items.size() == 1) {
            throw new BusinessException("Items with only 1 line doesn't make sense.");
        }

        BigDecimal totalDebit = BigDecimal.ZERO;
        BigDecimal totalCredit = BigDecimal.ZERO;
        Iterator<FinancialAccountJournalItem> it = items.iterator();
        while (it.hasNext()) {
            totalDebit = totalDebit.add(it.next().getDebit());
            totalCredit = totalCredit.add(it.next().getCredit());
        }
        if (totalDebit.compareTo(totalCredit) != 0) {
            throw new BusinessException("Total debit:" + totalDebit + " doesn't equal to total credit:" + totalCredit +".");
        }
    }

}
