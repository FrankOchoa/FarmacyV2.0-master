package com.psm.farmacy;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.psm.Model.User;

import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;

public class MedicationAddFragment extends BaseFragment {
	
	private EditText txtMedicationName;
	private EditText txtStartDate;
	private EditText txtStartTime;
	private EditText txtFrecuency;
	private EditText txtDuration;
	private Spinner spnMedUser;
	private Spinner spnFrecuency;
	private Spinner spnDuration;
	private Button btnAddMedicine;
	private Button btnPickDate;
	private Button btnPickTime;
	private ListView lstAddedMedicine;
	private List<String> userNames = new ArrayList<String>();

	@Override
	public void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		LoadDatabase(getActivity());
		try
		{
			vi=inflater.inflate(R.layout.fragment_medication_add, container, false);
			txtDuration=(EditText)vi.findViewById(R.id.txtDuration);
			txtFrecuency=(EditText)vi.findViewById(R.id.txtFrecuency);
			txtMedicationName=(EditText)vi.findViewById(R.id.txtMedicationName);
			txtStartDate=(EditText) vi.findViewById(R.id.txtStartDate);
			txtStartTime=(EditText)vi.findViewById(R.id.txtStartTime);
			spnDuration=(Spinner)vi.findViewById(R.id.spnDuration);
			spnFrecuency=(Spinner)vi.findViewById(R.id.spnFrecuency);
			spnMedUser=(Spinner)vi.findViewById(R.id.spnMedUser);
			btnAddMedicine=(Button)vi.findViewById(R.id.btnMedications);
			spnFrecuency.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,pr.lstPeriodos(getCurrentLang())));
			spnDuration.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,pr.lstPeriodos(getCurrentLang())));
			
			List<User> usuario = new ArrayList<User>();
			usuario = pr.lstUsuarios();
			for(int i = 0; i < usuario.size(); i++)
				userNames.add(usuario.get(i).getUsuario());
			spnMedUser.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, userNames));
			createListener();
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return vi;
	}
	
	
	public void createListener()
	{
		txtStartDate.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {				
	            Calendar mcurrentDate=Calendar.getInstance();
	            int mYear=mcurrentDate.get(Calendar.YEAR);
	            int mMonth=mcurrentDate.get(Calendar.MONTH);
	            int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

	            DatePickerDialog mDatePicker=new DatePickerDialog(getActivity(), 	new OnDateSetListener() 
	            {      
	            	@Override
	                public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) 
	                {
	                    txtStartDate.setText(selectedday+"/"+selectedmonth+"/"+selectedyear);
	                }
	            },mYear, mMonth, mDay);
	            mDatePicker.setTitle("Select date");                
	            mDatePicker.show();  }		
		});		
		
		txtStartTime.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Calendar mcurrentDate=Calendar.getInstance();
	            int mHour=mcurrentDate.get(Calendar.HOUR_OF_DAY);
	            int mMinute=mcurrentDate.get(Calendar.MINUTE);
	            
				TimePickerDialog mTimePicker= new TimePickerDialog(getActivity(), new OnTimeSetListener() {
					
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						txtStartTime.setText(hourOfDay+":"+minute);
					}
				}, mHour, mMinute, true);
				mTimePicker.setTitle("Select time");
				mTimePicker.show();
				
			}
		});		
		
	}

}
