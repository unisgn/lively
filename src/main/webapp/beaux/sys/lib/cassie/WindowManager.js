Ext.define('Beaux.sys.lib.cassie.WindowManager', {
    singleton: true,
    mixins: {
        observable: 'Ext.util.Observable'
    },
    requires: [
        'Ext.util.MixedCollection'
    ],

    
    /**
     * @private
     * @property
     */
    windows: null,

    /**
     * @private
     * @property
     */

    constructor: function(config) {
        var me = this;
        me.windows = Ext.create('Ext.util.MixedCollection');
        
        me.mixins.observable.constructor.call(this);
        
    },
    


    /**
     ***************************************************************************
     *                        public interface
     ***************************************************************************
     * @public
     * @returns {Beaux.sys.lib.cassie.XWindow}
     *
     */
    registerWindow: function(_win) {
        return this.windows.add(_win);
    },

    /** 
     * @public
     * @Returns {Ext.util.MixedCollection[Beaux.sys.lib.cassie.XWindow]}
     */    
    getWindows: function() {
        return this.windows;
    },       

    
    /** 
     * @public
     * @returns {Beaux.sys.lib.cassie.XWindow}
     */
    deregisterWindow: function(_win) {
        return this.windows.remove(_win);
    }
    
});
