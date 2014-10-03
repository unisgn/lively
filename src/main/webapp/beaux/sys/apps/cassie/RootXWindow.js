Ext.define('Beaux.sys.apps.cassie.RootXWindow', {
    extend: 'Beaux.sys.lib.RootXWindow',



    /**
     ***************************************************************************
     *                             configuration
     * @override
     * @cfg
     ***************************************************************************
     */
    layout: 'border',


    /**
     * @private 
     * @property
     */
    banner: null,

    /**
     * @private
     * @property
     * @readonly
     */
    desk: null,

    /**
     * @override
     */
    initComponent: function() {
        var me = this;
        me.banner = me.createBanner();
        me.items = [{
            region: 'north',
            items: [me.banner]
        },{
            region: 'center'
        }];

        var global_shortcuts = Ext.create('Ext.util.KeyMap', {
            target: Ext.getBody(),
            binding: {
                key: 27,
                fn: me.toggleArrangeWindows,
                scope: me
            },
            ignoreInputFields: true
        });
        
        me.callParent();
    },


    /**
     **********************************************************************
     *                             UI Building;
     * @private
     **********************************************************************
     */ 
    createBanner: function() {
        var me = this;
        var _appMenu = Ext.create('Beaux.sys.apps.cassie.panelWidget.AppsMenu');
        
        var _panel = Ext.create('Beaux.sys.lib.cassie.EdgePanel', {
            items: [
                _appMenu
            ]
        });
        return _panel;
    },
    
    /**
     **********************************************************************
     *                          public interface;
     **********************************************************************
     */
    getDesk: function() {
        return this.items.getAt(1);
    },

    /**
     * @private
     */
    toggleArrangeWindows: function() {
        var _wa = Beaux.sys.lib.cassie.WindowArranger;
        _wa.toggleArrangeWindows();
    }
    
});
