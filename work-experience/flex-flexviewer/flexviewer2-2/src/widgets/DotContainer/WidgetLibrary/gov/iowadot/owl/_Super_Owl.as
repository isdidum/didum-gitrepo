/**
 * This is a generated class and is not intended for modification.  To customize behavior
 * of this service wrapper you may modify the generated sub-class of this class - Owl.as.
 */
package gov.iowadot.owl
{
import com.adobe.fiber.core.model_internal;
import com.adobe.fiber.services.wrapper.WebServiceWrapper;
import com.adobe.serializers.utility.TypeUtility;
import flash.utils.ByteArray;
import mx.rpc.AbstractOperation;
import mx.rpc.AsyncToken;
import mx.rpc.soap.mxml.Operation;
import mx.rpc.soap.mxml.WebService;

[ExcludeClass]
internal class _Super_Owl extends com.adobe.fiber.services.wrapper.WebServiceWrapper
{
	
    // Constructor
    public function _Super_Owl()
    {
        // initialize service control
        _serviceControl = new mx.rpc.soap.mxml.WebService();
		var operations:Object = new Object();
        var operation:mx.rpc.soap.mxml.Operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetCountyList");
         operation.resultType = Object;
        operations["GetCountyList"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetCountyBorderWKT");
         operation.resultType = Object;
        operations["GetCountyBorderWKT"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetRPAWKT");
         operation.resultType = Object;
        operations["GetRPAWKT"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetCityList");
         operation.resultType = Object;
        operations["GetCityList"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetMapImageData");
         operation.resultType = ByteArray;
        operations["GetMapImageData"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetBridgeWKT");
         operation.resultType = Object;
        operations["GetBridgeWKT"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetMPOWKT");
         operation.resultType = Object;
        operations["GetMPOWKT"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetRPAList");
         operation.resultType = Object;
        operations["GetRPAList"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetMPOList");
         operation.resultType = Object;
        operations["GetMPOList"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetCityBorderWKT");
         operation.resultType = Object;
        operations["GetCityBorderWKT"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetStateBorderWKT");
         operation.resultType = Object;
        operations["GetStateBorderWKT"] = operation;

        operation = new mx.rpc.soap.mxml.Operation(null, "GetFHWAList");
         operation.resultType = Object;
        operations["GetFHWAList"] = operation;

        _serviceControl.operations = operations;
        try
        {
            _serviceControl.convertResultHandler = com.adobe.serializers.utility.TypeUtility.convertResultHandler;
        }
        catch (e: Error)
        { /* Flex 3.4 and eralier does not support the convertResultHandler functionality. */ }



        _serviceControl.service = "OWL";
        _serviceControl.port = "OWLSoap";
        wsdl = "http://owl/Service.asmx?wsdl";
        model_internal::loadWSDLIfNecessary();


        model_internal::initialize();
    }

    /**
      * This method is a generated wrapper used to call the 'GetCountyList' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetCountyList(vYear:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetCountyList");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vYear) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetCountyBorderWKT' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetCountyBorderWKT(vCoNum:int, vYear:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetCountyBorderWKT");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vCoNum,vYear) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetRPAWKT' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetRPAWKT(vRPANum:int) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetRPAWKT");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vRPANum) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetCityList' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetCityList(vYear:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetCityList");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vYear) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetMapImageData' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetMapImageData(vMapUrl:String, x1:String, y1:String, x2:String, y2:String, SRID:String, width:String, height:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetMapImageData");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vMapUrl,x1,y1,x2,y2,SRID,width,height) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetBridgeWKT' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetBridgeWKT(vFHWANum:int) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetBridgeWKT");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vFHWANum) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetMPOWKT' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetMPOWKT(vMPONum:int) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetMPOWKT");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vMPONum) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetRPAList' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetRPAList() : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetRPAList");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send() ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetMPOList' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetMPOList() : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetMPOList");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send() ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetCityBorderWKT' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetCityBorderWKT(vCityNum:int, vYear:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetCityBorderWKT");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vCityNum,vYear) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetStateBorderWKT' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetStateBorderWKT(vYear:String) : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetStateBorderWKT");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(vYear) ;

        return _internal_token;
    }
     
    /**
      * This method is a generated wrapper used to call the 'GetFHWAList' operation. It returns an mx.rpc.AsyncToken whose 
      * result property will be populated with the result of the operation when the server response is received. 
      * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
      * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
      */
    public function GetFHWAList() : mx.rpc.AsyncToken
    {
        model_internal::loadWSDLIfNecessary();
        var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("GetFHWAList");
        var _internal_token:mx.rpc.AsyncToken = _internal_operation.send() ;

        return _internal_token;
    }
     
}

}
