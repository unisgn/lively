(function () {
    var desktop;
    var loginMgr;
    var xserver;
    var processMgr = Ext.create('Beaux.core.ProcMgr');

    Beaux.getDesktop = function () {
        return desktop;
    };

    Beaux.setDesktop = function (_desktop) {
        desktop = _desktop;
    };

    Beaux.getLoginMgr = function () {
        return loginMgr;
    };

    Beaux.setLoginMgr = function (_loginMgr) {
        loginMgr = _loginMgr;
    };

    Beaux.getProcessMgr = function () {
        return processMgr;
    };

}());
