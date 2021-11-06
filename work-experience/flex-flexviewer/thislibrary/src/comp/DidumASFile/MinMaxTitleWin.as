// ActionScript file
package comp.DidumASFile
{
	import flash.display.DisplayObject;
	import flash.events.Event;
	import flash.events.MouseEvent;
	
	import mx.containers.TitleWindow;
	import mx.controls.Button;
	import mx.effects.Resize;
	
	
	public class MinMaxTitleWin extends TitleWindow
	{
		/**
		 * Variables
		 **/
		private var styleFlag:int = 0;
		private var previousHeight:int = 30;
		public var minMaxBtn:Button = new Button();
		public var effResize:Resize = new Resize();
		
		[Embed(source="assets/bluestar16.png")]
		[Bindable]public var blueStar16:Class;
		
		[Embed(source="assets/images/w_up.png")]
		[Bindable]public var buttonUpIcon:Class;
		
		[Embed(source="assets/images/w_down.png")]
		[Bindable]public var buttonDownIcon:Class;
		/**
		 *  Constructor.
		 */
		public function MinMaxTitleWin() {
			super();
			/**
			 * actual implementation of TitleWindow (TW)
			 * theese are properties of TW and can't be used in CSS
			 */
			this.titleIcon = blueStar16;
			this.title = "Didum's Floating Widget";
			this.width = 340;
			this.height = 200;
			this.showCloseButton = true;
		}
		
		protected override function createChildren():void {
			super.createChildren();
			// visible toolTip on startup
			this.minMaxBtn.toolTip = "minimize";
			
			/*use these lines and declare icon styles in stylesheet*/
			this.minMaxBtn.setStyle("overIcon", buttonUpIcon);
			this.minMaxBtn.setStyle("downIcon", buttonUpIcon);
			this.minMaxBtn.setStyle("upIcon", buttonUpIcon);
			
			this.minMaxBtn.visible = true;
			this.minMaxBtn.width = 14;
			this.minMaxBtn.height = 15;
			this.rawChildren.addChild(minMaxBtn);  //or this.titleBar.addChild(minMaxBtn);
			this.minMaxBtn.addEventListener(MouseEvent.CLICK, switchStateIcon);
			this.minMaxBtn.addEventListener(MouseEvent.CLICK, minTitleWin);
		}
		
		private function switchStateIcon(event:MouseEvent):void {
			if(styleFlag === 0){
				minMaxBtn.setStyle("overIcon", buttonUpIcon);
				styleFlag = 1;
				minMaxBtn.toolTip = "maximize";
			} else {
				minMaxBtn.setStyle("overIcon", buttonDownIcon);
				styleFlag = 0;
				minMaxBtn.toolTip = "minimize";
			}			
		}
		
		protected function minTitleWin(event:MouseEvent):void {
			effResize.stop();
			minMaxBtn.removeEventListener(MouseEvent.CLICK, minTitleWin);
			minMaxBtn.addEventListener(MouseEvent.CLICK, maxTitleWin);
			effResize.heightFrom = height;
			effResize.heightTo = previousHeight;
			previousHeight = height;
			effResize.play([this]);
		}
		
		protected function maxTitleWin(event:MouseEvent):void {
			effResize.stop();
			minMaxBtn.removeEventListener(MouseEvent.CLICK, maxTitleWin); 
			minMaxBtn.addEventListener(MouseEvent.CLICK, minTitleWin);
			effResize.heightFrom = height;
			effResize.heightTo = previousHeight;
			previousHeight = height;
			effResize.play([this]);
		}
		
		/*protected function fullExpansion(event:MouseEvent):void {
			effResize.stop();
			add an expand to full screen button
			this is a new button and requires new declaration
		}*/
		
		protected override function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void {
			super.updateDisplayList(unscaledWidth, unscaledHeight);
			if(unscaledWidth > 0) {
				this.visible = true;
			} else {
				this.visible = false;
			}
			/* sets position of button*/
			var upAsset:DisplayObject = minMaxBtn.getChildByName("upIcon");
			var margin:int = 4;
			var pixelsFromTop:int = 8;
			var pixelsFromRight:int = 30;
			var buttonWidth:int = minMaxBtn.width;
			var xPos:Number = unscaledWidth - buttonWidth - pixelsFromRight; 
			var yPos:Number = pixelsFromTop + 1;      
			// moves button to x, y position on TitleWindow
			minMaxBtn.move(xPos, yPos);
		}
	}
}
