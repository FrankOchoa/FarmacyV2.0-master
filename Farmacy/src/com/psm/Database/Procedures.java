package com.psm.Database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.psm.Model.*;

public class Procedures {
	private Source dbSource;
	private SQLiteDatabase database;	

	//private ContentValues values;
	//private String query;

	public Procedures(Context context)
	{
		this.dbSource= new Source(context);
		//values = new ContentValues();
	}

	private void OpenToWrite()
	{
		if(database==null || !database.isOpen())
		{
			this.database=this.dbSource.getWritableDatabase();
		}
	}

	private void OpenToRead()
	{
		if(database==null || !database.isOpen())
		{
			this.database=this.dbSource.getReadableDatabase();
		}
	}

	private void Close()
	{		
		if(this.database.isOpen())
			this.database.close();
	}

	/*Catálogos de la base de datos*/

	public List<String> lstPeriodos(Lang lan)
	{
		List<String> lista= new ArrayList<String>();
		Cursor dataset;
		OpenToRead();
		switch(lan)
		{
		case Spanish:
			dataset=database.rawQuery("Select Periodo from tbl_Periodo",null);
			break;
		case French:
			dataset=database.rawQuery("Select PeriodoF from tbl_Periodo",null);
			break;
		case English:
			dataset=database.rawQuery("Select PeriodoE from tbl_Periodo",null);
			break;
		default:
			dataset=database.rawQuery("Select Periodo from tbl_Periodo",null);
			break;
		}
		if(dataset.moveToFirst())
		{
			while(!dataset.isAfterLast())
			{
				lista.add(dataset.getString(0));
				dataset.moveToNext();
			}
		}
		Close();
		return lista;
	}

	public int srcPeriodoId(String periodo,Lang lan)
	{
		OpenToRead();
		Cursor dataset;
		switch(lan)
		{
		case Spanish:
			dataset=database.rawQuery("Select PeriodoId from tbl_Periodo where Periodo like '%"+ periodo+"%'",null);
			break;
		case French:
			dataset=database.rawQuery("Select PeriodoId from tbl_Periodo where PeriodoF like '%"+ periodo+"%'",null);
			break;
		case English:
			dataset=database.rawQuery("Select PeriodoId from tbl_Periodo where PeriodoE like '%"+ periodo+"%'",null);
			break;
		default:
			dataset=database.rawQuery("Select PeriodoId from tbl_Periodo where Periodo like '%"+ periodo+"%'",null);
			break;
		}
		int id;
		if(dataset.moveToFirst())
		{
			id= dataset.getInt(0);
		}
		else
		{
			id=0;
		}
		Close();
		return id;
	}

	public List<String> lstActivos(Lang lan)
	{
		List<String> lista= new ArrayList<String>();
		Cursor dataset;
		OpenToRead();
		switch(lan)
		{
		case Spanish:
			dataset=database.rawQuery("Select Activo from tbl_Activos",null);
			break;
		case French:
			dataset=database.rawQuery("Select ActivoF from tbl_Activos",null);
			break;
		case English:
			dataset=database.rawQuery("Select ActivoE from tbl_Activos",null);
			break;
		default:
			dataset=database.rawQuery("Select Activo from tbl_Activos",null);
			break;
		}
		if(dataset.moveToFirst())
		{
			while(!dataset.isAfterLast())
			{
				lista.add(dataset.getString(0));
				dataset.moveToNext();
			}
		}
		Close();
		return lista;
	}

