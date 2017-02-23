package rds;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.loader.VirtualWebappLoader;

public class DynamicVirtualWebappLoader extends VirtualWebappLoader
{
  String virtualPath = "";
  
  public void setVirtualClasspath(String path) 
  {
    virtualPath = path;
    super.setVirtualClasspath(path);
  }
  
  protected void startInternal() throws LifecycleException 
  {
    String newPath = virtualPath + getContainer().getName();
    
    super.setVirtualClasspath(newPath);
    super.startInternal();
  }
}
