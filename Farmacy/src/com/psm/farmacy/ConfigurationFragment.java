package com.psm.farmacy;

import java.util.ArrayList;
import java.util.Locale;
import com.psm.UI.drwItem;
import com.psm.UI.drwItemAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import com.psm.UI.LoginDialogFragment;

public class ConfigurationFragment extends Fragment{
	private Spinner spnLang;
	private Spinner spnTheme;
	private Button btnSave;
	private View vi;
	private CheckBox chkGps;
	private CheckBox chkNotification;
	private Activity actParent;
	private SharedPreferences sharedPref;
	private Button btnSync;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		vi= inflater.inflate(R.layout.fragment_configuration, container, false);	
		
		spnLang=(Spinner)vi.findViewById(R.id.spnLang);
		spnTheme=(Spinner)vi.findViewById(R.id.spnTheme);
		btnSave=(Button)vi.findViewById(R.id.btnSaveChanges);
		chkGps=(CheckBox) vi.findViewById(R.id.chkGps);
		chkNotification=(CheckBox) vi.findViewById(R.id.chkNotifications);
		btnSync=(Button)vi.findViewById(R.id.btnSync);
		actParent=getActivity();
		
		spnLang.setAdapter(new drwItemAdapter(getActivity(), InflateSpinnerLanguage()));
		spnTheme.setAdapter(new drwItemAdapter(getActivity(), InflateSpinnerTheme()));
		sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
		spnLang.setSelection(sharedPref.getInt("lang",0));		
		CreateListener();
		return vi;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		showGlobalContextActionBar();
		//super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub				
		super.onCreate(savedInstanceState);		
		
		
	}
	
	private ArrayList<drwItem> InflateSpinnerLanguage()
	{
		ArrayList<drwItem> items= new ArrayList<drwItem>();
    	drwItem item= new drwItem();
    	item.setIcom(getResources().getDrawable(R.drawable.spain));
    	item.setLabel(getResources().getString(R.string.conf_langSpanish));
    	items.add(item);
    	drwItem item2= new drwItem();
    	item2.setIcom(getResources().getDrawable(R.drawable.france));
    	item2.setLabel(getResources().getString(R.string.conf_langFrench));
    	items.add(item2);
    	drwItem item3= new drwItem();    	
    	item3.setIcom(getResources().getDrawable(R.drawable.us));
    	item3.setLabel(getResources().getString(R.string.conf_langEnglish));
    	items.add(item3);
    	return items;
	}
	
	private ArrayList<drwItem> InflateSpinnerTheme()
	{
		ArrayList<drwItem> items= new ArrayList<drwItem>();
    	drwItem item= new drwItem();
    	item.setIcom(getResources().getDrawable(R.drawable.spain));
    	item.setLabel(getResources().getString(R.string.conf_theme_black));
    	items.add(item);
    	drwItem item2= new drwItem();
    	item2.setIcom(getResources().getDrawable(R.drawable.france));
    	item2.setLabel(getResources().getString(R.string.conf_theme_blue));
    	items.add(item2);
    	drwItem item3= new drwItem();    	
    	item3.setIcom(getResources().getDrawable(R.drawable.us));
    	item3.setLabel(getResources().getString(R.string.conf_theme_pink));
    	items.add(item3);
    	drwItem item4= new drwItem();
    	item4.setIcom(getResources().getDrawable(R.drawable.us));
    	item4.setLabel(getResources().getString(R.string.conf_theme_red));
    	items.add(item4);
    	return items;
	}
	
	private void showGlobalContextActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setNavigationMode(ActionBar.DISPLAY_SHOW_HOME);
        actionBar.setTitle(R.string.app_name);
    }

    private ActionBar getActionBar() {
        return ((ActionBarActivity) getActivity()).getSupportActionBar();
    }

    private void CreateListener()
    {
    	btnSave.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
				SharedPreferences.Editor editor = sharedPref.edit();
				editor.putInt("lang", spnLang.getSelectedItemPosition());
				editor.putInt("theme", spnTheme.getSelectedItemPosition());
				editor.putBoolean("notify",chkNotification.isChecked());
				editor.putBoolean("gps", chkGps.isChecked());
				editor.commit();
				String languageToLoad="es";
				int lang=spnLang.getSelectedItemPosition();
				switch(lang)
		        {
		        case 0:
		        	languageToLoad  = "es";
		        	break;
		        case 1:
		        	languageToLoad  = "fr";
		        	break;
		        case 2:
		        	languageToLoad  = "en";
		        	break;
		        }
		        Locale locale = new Locale(languageToLoad);
		        Locale.setDefault(locale);
		        Configuration config = new Configuration();
		        config.locale = locale;
		        actParent.getBaseContext().getResources().updateConfiguration(config,actParent.getBaseContext().getResources().getDisplayMetrics());
				
				
				actParent.finish();
				actParent.startActivity(actParent.getIntent());
				
				
			}
		});
    
    	btnSync.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {		
				try
				{
					LoginDialogFragment dFragment = new LoginDialogFragment();
					dFragment.loginDialog(getActivity(), "Acceso").show();
                	//dFragment.show(getActivity().getSupportFragmentManager(), "Dialog Fragment");
				}
				catch(Exception ex)
				{
					ex.getMessage();					
				}
			}
		});
    
    }

    
}
