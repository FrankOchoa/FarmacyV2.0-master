package com.psm.farmacy;

import com.psm.Database.Procedures;
import com.psm.Model.User;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ProfileAddFragment extends Fragment{

	private View vi;
	private EditText  txtName;
	private EditText  txtAge;
	private Button btnSave;
	private FragmentActivity myContext;
	private RadioGroup radioGGen;
	private boolean isEdit = false; 
	private int idUser;
	public ProfileAddFragment(boolean isEdit, int idUser) {
		this.isEdit = isEdit;
		this.idUser = idUser;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {		
		//super.onCreateOptionsMenu(menu, inflater);

	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {		
		vi= inflater.inflate(R.layout.fragment_profile_add, container, false);	
		txtName=(EditText)vi.findViewById(R.id.profiletxtName);
		txtAge=(EditText)vi.findViewById(R.id.profiletxtAge);
		btnSave=(Button)vi.findViewById(R.id.profilebtnSave);
		radioGGen=(RadioGroup) vi.findViewById(R.id.radioGGen);
		CreateListener();

		if(isEdit){
			User user = new User();
			Procedures pr= new Procedures(getActivity());
			user = pr.SelecUsuario(idUser);
			txtName.setText(user.getUsuario());
			txtAge.setText(user.getEdad());
			if(user.getSexo().equals("M"))
				radioGGen.check(R.id.profilerdoFemale);
			else
				radioGGen.check(R.id.profilerdoMale);
		}

		return vi;
	}

	@Override
	public void onAttach(Activity activity) {
		myContext=(FragmentActivity) activity;
		super.onAttach(activity);
	}

	public void CreateListener()
	{
		if(isEdit){
			btnSave.setOnClickListener(clickEdit);
		}else{
			btnSave.setOnClickListener(clickAdd);
		}
	}

	public OnClickListener clickEdit = new OnClickListener() {

		@Override
		public void onClick(View v) {
			String nombre="";
			String edad="0";
			String sexo="H";
			if(txtName.getText().toString().equals(""))
			{
				Toast.makeText(getActivity(),"Nombre requerido",Toast.LENGTH_SHORT).show();
			}
			else
			{
				nombre=txtName.getText().toString();
				edad= txtAge.getText().toString()==""||
						txtAge.getText().toString()==""?"0":
							txtAge.getText().toString(); 

			}
			Procedures pr= new Procedures(getActivity());				
			int rdio =radioGGen.getCheckedRadioButtonId();
			if(rdio== R.id.profilerdoFemale)
			{
				sexo="M";
			}				
			if(pr.EditUsuario(nombre, edad, sexo, idUser))
			{
				Toast.makeText(getActivity(), "Actualizado", Toast.LENGTH_SHORT).show();					
			}
			else
			{
				Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
			}				
			FragmentManager fragManager = myContext.getSupportFragmentManager();
			fragManager.beginTransaction().replace(R.id.container, new ProfileFragment()).commit();
		}
	};

	public OnClickListener clickAdd = new OnClickListener() {

		@Override
		public void onClick(View v) {
			String nombre="";
			String edad="0";
			String sexo="H";
			if(txtName.getText().toString().equals(""))
			{
				Toast.makeText(getActivity(),"Nombre requerido",Toast.LENGTH_SHORT).show();
			}
			else
			{
				nombre=txtName.getText().toString();
				edad= txtAge.getText().toString()==""||
						txtAge.getText().toString()==""?"0":
							txtAge.getText().toString(); 

			}
			Procedures pr= new Procedures(getActivity());				
			int rdio =radioGGen.getCheckedRadioButtonId();
			if(rdio== R.id.profilerdoFemale)
			{
				sexo="M";
			}				
			if(pr.addUsuario(nombre, edad, sexo))
			{
				Toast.makeText(getActivity(), "Actualizado", Toast.LENGTH_SHORT).show();					
			}
			else
			{
				Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
			}				
			FragmentManager fragManager = myContext.getSupportFragmentManager();
			fragManager.beginTransaction().replace(R.id.container, new ProfileFragment()).commit();
		}
	};

}
