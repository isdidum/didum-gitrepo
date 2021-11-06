package gov.iowadot.jetfire.operations
{
	public class GetBestRouteId
	{
		import gov.iowadot.jetfire.Jetfire;
		
		import mx.collections.ArrayCollection;
		import mx.rpc.events.ResultEvent;
		protected var ws:Jetfire = new Jetfire();
		
		//Parameters
		private var _vXmlObject:String = new String();
		private var _vDate:String = new String();
		
		//Returned Values
		[Bindable]
		public var RouteId:int = NaN;
		
		//Constructor
		public function GetBestRouteId()
		{
			_vXmlObject = "";
		}
		public function set XmlObject(value:String):void
		{
			_vXmlObject = value;
			onParamChanged();
		}
		[Bindable]
		public function get XmlObject():String
		{
			return _vXmlObject;
		}
		public function onParamChanged():void 
		{
			ws.GetBestRouteId(_vXmlObject, _vDate);
			ws.addEventListener(ResultEvent.RESULT,onServiceResult);
		}
		private function onServiceResult(event:ResultEvent):void
		{
			try{
				RouteId = parseInt(event.result.RouteID);
				
			}
			catch(e:Error){
				
			}
			dispatchEvent(new Event("onResultReturn"));
		}
	}
}