	public List<String> srcActivos(Lang lan, String activo)
	{
		List<String> lista= new ArrayList<String>();
		OpenToRead();
		Cursor dataset;
		switch(lan)
		{
		case Spanish:
			dataset=database.rawQuery("Select ActivoId,Activo from tbl_Activos where Activo like '%"+ activo+"%'",null);
			break;
		case French:
			dataset=database.rawQuery("Select ActivoId,ActivoF from tbl_Activos where ActivoF like '%"+ activo+"%'",null);
			break;
		case English:
			dataset=database.rawQuery("Select ActivoId,ActivoE from tbl_Activos where ActivoE like '%"+ activo+"%'",null);
			break;
		default:
			dataset=database.rawQuery("Select ActivoId,Activo from tbl_Activos where Activo like '%"+ activo+"%'",null);
			break;
		}
		if(dataset.moveToFirst())
		{
			while(!dataset.isAfterLast())
			{
				String ac=dataset.getString(1);								
				lista.add(ac);
				dataset.moveToNext();
			}
		}
		Close();
		return lista;
	}

	public int srcActivoId(String activo,Lang lan)
	{
		OpenToRead();
		Cursor dataset;
		switch(lan)
		{
		case Spanish:
			dataset=database.rawQuery("Select ActivoId from tbl_Activos where Activo like '%"+ activo+"%'",null);
			break;
		case French:
			dataset=database.rawQuery("Select ActivoId from tbl_Activos where ActivoF like '%"+ activo+"%'",null);
			break;
		case English:
			dataset=database.rawQuery("Select ActivoId from tbl_Activos where ActivoE like '%"+ activo+"%'",null);
			break;
		default:
			dataset=database.rawQuery("Select ActivoId from tbl_Activos where Activo like '%"+ activo+"%'",null);
			break;
		}
		int id;
		if(dataset.moveToFirst())
		{
			id= dataset.getInt(0);
		}
		else
		{
			id=0;
		}
		Close();
		return id;
	}

	public List<Container> lstExcipientes(Lang lan)
	{
		List<Container> lista= new ArrayList<Container>();
		Cursor dataset;
		OpenToRead();
		switch(lan)
		{
		case Spanish:
			dataset=database.rawQuery("Select Icon,Excipiente from tbl_Excipiente order by Excipiente",null);
			break;
		case French:
			dataset=database.rawQuery("Select Icon,ExcipienteF from tbl_Excipiente order by ExcipienteF",null);
			break;
		case English:
			dataset=database.rawQuery("Select Icon,ExcipienteE from tbl_Excipiente order by ExcipienteE",null);
			break;
		default:
			dataset=database.rawQuery("Select Icon,Excipiente from tbl_Excipiente order by Excipiente",null);
			break;
		}
		if(dataset.moveToFirst())
		{
			while(!dataset.isAfterLast())
			{				
				Container cont= new Container();
				cont.setIcon(dataset.getString(0));
				cont.setContainer(dataset.getString(1));
				lista.add(cont);
				dataset.moveToNext();
			}
		}
		Close();
		return lista;
	}

	public int srcExcipienteId(String excipiente,Lang lan)
	{
		OpenToRead();
		Cursor dataset;
		switch(lan)
		{
		case Spanish:
			dataset=database.rawQuery("Select ExcipienteId from tbl_Excipiente where Excipiente like '%"+ excipiente+"%'",null);
			break;
		case French:
			dataset=database.rawQuery("Select ExcipienteId from tbl_Excipiente where ExcipienteF like '%"+ excipiente+"%'",null);
			break;
		case English:
			dataset=database.rawQuery("Select ExcipienteId from tbl_Excipiente where ExcipienteE like '%"+ excipiente+"%'",null);
			break;
		default:
			dataset=database.rawQuery("Select ExcipienteId from tbl_Excipiente where Excipiente like '%"+ excipiente+"%'",null);
			break;
		}
		int id;
		if(dataset.moveToFirst())
		{
			id= dataset.getInt(0);
		}
		else
		{
			id=0;
		}
		Close();
		return id;
	}

	public List<String[]> lstTratamientos(int usuarioId)
	{
		List<String[]> lista= new ArrayList<String[]>();
		//Cursor dataset;
		OpenToRead();
		//dataset=database.rawQuery("Select Tratamiento from  ",null);

		Close();
		return lista;
	}

