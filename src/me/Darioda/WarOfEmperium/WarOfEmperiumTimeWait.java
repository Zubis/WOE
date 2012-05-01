package me.Darioda.WarOfEmperium;



public class WarOfEmperiumTimeWait extends Thread{
	
	public static WarOfEmperium plugin;
	public String castle_name;
	public WarOfEmperiumTimeWait(WarOfEmperium instance, String castle) {
		plugin = instance;
		castle_name = castle;
	}

	@SuppressWarnings("deprecation")
	public void run()
	{
		try
    	{
			plugin.generateEmperium(castle_name, false);
			Thread.sleep(10000);
			plugin.generateEmperium(castle_name, true);
			this.stop();
		} 
    	catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}


}
