Didum,

Please see FlexViewerError folder on DeskTop, a folder called 4_22_2011 has
a) MyFloatDG.mxml
b) MySearchWidget.mxml

Adam,

   Here is a example of what you were as to see in the Flex Sample Viewer. 
Just copy the 2 mxml file to your widgets folder and then add the following line to the config.xml
Also you will have to register both these Flex Modules with your project by right clicking the flexviewer
project, going to properties, Flex Modules, add, browse to the widgets folder, choose MySearchWidget.mxml
and repeat for MyFloatDG.mxml

<widget label="My Search" icon="com/esri/solutions/flexviewer/assets/images/icons/i_search.png" menu="menuWidgets" config="">com/esri/solutions/flexviewer/widgets/MySearchWidget.swf</widget>

Robert

website
<!--http://forums.esri.com/Thread.asp?c=158&f=2421&t=284280-->