package gov.iowadot.owl.operations
{
	public class GetBridgeWKT
	{
		import gov.iowadot.owl.Owl;
		
		import mx.binding.utils.*;
		import mx.collections.ArrayCollection;
		import mx.events.FlexEvent;
		import mx.rpc.events.ResultEvent;
		protected var ws:Owl = new Owl();
		
		//Parameters
		private var _FHWANum:int = 0;
		
		//Returned Values
		[Bindable]
		public var WKT:String = new String();
		
		//Constructor
		public function GetBridgeWKT()
		{
		}
		public function set FHWANum(value:int):void
		{
			_FHWANum = value;
			onParamChanged();
		}
		[Bindable]
		public function get FHWANum():int
		{
			return _FHWANum;
		}
		public function onParamChanged():void {
			ws.GetBridgeWKT(FHWANum);
			ws.addEventListener(ResultEvent.RESULT,onServiceResult);
		}
		private function onServiceResult(event:ResultEvent):void
		{
			WKT = event.result.WKT;
		}
	}
}