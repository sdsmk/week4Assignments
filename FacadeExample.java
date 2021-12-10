package Day4Assignments;
class FileSystem{

   public void readFile() {
      System.out.println("readFile() in FileSystem");
   }
}

class Network {

   public void sendData() {
      System.out.println("sendData() in Network");
   }
}


class Display {

   public void draw() {
      System.out.println("draw() in Display");
   }
}

class AppLifeCycle {

   public void startApp() {
      System.out.println("startApp() in AppLifeCycle");
   }
}

class HardwareModule{
	public void getStatus() {
		System.out.println("getStatus() in HardwareModule");
	}
	public void sendData() {
		System.out.println("sendData() in HardwareModule");
	}
	public void recvData() {
		System.out.println("recvData() in HardwareModule");
	}
}
interface OSAPI{
    public void readFileOS();
    public void sendDataOS();
    public void startAppOS();
    public void drawOS(); 
    public void hardwareOS();
}

class FacadeClass implements OSAPI{
      public void readFileOS(){
          new FileSystem().readFile();
      }
      
    public void sendDataOS(){
            new Network().sendData();
    }
    
    public void startAppOS(){
        new AppLifeCycle().startApp();
    }
    
    public void drawOS(){
        new Display().draw();
    }
    public void hardwareOS() {
    	new HardwareModule().getStatus();
    	new HardwareModule().sendData();
    	new HardwareModule().recvData();
    }
}

public class FacadeExample {
   public static void main(String[] args) {
      FacadeClass obj = new FacadeClass();

      obj.drawOS();
      obj.readFileOS();
      obj.sendDataOS();
      obj.startAppOS();
      obj.hardwareOS();
   }
}