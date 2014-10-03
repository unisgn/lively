Ext.log('start ext;');

Ext.Loader.setConfig({
    enabled: true,
    paths: {
        'Beaux': './.',
        'Jeeper':'./usr/jeeper/.'
    }
});

Ext.Loader.loadScript('./core/override.js');

Ext.Loader.loadScript('./core/Beaux.js');


// doesn't work on extjs5
/*Ext.getDoc().on({
    contextmenu: function(e) { e.stopEvent(); }
});*/

Ext.require('Beaux.sys.apps.loginmgr.LoginMgr');
Ext.require('Beaux.sys.apps.cassie.Cassie');

Ext.onReady(function () {


    /* disable global oncontextmenu event*/
    Ext.getBody().on({
        contextmenu: function(e) {
            e.stopEvent();
        }
    });


    Ext.log('start beaux boot;');

    Beaux.setDesktop(Beaux.sys.apps.cassie.Cassie);

    Beaux.sys.lib.XServer.main();
    Beaux.sys.apps.cassie.Cassie.main();


//    var desktop = Ext.sys.desktop.Cassie;
//    Beaux.setDesktop(desktop);

//    var loginManager = Ext.sys.loginManager.LoginManager;
//    Beaux.setLoginManager(loginManager);

//    Beaux.boot();
    Ext.log('beaux loaded;');
});
