package com.awesome.mariadmar.realtimedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    Button buttonAdd;
    Spinner spinnerGenres;

    DatabaseReference databaseNames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseNames = FirebaseDatabase.getInstance().getReference("name");

        editTextName = (EditText) findViewById(R.id.editTextName);
        buttonAdd = (Button) findViewById(R.id.buttonAddText);
        spinnerGenres = (Spinner) findViewById(R.id.spinnerGenres);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             addNombres();

                                         }
                                     });
    }

    private void addNombres(){
        String name = editTextName.getText().toString().trim();
        String genre = spinnerGenres.getSelectedItem().toString();

        if(!TextUtils.isEmpty(name)){

            String id = databaseNames.push().getKey();

            Nombres nombre = new Nombres(id, name, genre);

            databaseNames.child(id).setValue(name);

            Toast.makeText(this,"Nombre añadido", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"You should enter a name", Toast.LENGTH_LONG).show();
        }

    }
}
