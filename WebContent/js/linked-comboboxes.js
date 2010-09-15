/*!
 * Ext JS Library 3.2.1
 * Copyright(c) 2006-2010 Ext JS, Inc.
 * licensing@extjs.com
 * http://www.extjs.com/license
 */
Ext.onReady(function(){
	
	var tabs = new Ext.TabPanel({
        renderTo: document.body,
        width:450,
        activeTab: 0,
        frame:true,
        defaults:{autoHeight: true},
        items:[localForm, dataBaseForm]
    });
});