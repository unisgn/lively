Ext.define('Beaux.sys.apps.loginmgr.LoginMgr', {
    singleton : true,
    requires : ['Beaux.sys.lib.XServer' ],


    rootXWindow : null,
    currentLoginUser : null,

    // @public
    main : function () {
        var me = this;
        Ext.log('start loading loginManager;');
        me.rootXWindow = me.createRootXWindow();
        Beaux.sys.lib.XServer.resetRootXWindow(me.rootXWindow);
        Ext.log('loginManager loaded;');
    },

    // @private
    createRootXWindow : function () {
        var me = this,
        win = Ext.create('Beaux.sys.apps.loginmgr.RootXWindow');
        return win;
    },

    getAuthentication : function (_username, _password) {},

    // @public
    getCurrentLoginUser : function () {}
});
