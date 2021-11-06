package gov.iowadot.owl.operations
{
	public class GetStateBorderWKT
	{
		import gov.iowadot.owl.Owl;
		
		import mx.collections.ArrayCollection;
		import mx.rpc.events.ResultEvent;
		protected var ws:Owl = new Owl();
		
		//Returned Values
		[Bindable]
		public var WKT:String = new String();
		
		//Parameters
		private _vYear:String = new String();
		
		//Constructor
		public function GetCountyBorderWKT()
		{
			
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
			ws.GetStateBorderWKT(_vYear);
			ws.addEventListener(ResultEvent.RESULT,onServiceResult);
		}
		private function onServiceResult(event:ResultEvent):void
		{
			WKT = event.result.WKT;
		}
	}
}