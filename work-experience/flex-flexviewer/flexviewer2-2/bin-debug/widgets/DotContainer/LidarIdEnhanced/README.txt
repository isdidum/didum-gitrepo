/////////////////////////////////////////////////////
// Designer: Developed by Didum Abraham
// Email(s): didum.abraham@iowa.gov or iusc13@gmail.com
// Reason: Use of ArcGIS Viewer for Flex to assemble a standard libary for the IA DOT
// Company: Iowa Department of Tranpostation
// Division: Information Technology (IT) - GIS Support Team
// Version: Flexviewer version 2.2
// Date: June 20, 2011
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
A. Use and Geometry DrawTool
	1.	Widget allows end-user an option to Geometry draw tool such as map point identify,
		polyline, polygon, and extent
	2.  Has one graphicslayer (myGraphicsLayer)
	3.	Widget uses identifyTask to find features on map
	4.	Features are populated onResult() to AdvancedDataGrid
	5.	Results' TitlebarButton gives end-user the flexibility to view individual column of the AdvancedDataGrid
	6.	Upon viewing each individual column of the AdvancedDataGrid, end-user can use the mouse pointer to interact with map

B. Enhancement
	1. 	Resize grid (auto)
	2.	Open results in list view
		- File Name, Click Name (open file locaion in external browser)
		- Allow for copying multiple paths to a textpad/notepad
	3. 	Keep active widget when minimized
	4.	Deactivate widget when closed
	
C. Files Required
	1. main application file (.swf) made from mxml component
	2. xml file (.xml)
	
D. ActionScript Functions and Functionalities
	1.	activateGraphic()
			- adds a graphicslayers to the map
			- myGraphicsLayer
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
	7.	myResultFunction()
			- has an if-selection structure that checks to be sure resuts are retruned 
			- uses a switch-selection structure to check geometryType returned
			- Also uses a for-loop to store features to provide to the AdvancedDataGrid (myGrid)
			- lastly, assigns result's features to graphicslayer
	8.	myFaultFunction()
			- reports error found with function doIdentify
			- displays errors through use of alert statement and function showMessage
	9.	onItemClick()
			- uses AdvancedDataGrid's (myGrid) listEvent
			- Also uses a switch-selection structure to check listEvent on AdvancedDataGrid (myGrid) columnIndex
			- And also makes use of if-selection structure in each case of the switch structure 
			to ensure the proper column is selected and end-user can have interaction
	10.	showdgToolTip()
			- hides and show AdavanceDataGrid (myGrid) ToolTip
			- returns a string
	11.	myKeyUpHandler()
			- allows end-user the availability of copy and paste with keyboard keys
	12. hideShowMyGridCols()
			- compares the columns of two arrays
				- [A] : myListColsLabels
				- [B] : AdvancedDataGrid (myGrid)
			- uses two for loops to make comparision possible
			- also uses an if-selection statement to check if columns names match up
			- if true, show it, otherwise, hide it
	13. showAll()
			- shows all AdvancedDataGrid (myGrid) columns
			- calls function hideShowMyGridCols
	14.	hideAll()
			- empties all AdvancedDataGrid (myGrid) columns
			- calls function hideShowMyGridCols
	15.	setDefualt()
			- sets initial viewing columns of AdvancedDataGrid (myGrid)
			- calls function hideShowMyGridCols
	16.	handleDividerRelease()
			- uses an if-selection struction to control the width VBox	
	17.	clearMap()
			- sets Geometry DrawTool and clears graphicslayer
			- empties out AdvancedDataGrid (myGrid) dataProvider
			- deactivates DrawTool and calls function clearMessage
	18.	showMessage()
			- sets loader messages
			- allows visibility of load spinner
	19. clearMessage()
			- clears loader messages
	20.	showStateIdentify()
			- widget's Geometry DrawTool tab
			- allows for geometric tool selection
	21. showStateResults()
			- widget's 4th tab, Results
			- when either identifyTask or queryTask is called, this state is displayed
	22. showClearGraphic()
			- clears graphicslayer
			- widget's 5th tab, Clear
	23. widgetOpenHandler()
			- calls function showStateIdentify
			- activates listener's ItemClickEvent on function activateClick
			- ensures graphicslayer is visible
	24. widgetMinimizedHandler()
			- deactivates DrawTool
			- keeps other tab invisible 
			- ensures graphicslayer is visible
	25. widgetClosedHandler()
			- deactivate DrawTool
			- clears graphicslayer
			- ensures graphicslayer is invisible	

