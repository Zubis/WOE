package me.Darioda.WarOfEmperium;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WarOfEmperiumTimeThread extends Thread{
	
	public static WarOfEmperium plugin;
	
	public WarOfEmperiumTimeThread(WarOfEmperium instance) {
		plugin = instance;
	}

	public void run()
	{
		boolean no_stop = true;
	    while(no_stop == true) 
	    {
	    	try
	    	{
				Thread.sleep(30000);
			} 
	    	catch (InterruptedException e)
			{
				e.printStackTrace();
			}
	        Date date = new Date();
	        SimpleDateFormat date_jour = new SimpleDateFormat("E");
	        SimpleDateFormat date_heure = new SimpleDateFormat("H");
	        SimpleDateFormat date_minute = new SimpleDateFormat("m");
	        String date_jour_string = date_jour.format(date);
	        String date_heure_string = date_heure.format(date);
	        String date_minute_string = date_minute.format(date);
	        int date_heure_int = Integer.valueOf(date_heure_string);
	        int date_minute_int = Integer.valueOf(date_minute_string);
	        plugin.woe_m = Integer.valueOf(date_minute_string);
	        plugin.woe_h = Integer.valueOf(date_heure_string);
	        plugin.thread(date_jour_string, Integer.valueOf(date_heure_int), Integer.valueOf(date_minute_int));
	        plugin.reloadDj(date_jour_string, date_heure_string, date_minute_string);
	    }
	}


}
