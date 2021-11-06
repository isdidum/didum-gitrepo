/**
 * This is a generated class and is not intended for modification.  To customize behavior
 * of this service wrapper you may modify the generated sub-class of this class - Jetfire.as.
 */
package gov.iowadot.jetfire
{
import com.adobe.fiber.core.model_internal;
import com.adobe.fiber.services.wrapper.WebServiceWrapper;
import com.adobe.serializers.utility.TypeUtility;
import mx.rpc.AbstractOperation;
import mx.rpc.AsyncToken;
import mx.rpc.soap.mxml.Operation;
import mx.rpc.soap.mxml.WebService;

[ExcludeClass]
internal class _Super_Jetfire extends com.adobe.fiber.services.wrapper.WebServiceWrapper
{
     
    // Constructor
    public function _Super_Jetfire()
    {
        // initialize service control
        _serviceControl = new mx.rpc.soap.mxml.WebService();
        var operations:Object = new Object();
        var operation:mx.rpc.soap.mxml.Operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "XmlObjectToCoordRouteS");
         operation.resultType = Object;
        operations["XmlObjectToCoordRouteS"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "Reproject");
         operation.resultType = Object;
        operations["Reproject"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "LatLongToLrs");
         operation.resultType = Object;
        operations["LatLongToLrs"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "CoordRouteToDatumAP");
         operation.resultType = Object;
        operations["CoordRouteToDatumAP"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "CoordRouteToDatumAL");
         operation.resultType = Object;
        operations["CoordRouteToDatumAL"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "XmlObjectToCoordRouteU");
         operation.resultType = Object;
        operations["XmlObjectToCoordRouteU"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "RefPostToDatumUP");
         operation.resultType = Object;
        operations["RefPostToDatumUP"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "LrsToLatLong");
         operation.resultType = Object;
        operations["LrsToLatLong"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "CoordRouteToDatumUL");
         operation.resultType = Object;
        operations["CoordRouteToDatumUL"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "XmlObjectToLiteral");
         operation.resultType = Object;
        operations["XmlObjectToLiteral"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "XmlObjectToRefPostU");
         operation.resultType = Object;
        operations["XmlObjectToRefPostU"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "RefPostToDatumUL");
         operation.resultType = Object;
        operations["RefPostToDatumUL"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetRouteIdU");
         operation.resultType = Object;
        operations["GetRouteIdU"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "RefPostToDatumAP");
         operation.resultType = Object;
        operations["RefPostToDatumAP"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetRouteLength");
         operation.resultType = Object;
        operations["GetRouteLength"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "CoordRouteToDatumUP");
         operation.resultType = Object;
        operations["CoordRouteToDatumUP"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetRouteList");
         operation.resultType = Object;
        operations["GetRouteList"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetGeographicExtentList");
         operation.resultType = Object;
        operations["GetGeographicExtentList"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetGeoExtentIdByName");
         operation.resultType = Object;
        operations["GetGeoExtentIdByName"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "XmlObjectToRefPost");
         operation.resultType = Object;
        operations["XmlObjectToRefPost"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetBestRouteId");
         operation.resultType = Object;
        operations["GetBestRouteId"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetGeoExtentListByRouteSysName");
         operation.resultType = Object;
        operations["GetGeoExtentListByRouteSysName"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "XmlObjectToCoordRouteA");
         operation.resultType = Object;
        operations["XmlObjectToCoordRouteA"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetCardinalDirection");
         operation.resultType = Object;
        operations["GetCardinalDirection"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetRouteSystemList");
         operation.resultType = Object;
        operations["GetRouteSystemList"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "XmlObjectToRefPostA");
         operation.resultType = Object;
        operations["XmlObjectToRefPostA"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetRouteSysIdByName");
         operation.resultType = Object;
        operations["GetRouteSysIdByName"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetRefPostList");
         operation.resultType = Object;
        operations["GetRefPostList"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "CoordRouteToDatumSL");
         operation.resultType = Object;
        operations["CoordRouteToDatumSL"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "RefPostToDatumSP");
         operation.resultType = Object;
        operations["RefPostToDatumSP"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "XmlObjectToCoordRoute");
         operation.resultType = Object;
        operations["XmlObjectToCoordRoute"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "XmlObjectToWKT");
         operation.resultType = Object;
        operations["XmlObjectToWKT"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetGeoExtentListByRouteSysId");
         operation.resultType = Object;
        operations["GetGeoExtentListByRouteSysId"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "SnapXYToDatum");
         operation.resultType = Object;
        operations["SnapXYToDatum"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "RefPostToDatumAL");
         operation.resultType = Object;
        operations["RefPostToDatumAL"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "RefPostToDatumSL");
         operation.resultType = Object;
        operations["RefPostToDatumSL"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "XmlObjectToRefPostS");
         operation.resultType = Object;
        operations["XmlObjectToRefPostS"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "CoordRouteToDatumSP");
         operation.resultType = Object;
        operations["CoordRouteToDatumSP"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetRouteIdA");
         operation.resultType = Object;
        operations["GetRouteIdA"] = operation;

        _serviceControl.operations = operations;
        try
        {
            _serviceControl.convertResultHandler = com.adobe.serializers.utility.TypeUtility.convertResultHandler;
        }
        catch (e: Error)
        { /* Flex 3.4 and eralier does not support the convertResultHandler functionality. */ }



        _serviceControl.service = "JetFire";
        _serviceControl.port = "JetFireSoap";
        wsdl = "http://lrs/Service.asmx?wsdl";
        model_internal::loadWSDLIfNecessary();


        model_internal::initialize();
    }

    /**
      * This method is a generated wrapper used to call the 'XmlObjectToCoordRouteS' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function XmlObjectToCoordRouteS(vXmlObject:String, vRouteId:int, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("XmlObjectToCoordRouteS");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vXmlObject,vRouteId,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'Reproject' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function Reproject(vX:Number, vY:Number, vInSRID:int, vOutSRID:int) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("Reproject");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vX,vY,vInSRID,vOutSRID) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'LatLongToLrs' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function LatLongToLrs(vX:Number, vY:Number) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("LatLongToLrs");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vX,vY) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'CoordRouteToDatumAP' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function CoordRouteToDatumAP(vRouteSystemName:String, vRoutePrefix:String, vRouteName:String, vRouteType:String, vRouteSuffix:String, vRouteDirection:String, vGeographicExtentName:String, vX:Number, vY:Number, vTolerance:String, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("CoordRouteToDatumAP");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vRouteSystemName,vRoutePrefix,vRouteName,vRouteType,vRouteSuffix,vRouteDirection,vGeographicExtentName,vX,vY,vTolerance,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'CoordRouteToDatumAL' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function CoordRouteToDatumAL(vRouteSystemName:String, vRoutePrefix:String, vRouteName:String, vRouteType:String, vRouteSuffix:String, vRouteDirection:String, vGeographicExtentName:String, vStartX:Number, vStartY:Number, vEndX:Number, vEndY:Number, vTolerance:String, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("CoordRouteToDatumAL");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vRouteSystemName,vRoutePrefix,vRouteName,vRouteType,vRouteSuffix,vRouteDirection,vGeographicExtentName,vStartX,vStartY,vEndX,vEndY,vTolerance,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'XmlObjectToCoordRouteU' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function XmlObjectToCoordRouteU(vXmlObject:String, vRouteSystemName:String, vRouteDesignator:String, vGeographicExtentName:String, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("XmlObjectToCoordRouteU");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vXmlObject,vRouteSystemName,vRouteDesignator,vGeographicExtentName,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'RefPostToDatumUP' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function RefPostToDatumUP(vRouteSystemName:String, vRouteDesignator:String, vGeographicExtentName:String, vPostName:String, vOffset:Number, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("RefPostToDatumUP");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vRouteSystemName,vRouteDesignator,vGeographicExtentName,vPostName,vOffset,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'LrsToLatLong' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function LrsToLatLong(vX:Number, vY:Number) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("LrsToLatLong");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vX,vY) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'CoordRouteToDatumUL' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function CoordRouteToDatumUL(vRouteSystemName:String, vRouteDesignator:String, vGeographicExtentName:String, vStartX:Number, vStartY:Number, vEndX:Number, vEndY:Number, vTolerance:String, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("CoordRouteToDatumUL");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vRouteSystemName,vRouteDesignator,vGeographicExtentName,vStartX,vStartY,vEndX,vEndY,vTolerance,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'XmlObjectToLiteral' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function XmlObjectToLiteral(vXmlObject:String, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("XmlObjectToLiteral");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vXmlObject,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'XmlObjectToRefPostU' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function XmlObjectToRefPostU(vXmlObject:String, vRouteSystemName:String, vRouteDesignator:String, vGeographicExtentName:String, vOffsetType:int, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("XmlObjectToRefPostU");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vXmlObject,vRouteSystemName,vRouteDesignator,vGeographicExtentName,vOffsetType,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'RefPostToDatumUL' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function RefPostToDatumUL(vRouteSystemName:String, vRouteDesignator:String, vGeographicExtentName:String, vStartPostName:String, vStartOffset:Number, vEndPostName:String, vEndOffset:Number, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("RefPostToDatumUL");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vRouteSystemName,vRouteDesignator,vGeographicExtentName,vStartPostName,vStartOffset,vEndPostName,vEndOffset,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetRouteIdU' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetRouteIdU(vRouteSystemName:String, vRouteDesignator:String, vGeographicExtentName:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetRouteIdU");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vRouteSystemName,vRouteDesignator,vGeographicExtentName) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'RefPostToDatumAP' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function RefPostToDatumAP(vRouteSystemName:String, vRoutePrefix:String, vRouteName:String, vRouteType:String, vRouteSuffix:String, vRouteDirection:String, vGeographicExtentName:String, vPostName:String, vOffset:Number, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("RefPostToDatumAP");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vRouteSystemName,vRoutePrefix,vRouteName,vRouteType,vRouteSuffix,vRouteDirection,vGeographicExtentName,vPostName,vOffset,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetRouteLength' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetRouteLength(vRouteId:int) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetRouteLength");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vRouteId) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'CoordRouteToDatumUP' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function CoordRouteToDatumUP(vRouteSystemName:String, vRouteDesignator:String, vGeographicExtentName:String, vX:Number, vY:Number, vTolerance:String, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("CoordRouteToDatumUP");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vRouteSystemName,vRouteDesignator,vGeographicExtentName,vX,vY,vTolerance,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetRouteList' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetRouteList(vSystemId:String, vExtentId:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetRouteList");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vSystemId,vExtentId) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetGeographicExtentList' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetGeographicExtentList() : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetGeographicExtentList");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send() ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetGeoExtentIdByName' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetGeoExtentIdByName(vExtentName:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetGeoExtentIdByName");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vExtentName) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'XmlObjectToRefPost' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function XmlObjectToRefPost(vXmlObject:String, vRouteId:int, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("XmlObjectToRefPost");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vXmlObject,vRouteId,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetBestRouteId' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetBestRouteId(vXmlObject:String, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetBestRouteId");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vXmlObject,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetGeoExtentListByRouteSysName' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetGeoExtentListByRouteSysName(vSystemName:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetGeoExtentListByRouteSysName");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vSystemName) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'XmlObjectToCoordRouteA' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function XmlObjectToCoordRouteA(vXmlObject:String, vRouteSystemName:String, vRoutePrefix:String, vRouteName:String, vRouteType:String, vRouteSuffix:String, vRouteDirection:String, vGeographicExtentName:String, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("XmlObjectToCoordRouteA");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vXmlObject,vRouteSystemName,vRoutePrefix,vRouteName,vRouteType,vRouteSuffix,vRouteDirection,vGeographicExtentName,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetCardinalDirection' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetCardinalDirection(vSystemId:int, vExtentId:int, vRouteName:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetCardinalDirection");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vSystemId,vExtentId,vRouteName) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetRouteSystemList' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetRouteSystemList() : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetRouteSystemList");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send() ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'XmlObjectToRefPostA' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function XmlObjectToRefPostA(vXmlObject:String, vRouteSystemName:String, vRoutePrefix:String, vRouteName:String, vRouteType:String, vRouteSuffix:String, vRouteDirection:String, vGeographicExtentName:String, vOffsetType:int, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("XmlObjectToRefPostA");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vXmlObject,vRouteSystemName,vRoutePrefix,vRouteName,vRouteType,vRouteSuffix,vRouteDirection,vGeographicExtentName,vOffsetType,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetRouteSysIdByName' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetRouteSysIdByName(vSystemName:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetRouteSysIdByName");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vSystemName) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetRefPostList' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetRefPostList(vRouteId:int) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetRefPostList");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vRouteId) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'CoordRouteToDatumSL' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function CoordRouteToDatumSL(vRouteId:int, vStartX:Number, vStartY:Number, vEndX:Number, vEndY:Number, vTolerance:String, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("CoordRouteToDatumSL");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vRouteId,vStartX,vStartY,vEndX,vEndY,vTolerance,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'RefPostToDatumSP' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function RefPostToDatumSP(vRouteId:int, vPostName:String, vOffset:Number, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("RefPostToDatumSP");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vRouteId,vPostName,vOffset,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'XmlObjectToCoordRoute' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function XmlObjectToCoordRoute(vXmlObject:String, vRouteId:int, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("XmlObjectToCoordRoute");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vXmlObject,vRouteId,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'XmlObjectToWKT' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function XmlObjectToWKT(vXmlObject:String, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("XmlObjectToWKT");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vXmlObject,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetGeoExtentListByRouteSysId' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetGeoExtentListByRouteSysId(vSystemId:int) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetGeoExtentListByRouteSysId");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vSystemId) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'SnapXYToDatum' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function SnapXYToDatum(vX:Number, vY:Number, vTolerance:String, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("SnapXYToDatum");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vX,vY,vTolerance,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'RefPostToDatumAL' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function RefPostToDatumAL(vRouteSystemName:String, vRoutePrefix:String, vRouteName:String, vRouteType:String, vRouteSuffix:String, vRouteDirection:String, vGeographicExtentName:String, vStartPostName:String, vStartOffset:Number, vEndPostName:String, vEndOffset:Number, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("RefPostToDatumAL");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vRouteSystemName,vRoutePrefix,vRouteName,vRouteType,vRouteSuffix,vRouteDirection,vGeographicExtentName,vStartPostName,vStartOffset,vEndPostName,vEndOffset,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'RefPostToDatumSL' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function RefPostToDatumSL(vRouteId:int, vStartPostName:String, vStartOffset:Number, vEndPostName:String, vEndOffset:Number, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("RefPostToDatumSL");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vRouteId,vStartPostName,vStartOffset,vEndPostName,vEndOffset,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'XmlObjectToRefPostS' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function XmlObjectToRefPostS(vXmlObject:String, vRouteId:int, vOffsetType:int, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("XmlObjectToRefPostS");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vXmlObject,vRouteId,vOffsetType,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'CoordRouteToDatumSP' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function CoordRouteToDatumSP(vRouteId:int, vX:Number, vY:Number, vTolerance:String, vDate:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("CoordRouteToDatumSP");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vRouteId,vX,vY,vTolerance,vDate) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetRouteIdA' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetRouteIdA(vRouteSystemName:String, vRoutePrefix:String, vRouteName:String, vRouteType:String, vRouteSuffix:String, vRouteDirection:String, vGeographicExtentName:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetRouteIdA");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vRouteSystemName,vRoutePrefix,vRouteName,vRouteType,vRouteSuffix,vRouteDirection,vGeographicExtentName) ;

        return _internal_token;
    }
     
}

}
