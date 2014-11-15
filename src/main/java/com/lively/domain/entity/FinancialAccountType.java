package com.lively.domain.entity;

/**
 * Created by franCiS on Oct 03, 2014.
 */
public enum FinancialAccountType {
    CASH,
    ACCOUNT_RECEIVABLE,
    OTHER_CURRENT_ASSET,
    FIXED_ASSET,
    OTHER_LONGTERM_ASSET,
    OTHER_ASSET,

    ACCOUNT_PAYABLE,
    OTHER_CURRENT_LIABILITY,
    OTHER_LONGTERM_LIABILITY,
    OTHER_LIABILITY,

    INCOME,
    COG,
    EXPENSE,
    RETAINED_EARNINGS,
    COMMON_STOCK,
    OTHER_EQUITY;

    public final boolean isAsset() {
        return this.ordinal() <= OTHER_ASSET.ordinal();
    }

    public final boolean isLiability() {
        return ACCOUNT_PAYABLE.ordinal() < this.ordinal() && this.ordinal() <= OTHER_LIABILITY.ordinal();
    }

    public final boolean isEquity() {
        return INCOME.ordinal() <= this.ordinal();
    }

}
