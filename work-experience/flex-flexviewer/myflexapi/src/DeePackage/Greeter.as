// ActionScript file
package DeePackage {
	
	import mx.controls.Alert;
	
	public class Greeter {
		
		public function sayHello():String {
			var greeting:String = "<a href='http://www.adobe.com/devnet-archive/flex/tourdeflex/web/#' target='_blank'>Hello World of TourDeFlex!</a>";
			//since the function is not void, it must have a return-statement
			return greeting; 
		}
		
		public function forLoop():String {
			var eNum:Number;
			var oNum:Number;
			var aNum:Number = 0;
			
			//var myNum:Number = prompt("Please enter a number", "int/whole #");
			if(10 <= 0){
				Alert.show("The value entered must not be negative nor zero");		
			}else {
				for (var i:int=1; i<10; i++){
					if(i % 2 === 0){
						eNum = i;							
					} else {
						oNum = i;
					}
					aNum = aNum + 1;
					Alert.show(aNum + "\t" + eNum + "\t" + oNum);
					var myNum:String = (aNum + "\t" + eNum + "\t" + oNum);
				}
			}
			return myNum;
		}
		
		
	}
}