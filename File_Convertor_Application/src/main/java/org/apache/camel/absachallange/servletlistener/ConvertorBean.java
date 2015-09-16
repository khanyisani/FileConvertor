/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.absachallange.servletlistener;

import org.apache.camel.CamelContext;
import org.apache.camel.Header;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spi.DataFormat;


public class ConvertorBean {
    
    public String DisplayMessage(@Header("name")String name) throws Exception {
    	try{
    		if(name.equals("allowed")){
		    	CamelContext context = new DefaultCamelContext();
		        final DataFormat bindy = new BindyCsvDataFormat("org.apache.camel.absachallange.servletlistener");
		        context.addRoutes(new RouteBuilder() {
		            public void configure() {
		                from("file:C:\\Users\\Training\\Desktop\\File_Convertor_Application\\csv_data?noop=true").
		                unmarshal(bindy)
		                .process(new OutputProcessor());
		            }
		        });
		        context.start();
		        Thread.sleep(10000);
		        context.stop();
	    
	    	
		        return "Json Files Have Been Generated";
    		}
    		else{
    			
    			return "denied json files not created";
    		}
    	}
    	catch(Exception e){
    		
    		
    		return e.toString() +" ----- an error occured" ;
    		
    	}
        
    }

}