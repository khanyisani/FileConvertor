package org.apache.camel.absachallange.servletlistener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;

 

 
public class OutputProcessor implements Processor {
	Gson gson = new Gson();
	int x =1;
    public void process(Exchange exchange) throws Exception {
        ArrayList<HashMap<String, Object>> list = (ArrayList) exchange.getIn().getBody();
        for (HashMap<String, Object> map : list) {
            for (String key : map.keySet()) {
            	
               
                Person person = (Person) map.get(key);
                String jsonFilePath = "C:\\Users\\Training\\Desktop\\File_Convertor_Application\\data\\jsonFile"+x+".json";
                  FileWriter fileWriter = new FileWriter(jsonFilePath);
                  PrintWriter printWriter = new PrintWriter(jsonFilePath);
                  printWriter.println(gson.toJson(person));
                  printWriter.close();
                  fileWriter.close();
                  x++;
                
                
            }
        }
 
    }
}