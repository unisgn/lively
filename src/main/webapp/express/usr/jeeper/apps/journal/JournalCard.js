Ext.define('Jeeper.apps.journal.JournalCard', {
    extend: 'Beaux.sys.XWindow',

    requires: [
        'Jeeper.model.AccountJournal',
        'Jeeper.model.AccountJournalItem',
        'Jeeper.model.FinancialAccount',
        'Jeeper.model.Partner'
    ],

    model: 'Jeeper.model.AccountJournal',
    newTitle: 'new AccountJournal',
    titleProperty: 'number',

    
    layout:'vbox',
    bodyPadding:5,

    

    itemGrid: null,

    journal: null,

    constructor: function(cfg) {
        var me = this;
        me.journal = cfg ? cfg.journal : null;
        me.callParent();
    },
    
    initComponent: function(){
        var me = this;
        me.partnerStore = Ext.create('Ext.data.Store', {
            model: 'Jeeper.model.Partner',
            listeners:{
                load: function() { me.initItemStore(); },
                scope: me
            }
        });
        me.accountStore = Ext.create('Ext.data.Store', {
            model: 'Jeeper.model.FinancialAccount',
            listeners:{
                load: function() { me.partnerStore.load(); },
                scope: me
            }
        });

        
        me.card = me.buildModelCard();
        me.itemGrid = me.buildItemGrid();
        me.itemGrid.on({
            containercontextmenu: me.onGridContainerContextMenu,
            itemcontextmenu: me.onGridItemContextMenu,
            scope: me
        });
        
        Ext.apply(me, {
            items:[
                me.card, me.itemGrid
            ],
            dockedItems: [{
                xtype:'toolbar',
                dock:'bottom',
                ui:'footer',
                defaults:{minWidth: 80},
                items:[{
                    xtype:'component',
                    flex: 1
                }, {
                   
                    text:'保存',
                    handler: me.handle_btn_save,
                    socpe: me
                
                }]
            }]
        });

        me.accountStore.load();
        me.callParent();
    },
    
    buildModelCard: function() {
        var me = this;
        return Ext.create('Ext.form.Panel', {
            width: 800,
            bodyPadding: 5,
            defaultType: 'textfield',
            items: [{
                xtype:'fieldcontainer',
                layout: 'hbox',
                fieldDefaults:{
                    labelWidth: 60
                },
                items: [{
                    fieldLabel: '日期',
                    name: 'journalDate',
                    xtype: 'datefield',
                    value: me.journal ? me.journal.get("journalDate") : new Date()
                }, {
                    xtype:'tbtext',
                    flex: 1
                }, {
                    fieldLabel: '凭证编号',
                    name:'number',
                    xtype: 'textfield',
                    value: me.journal ? me.journal.get("number") : ''
                }]
            }]
            
        });
    },

    buildItemGrid: function() {
        var me = this;
        me.itemStore = Ext.create('Ext.data.Store', {
            model:'Jeeper.model.AccountJournalItem'
        });
        
        
        return Ext.create('Ext.grid.Panel', {
            xtype: 'cell-editing',
            plugins:[
                Ext.create('Ext.grid.plugin.CellEditing', {
                    clicksToEdit: 1
                })
            ],
            features:[
                {ftype:'summary'}
            ],
            width: 800,
            height: 300,
            columnLines:true,
            store: me.itemStore,
            columns:[{
                text: 'Memo',
                header: '摘要',
                dataIndex: 'memo',
                menuDisabled: true,
                flex: 1,
                editor: {
                    allowBlank: false
                },
                summaryRenderer: function() { return '总计'; }
            }, {
                text:'Account',
                header: '科目',
                dataIndex: 'account_fk',
                menuDisabled: true,
                width: 150,
                editor: Ext.create('Ext.form.field.ComboBox', {
                    displayField: 'fullPathName',
                    valueField: 'id',
                    store: me.accountStore,
                    queryMode:'local',
                    enableRegEx:true
                }),
                
                renderer:function(value) {
                    if(value > 0) {
                        return me.accountStore.findRecord('id', value).get('fullPathName');
                    } else {
                        return '';
                    }
                }
                 
            }, {
                text:'Debit',
                header: '借',
                align: 'right',
                dataIndex:'debit',
                menuDisabled: true,
                width: 100,
                summaryType:'sum',
                editor: 'numberfield',
                renderer: function(value) {
                    return value > 0 ? value : '';
                }
            }, {
                text:'贷',
                header: '贷',
                dataIndex:'credit',
                menuDisabled:true,
                summaryType:'sum',
                align: 'right',
                width: 100,
                editor:'numberfield',
                renderer: function(value) {
                    return value > 0 ? value : '';
                }
            }, {
                text:'Partner',
                header: '合作伙伴',
                dataIndex: 'linkedPartner_fk',
                menuDisabled:true,
                width: 150,
                editor: {
                    xtype: 'combobox',
                    matchFieldWith:false,
                    displayField: 'name',
                    valueField: 'id',
                    queryMode:'local',
                    enableRegEx:true,
                    listConfig:{
                        resizeable: true,
                        width: 200
                    },
                    store: me.partnerStore
                },
                
                renderer:function(value) {
                    return value > 0 ? me.partnerStore.findRecord('id', value).get('name') : '';
                }
            }]
         
        });
    },

    onGridContainerContextMenu: function(grid, e) {
        menu = Ext.create('Ext.menu.Menu', {
            items: [{
                text: '添加新条目',
                handler: function() {
                    grid.getStore().add(Ext.create('Jeeper.model.AccountJournalItem'));
                },
                scope: this
            }]
        }).showAt(e.getXY());
    },
    onGridItemContextMenu: function(grid, record, item, index, e){
        Ext.create('Ext.menu.Menu', {
            items:[{
                text: '清除当前条目',
                handler: function() {
                    // clear current line
                    var newRecord = Ext.create('Jeeper.model.AccountJournalItem');
                    // ref: Ext.form.Basic.updateRecord()
                    record.beginEdit();
                    record.set(newRecord.getData());
                    record.endEdit();
                },
                scope: this
            }, {
                text: '删除当前条目',
                handler: function() {
                    // delete current line
                    grid.getStore().removeAt(index);
                },
                scope: this
            }, '-',  {
                text:'添加新条目',
                handler: function() {
                    grid.getStore().add(Ext.create('Jeeper.model.AccountJournalItem'));
                },
                scope: this
            }]
        }).showAt(e.getXY());
    },

    handle_btn_save:function() {
        var me = this,
            journalJson = Ext.create('Jeeper.model.AccountJournal').getData(),
            win = me.up('panel'),
            store = win.itemGrid.getStore(),
            nextUnblankLine = 0,
            totalDebit = 0,
            totalCredit = 0;
        journalJson.journalDate = Ext.Date.format(new Date(win.card.getValues().journalDate), 'time');
        journalJson.number = win.card.getValues().number;
        journalJson.items = new Array();
        store.each(function(record) {
            if(record.get('account_fk') && (record.get('credit') + record.get('debit'))) {
                totalDebit += record.get('debit');
                totalCredit += record.get('credit');
                journalJson.items[nextUnblankLine++] = record.getData();
                
            } 
        }, this);
        if(nextUnblankLine > 0 && (totalCredit === totalDebit)) {
            var journal = me.up('panel').journal;
            var action = journal ? "PUT":"POST";
            var id = journal ? journal.getId() : 0;
            journalJson.id = id;
            Ext.Ajax.request({
                url:'../res/financial_account_journals/' + id,
                method:action,
                jsonData: journalJson,
                //success: function(record) {console.log(record);},
                failure: function(record, op, success) { Ext.Msg.alert('服务器错误', ''); },
                scope: this
            });
            
        } else {
            Ext.Msg.alert('错误', '请检查，1,至少有一项条目；2,条目科目项不能为空；3, 应收账款或应付账款的科目需指明合作伙伴； 4,借贷需平衡');
        }
    },

    initItemStore: function() {
        // init 5 blank item
        var me = this;
        if(me.journal) {
            var items = me.journal.raw.items;
            for(var i = 0; i < items.length; i++) {
                var target = items[i];
                var item = Ext.create('Jeeper.model.AccountJournalItem');
                item.beginEdit();
                item.set('id', target.id);
                item.set('memo', target.memo);
                item.set('account_fk', target.account.id);
                item.set('debit', target.debit);
                item.set('credit', target.credit);
                item.set('linkedPartner_fk', target.linkedPartner ? target.linkedPartner.id : 0);
                item.endEdit();
                me.itemStore.add(item);
            }
            
        } else {
            for(var j = 1; j <= 5; j++) {
                me.itemStore.add(Ext.create('Jeeper.model.AccountJournalItem'));
            }
        }
    },
    handle_btn_reset: Ext.emptyFn,
    handle_btn_save_and_new: Ext.emptFn
});
