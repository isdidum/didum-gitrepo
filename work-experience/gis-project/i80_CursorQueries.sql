/********************************************************************************
**      FORMULATING AND ANSWERING QUESTION I
**      STORED IN TABLE bCURSOR_OUTPUT (automatically created)
*********************************************************************************/


BEGIN
   idotlrs.LINEAROVERLAY.SET_EVENT_SCHEMA ('IOWA_TRANSFORM');

   idotlrs.LINEAROVERLAY.SET_REFERENCE_SCHEMA ('IOWA_TRANSFORM');

   IDOTLRS.LINEAROVERLAY.LAYER ('BPAINT',                                            --eventFeature 
                                ' ',                                                 --eventAttributes
                                'WHERE PAINT_VALUE >= 41',                           --eventFilter  
                                'BSALT',                                             --referenceFeature
                                ' ',                                                 --referenceAttributes
                                'WHERE SALT_VALUE > 5',                              --referenceFilter   
                                IDOTLRS.LINEAROVERLAY.OPERATOR_INTERSECTION,         --operator
                                'BOUTPUT1',                                          --OutputTableName
                                'GEOMETRY',                                          --OutputGeometryColumnName   
                                0,                                                   --append
                                2);                                                  --overlayId
END; 


BEGIN
   idotlrs.LINEAROVERLAY.SET_EVENT_SCHEMA ('IOWA_TRANSFORM');

   idotlrs.LINEAROVERLAY.SET_REFERENCE_SCHEMA ('IOWA_TRANSFORM');

   IDOTLRS.LINEAROVERLAY.LAYER ('BPAVEMENT',                                               		--eventFeature
                                ' ',                                                            --eventAttributes
                                'WHERE MATE_TYPE LIKE ''PCC'' AND MATE_TYPE LIKE ''ACC III''',  --eventFilter
                                'BOUTPUT1',                                                     --referenceFeature
                                ' ',                                                            --referenceAttributes
                                ' ',                                                            --referenceFilter
                                IDOTLRS.LINEAROVERLAY.OPERATOR_INTERSECTION,         			--operator
                                'BOUTPUT1',                                                     --OutputTableName
                                'GEOMETRY',                                                     --OutputGeometryColumnName
                                0,                                                              --append            
                                2);                                                             --overlayId
END;


BEGIN
   idotlrs.LINEAROVERLAY.SET_EVENT_SCHEMA ('IOWA_TRANSFORM');

   idotlrs.LINEAROVERLAY.SET_REFERENCE_SCHEMA ('IOWA_TRANSFORM');

   IDOTLRS.LINEAROVERLAY.LAYER ('BRESILIENT',                                        --eventFeature
                                ' ',                                                 --eventAttributes
                                'WHERE STRENGTH <= 4100',                            --eventFilter
                                'BOUTPUT1',                                          --referenceFeature
                                ' ',                                                 --referenceAttributes
                                ' ',                                                 --referenceFilter
                                IDOTLRS.LINEAROVERLAY.OPERATOR_INTERSECTION,         --operator
                                'BOUTPUT1',                                          --OutputTableName
                                'GEOMETRY',                                          --OutputGeometryColumnName
                                0,                                                   --append            
                                2);                                                  --overlayId
END;
