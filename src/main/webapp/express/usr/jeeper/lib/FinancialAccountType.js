Ext.define('Jeeper.lib.FinancialAccountType', {
    singleton: true,

    cash                     : 'CASH',
    account_receivable       : 'ACCOUNT_RECEIVABLE',
    other_current_asset      : 'OTHER_CURRENT_ASSET',
    fixed_asset              : 'FIXED_ASSET',
    other_longterm_asset     : 'OTHER_LONGTERM_ASSET',
    other_asset              : 'OTHER_ASSET',

    account_payable          : 'ACCOUNT_PAYABLE',
    other_current_liability  : 'OTHER_CURRENT_LIABILITY',
    other_longterm_liability : 'OTHER_LONGTERM_LIABILITY',
    other_liability          : 'OTHER_LIABILITY',

    income                   : 'INCOME',
    cog                      : 'COG',
    expense                  : 'EXPENSE',

    retained_earnings        : 'RETAINED_EARNINGS',

    common_stock             : 'COMMON_STOCK',
    other_equity             : 'OTHER_EQUITY',
    
    asset:['CASH', 'ACCOUNT_RECEIVABLE', 'OTHER_CURRENT_ASSET', 'FIXED_ASSET', 'OTHER_LONGTERM_ASSET', 'OTHER_ASSET'],
    liability:['ACCOUNT_PAYABLE', 'OTHER_CURRENT_LIABILITY', 'OTHER_LONGTERM_LIABILITY', 'OTHER_LIABILITY'],
    equity:['RETAINED_EARNINGS', 'COMMON_STOCK', 'OTHER_EQUITY'],
    retainedEarnings:['INCOME', 'COG', 'EXPENSE'],

    types: [
        'CASH', 'ACCOUNT_RECEIVABLE', 'OTHER_CURRENT_ASSET', 'FIXED_ASSET', 'OTHER_LONGTERM_ASSET', 'OTHER_ASSET',
        'ACCOUNT_PAYABLE', 'OTHER_CURRENT_LIABILITY', 'OTHER_LONGTERM_LIABILITY', 'OTHER_LIABILITY',
        'INCOME', 'COG', 'EXPENSE',
        'RETAINED_EARNINGS', 'COMMON_STOCK', 'OTHER_EQUITY'
    ],

    
    isAsset:function(type) {
        return this.asset.indexOf(type) < 0 ? false : true;
    },

    isLiability:function(type) {
        return this.liability.indexOf(type) < 0 ? false : true;
    },

    isEquity: function(type) {
        return this.equity.indexOf(type) < 0 ? false : true;
    },

    isAccountReceivable: function(type) {
        return type === this.account_receivable;
    },

    isAccountPayable: function(type) {
        return type === this.account_payable;
    },

    isRetainedEarnings: function(type) {
        return this.retained_earnings.indexOf(type) < 0 ? false : true;
    }
    
});
