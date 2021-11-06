////////////////////////////////////////////////////////////////////////////////
//
// Version 2.1.3 - Sept. 25, 2010
//
// Delevoped by Robert Scheitlin
// Modified: Abraham, Didum - 4/12/2011
////////////////////////////////////////////////////////////////////////////////
package widgets.DotContainer.LidarIdentify
{
	import mx.core.ClassFactory;
	import spark.components.DataGroup;
	
	// these events bubble up from the idResultItemRenderer
	[Event(name="idResultClick", type="flash.events.Event")]
	[Event(name="idResultOver", type="flash.events.Event")]
	[Event(name="idResultOut", type="flash.events.Event")]
	
	public class IdResultDataGroup extends DataGroup
	{
		public function IdResultDataGroup()
		{
			super();
			this.itemRenderer = new ClassFactory(IdResultItemRenderer);
		}
	}
}