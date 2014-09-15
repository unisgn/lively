Ext.define('Beaux.sys.desktop.Cassie', {

    singleton: true,
    requires: [
        'Beaux.sys.xserver.XServer',
        'Beaux.sys.application.Application',
        'Beaux.sys.application.ApplicationManager'
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
        var me = this,
            win = Ext.create('Beaux.sys.desktop.RootXWindow');
        return win;
    },    

    /**
     * @public
     *
     */
    main: function() {
        var me = this;
        console.log('start loading desktop;');
        me.rootXWindow = me.createRootXWindow();
        Beaux.sys.xserver.XServer.resetRootXWindow(me.rootXWindow);
        console.log('desktop loaded;');

        Beaux.sys.application.ApplicationManager.launchApp('Jeeper.apps.express.ExpressForm');
    },
    
    getRootXWindow: function() {
        return this.rootXWindow;
    }
});
