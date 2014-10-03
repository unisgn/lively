Ext.define('Beaux.sys.lib.XServer', {
    singleton: true,
    requires: [
        'Ext.container.Viewport'
    ],

    /**
     * @private
     * @property
     */
    viewport: null,

    /**
     * @private
     * @property
     */
    rootXWindow: null,

    /**
     * @private
     */
    setRootXWindow: function(win) {
        this.rootXWindow = win;
    },


    /**
     *
     * @returns {Beaux.sys.lib.RootXWindow}
     */
    getRootXWindow: function() {
        return this.rootXWindow;
    },

    /**
     *
     * @param win {Beaux.sys.lib.RootXWindow}
     */
    resetRootXWindow: function(win) {
        var me = this;
        if(me.rootXWindow) {
            me.viewport.remove(me.rootXWindow);
//            me.viewport.update();
        }
        me.setRootXWindow(win);
        me.viewport.add(win);
        me.viewport.update();
    },

    /**
     * @public
     */
    main: function() {
        var me = this;
        me.viewport = Ext.create('Ext.container.Viewport', {layout: 'fit'});
    }
});
