// ActionScript file
package DeePackage {
	import flash.system.System;
	
	import mx.collections.ArrayCollection;
	import mx.collections.ICollectionView;
	import mx.collections.IViewCursor;
	import mx.controls.AdvancedDataGrid;
	
	public class myAdvDGUtil {
		protected static var tabDelimiter:String = "\t";
		protected static var commaDelimiter:String = ","; 
		protected static var newLine:String = "\n";						
		
		public static function xptADGToCpBrd (grid:AdvancedDataGrid, csv:Boolean = true, mySelected:Boolean = true):void
		{
			System.setClipboard(xptADGToCSV (grid, csv, mySelected));
		}				
		
		public static function xptADGToCSV (grid:AdvancedDataGrid, csv:Boolean = true, mySelected:Boolean = true):String
		{
			return exportGridToCSV (grid, csv, mySelected);
		}
		
		protected static function exportGridToCSV (grid:Object, csv:Boolean, mySelected:Boolean):String
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
			}while (cursor.moveNext())
			
			return headers + data;
		} 
	}
}
