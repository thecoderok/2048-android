package com.thecoderok.game2048;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ExitAppDialogFragment extends DialogFragment {
    public ExitAppDialogFragment(){
        int style = DialogFragment.STYLE_NORMAL, theme = 0;
        theme = android.R.style.Theme_DeviceDefault_Light_NoActionBar;
        setStyle(style, theme);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View v = inflater.inflate(R.layout.dialog_exit, null);
        AdView mAdView = v.findViewById(R.id.adViewDialog);
        AdRequest adRequest = new AdRequest.Builder().tagForChildDirectedTreatment(true).build();
        mAdView.loadAd(adRequest);
        builder.setView(v)
                // Add action buttons
                .setPositiveButton("Leave", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        getActivity().finish();
                    }
                })
                .setNegativeButton("Keep playing", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ExitAppDialogFragment.this.getDialog().cancel();
                    }
                });



        Dialog result = builder.create();

        return result;
    }
}
