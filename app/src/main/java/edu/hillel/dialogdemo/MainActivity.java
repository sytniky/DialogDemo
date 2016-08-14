package edu.hillel.dialogdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//public class MainActivity extends AppCompatActivity
//        implements View.OnClickListener, DialogInterface.OnClickListener {
public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, MyDialogFragment.MyDialogListener {

    TextView tvText;
    int mSelectedChoice = 1;
    private int currentBackgroundPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btnShowDialog);
        button.setOnClickListener(this);

        tvText = (TextView) findViewById(R.id.tvText);
    }

    @Override
    public void onClick(View view) {
//        new MyDialogFragment().show(getSupportFragmentManager(), "Dialog");
        MyDialogFragment.newInstance(currentBackgroundPos).show(getSupportFragmentManager(), "Dialog");
    }

    @Override
    public void onBackgroundApply(int color, int pos) {
        tvText.setBackgroundColor(color);
        currentBackgroundPos = pos;
    }

//    @Override
//    public void onClick(View view) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Title");
////        builder.setMessage("Message");
//        builder.setIcon(android.R.drawable.ic_dialog_info);
////        builder.setCancelable(false);  // если нельзя отменить кроме как нажатия своих кнопок
////        builder.setPositiveButton(R.string.btn_yes, this);
////        builder.setNegativeButton(R.string.btn_no, this);
//        builder.setSingleChoiceItems(R.array.str_data, mSelectedChoice, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                mSelectedChoice = i;
//                tvText.setText(String.valueOf(mSelectedChoice));
//                dialogInterface.dismiss();
//            }
//        });
//        AlertDialog dialog = builder.create();
//        dialog.show();
//    }

//    @Override
//    public void onClick(DialogInterface dialogInterface, int i) {
////        if (AlertDialog.BUTTON_POSITIVE == i) {
////            tvText.setText("Positive answer");
////        } else if (AlertDialog.BUTTON_NEGATIVE == i) {
////            tvText.setText("Negative answer");
////        }
//    }
}
