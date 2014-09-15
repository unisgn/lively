Ext.define('Jeeper.apps.journal.AccountJournalGrid', {
    extend: 'Ext.grid.Panel',

    requires: [
        'Jeeper.model.AccountJournalItem',
        'Jeeper.lib.FinancialAccountType',
        'Jeeper.apps.journal.JournalCard'
    ],

    width: 800,
    height: 600,
    columnLines: true,

    balance: 0,

    account: null,
    isAsset: false,
    constructor: function(cfg) {
        var me = this;
        //console.log(cfg);
        Ext.apply(me, cfg);
        me.isAsset = Jeeper.lib.FinancialAccountType.isAsset(me.account.get('type'));
        me.callParent();
    },
    
    initComponent: function() {
        var me = this;

        Ext.apply(me, {
            store: Ext.create('Ext.data.Store', {
                model: 'Jeeper.model.AccountJournalItem',
                proxy: {
                    type: 'ajax',
                    url: '../res/financial_account_journal_items/by_account/' + me.account.getId(),
                    reader: {
                        type: 'json',
                        root: 'data'
                    }
                
                },
                autoLoad: true
            }),
            features:[{
                ftype:'summary'
            }],
            columns:[{
                text: '日期',
                dataIndex: 'journal_date',
                renderer: this.render_journalDate,
                width: 100,
                summaryRenderer: function() { return '总计'; }
            }, {
                text: '编号',
                dataIndex: 'journal_number',
                renderer: me.render_journalNumber,
                width: 120
            }, {
                text: '摘要',
                dataIndex: 'memo',
                flex: 1
            }, {
                text: '借',
                width: 80,
                dataIndex: 'debit',
                align: 'right',
                renderer: function(value) {
                    return value ? Ext.util.Format.number(value, '0,0.00') : '&nbsp';
                },
                summaryType: 'sum'
            }, {
                text: '贷',
                dataIndex: 'credit',
                width: 80,
                align: 'right',
                renderer: function(value) {
                    return value ? Ext.util.Format.number(value, '0,0.00') : '&nbsp';
                },
                summaryType: 'sum'
            }, {
                text: '合作伙伴',
                dataIndex: 'linkedPartner_fk',
                width: 200,
                renderer: this.render_partner
            }, {
                text: '余额',
                dataIndex: 'balance',
                width: '80',
                align: 'right',
                renderer: this.render_balance
            }],
            listeners:{
                itemdblclick: this.onItemDblClick,
                scope: this
            }
        });
        me.callParent();
    },

    onItemDblClick: function(dom, record, index, e, eOpts) {
        Jeeper.model.AccountJournal.load(record.raw.journal.id, {
            success: function(rec) {
                this.launchGeneralJournal({journal: rec});
            },
            scope: this
        });
    },


    launchGeneralJournal:function(cfg) {
        Ext.create('Jeeper.apps.journal.JournalCard', cfg).show();
    },

    render_journalDate: function(value, metaData, record, rowIndex, colIndex, store, view) {
        //console.log(record);
        return Ext.Date.format(new Date(record.raw.journal.journalDate), 'Y-m-d');
    },

    render_journalNumber: function(value, metaData, record, rowIndex, colIndex, store, view) {
        return record.raw.journal.number;
    },
    
    render_partner: function(value, metaData, record, rowIndex, colIndex, store, view) {
        var partner = record.raw.linkedPartner;
        return partner ? partner.name : '-';
    },
    render_balance: function(value, metaData, record, rowIndex, colIndex, store, view) {
        if(this.isAsset) {
            this.balance += (record.get('debit') - record.get('credit'));
        } else {
            this.balance += (record.get('credit') - record.get('debit'));
        }

        return Ext.util.Format.number(this.balance, '0,0.00');
    }
});
