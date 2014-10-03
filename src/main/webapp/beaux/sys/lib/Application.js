Ext.define('Beaux.sys.lib.Application', {

    pid: null,

    /**
     * every single application should implements an static method
     * launch() to provide an entry to start.
     * statics: {
     *     launch: function(cfg) {
     *         // implements statement;
     *         return new this(cfg)
     *     }
     * }
     *
     * application should also implements singleton mechanics if needed.
     *
     */

    constructor: function (cfg) {
        this.initConfig(cfg);
        var procMgr = Beaux.getProcessMgr();
        var pid = procMgr.registerProcess(this);
        if (pid) {
            this.pid = pid;
        }
        this.postConstructor();
    },


    /**
     * To be implemented by concrete app
     */


    /**
     * To be implemented by concrete app
     */
    postConstructor: function () { },

    getPid: function () {
        return this.pid;
    },

    /**
     * @public
     */
    terminate: function () {
        var procMgr = Beaux.getProcessMgr();
        procMgr.deregisterProcess(this.getPid());
        this.preTerminate();
    },

    /**
     * To be implemented by concrete app
     */
    preTerminate: function () { }
});
