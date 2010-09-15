var dataBaseForm = new Ext.FormPanel({
       width: 400
       ,height: 200
       ,style:'margin:16px'
       ,bodyStyle:'padding:10px'
       ,title:'Linked Combos - Database'
       ,defaults: {xtype:'combo'}
       ,items:[{
            fieldLabel:'Select State'
           ,displayField:'name'
           ,valueField:'id'
           ,store: new Ext.data.JsonStore({
	       		url: 'state/view.action',
	            remoteSort: false,
	            autoLoad:true,
	            idProperty: 'id',
	            root: 'data',
	            totalProperty: 'total',
	            fields: ['id','name']
	        })
           ,triggerAction:'all'
           ,mode:'local'
           ,listeners: {
               select: {
                   fn:function(combo, value) {
                       var comboCity = Ext.getCmp('combo-city');
                       //set and disable cities
                       comboCity.setDisabled(true);
                       comboCity.setValue('');
                       comboCity.store.removeAll();
                       //reload city store and enable city combobox 
                       comboCity.store.reload({
                           params: { stateId: combo.getValue() }
                       });
                       comboCity.setDisabled(false);
       			  }
               }
       		}
       },{
            fieldLabel:'Select City'
           ,displayField:'name'
           ,valueField:'id'
           ,disabled:true	   
           ,id:'combo-city'
           ,store: new Ext.data.JsonStore({
       		   url: 'city/getCitiesByState.action',
               remoteSort: false,
               idProperty: 'id',
               root: 'data',
               totalProperty: 'total',
               fields: ['id','stateId','name']
           })
           ,triggerAction:'all'
           ,mode:'local'
           ,lastQuery:''
       }]
});