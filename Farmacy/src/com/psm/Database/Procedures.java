package com.psm.Database;

import java.util.ArrayList;
import java.util.List;
//import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
		this.database=this.dbSource.getWritableDatabase();
	}

	private void OpenToRead()
	{
		this.database=this.dbSource.getReadableDatabase();
	}

	private void Close()
	{		
		if(this.database.isOpen())
			this.database.close();
	}

	/*Catálogos de la base de datos*/

	public List<String> LstPeriodos(Lang lan)
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

	public int SrcPeriodoId(String periodo,Lang lan)
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

	public List<String> LstActivos(Lang lan)
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

	public int SrcActivoId(String activo,Lang lan)
	{
		OpenToRead();
		Cursor dataset;
		switch(lan)
		{
		case Spanish:
			dataset=database.rawQuery("Select PeriodoId from tbl_Activos where Periodo like '%"+ activo+"%'",null);
			break;
		case French:
			dataset=database.rawQuery("Select PeriodoId from tbl_Activos where PeriodoF like '%"+ activo+"%'",null);
			break;
		case English:
			dataset=database.rawQuery("Select PeriodoId from tbl_Activos where PeriodoE like '%"+ activo+"%'",null);
			break;
		default:
			dataset=database.rawQuery("Select PeriodoId from tbl_Activos where Periodo like '%"+ activo+"%'",null);
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

	public List<String[]> LstExcipientes(Lang lan)
	{
		List<String[]> lista= new ArrayList<String[]>();
		Cursor dataset;
		OpenToRead();
		switch(lan)
		{
		case Spanish:
			dataset=database.rawQuery("Select Icon,Excipiente from tbl_Excipiente",null);
			break;
		case French:
			dataset=database.rawQuery("Select Icon,ExcipienteF from tbl_Excipiente",null);
			break;
		case English:
			dataset=database.rawQuery("Select Icon,ExcipienteE from tbl_Excipiente",null);
			break;
		default:
			dataset=database.rawQuery("Select Icon,Excipiente from tbl_Excipiente",null);
			break;
		}
		if(dataset.moveToFirst())
		{
			while(!dataset.isAfterLast())
			{
				String[] arr={dataset.getString(0),dataset.getString(1)};
				lista.add(arr);
				dataset.moveToNext();
			}
		}
		Close();
		return lista;
	}

	public int SrcExcipiente(String excipiente,Lang lan)
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

	public List<String[]> LstTratamientos(int usuarioId)
	{
		List<String[]> lista= new ArrayList<String[]>();
		//Cursor dataset;
		OpenToRead();
		//dataset=database.rawQuery("Select Tratamiento from  ",null);

		Close();
		return lista;
	}

	public List<User> LstUsuarios()
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

	public boolean AddUsuario(String usuario,String edad,String sexo)
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

	public boolean deleteUsuario(int id)
	{
		try{
			OpenToWrite();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
