package com.psm.UI;

import com.psm.farmacy.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LoginDialogFragment extends DialogFragment{
	
	/*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View vi = inflater.inflate(R.layout.fragment_login_dialog, container, false);  
        return vi;
    }	
	
	 public Dialog onCreateDialog(Bundle savedInstanceState) {
		 Dialog dl= new Dialog(getActivity());
		 
		 return dl;
	 }*/
	
	public AlertDialog loginDialog(Context c, String message) {
	    LayoutInflater factory = LayoutInflater.from(c);            
	    final View textEntryView = factory.inflate(R.layout.fragment_login_dialog, null);
	    final AlertDialog.Builder failAlert = new AlertDialog.Builder(c);
	    failAlert.setTitle("Login/ Register Failed"); 
	    failAlert.setNegativeButton("OK", new DialogInterface.OnClickListener() { 
	        public void onClick(DialogInterface dialog, int whichButton) { 
	            // Cancelled
	        }
	    });
	    AlertDialog.Builder alert = new AlertDialog.Builder(c); 
	    alert.setTitle("Login/ Register"); 
	    alert.setMessage(message); 
	    alert.setView(textEntryView); 
	    alert.setPositiveButton("Login", new DialogInterface.OnClickListener() { 
	        public void onClick(DialogInterface dialog, int whichButton) { 
	            try {
	                //final EditText usernameInput = (EditText) textEntryView.findViewById(R.id.userNameEditText);
	                //final EditText passwordInput = (EditText) textEntryView.findViewById(R.id.passwordEditText);
	                //ff.login(usernameInput.getText().toString(), passwordInput.getText().toString());
	            }
	            //FFException
	            catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	    alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { 
	        public void onClick(DialogInterface dialog, int whichButton) {
	            // Canceled. 
	        }
	    }); 
	    return alert.create();
	}
}
