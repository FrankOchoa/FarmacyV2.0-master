package com.psm.utilery;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateOperations {

	public static final String DateFormat="yyyyMMddHHmmss";

	public static void GenerateSchedule(String fechaInicio,int intervalHora,int duracionDia)
	{
		SimpleDateFormat df = new SimpleDateFormat (DateFormat);
		int tomas=(24*duracionDia)/intervalHora;
		List<String> tomadera= new ArrayList(); 				
		try {
			Date date=df.parse(fechaInicio);
			date.clone();
			String par=df.format(date);
			par=par;
			for(int i=0;i<tomas;i++)
			{
				
			}
			
		} catch (ParseException e) {			
			e.printStackTrace();
		} 		
	}
	
	public Date Add(Date fecha, int dias,int horas){			
		      Calendar calendar = Calendar.getInstance();		
		      calendar.setTime(fecha); // Configuramos la fecha que se recibe
		      if(dias>0)
		    	  calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
		      if(horas>0)
		    	  calendar.add(Calendar.HOUR_OF_DAY,horas);		    
		      return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos			
		 }
}


