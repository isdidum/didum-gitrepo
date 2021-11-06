package gov.iowadot.owl.operations
{
	public class GetCountyBorderWKT
	{
		import gov.iowadot.owl.Owl;
		
		import mx.collections.ArrayCollection;
		import mx.rpc.events.ResultEvent;
		protected var ws:Owl = new Owl();
		
		//Returned Values
		[Bindable]
		public var WKT:String = new String();
		
		//Parameters
		private _vCoNum:int = new int();
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
		public function set CoNum(value:int):void
		{
			_vCoNum = value;
			onParamChanged();
		}
		[Bindable]
		public function get CoNum():int
		{
			return _vCoNum;
		}
		public function onParamChanged():void {
			ws.GetCountyBorderWKT(_vCoNum, _vYear);
			ws.addEventListener(ResultEvent.RESULT,onServiceResult);
		}
		private function onServiceResult(event:ResultEvent):void
		{
			WKT = event.result.WKT;
		}
	}
}