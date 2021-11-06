// ActionScript file
package DeePackage {
	import flash.events.KeyboardEvent;
	import flash.system.System;
	
	import mx.collections.ArrayCollection;
	import mx.collections.ICollectionView;
	import mx.collections.IViewCursor;
	import mx.controls.AdvancedDataGrid;
	
	public class myAdvDGUtil2 {
		protected static var tabDelimiter:String = "\t";
		protected static var commaDelimiter:String = ","; 
		protected static var newLine:String = "\n";						
		
		public static function xptADGToCpBrd (grid:AdvancedDataGrid, event:KeyboardEvent, mySelected:Boolean = true):void
		{
			System.setClipboard(xptADGToCSV (grid, event, mySelected));
		}				
		
		public static function xptADGToCSV (grid:AdvancedDataGrid, event:KeyboardEvent, mySelected:Boolean = true):String
		{
			return getmyExport (grid, event, mySelected);
		}
		
		protected static function getmyExport(grid:AdvancedDataGrid, event:KeyboardEvent, mySelected:Boolean):String {
			if(event.ctrlKey && grid) {
				//seperator used between strings
				var separator:String = "\n"; //","; googled escape characters for flex
				//the string sent to clipboard
				var dataString:String = "";
				
				var getLength:int = event.currentTarget.selectedCells.length;
				for (var i:int = 0; i < getLength; i++) {
					
					var cell:Object = event.currentTarget.selectedCells[i];
					// Get the row for the selected cell.
					var data:Object = event.currentTarget.dataProvider[cell.rowIndex];
					
					// Get the name of the field for the selected cell.
					var dataField:String = event.currentTarget.columns[cell.columnIndex].dataField;
					
					// Get the cell data using the field name.
					dataString = data[dataField] + separator + dataString;
				}
				// Remove trailing separator.
				dataString = dataString.substr(0, dataString.length - separator.length);
				
				// Write dataString to the clipboard.
				//System.setClipboard(dataString);
				return dataString;
			}
			return dataString;
		}
		
		/*protected static function exportGridToCSV (grid:Object, csv:Boolean, mySelected:Boolean):String
		{
			var dataSource:ICollectionView = (mySelected ? new ArrayCollection (grid.selectedItems) : grid.dataProvider) as ICollectionView;
			var headers:String = "";		
			var delimiter:String = ""
			
			if (csv)
				delimiter = commaDelimiter;
			else
				delimiter = tabDelimiter;
			
			//build header
			for each (var hcol:Object in grid.columns) {//coltypes differe between DG & ADG
				if (headers.length > 0)//avoid firstcolumn having extra delimeter
					headers += delimiter;					
				headers += hcol.headerText;			
			}
			headers += newLine;
			
			
			//populate data
			var cursor:IViewCursor = dataSource.createCursor();
			var data:String = "";
			var item:Object;
			var itemData:String;
			
			do 
			{
				item = cursor.current;
				itemData = "";
				
				for each (var col:Object in grid.columns)
				{
					if (itemData.length > 0)	//avoid firstcolumn having extra delimeter				
						itemData += delimiter;
					
					itemData += col.itemToLabel(item);					
				}
				
				data += itemData +newLine;
			} while (cursor.moveNext())
			
			return headers + data;
		}*/ 
	}
}
