package gov.iowadot.jetfire.operations
{
	public class GetRouteList
	{
		//Returned values
		[Bindable]//Automatically updates due to [Bindable] Keyword
		public var RouteID:ArrayCollection = new ArrayCollection();
		[Bindable]
		public var RouteSystemID:ArrayCollection = new ArrayCollection();
		[Bindable]
		public var AssignedRoutesID:ArrayCollection = new ArrayCollection();
		[Bindable]
		public var GeographicExtentID:ArrayCollection = new ArrayCollection();
		[Bindable]
		public var RouteName:ArrayCollection = new ArrayCollection();
		[Bindable]
		public var RouteDirection:ArrayCollection = new ArrayCollection();
		[Bindable]
		public var FullName:ArrayCollection = new ArrayCollection();
		[Bindable]
		public var OfficialName:ArrayCollection = new ArrayCollection();
		public function GetRouteList()
		{
			
		}
	}
}