package com.example.vipavee.project1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    private TextView txtName,txtDetail, txtPrice;
    private Button btn_order;
    private ImageView imageView;
    private int checknum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = (ImageView) findViewById(R.id.imageView2);
        txtName = (TextView) findViewById(R.id.txtName1);
        txtDetail = (TextView) findViewById(R.id.txtDetail1);
        txtPrice = (TextView) findViewById(R.id.txtPrice);
        btn_order = (Button) findViewById(R.id.btn_order);

        String stringName = getIntent().getStringExtra("Name");
        txtName.setText(stringName);

        String stringDetail = getIntent().getStringExtra("Description");
        txtDetail.setText(stringDetail);

        String stringPrice = getIntent().getStringExtra("Price");
        txtPrice.setText(stringPrice);

        int instPic = getIntent().getIntExtra("Pic",R.drawable.conan);
        imageView.setImageResource(instPic);

        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog();
            }
        });

    }


    public void ShowDialog() {
        final AlertDialog.Builder dDialog = new AlertDialog.Builder(this);
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);//input number only

        dDialog.setTitle("QTY");
        dDialog.setMessage("Please Input QTY");
        dDialog.setView(input);

        dDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override

            public void onClick(DialogInterface dialog, int which) {
//                int value = input.getInputType();
//                String value = input.getText().toString();

//          if (input.toString().trim().length()< 0) {
//              AlertDialog.Builder builder = new AlertDialog.Builder(DetailActivity.this);
//              builder.setTitle("Warning");
//              builder.setMessage("Please Input QTY");
//              builder.show();
//
//          }
                    int val = Integer.parseInt(input.getText().toString());
                    Toast.makeText(DetailActivity.this, "Order QTY = " + val,
                            Toast.LENGTH_LONG).show();


            }
        });//OK

        dDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                int value = input.getInputType();
                String value = input.getText().toString();
//                int val = Integer.parseInt( input.getText().toString() );
                Toast.makeText(DetailActivity.this,"Cancel = " + value ,
                        Toast.LENGTH_LONG).show();
            }
        });//Cancel

        dDialog.show();
    }

}
