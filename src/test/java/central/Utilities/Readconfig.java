package central.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig 
{
	Properties pro;
	public Readconfig()
	{
		File source = new File("./Configuration/config.properties");
		try 
		{
		FileInputStream  fis = new FileInputStream(source); 
		pro = new Properties();
		pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is" + e.getMessage());
		}
	}
	
	public String getapplicationURL()
	{
		String URL = pro.getProperty("baseurl");
		return URL;
	}
	
	public String getusername()
	{
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getpassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	
}

