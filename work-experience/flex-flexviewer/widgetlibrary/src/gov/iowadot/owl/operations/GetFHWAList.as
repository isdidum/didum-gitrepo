package gov.iowadot.owl.operations
{
	public class GetFHWAList
	{
		import gov.iowadot.owl.Owl;
		
		import mx.collections.ArrayCollection;
		import mx.rpc.events.ResultEvent;
		protected var ws:Owl = new Owl();
		
		//Returned values
		[Bindable]
		public var FHWANumber:ArrayCollection = new ArrayCollection();//List of FHWANumbers
		
		//Constructor
		public function GetFHWAList()
		{
			FHWANumber.addItem("fetching...");
			ws.GetFHWAList();
			ws.addEventListener(ResultEvent.RESULT,onServiceResult);
		}
		private function onServiceResult(event:ResultEvent):void
		{
			FHWANumber = event.result.FHWAList.FHWANumber;
		}
	}
}