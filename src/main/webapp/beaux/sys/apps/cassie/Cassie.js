Ext.define('Beaux.sys.apps.cassie.Cassie', {

    singleton: true,
    requires: [
        'Beaux.sys.lib.XServer',
        'Beaux.sys.lib.RootXWindow'
    ],
    
    /**
     * @private 
     * @property
     */
    rootXWindow: null,

    /**
     * @private
     * @property
     */
    currentUser: null,

    /**
     * @private
     */
    createRootXWindow: function() {
        return Ext.create('Beaux.sys.apps.cassie.RootXWindow');
    },

    /**
     * @public
     *
     */
    main: function() {
        var me = this;
        Ext.log('start loading cassie desktop environment;');
        me.rootXWindow = me.createRootXWindow();
        Beaux.sys.lib.XServer.resetRootXWindow(me.rootXWindow);
        Ext.log('cassie desktop environment loaded;');
    },
    
    getRootXWindow: function() {
        return this.rootXWindow;
    }
});
