package edu.hillel.dialogdemo;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by yuriy on 14.08.16.
 */
public class MyDialogFragment extends DialogFragment {

    private static final String ARG_SELECTED_POS = "selectedPos";

    public static MyDialogFragment newInstance(int pos) {
        MyDialogFragment dialog = new MyDialogFragment();
        Bundle args  = new Bundle();
        args.putInt(ARG_SELECTED_POS, pos);
        dialog.setArguments(args);
        return dialog;
    }

    public interface MyDialogListener {
        void onBackgroundApply(int color, int pos);
    }

    private MyDialogListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof MyDialogListener) {
            mListener = (MyDialogListener) activity;
        } else {
            throw new ClassCastException(activity.getClass().getSimpleName()
            + " should implement: "
            + MyDialogListener.class.getSimpleName());
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        int pos = 1;
        if (getArguments() != null) {
            pos = getArguments().getInt(ARG_SELECTED_POS);
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Title");
        builder.setIcon(android.R.drawable.ic_dialog_info);

        builder.setSingleChoiceItems(R.array.str_data, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int pos) {

                int color;
                switch (pos) {
                    case 0: color = Color.GREEN; break;
                    case 1: color = Color.RED; break;
                    case 2: color = Color.BLUE; break;
                    default: color = Color.WHITE;
                }

                mListener.onBackgroundApply(color, pos);
                dialogInterface.dismiss();
            }
        });

        return builder.create();
    }
}
