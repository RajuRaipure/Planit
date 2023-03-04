package helpers;
import java.util.ArrayList;

import ObjectIDs.testElementIDs;
import reusableFunctions.reusableFunctions;

public class GenericFunctions implements testElementIDs
{
	public static reusableFunctions reuse=new reusableFunctions();
	   public static EnvironmentProperties environmentProperties = new EnvironmentProperties();
	   public static ArrayList<String> ar;
	   public GenericFunctions()
	   {
	   }
	    protected static String getProperty(String property)
	   {
	        EnvironmentProperties environmentProperties = new EnvironmentProperties();
	        return environmentProperties.getProperty(property);
	    }

}
