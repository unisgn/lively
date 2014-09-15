Ext.define('Beaux.sys.desktop.panelWidget.AppsMenu', {
    extend: 'Beaux.sys.desktop.lib.PanelWidget',
    requires: [
        'Beaux.sys.application.Application',
        'Beaux.sys.application.ApplicationManager',
        'Beaux.sys.desktop.lib.XWindow'
    ],
    
    initComponent: function() {
        var me = this;
        var appMgr = me.getApplicationManager();
        me.items = [
            Ext.create('Ext.toolbar.Toolbar', {
                items: [{
                    xtype: 'button',
                    text: 'System',
                    menu: [{
                        text: '会计科目',
                        handler: function() {
                            appMgr.launchApp('Jeeper.apps.account.FinancialAccount');
                        }
                    }, {
                        text: '通用记账',
                        handler: function() {
                            appMgr.launchApp('Jeeper.apps.journal.GeneralJournal');
                        }
                    }, {
                        text: '合作伙伴',
                        handler: function() {
                            appMgr.launchApp('Jeeper.apps.partner.Partner');
                        }
                    }]
                }, {
                    xtype:'button',
                    text:'Express',
                    menu:[{
                        text:'Express Company',
                        handler: function() {
                            appMgr.launchApp('Jeeper.apps.express.ExpressCompany');
                        }
                    }, {
                        text:'Express Form',
                        handler:function() {
                            appMgr.launchApp('Jeeper.apps.express.ExpressForm');
                        }
                    }]
                }]
            })
        ];
        
        me.callParent();
        
    },
    
    getApplicationManager: function() {
        return Beaux.sys.application.ApplicationManager;
    }
});