	public List<User> lstUsuarios()
	{
		List<User> lista= new ArrayList<User>();
		try
		{
			Cursor dataset;
			OpenToRead();
			dataset=database.rawQuery("Select UsuarioId, Usuario, Edad, Sexo  from tbl_usuario",null);
			if(dataset.moveToFirst())
			{
				while(!dataset.isAfterLast())
				{
					User usuario = new User(dataset.getInt(0),dataset.getString(1) , dataset.getString(2), dataset.getString(3));
					lista.add(usuario);
					dataset.moveToNext();
				}
			}
			Close();
		}
		catch(Exception ex)
		{					
			if(database.isOpen())
				Close();
		}
		Close();
		return lista;		

	}

	public boolean addUsuario(String usuario,String edad,String sexo)
	{
		try
		{
			OpenToWrite();
			database.execSQL("insert into tbl_usuario(Usuario,Edad,Sexo)VALUES('"+usuario+"',"+edad+",'"+sexo+"')");
			return true;
		}
		catch(Exception ex)
		{			
			return false;
		}

	}
	public boolean EditUsuario(String usuario,String edad,String sexo, int id)
	{
		try
		{
			OpenToWrite();
			database.execSQL("UPDATE tbl_usuario SET Usuario ='" + usuario + "',Edad ='"+edad+"',Sexo='"+sexo+"' WHERE UsuarioId = "+id);
			return true;
		}
		catch(Exception ex)
		{			
			return false;
		}

	}
	public boolean deleteUsuario(int id)
	{
		try{
			OpenToWrite();
			database.execSQL("DELETE FROM tbl_usuario WHERE UsuarioId = "+ id);
			return true;
		}
		catch(Exception ex)
		{			
			Log.println(0, "FarmacyLog", ex.getMessage());
			return false;
		}
	}

	public User SelecUsuario(int id)
	{
		User user = new User();
		try{
			OpenToWrite();
			Cursor dataset;
			dataset = database.rawQuery("Select Usuario,Edad,Sexo FROM tbl_usuario WHERE UsuarioId = "+ id, null);
			dataset.moveToFirst();
			user.setId(id);
			user.setUsuario(dataset.getString(0));
			user.setEdad(dataset.getString(1));
			Log.e("sexo", dataset.getString(2));
			user.setSexo(dataset.getString(2));
		}
		catch(Exception ex)
		{			
			Log.e("FarmacyLog", ex.getMessage());
		}
		Close();
		return user;
	}

	@SuppressLint("SimpleDateFormat")
	public List<Take> srcLast()
	{
		try
		{
			List<Take> lista=new ArrayList<Take>();					    
			OpenToRead();
			Cursor dataset;
			dataset=database.rawQuery("Select a.RelacionId,a.TomaNo, a.Fecha,a.Tomada,a.Reprogramada,b.MedicinaId, " +
					"d.Medicina,b.TratamientoId, c.Tratamiento,d.ExcipienteId, e.Excipiente,e.Icon,f.UsuarioId,f.Usuario  " +
					"from tbl_horario a " +
					"inner join tbl_MedicinaTratamiento b on a.RelacionId=b.RelacionId " +
					"inner join tbl_Tratamiento c on b.TratamientoId=c.TratamientoId " +
					"inner join tbl_Medicina d on b.MedicinaId=d.MedicinaId " +
					"inner join tbl_Excipiente e on d.ExcipienteId=e.ExcipienteId " +
					"inner join tbl_Usuario f on c.UsuarioId =f.UsuarioId ",null);
			if(dataset.moveToFirst())
			{				
				while(!dataset.isAfterLast())
				{
					Take toma= new Take();
					toma.setRelacionId(dataset.getInt(dataset.getColumnIndex("RelacionId")));				
					toma.setTomaNo(dataset.getInt(dataset.getColumnIndex("TomaNo")));
					toma.setMedicinaId(dataset.getInt(dataset.getColumnIndex("MedicinaId")));
					toma.setMedicina(dataset.getString(dataset.getColumnIndex("Medicina")));
					toma.setTratamientoId(dataset.getInt(dataset.getColumnIndex("TratamientoId")));
					toma.setTratamiento(dataset.getString(dataset.getColumnIndex("Tratamiento")));
					toma.setIcon(dataset.getString(dataset.getColumnIndex("Icon")));
					toma.setUsuarioId(dataset.getInt(dataset.getColumnIndex("UsuarioId")));
					toma.setUsuario(dataset.getString(dataset.getColumnIndex("Usuario")));
					String date=dataset.getString(dataset.getColumnIndex("Fecha")); 
					SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					toma.setFecha(f.parse(date));					
					lista.add(toma);
					dataset.moveToNext();
				}				
			}			
			Close();
			return lista;
		}
		catch(Exception ex)
		{
			//Log.println(Log.ERROR, "FarmacyLog", ex.getMessage());		
			return null;
		}		
	}

