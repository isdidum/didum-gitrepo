// ActionScript file
// https://gist.github.com/773635

package DeePackage {/*org.lacsd.sf.view.components{*/	
	
	import com.esri.ags.Map;	
	import flash.events.Event;	
	import mx.states.State;	
	import spark.components.SkinnableContainer;	
	
	[SkinState("collapsed")];	
	[SkinState("expanded")];
	
	[Event(name="mapChange",type="flash.events.Event")];
	
	public class CollapseContainer extends SkinnableContainer	
	{		
		public static const MAP_CHANGE_EVENT:String = "mapChange";		
		private var _map:Map;		
		
		[Bindable(event="mapChange")]public function get map():Map		
		{			
			return _map;		
		}		
		
		public function set map(value:Map):void		
		{			
			if (_map != value){				
				_map = value;				
				dispatchEvent(new Event(MAP_CHANGE_EVENT));			
			}		
		}		
		
		override public function initialize():void	{			
			super.initialize();			
			states.push(new State({name:"collapsed"}));			
			states.push(new State({name:"expanded"}));		
		}
		
		override protected function stateChanged(oldState:String, newState:String, recursive:Boolean):void	{			
			super.stateChanged(oldState, newState, recursive);			
			invalidateSkinState();		
		}		
		
		override protected function getCurrentSkinState():String {			
			return currentState;		
		}	
	}
} 
