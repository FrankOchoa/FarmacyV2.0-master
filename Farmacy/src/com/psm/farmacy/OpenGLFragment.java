package com.psm.farmacy;

import com.google.android.gms.common.SupportErrorDialogFragment;

import OpenGl.Render;
import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.text.AndroidCharacter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class OpenGLFragment extends Fragment {

	private View view;
	GLSurfaceView ourSurface;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onPause() {
		super.onPause();
		ourSurface.onPause();
	}
	@Override
	public void onResume() {
		super.onResume();
		ourSurface.onResume();
	}

	@Override
	public void onStop() {
		super.onStop();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		ourSurface = new GLSurfaceView(inflater.getContext());
		ourSurface.setRenderer(new Render(inflater.getContext()));
		Home.action.hide();
		ourSurface.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Home.action.show();
				FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
				Fragment home = new HomeFragment();
				FragmentTransaction FT =fragmentManager.beginTransaction();
				FT.replace(R.id.container, home);
				FT.commit();
			}
		});
		return ourSurface;	
		}
}
