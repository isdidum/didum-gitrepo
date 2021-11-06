package gov.iowadot.owl.operations
{
	public class GetMPOList
	{
		import gov.iowadot.owl.Owl;
		
		import mx.collections.ArrayCollection;
		import mx.rpc.events.ResultEvent;
		protected var ws:Owl = new Owl();
		
		//Returned values
		[Bindable]
		public var MPONumber:ArrayCollection = new ArrayCollection();//List of FHWANumbers
		[Bindable]
		public var MPOName:ArrayCollection = new ArrayCollection();//List of FHWANumbers
		
		//Constructor
		public function GetMPOList()
		{
			FHWANumber.addItem("fetching...");
			ws.GetMPOList();
			ws.addEventListener(ResultEvent.RESULT,onServiceResult);
		}
		private function onServiceResult(event:ResultEvent):void
		{
			FHWANumber = event.result.FHWAList.FHWANumber;
		}
	}
}