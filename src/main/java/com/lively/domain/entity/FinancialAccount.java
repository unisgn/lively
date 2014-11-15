package com.lively.domain.entity;

import com.lively.exception.BusinessException;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by franCiS on Sep 14, 2014.
 */
@Entity
@Table
public class FinancialAccount extends BusinessEntity {


    @Transient
    private final String CODE_PATH_SEPERATOR = ":";
    @Column(nullable = false)
    private FinancialAccountType type;
    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;
    private String codePath;
    @ManyToOne
    private FinancialAccount parentNode;
    @OneToMany(mappedBy = "parentNode", cascade = CascadeType.ALL)
    private Set<FinancialAccount> childNodes = new HashSet<FinancialAccount>();
    private boolean isLeaf = true;
    private boolean isRoot = true;

    public FinancialAccount() {
    }

    public FinancialAccountType getType() {
        return type;
    }

    public void setType(FinancialAccountType type) {
        this.type = type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public FinancialAccount getParentNode() {
        return parentNode;
    }

    protected void setParentNode(FinancialAccount parentNode) {
        this.parentNode = parentNode;
    }

    public Set<FinancialAccount> getChildNodes() {
        return childNodes;
    }

/*    protected void setChildNodes(Set<FinancialAccount> childNodes) {
        this.childNodes = childNodes;
    }*/

    public String getCodePath() {
        return codePath;
    }

    protected void setCodePath(String codePath) { // TODO init code path
        this.codePath = codePath;
    }

    @Override
    public void setCode(String code) { // TODO just for test
        setCode(getNumber());
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    protected void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    protected void setRoot(boolean isRoot) {
        this.isRoot = isRoot;
    }

    public void appendChild(FinancialAccount childNode) throws BusinessException { //TODO to be implemented more explicitly
        if (!childNode.getType().equals(getType())) {
            throw new BusinessException("Append a child FinancialAccount node with different type is not supported YET.");
        }

        if (!childNode.isLeaf()) {
            throw new BusinessException("Append a child FinancialAccount node with isLeaf = false is not supported YET.");
        }

        if (childNode.getBalance().compareTo(BigDecimal.ZERO) != 0) {
            throw new BusinessException("Append a child FinancialAccount node with balance > 0 is not allowed YET.");
        }

        setLeaf(false);
        childNode.setRoot(false);


//        childNode.setParentNode(this);
        childNode.setCodePath(getCodePath() + CODE_PATH_SEPERATOR + childNode.getCode());

        getChildNodes().add(childNode);
    }

    public void makeDebit(BigDecimal amount) {
        setBalance(getType().isAsset() ? getBalance().add(amount) : getBalance().subtract(amount));
    }

    public void makeCredit(BigDecimal amount) {
        setBalance(getType().isAsset() ? getBalance().subtract(amount) : getBalance().add(amount));
    }


}
