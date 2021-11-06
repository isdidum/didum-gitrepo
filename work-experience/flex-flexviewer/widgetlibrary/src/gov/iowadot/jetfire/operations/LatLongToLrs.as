package gov.iowadot.jetfire.operations
{
	public class LatLongToLrs
	{
		import gov.iowadot.jetfire.Jetfire;
		
		import mx.collections.ArrayCollection;
		import mx.rpc.events.ResultEvent;
		protected var ws:Jetfire = new Jetfire();
		
		//Parameters
		private var _vX:Number = new Number(0.0);
		private var _vY:Number = new Number(0.0);
		
		//Returned Values
		[Bindable]
		public var X:String = new String();
		[Bindable]
		public var Y:String = new String();
	
		//Constructor
		public function LatLongToLrs()
		{
		}
		//Constructor
		//public function LatLongToLrs(pLongitude:Number, pLatitude:Number)
		//{
		//	_vX = pLongitude;
		//	_vY = pLatitude;
		//	onParamChanged();
		//}
		public function set Lon(value:Number):void
		{
			_vX = value;
			onParamChanged();
		}
		[Bindable]
		public function get Lon():Number
		{
			return _vX;
		}
		public function set Lat(value:Number):void
		{
			_vY = value;
			onParamChanged();
		}
		[Bindable]
		public function get Lat():Number
		{
			return _vY;
		}
		public function onParamChanged():void 
		{
			ws.LatLongToLrs(_vX, _vY);
			ws.addEventListener(ResultEvent.RESULT,onServiceResult);
		}
		private function onServiceResult(event:ResultEvent):void
		{
			try{
				X = event.result.Coordinate.X;
				Y = event.result.Coordinate.Y;
				
			}
			catch(e:Error){
			}
			dispatchEvent(new Event("onResultReturn"));
		}
	}
}