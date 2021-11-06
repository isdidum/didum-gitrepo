SET SERVERROUTPUT ON SIZE 1000000  
SET ESCAPE ON;


DECLARE 
    CURSOR c_1 
    IS 
        --setup cursor for paint condition
        SELECT M.ROWID, m.ST_POST, m.ED_POST, m.ROUTE_NAME, m.ST_OFFSET, ED_OFFSET, m.ROUTE_TYPE, m.ROUTE_DIR, m.GEO_EXTENT, m.SYSTEM_NAME
        FROM IOWA_TRANSFORM.BPAINT M   ORDER BY USER_ID;
        
    CURSOR c_2
    IS   
        --setup cursor for salt
         SELECT M.ROWID, m.ST_POST, m.ED_POST, m.ROUTE_NAME, m.ST_OFFSET, ED_OFFSET, m.ROUTE_TYPE, m.ROUTE_DIR, m.GEO_EXTENT, m.SYSTEM_NAME
        FROM IOWA_TRANSFORM.BSALT M   ORDER BY USER_ID;
      
    CURSOR c_3 
    IS 
        --setup cursor for pavement
         SELECT M.ROWID, m.ST_POST, m.ED_POST, m.ROUTE_NAME, m.ST_OFFSET, ED_OFFSET, m.ROUTE_TYPE, m.ROUTE_DIR, m.GEO_EXTENT, m.SYSTEM_NAME
        FROM IOWA_TRANSFORM.BPAVEMENT M   ORDER BY USER_ID;
        
     CURSOR c_4 
     IS 
        --setup cursor for resilient
         SELECT M.ROWID, m.ST_POST, m.ED_POST, m.ROUTE_NAME, m.ST_OFFSET, ED_OFFSET, m.ROUTE_TYPE, m.ROUTE_DIR, m.GEO_EXTENT, m.SYSTEM_NAME
        FROM IOWA_TRANSFORM.BRESILIENT M   ORDER BY USER_ID;   
        
        --MISC 
        v_WKT           CLOB;
        v_datum         CLOB;
        
        v_url       varchar2(32767);
        v_url2      varchar2(32767);    
         
