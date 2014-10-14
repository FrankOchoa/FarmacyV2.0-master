package com.psm.farmacy;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.ls.LSInput;
import com.psm.Model.Container;
import com.psm.Model.Lang;
import com.psm.UI.spnContainerAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import com.psm.Model.*;

public class MedicineAddFragment extends BaseFragment{
	
	private View vi;
	private EditText txtMedicineName;
	private Spinner spnType;
	private ListView lstActivesAdded;
	private Button btnSave;
	private Button btnAddActive;
	private List<Container> list;
	private Bundle savedParams;
	private EditText txtIndication;

	public static MedicineAddFragment NewInstance(String name,int index,List<String> actives,String indication)
	{
		MedicineAddFragment frag= new MedicineAddFragment();		
		Bundle args = new Bundle();	
		args.putString("textMedicine", name);		
		args.putInt("selSpnType", index);
		args.putStringArrayList("actives", (ArrayList<String>) actives);
		args.putString("indication", indication);
		frag.setArguments(args);
		return frag;
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		try
		{
			setHasOptionsMenu(true);		
			if(savedInstanceState!=null)
				savedParams=savedInstanceState;			
			LoadDatabase(getActivity());
			Lang lan=getCurrentLang();		
			list=pr.lstExcipientes(lan);		
		}
		catch(Exception ex)
		{
			String es= ex.getMessage();			
		}
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		menu.clear();
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		vi=inflater.inflate(R.layout.fragment_medicine_add, container, false);
		txtMedicineName=(EditText)vi.findViewById(R.id.txtMedicineName);
		spnType=(Spinner)vi.findViewById(R.id.spnType);
		lstActivesAdded=(ListView)vi.findViewById(R.id.lstActivesAdded);
		btnSave=(Button)	vi.findViewById(R.id.btnSave);
		spnType.setAdapter(new spnContainerAdapter(getActivity(), list));
		btnAddActive=(Button)vi.findViewById(R.id.btnAddActive);
		txtIndication=(EditText)vi.findViewById(R.id.txtIndication);
		createListeners();
		savedParams=getArguments();
		if(savedParams!=null)
		{
			txtMedicineName.setText(savedParams.getString("textMedicine"));
			spnType.setSelection(savedParams.getInt("selSpnType"));
			txtIndication.setText(savedParams.getString("indication"));		
			List<String> list=savedParams.getStringArrayList("actives");
			try
			{
				lstActivesAdded.setAdapter(new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,list));
			}
			catch(Exception ex)
			{
				String es= ex.getMessage();				
			}
		}
		return vi;
	}	
	
	public void createListeners()
	{
		btnSave.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				if(ValidateFields())
				{
					try
					{
					Medicine med= new Medicine();
					med.setNombre(txtMedicineName.getText().toString());
					med.setIndicacion(txtIndication.getText().toString());	
					med.setExcipiente(new Container(0,spnType.getSelectedItem().toString() , ""));
					if(lstActivesAdded.getAdapter()!= null)
					{
						int count=lstActivesAdded.getAdapter().getCount();
						for(int i =0;i<count;i++)
						{							
							String n=(String) lstActivesAdded.getAdapter().getItem(i);
							//String activo=n.getName();
							med.getActivos().add(new Active(n     ,0));										
						}
					}					
					LoadDatabase(getActivity());
					pr.addMedicina(getCurrentLang(), med);
					ReplaceFragment(new MedicineFragment());
					}catch(Exception ex)
					{
						Toast.makeText(getActivity(), "Ha ocurrido un error", Toast.LENGTH_LONG).show();
					}
			}
			}	
			
		});
		
		btnAddActive.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				String name=txtMedicineName.getText().toString();
				int item=spnType.getSelectedItemPosition();
				String inf=txtIndication.getText().toString();
				Fragment fr=ActivesFragment.NewInstance(name, item , getCurrentActives(),inf);
				ReplaceFragment(fr);
			}
		});
	}
	
	public boolean ValidateFields()
	{
		if(txtMedicineName.getText().toString().equals(""))
		{
			Toast.makeText(getActivity(), "Proporciona el nombre de medicina", Toast.LENGTH_LONG).show();
			return false;
		}
		else
		{
			return true;			
		}		
	}
	
	public List<String> getCurrentActives()
	{
		List<String> actives= new ArrayList<String>();
		try
		{		
		int n= lstActivesAdded.getAdapter().getCount();
		for(int i=0;i<n;i++)
		{
			actives.add(lstActivesAdded.getItemAtPosition(i).toString());
		}
		return actives;
		}
		catch(Exception ex)
		{
			String n=ex.getMessage();
			return actives;
		}
		
	}
}
