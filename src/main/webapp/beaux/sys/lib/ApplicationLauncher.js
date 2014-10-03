Ext.define('Beaux.sys.lib.ApplicationLauncher', {
    singleton: true,
    launchApp: function(_appCls, _cfg) {
        var cfg = _cfg || {};
        Ext.require(_appCls, function() {
            Ext.ClassManager.get(_appCls).launch(cfg);
        });

    }
});