	public List<String> lstMedicinas()
	{
		try
		{
			List<String> lista= new ArrayList<String>();
			OpenToRead();
			Cursor dataset;
			dataset=database.rawQuery("Select Medicina from tbl_Medicina",null);
			if(dataset.moveToFirst())
			{
				while(!dataset.isAfterLast())
				{
					lista.add(dataset.getString(0));
					dataset.moveToNext();
				}
			}			
			Close();
			return lista;
		}
		catch(Exception ex)
		{
			return null;
		}
	}

	public boolean addMedicina(Lang lan,Medicine data)
	{		
		try
		{		
			int exid=srcExcipienteId(data.getExcipiente().getContainer(), lan);
			OpenToWrite();
			database.execSQL("Insert into tbl_Medicina(Medicina,Indicacion,ExcipienteId) Values('" +
					data.getNombre()+"','"+data.getIndicacion()+"',"+exid+")");
			//			Cursor c1=database.rawQuery("Select Medicina from tbl_Medicina", null);
			if(data.getActivos().size()>0)
			{
				Cursor dataset=database.rawQuery("Select MAX(MedicinaId) from tbl_Medicina", null);		
				if(dataset.moveToFirst())
				{
					data.setId(dataset.getInt(0));
					if(data.getActivos().size()>0)
					{
						for(Active activo:data.getActivos())
						{
							int i= srcActivoId(activo.getName(),lan);
							OpenToWrite();
							database.rawQuery("Insert into tbl_MedicinaActivo(MedicinaId,ActivoId) Values("+data.getId()+","+i+")",null);
							Close();
						}
					}
				}
			}
			Close();
		}
		catch(Exception ex)
		{
			ex.getMessage();			
		}		
		return true;
	}

	public int countUser()
	{		
		try
		{
			OpenToRead();
			Cursor dataset;
			int count=0;
			dataset=database.rawQuery("Select count(UsuarioId) from tbl_Usuario",null);
			if(dataset.moveToFirst())
			{
				count=dataset.getInt(0);
			}
			Close();
			return count;			

		}
		catch(Exception ex)
		{
			ex.getMessage();
			Close();
			return 0;
		}		
	}

	public int countMedicine()
	{
		try
		{
			OpenToRead();
			Cursor dataset;
			int count=0;
			dataset=database.rawQuery("Select count(MedicinaId) from tbl_Medicina",null);
			if(dataset.moveToFirst())
			{
				count=dataset.getInt(0);
			}
			Close();
			return count;			

		}
		catch(Exception ex)
		{
			ex.getMessage();
			Close();
			return 0;
		}	

	}

	public int countMedication()
	{
		try
		{
			OpenToRead();
			Cursor dataset;
			int count=0;
			dataset=database.rawQuery("Select count(TratamientoId) from tbl_Tratamiento",null);
			if(dataset.moveToFirst())
			{
				count=dataset.getInt(0);
			}
			Close();
			return count;			

		}
		catch(Exception ex)
		{
			ex.getMessage();
			Close();
			return 0;
		}	
	}



}
