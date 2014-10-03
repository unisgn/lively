Ext.define('Beaux.sys.lib.cassie.WindowArranger', {
    singleton: true,
    requires:[
        'Beaux.sys.apps.cassie.Cassie'
    ],

    /**
     * @static
     * @final
     * @brief the ratio of the transformed window to its arranged cell;
     */
    FIX_RATIO: 0.9,

    GOLDEN_RATIO: 1.6,
    
    
    /**
     * @private
     * @property
     * @brief flag status
     */
    arranged: false,
    
    /**
     ***************************************************************************
     *                          public interface
     * @public
     ***************************************************************************
     */    

    toggleArrangeWindows: function() {
        var me = this;
        var _winCount = me.getWindowManager().getWindows().length;
        if(_winCount > 0) {
            //            return me[me.arranged ? 'resetWindows':'arrangeWindows']();
            if (me.arranged) {
                me.resetWindows();
            } else {
                me.arrangeWindows();
            }
        }
    },

    /**
     * @public
     * @brief arrange windows to desk in cell grid;
     */
    arrangeWindows: function() {
        var me = this;
        var _wins = me.getWindowManager().getWindows();
        var _winCount = _wins.length;
        if(_winCount > 0 && !me.arranged) {
            var _desk = me.getDesk();
            var _deskRegion = me.getDeskRegion();
            var _regionRate = _desk.getWidth() / _desk.getHeight();
            var _cellGrid = me.makeCellGrid(_regionRate, _winCount);

            var _cellWidth = _desk.getWidth() / _cellGrid.cols;
            var _cellHeight = _desk.getHeight() / _cellGrid.rows;

            var i = 0;
            _wins.each(function(_win) {
                var _cellX = i % _cellGrid.cols;
                var _cellY = Math.floor(i / _cellGrid.cols);

                // http://www.eleqtriq.com/wp-content/static/demos/2010/css3d/matrix2dExplorer.html
                // http://dev.opera.com/articles/view/understanding-the-css-transforms-matrix/
                var _dx = (_deskRegion.left + _cellWidth / 2) + _cellX * _cellWidth - (_win.getRegion().left + _win.getRegion().right) / 2;
                var _dy = (_deskRegion.top + _cellHeight / 2) + _cellY * _cellHeight - (_win.getRegion().top + _win.getRegion().bottom) / 2;
                
                var _r1 = _win.getWidth() / _cellWidth;
                var _r2 = _win.getHeight() / _cellHeight;
                
                var _ratio = (_r1 <= me.FIX_RATIO && _r2 <= me.FIX_RATIO) ? 1 : me.FIX_RATIO/Math.max(_r1, _r2);
                _win.transform(_ratio, _dx, _dy);
                i++;
            });
            me.arranged = true;
        
        }
    },

    /**
     * @public
     */
    resetWindows: function() {
        var me = this;
        var _wins = me.getWindowManager().getWindows();
        var _winCount = _wins.length;
        if(_winCount > 0 && me.arranged) {
            _wins.each( function(_win) {
                _win.resetTransform();
            });
            me.arranged = false;
        }
    },

    /**
     ***************************************************************************
     *                          private method
     * @private
     ***************************************************************************
     */    

    getDesk: function() {
        return Beaux.sys.apps.cassie.Cassie.getRootXWindow().getDesk();
    },
    
    /**
     * @private
     */
    getWindowManager: function() {
        return Beaux.sys.lib.cassie.WindowManager;
    },

    /**
     * @private
     */
    getDeskRegion: function() {
        return this.getDesk().getRegion();
    },

    /**
     * initial grid is {rows: 1, columns: 1}
     * then we add a row or column depending on which will make the cell ratio more close to our golden ratio.
     * until the given count less than cell count
     * @private
     * @brief calculate a cell grid by given (windows) ratio(=region.width / region.height) and (windows) count.

     */
    makeCellGrid: function(_ratio, _count) {
        var golden_ratio = this.GOLDEN_RATIO;
        var rows = 1;
        var cols = 1;
        if(_count == 1) {
            return {rows: 1, cols: 1};
        } else {
            while(_count > rows * cols) {
                var cell_ratio_if_add_row = (rows + 1) * _ratio / cols; // ((rows + 1) / cols) * _ratio
                var cell_ratio_if_add_col = rows * _ratio / (cols + 1); // (rows / (cols + 1)) * _ratio
                if (Math.abs(golden_ratio - cell_ratio_if_add_row) < Math.abs(golden_ratio - cell_ratio_if_add_col)) {
                    rows++;
                } else {
                    cols++;
                }
            }
        }
        return {rows: rows, cols: cols};
    }
});
