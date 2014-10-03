/*Ext.define('Beaux.core.ProcMgr', {
    singleton: true,
    pidGen: null,
    procColl: null,

    constructor: function () {
        this.pidGen = (function () {
            var pid = 0;
            return {
                next: function () {
                    return (++pid).toString();
                }
            }
        }());

        this.procColl = (function () {
            var processes = Ext.create('Ext.util.MixedCollection');
            return {
                getProcesses: function () {
                    return processes;
                },
                *//**
                 *
                 * @param key {String}
                 * @param proc {Object}
                 * @returns {Object}
                 *//*
                add: function (key, proc) {
                    return processes.add(key, proc);
                },

                remove: function (pid) {
                    return processes.removeAtKey(pid);
                },
                getProc: function (key) {
                    return processes.get(key);
                }
            }
        }());
    },

    registerProcess: function (_proc) {
        var pid = this.pidGen.next();
        if (typeof(_proc) === 'object' && !Ext.Object.isEmpty(_proc)) { //TODO determine _proc is extends Beaux.sys.Application
            this.procColl.add(pid, _proc);
            return pid;
        } else {
            return null;
        }
    },

    deregisterProcess: function (pid) {
        return  this.procColl.remove(pid);
    },

    getProc: function (pid) {
        return this.procColl.getProc(pid);
    },

    getProcesses: function () {
        return this.procColl.getProcesses().clone();
    }
});*/


Ext.define('Beaux.core.ProcMgr', function () {
    var pidGen = (function () {
        var pid = 0;
        return {
            next: function () {
                return (++pid).toString();
            }
        }
    }());

    var procColl = (function () {
        var  processes = Ext.create('Ext.util.MixedCollection');
        return {
            getProcesses: function () {
                return processes;
            },

            /**
             *
             * @param key {String}
             * @param proc {Object}
             * @returns {Object}
             */
            add: function (key, proc) {
                return processes.add(key, proc);
            },

            /**
             *
             * @param pid {String}
             * @returns {Object}
             */
            remove: function (pid) {
                return processes.removeAtKey(pid);
            },

            /**
             *
             * @param key {String}
             * @returns {Object}
             */
            getProc: function (key) {
                return processes.get(key);
            }
        }
    }());

    return {

        /**
         * @param _proc {Object}
         * @returns {Number} the pid of _proc assigned by mgr
         */
        registerProcess: function (_proc) {
            var pid = pidGen.next();
            if (typeof(_proc) === 'object' && !Ext.Object.isEmpty(_proc)) { //TODO determine _proc is extends Beaux.sys.Application
                procColl.add(pid, _proc);
                return pid;
            } else {
                return null;
            }
        },

        /**
         *
         * @param _proc {Object}
         * @returns {Object}
         */
        deregisterProcess: function (pid) {
            return  procColl.remove(pid);
        },

//        getProcesses: function () {
//            return processes.getProcesses();
//        },

        /**
         *
         * @param {String} pid get process by pid
         * @returns {Object}
         */
        getProcess: function (pid) {
            return procColl.getProc(pid);
        },

        getProcesses: function () {
            return procColl.getProcesses().clone();
        }
    }
});