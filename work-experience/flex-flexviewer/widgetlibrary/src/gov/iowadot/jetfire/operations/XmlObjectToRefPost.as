package gov.iowadot.jetfire.operations
{
	public class XmlObjectToRefPost
	{
		import gov.iowadot.jetfire.Jetfire;
		
		import mx.collections.ArrayCollection;
		import mx.rpc.events.ResultEvent;
		protected var ws:Jetfire = new Jetfire();
		
		//Parameters
		private var _vXmlObject:String = new String();
		private var _vRouteId:int = 0;
		private var _vOffsetType:int = 0;
		private var _vDate:String = new String();
		
		//Returned Values
		[Bindable]
		public var RouteSystem:String = new String();		//RouteDefinition
		[Bindable]
		public var GeographicExtent:String = new String();	//RouteDefinition
		[Bindable]
		public var RouteName:String = new String();				//RouteDescription
		[Bindable]
		public var RouteType:String = new String();				//RouteDescription
		[Bindable]
		public var RouteDirection:String = new String();		//RouteDescription
		[Bindable]
		public var ReferencePost:String = new String();		//ReferencePostPoint
		[Bindable]
		public var Offset:String = new String();			//ReferencePostPoint
		
		//Constructor
		public function XmlObjectToRefPost()
		{
			_vXmlObject = "";
			_vRouteId = 0;
			_vOffsetType = 0;
			_vDate = "";
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
		public function set RouteId(value:int):void
		{
			_vRouteId = value;
			onParamChanged();
		}
		[Bindable]
		public function get RouteId():int
		{
			return _vRouteId;
		}
		public function set OffsetType(value:int):void
		{
			_vOffsetType = value;
			onParamChanged();
		}
		[Bindable]
		public function get OffsetType():int
		{
			return _vOffsetType;
		}
		
		public function onParamChanged():void 
		{
			ws.XmlObjectToRefPostS(_vXmlObject, _vRouteId, _vOffsetType, _vDate);
			ws.addEventListener(ResultEvent.RESULT,onServiceResult);
		}
		private function onServiceResult(event:ResultEvent):void
		{
			try{
				RouteSystem = 		event.result.LinearReference.ReferencePostReference.RouteDefinition.RouteSystem;
				GeographicExtent =  event.result.LinearReference.ReferencePostReference.RouteDefinition.GeographicExtent;
				RouteName = 		event.result.LinearReference.ReferencePostReference.RouteDefinition.RouteDescription.RouteName;
				RouteType = 		event.result.LinearReference.ReferencePostReference.RouteDefinition.RouteDescription.RouteType;
				RouteDirection = 	event.result.LinearReference.ReferencePostReference.RouteDefinition.RouteDescription.RouteDirection;
				ReferencePost = 	event.result.LinearReference.ReferencePostReference.ReferencePostPoint.ReferencePost;
				Offset = 			event.result.LinearReference.ReferencePostReference.ReferencePostPoint.Offset;
				
				
			}
			catch(e:Error){
				ReferencePost = "Not Found";
				Offset = "Not Found";
			}
			dispatchEvent(new Event("onResultReturn"));
		}
	}
}