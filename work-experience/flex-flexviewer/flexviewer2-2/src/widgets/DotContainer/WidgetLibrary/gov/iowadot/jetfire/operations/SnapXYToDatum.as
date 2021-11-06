package widgets.DotContainer.WidgetLibrary.gov.iowadot.jetfire.operations { 
	//gov.iowadot.jetfire.operations

	public class SnapXYToDatum
	{
		import widgets.DotContainer.WidgetLibrary.gov.iowadot.jetfire.Jetfire; 
		//gov.iowadot.jetfire.Jetfire;
		
		import mx.collections.ArrayCollection;
		import mx.rpc.events.ResultEvent;
		protected var ws:Jetfire = new Jetfire();
		
		//Parameters
		private var _vX:Number = new Number(0.0);
		private var _vY:Number = new Number(0.0);
		private var _vTolerance:String = new String();
		private var _vDate:String = new String();
		
		//Returned Values
		[Bindable]public var LinearReference:String = new String();
		
		//Constructor
		public function SnapXYToDatum() {
			_vTolerance = "100";
			_vDate = "";
		}
		
		public function set X(value:Number):void {
			_vX = value;
			onParamChanged();
		}
		
		[Bindable]public function get X():Number {
			return _vX;
		}
		
		public function set Y(value:Number):void {
			_vY = value;
			onParamChanged();
		}
		
		[Bindable]public function get Y():Number {
			return _vY;
		}
		
		public function set Tolerance(value:String):void {
			_vTolerance = value;
			onParamChanged();
		}
		
		[Bindable]public function get Tolerance():String {
			return _vTolerance;
		}
		
		public function onParamChanged():void {
			ws.SnapXYToDatum(_vX, _vY, _vTolerance, _vDate);
			ws.addEventListener(ResultEvent.RESULT,onServiceResult);
		}
		
		public function onServiceResult(event:ResultEvent):void {
			try{
				var AnchorSection:String = event.result.LinearReference.DatumReference.DatumPoint.AnchorSection;
				var Offset:String = event.result.LinearReference.DatumReference.DatumPoint.Offset;
				LinearReference = "<LinearReference><DatumReference><DatumPoint><AnchorSection>"+AnchorSection
					+"</AnchorSection><Offset>"+Offset
					+"</Offset></DatumPoint></DatumReference></LinearReference>";
				
			}
			catch(e:Error){
			}
			dispatchEvent(new Event("onResultReturn"));
		}
	}
}