package com.example.assignment03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    EditText name, contact, dob;
    Button insert, update, delete, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        dob = findViewById(R.id.DOB);

        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);

        DB = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dob.getText().toString();

                boolean checkinsertdata = DB.insertuserdata(nameTXT,contactTXT,dobTXT);
                if(checkinsertdata==true)
                    Toast.makeText(SecondActivity.this,"New entry inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(SecondActivity.this,"New entry not inserted", Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dob.getText().toString();

                boolean checkupdatedata = DB.updateuserdata(nameTXT,contactTXT,dobTXT);
                if(checkupdatedata==true)
                    Toast.makeText(SecondActivity.this,"New entry updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(SecondActivity.this,"New entry not updated", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dob.getText().toString();

                boolean checkdeletedata = DB.deleteuserdata(nameTXT);
                if(checkdeletedata==true)
                    Toast.makeText(SecondActivity.this," entry deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(SecondActivity.this," entry not deleted", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.getdata();
                if(res.getCount()==0)
                {
                    Toast.makeText(SecondActivity.this,"No entry exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext())
                {
                    buffer.append("Name :"+res.getString(0)+"\n");
                    buffer.append("Contact :"+res.getString(1)+"\n");
                    buffer.append("Date of Birth :"+res.getString(2)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}