package gov.iowadot.owl.operations
{
	public class GetCountyList
	{
		import gov.iowadot.owl.Owl;
		
		import mx.collections.ArrayCollection;
		import mx.rpc.events.ResultEvent;
		protected var ws:Owl = new Owl();
		
		//Returned values
		[Bindable]//Automatically updates due to [Bindable] Keyword
		public var CountyName:ArrayCollection = new ArrayCollection();
		[Bindable]
		public var CountyNumber:ArrayCollection = new ArrayCollection();
		private var _vYear:String = "";
		
		//Constructor
		public function GetCountyList()
		{
			CountyName.addItem("fetching...");
			CountyNumber.addItem("fetching...");
			onParamChanged();
		}
		public function set Year(value:String):void
		{
			_vYear = value;
			onParamChanged();
		}
		[Bindable]
		public function get Year():String
		{
			return _vYear;
		}
		public function onParamChanged():void {
			ws.GetCountyList(_vYear);
			ws.addEventListener(ResultEvent.RESULT,onServiceResult);
		}
		private function onServiceResult(event:ResultEvent):void
		{
			var Counties:ArrayCollection = event.result.CountyList.County;
			CityName.removeAll();
			CityNumber.removeAll();
			for each(var County:Object in Counties)
			{
				CountyName.addItem(County.CountyName);
				CountyNumber.addItem(County.CountyNumber);
			}
		}
	}
}