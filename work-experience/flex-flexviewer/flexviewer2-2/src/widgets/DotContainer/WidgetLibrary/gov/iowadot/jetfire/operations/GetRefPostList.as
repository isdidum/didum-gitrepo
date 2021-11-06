package widgets.DotContainer.WidgetLibrary.gov.iowadot.jetfire.operations {
	//gov.iowadot.jetfire.operations

	public class GetRefPostList
	{
		public function GetRefPostList()
		{
			import widgets.DotContainer.WidgetLibrary.gov.iowadot.jetfire.Jetfire;
				//gov.iowadot.Jetfire.Jetfire;
			
			import mx.collections.ArrayCollection;
			import mx.rpc.events.ResultEvent;
			protected var ws:Jetfire = new Jetfire();
			
			//Returned values
			[Bindable]//Automatically updates due to [Bindable] Keyword
			public var PostValue:ArrayCollection = new ArrayCollection();
			
			//Parameters
			private var _vRouteId:int = "";
			
			//Constructor
			public function GetRefPostList() {
				PostValue.addItem("fetching...");
				onParamChanged();
			}
			
			public function set RouteId(value:int):void {
				_vRouteId = value;
				onParamChanged();
			}
			
			[Bindable]public function get RouteId():String {
				return _vRouteId;
			}
			
			public function onParamChanged():void {
				ws.GetRefPostList(_vRouteId);
				ws.addEventListener(ResultEvent.RESULT,onServiceResult);
			}
			
			private function onServiceResult(event:ResultEvent):void {
				var Counties:ArrayCollection = event.result.ReferencePostList.ReferencePost;
				PostValue.removeAll();
				for each(var rPost:Object in ReferencePost) {
					CountyName.addItem(rPost.PostValue);
				}
			}
		}
	}
}