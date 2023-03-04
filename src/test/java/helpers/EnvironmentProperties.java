package helpers;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentProperties 
{
	public EnvironmentProperties() 
	{

	}
	public String getCurrentEnvironmentName() {
		Properties propMainEnvFile = new Properties();
		InputStream inputStreamMain = Thread.currentThread().getContextClassLoader().getResourceAsStream("env.properties");
		try {
			propMainEnvFile.load(inputStreamMain);
		} catch(FileNotFoundException e) {

		} catch(IOException e) {

		}
		String currentEnvironment = System.getProperty("env");

		if (currentEnvironment==null || currentEnvironment=="")
		{
			currentEnvironment = propMainEnvFile.getProperty("environment.to.be.used");
		}
		return currentEnvironment;
	}

	public String getProperty(String key) {
		String currentEnvironment = getCurrentEnvironmentName()+ ".properties";
		Properties properties = new Properties();
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(currentEnvironment);

		try {
			properties.load(inputStream);
			inputStream.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		String value = properties.getProperty(key);
		return value;
	}
	public String ConfigFileReader(String propertyFilePath, String path)
	{
		String dataFile=null;
		BufferedReader reader;
		try 
		{
			reader = new BufferedReader(new FileReader(propertyFilePath));
			Properties properties = new Properties();
			try 
			{
				properties.load(reader);
				String env = properties.getProperty("environment");
				if(env!= null) 
				{
					if(env.equalsIgnoreCase("Test"))
					{
						dataFile=path+"/resources/configuration/Test.yml";
					}
					else throw new RuntimeException("Data File does not exist");
				}
				else throw new RuntimeException("Environment not specified in the Configuration.properties file.");
				{
				}
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
		return dataFile;
	}

}
