Ext.define('Jeeper.apps.journal.GeneralJournalGrid', {
    extend: 'Ext.grid.Panel',

    requires: 'Jeeper.model.AccountJournal',

    width: 1000,
    height: 600,
    columnLines: true,

    
    
    initComponent: function() {
        var me = this;

        
        Ext.apply(me, {
            store: Ext.create('Ext.data.Store', {
                model: 'Jeeper.model.AccountJournal',
                autoLoad: true
            }),
            columns:[{
                text: '日期',
                dataIndex: 'journalDate',
                renderer: Ext.util.Format.dateRenderer('Y-m-d'),
                width: 90
            }, {
                text: '凭证编号',
                dataIndex: 'number',
                width: 80,
                renderer: function(value) {
                    return value ? value : '-';
                }
            }, {
                text: '摘要',
                dataIndex: 'memo',
                renderer: function(value, metaData, record) {
                    var html = '';
                    var items = record.raw.items;
                    var length = items.length;
                    for(var i = 0; i < length; i++) {
                        var memo = items[i].memo ? items[i].memo : '';
                        html += ('<p class="x-grid-cell-inner">' + memo + '</p>');
                    }
                    return html;
                },
                flex: 2
            }, {
                text: '科目',
                dataIndex: 'account',
                renderer: function(value, metaData, record) {
                    var html = '';
                    var items = record.raw.items;
                    var length = items.length;
                    for(var i = 0; i < length; i++)
                        html += ('<p class="x-grid-cell-inner">' + items[i].account.fullPathName + '</p>');
                    return html;
                },
                flex: 1
            }, {
                text: '借',
                dataIndex: 'debit',
                renderer: function(value, metaData, record) {
                    var html = '';
                    var items = record.raw.items;
                    var length = items.length;
                    for(var i = 0; i < length; i++) {
                        var debit =  (items[i].debit ? Ext.util.Format.number(items[i].debit, '0,0.00') : '&nbsp');
                        html += ('<p class="x-grid-cell-inner" style="text-align:right;">' + debit + '</p>');
                    }
                        
                    return html;
                },
                width: 80
            }, {
                text: '贷',
                dataIndex: 'credit',
                width: 80,
                renderer: function(value, metaData, record) {
                    var html = '';
                    var items = record.raw.items;
                    var length = items.length;
                    for(var i = 0; i < length; i++) {
                        var credit = items[i].credit ? Ext.util.Format.number(items[i].credit, '0,0.00') : '&nbsp';
                        html += ('<p class="x-grid-cell-inner" style="text-align:right;">' + credit + '</p>');
                    }
                        
                    return html;
                }
            }, {
                text: '合作伙伴',
                dataIndex: 'partner_name',
                renderer: function(value, metaData, record) {
                    var html = '';
                    var items = record.raw.items;
                    var length = items.length;
                    for(var i = 0; i < length; i++) {
                        var partner = items[i].linkedPartner ? items[i].linkedPartner.name : '-';
                        html += ('<p class="x-grid-cell-inner">' + partner + '</p>');
                    }
                    return html;
                },
                flex: 2
            }]
        });
        me.on({
            containercontextmenu: me.onContainerContextMenu,
            itemcontextmenu: me.onItemContextMenu,
            itemdblclick: me.onItemDblClick,
            scope: me
        });
        me.callParent();
    },

    onContainerContextMenu: function(dom, e) {
        var menu = Ext.create('Ext.menu.Menu', {
            items:[{
                text: '新建记账',
                handler: this.launchJournalCard,
                scope: this
            }]
        });

        menu.showAt(e.getXY());
    },

    onItemContextMenu: function(dom, record, item, index, e) {
        var me = this;
        var menu = Ext.create('Ext.menu.Menu', {
            items:[{
               
                
                text:'新建记账',
                handler: this.launchJournalCard,
                scope: this
            }]
        });
        menu.showAt(e.getXY());
    },
    onItemDblClick: function(dom, record) {
        this.launchJournalCard({journal: record});
    },
    launchJournalCard: function(cfg) {
        Ext.create('Jeeper.apps.journal.JournalCard', cfg).show();
    }

});