BEGIN
    
    FOR gii IN c_1 LOOP
        BEGIN
            v_url := 'http://testlrs/wcf/1.0/JetFire.svc/pox/RefPostToDatumAL?RouteSystemName='||gii.SYSTEM_NAME||'\&RoutePrefix=\&RouteName='||gii.ROUTE_NAME||'
            \&RouteType='||gii.ROUTE_TYPE||'\&RouteSuffix=\&RouteDirection='||gii.ROUTE_DIR||'\&GeographicExtentName='||gii.GEO_EXTENT||'
            \&StartPostName='||gii.ST_POST||'\&StartOffset='||gii.ST_OFFSET||'\&EndPostName='||gii.ED_POST||'\&EndOffset='||gii.ED_OFFSET||'\&Date=\';
            
            v_datum := httpuritype (httpuritype (v_url).getExternalUrl()).getClob(); --also change to .getXML()
            
            v_url2 := 'http://testlrs/wcf/1.0/JetFire.svc/pox/XmlObjectToWKT?XmlObject='||v_datum||'\&Date='; --replaced lrs with testlrs
            
            --write an if-statement here
            IF(INSTR(v_datum, 'Error') <> 0)THEN
                DBMS_OUTPUT.PUT_LINE('DatumRef_ERR = ' || v_datum);
            ELSE
                v_WKT := XMLType(httpuritype (httpuritype (v_url2).getExternalUrl()).getClob()).EXTRACT('//WKT/text()').getClobVal();
                DBMS_OUTPUT.PUT_LINE ('DatumRef_PASS = ' || v_WKT);
             
                --update paint condition table 
                UPDATE  IOWA_TRANSFORM.BPAINT
                SET  DATUM_REFERENCE = v_datum, GEOMETRY = SDO_CS.TRANSFORM(SDO_GEOMETRY(v_WKT, 8192), 1050010) 
                    WHERE   ROWID = gii.ROWID;
            END IF;    

            
        END;
    END LOOP;
    
    --LOOP2
    FOR gii IN c_2 LOOP
        BEGIN
            v_url := 'http://lrs/wcf/1.0/JetFire.svc/pox/RefPostToDatumAL?RouteSystemName='||gii.SYSTEM_NAME||'\&RoutePrefix=\&RouteName='||gii.ROUTE_NAME||'
            \&RouteType='||gii.ROUTE_TYPE||'\&RouteSuffix=\&RouteDirection='||gii.ROUTE_DIR||'\&GeographicExtentName='||gii.GEO_EXTENT||'
            \&StartPostName='||gii.ST_POST||'\&StartOffset='||gii.ST_OFFSET||'\&EndPostName='||gii.ED_POST||'\&EndOffset='||gii.ED_OFFSET||'\&Date=\';
            
            v_datum := httpuritype (httpuritype (v_url).getExternalUrl()).getClob(); --also change to .getXML() if need be
            
            v_url2 := 'http://lrs/wcf/1.0/JetFire.svc/pox/XmlObjectToWKT?XmlObject='||v_datum||'\&Date=';
            
            IF(INSTR(v_datum, 'Error') <> 0)THEN
                DBMS_OUTPUT.PUT_LINE('DatumRef_FAIL = ' || v_datum);
            ELSE
                v_WKT := XMLType(httpuritype (httpuritype (v_url2).getExternalUrl()).getClob()).EXTRACT('//WKT/text()').getClobVal();
                DBMS_OUTPUT.PUT_LINE ('DatumRef_PASS = ' || v_WKT);
                --update salt table
                UPDATE  IOWA_TRANSFORM.BSALT
                SET  DATUM_REFERENCE = v_datum, GEOMETRY = SDO_CS.TRANSFORM(SDO_GEOMETRY(v_WKT, 8192), 1050010) 
                     WHERE   ROWID = gii.ROWID;
            END IF;
            
        END;
    END LOOP;
    
    --LOOP3
      FOR gii IN c_3 LOOP
        BEGIN
            v_url := 'http://lrs/wcf/1.0/JetFire.svc/pox/RefPostToDatumAL?RouteSystemName='||gii.SYSTEM_NAME||'\&RoutePrefix=\&RouteName='||gii.ROUTE_NAME||'
            \&RouteType='||gii.ROUTE_TYPE||'\&RouteSuffix=\&RouteDirection='||gii.ROUTE_DIR||'\&GeographicExtentName='||gii.GEO_EXTENT||'
            \&StartPostName='||gii.ST_POST||'\&StartOffset='||gii.ST_OFFSET||'\&EndPostName='||gii.ED_POST||'\&EndOffset='||gii.ED_OFFSET||'\&Date=\';
            
            v_datum := httpuritype (httpuritype (v_url).getExternalUrl()).getClob(); --also change to .getXML() if need be
            
            v_url2 := 'http://lrs/wcf/1.0/JetFire.svc/pox/XmlObjectToWKT?XmlObject='||v_datum||'\&Date=';
            
               IF(INSTR(v_datum, 'Error') <> 0)THEN
                DBMS_OUTPUT.PUT_LINE('DatumRef_ERR = ' || v_datum);
            ELSE
                v_WKT := XMLType(httpuritype (httpuritype (v_url2).getExternalUrl()).getClob()).EXTRACT('//WKT/text()').getClobVal();
                DBMS_OUTPUT.PUT_LINE ('DatumRef_PASS = ' || v_WKT);    
                --update pavement type table
                UPDATE  IOWA_TRANSFORM.BPAVEMENT
                SET  DATUM_REFERENCE = v_datum, GEOMETRY = SDO_CS.TRANSFORM(SDO_GEOMETRY(v_WKT, 8192), 1050010) 
                    WHERE   ROWID = gii.ROWID;
             END IF;
            
        END;
    END LOOP;
    
    --LOOP4
      FOR gii IN c_4 LOOP
        BEGIN
            v_url := 'http://lrs/wcf/1.0/JetFire.svc/pox/RefPostToDatumAL?RouteSystemName='||gii.SYSTEM_NAME||'\&RoutePrefix=\&RouteName='||gii.ROUTE_NAME||'
            \&RouteType='||gii.ROUTE_TYPE||'\&RouteSuffix=\&RouteDirection='||gii.ROUTE_DIR||'\&GeographicExtentName='||gii.GEO_EXTENT||'
            \&StartPostName='||gii.ST_POST||'\&StartOffset='||gii.ST_OFFSET||'\&EndPostName='||gii.ED_POST||'\&EndOffset='||gii.ED_OFFSET||'\&Date=\';
            
            v_datum := httpuritype (httpuritype (v_url).getExternalUrl()).getClob() ; --also change to .getXML()
            
            v_url2 := 'http://lrs/wcf/1.0/JetFire.svc/pox/XmlObjectToWKT?XmlObject='||v_datum||'\&Date=';
            
               IF(INSTR(v_datum, 'Error') <> 0)THEN
                DBMS_OUTPUT.PUT_LINE('DatumRef_ERR = ' || v_datum);
            ELSE
                v_WKT := XMLType(httpuritype (httpuritype (v_url2).getExternalUrl()).getClob()).EXTRACT('//WKT/text()').getClobVal();
                DBMS_OUTPUT.PUT_LINE ('DatumRef_PASS = ' || v_WKT);    
                --update resilient type table
                UPDATE  IOWA_TRANSFORM.BRESILIENT
                SET  DATUM_REFERENCE = v_datum, GEOMETRY = SDO_CS.TRANSFORM(SDO_GEOMETRY(v_WKT, 8192), 1050010) 
                    WHERE   ROWID = gii.ROWID;
             END IF;
            
         END;
        END LOOP;
    
    COMMIT;
    
END;
/
