package widgets.DotContainer.WidgetLibrary.gov.iowadot.jetfire.operations { 
	//gov.iowadot.jetfire.operations

	public class XmlObjectToLiteral
	{
		import widgets.DotContainer.WidgetLibrary.gov.iowadot.jetfire.Jetfire;
		
		import mx.collections.ArrayCollection;
		import mx.rpc.events.ResultEvent;
		protected var ws:Jetfire = new Jetfire();
		
		//Parameters
		private var _vXmlObject:String = new String();
		private var _vDate:String = new String();
		
		//Returned Values
		[Bindable]public var LiteralDescription:String = new String();
		
		//Constructor
		public function XmlObjectToLiteral() {
			_vXmlObject = "";
			_vDate = "";
		}
		
		public function set XmlObject(value:String):void {
			_vXmlObject = value;
			onParamChanged();
		}
		
		[Bindable]public function get XmlObject():String {
			return _vXmlObject;
		}
		
		public function onParamChanged():void {
			ws.XmlObjectToLiteral(_vXmlObject, _vDate);
			ws.addEventListener(ResultEvent.RESULT,onServiceResult);
		}
		
		private function onServiceResult(event:ResultEvent):void {
			try{
				LiteralDescription = event.result.LiteralDescription;
				
			}
			catch(e:Error){
				LiteralDescription = "Not Found";
			}
			dispatchEvent(new Event("onResultReturn"));
		}
	}
}