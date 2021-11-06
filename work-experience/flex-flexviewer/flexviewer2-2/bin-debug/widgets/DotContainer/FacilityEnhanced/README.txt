/////////////////////////////////////////////////////
// Designer: Developed by Didum Abraham
// Email(s): didum.abraham@iowa.gov or iusc13@gmail.com
// Reason: Use of ArcGIS Viewer for Flex to assemble a standard libary for the IA DOT
// Company: Iowa Department of Tranpostation
// Division: Information Technology (IT) - GIS Support Team
// Version: Flexviewer version 2.2
// Date: June 15, 2011
////////////////////////////////////////////////////

/**************************************************
			SOFTWARE SERVICE AGREEMENT
***************************************************/
1. 	Update and/or modify software as needed
2.	If updates are made, note them down in a textpad, specifically stating the changes and dates made
3.	Use and distribute to friends but not to be sold for any money
4.	Selling of this software product is forbidden
5.	For complete hearing on software service agreement, see license.txt

================================
 Enhanced LiDAR Locator Widget
================================
A. Overview
	1.	Widget uses QueryTask and IdentifyTask to find features on map
	2.	Has two graphicslayers (myGraphicsLayer & myGraphicsLayer2)
	3. 	Also has two onItemClick functions (onItemClick() & onItemClick2()) place one after the other in AdvancedDataGrid
	3.	Writes results from QueryTask to myGraphicsLayer2
	4.	Overrides results found from QueryTask with results found from IdentifyTask to myGraphicsLayer2
	5.	Widget allows end-user an option to Geometry draw tool such as map point identify,
		polyline, polygon, and extent
	6.	Features are populated onResult() & onMyResult() to AdvancedDataGrid
	7.	Results' TitlebarButton gives end-user the flexibility to view individual column of the AdvancedDataGrid
	8.	Upon viewing each individual column of the AdvancedDataGrid, end-user can use the mouse pointer to interact with map

B. Enhancement
	1. 	Resize grid (auto)
	2.	Open results in list view
		- Address, Bulding Type, Cost Center, Year, Phone, Square-footage, Unique Key, Inventory
		- Click on data in AdvancedDataGrid cell zooms to data
	3. 	Keep active widget when minimized
	4.	Deactivate widget when closed
	
C. Files Required
	1. main application file (.swf) made from mxml component
	2. xml file (.xml)

