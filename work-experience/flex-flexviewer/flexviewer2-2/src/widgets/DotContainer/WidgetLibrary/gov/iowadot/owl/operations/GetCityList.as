package gov.iowadot.owl.operations
{
	import mx.utils.object_proxy;

	public class GetCityList
	{
		import gov.iowadot.owl.Owl;
		
		import mx.collections.ArrayCollection;
		import mx.rpc.events.ResultEvent;
		protected var ws:Owl = new Owl();
		
		//Returned Values
		[Bindable]
		public var CityName:ArrayCollection = new ArrayCollection();
		[Bindable]
		public var CityNumber:ArrayCollection = new ArrayCollection();
		
		//Parameters
		private var _vYear:String = "";
		
		//Constructor
		public function GetCityList()
		{
			CityName.addItem("fetching...");
			CityNumber.addItem("fetching...");
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
			ws.GetCityList(_vYear);
			ws.addEventListener(ResultEvent.RESULT,onServiceResult);
		}
		private function onServiceResult(event:ResultEvent):void
		{
			var Cities:ArrayCollection = event.result.CityList.City;
			CityName.removeAll();
			CityNumber.removeAll();
			for each(var City:Object in Cities)
			{
				CityName.addItem(City.CityName);
				CityNumber.addItem(City.CityNumber);
			}
		}
	}
}