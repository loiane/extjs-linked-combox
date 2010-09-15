	var localForm = new Ext.FormPanel({
       width: 400
       ,height: 300
       ,style:'margin:16px'
       ,bodyStyle:'padding:10px'
       ,title:'Linked Combos - Local Filtering'
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
           ,listeners:{select:{fn:function(combo, value) {
               var comboCity = Ext.getCmp('combo-city-local');        
               comboCity.clearValue();
               comboCity.store.filter('stateId', combo.getValue());
               }}
           }

       },{
            fieldLabel:'Select City'
           ,displayField:'name'
           ,valueField:'id'
           ,id:'combo-city-local'
           ,store: new Ext.data.JsonStore({
       		   url: 'city/getAllCities.action',
               remoteSort: false,
               autoLoad:true,
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