D. ActionScript Functions and Functionalities
	1.	activateGraphic()
			- adds both graphicslayers to the map
			- myGraphicsLayer and myGraphicsLayer2
	2.	init()
			- activate graphicslayers
			- instantiate new DrawTool
			- activates listener's ItemClcikEvent on function activateClick
			- activates listener's DrawEvent on function onDrawEnd
			- parses out xml string literals
			- sets up widget's TitlebarButtons
	3.	activateClick()
			- instantiate new DrawTool
			- adds symbols to DrawTool
			- uses a switch selection structure to give end-user access to Geometry DrawTool
	4.	onDrawEnd()
			- clears map
			- adds draw event to myGraphicsLayer
			- sets and passes draw event as Geometry
			- deactivates DrawTool
			- deactivates DrawTool ToolTip
			- calls function doIdentify 			
	5.	doIdentify()
			- instantiates new IdentifyParameters
			- sets up identifyParameters's properties to use when identify begins
			- calls in function doExecuteIdentifyNow 
			- calls function showMessage
			- calls function showResultState
	6.	doExecuteIdentifyNow()
			- executes identifyTask
			- calls AsynchronousResponder, which allows simultaneous execution of multiple functions
	7.	onMyResult()
			- has an if-selection structure that checks to be sure results are retruned 
			- uses a for-each loop to add graphic to the graphicslayer (myGraphicsLayer2)
			- also uses a switch-selection structure to check geometryType returned
			- finally use a for loop to store features to provide to the AdvancedDataGrid (myGrid)
	8.	onMyFault()
			- reports error found with function doIdentify
			- displays through use of alert statement
	9. 	doQuery()
			- instantiattes new Query
			- uses an if-selection structure to identify radio button selected by end-user
			- sets up query's properties to use when query begins
			- calls in function doExecuteQueryNow
			- calls function showMessage
			- calls function showResultState
	10.	doExecuteQueryNow()
			- executes queryTask
			- calls AsynchronousResponder, which allows simultaneous execution of multiple functions		
	11.	onResult()
			- uses a try-catch statement to detect error, otherwise, displays results
			- an if-selection structure is used to check if no results then alert message, otherwise, displays results
			- gets graphics's extent through the use of GraphicUtil then zooms to results
			- populates results to AdvancedDataGrid (myGrid) through dataProvider
			- calls function clearMessages
	12. onFault()
			- uses alert statement to show error
			- also uses function showMessage
	13.	onItemClick()
			- uses AdvancedDataGrid's (myGrid) listEvent
			- has a nested function
			- function inner findGraphicByAttributes
				- returns Graphic after using a for-each loop to get graphics in myGraphicsLayer2 
				- uses an if-selecture structure to compare objects then gets graphicsextent of each object
				- zooms to extent upon mouse click
			- function outter onItemClick : assigns symbols to the Graphic returned
	14. onItemClick2()
			- uses AdvancedDataGrid's (myGrid) listEvent
			- has a nested function
			- function inner findGraphicByAttributes2
				- returns Graphics found after using a for-each loop to get graphics in myGraphicsLayer2
				- use an if-selection structure to compare objects
			- function outter onItemClick2 : checks to ensure myGraphicsLayer2 is present
				- assigns symbols to each graphic
				- gets graphicsextent and zooms to graphic upon mouse click
			
	15.	hideShowMyGridCols()
			- compares the columns of two arrays
				- [A] : myListColsLabels
				- [B] : AdvancedDataGrid (myGrid)
			- uses two for loops to make comparision possible
			- also uses an if-selection statement to check if columns names match up
			- if true, show it, otherwise, hide it
	16. showAll()
			- shows all AdvancedDataGrid (myGrid) columns
			- calls function hideShowMyGridCols
	17.	hideAll()
			- empties all AdvancedDataGrid (myGrid) columns
			- calls function hideShowMyGridCols
	18.	setDefualt()
			- sets initial viewing columns of AdvancedDataGrid (myGrid)
			- calls function hideShowMyGridCols
	19.	handleDividerRelease()
			- uses an if-selection struction to control the width VBox
	20. showMessage()
			- sets loader messages
			- allows visibility of load spinner
	21. clearMessage()
			- clears loader messages
	22. showBeginState()
			- initial state of widget tab, namely, Search
			- activates dynamic map service
	23. showIdentifyState()
			- widget's Geometry DrawTool tab
			- allows for geometric tool selection
	24. showToggleState()
			- widget's Layer tab
			- allows for facilities and/or parcels layer to be visible 
	25. showResultState()
			- widget's 4th tab, Results
			- when either identifyTask or queryTask is called, this state is displayed
	26. showClearGraphic()
			- clears graphicslayer
			- widget's 5th tab, Clear
	27. wgtTempOpen()
			- widget's open state
			- calls function showBeginState
			- keeps events on AdvancedDataGrid (myGrid) active
			- uses an if-selection structure to ensure both graphicslayers are available
	28. wgtTempMinimized()
			- widget's minimized state
			- deactivates DrawTool
			- ensures other tabs aren't visible in the current visible state
			- uses an if-selection structure to ensure both graphicslayers are kept active upon minimized
	29. wgtTempClosed()
			- widget's minimized state
			- deactivates DrawTool
			- clears both graphicslayers
			- deactivate events on AdvancedDataGrid (myGrid)
			- ensures other tabs aren't visible in the current visible state
			- uses an if-selection structure to ensure both graphicslayers are deactivated upon closed
	

