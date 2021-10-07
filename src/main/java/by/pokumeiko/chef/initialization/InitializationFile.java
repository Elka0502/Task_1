package by.pokumeiko.chef.initialization;


import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.*;

public class InitializationFile {
	
	private static  final ArrayList<String> arrayVegetables = new ArrayList<String>();
	private static final Logger LOGGER = LoggerFactory.getLogger(InitializationFile.class);
	
	/**The method returns information from a file as ArrayList*/
	public final static ArrayList<String> readData(String pathString) {
        try {
        	arrayVegetables.clear();
        	Node nodeRoot = documentBuilder(pathString);
        	getElement (nodeRoot); 
        	NodeList nodeChild = nodeRoot.getChildNodes();
            for (int i = 0; i < nodeChild.getLength(); i++) {
          		getElement (nodeChild.item(i));  
            }
        	return arrayVegetables;	
        }
       catch (Exception e) {
    	   LOGGER.error("Error reading data from xml-file: readData");
    	   System.exit(1);
    	   return  null;
    	   
       }
    } 
	
	/**The method reads data from a file.*/
	private static Node documentBuilder(String pathString) { 
		try {
			File fXml =  new File(pathString);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		    DocumentBuilder db = dbf.newDocumentBuilder();
		    Document doc=db.parse(fXml);
			doc.getDocumentElement().normalize();
			Node nodeRoot = doc.getDocumentElement();
			return nodeRoot;
        } 
	    catch (Exception e) {
	    	LOGGER.error("Error reading data from xml-file: documentBuilder");
	    	System.exit(1);
	    	return  null;
	    }
		 
	}
	
	/**The method reads attributes from the tag. */
	private static void getElement (Node nodeList) {
		try {
			String name, calories, weight;
			String attributName, attributCalories, attributWeight;
			if(nodeList.getNodeType() == Node.ELEMENT_NODE)
	        {   
			    Element elj = (Element) nodeList;
			    attributName = Constant.ATTRIBUT_NAME.getValue();
			    attributCalories = Constant.ATTRIBUT_CALORIES.getValue();
			    attributWeight = Constant.ATTRIBUT_WEIGHT.getValue();
			    if (elj.getAttribute(attributName).isEmpty()) name = "";
			    else name=elj.getAttribute(attributName);
			    if (elj.getAttribute(attributCalories) == "")	calories = "0.00";
			    else calories=elj.getAttribute(attributCalories);
			    if (elj.getAttribute(attributWeight) == "")	weight = "0.00";
			    else weight=elj.getAttribute(attributWeight);
			    arrayVegetables.add(String.format("%s_%s_%s_%s", name, weight, calories, elj.getNodeName()));
	        }
		}
	        catch (Exception e){
	        	LOGGER.error("Error reading data from xml-file: getElement");
	        	System.exit(1);
	        	}
    }
}