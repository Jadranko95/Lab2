package com.example.adrian.lab2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton nextActivity, drawActivity;
    EditText sendCommunication;
    TextView showCommunication;
    String communicationFromActivity, communicationToActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextActivity = (ImageButton)findViewById(R.id.firstIB);
        drawActivity = (ImageButton)findViewById(R.id.drawIB);
        sendCommunication = (EditText)findViewById(R.id.firstET);

        showCommunication = (TextView)findViewById(R.id.firstTV);
        communicationFromActivity = getIntent().getStringExtra("COMMUNICATION");
        showCommunication.setText(communicationFromActivity);

        nextActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (sendCommunication.length() > 0) {
                    Intent intent = new Intent(getBaseContext(), Main2Activity.class);
                    communicationToActivity = sendCommunication.getText().toString();
                    intent.putExtra("COMMUNICATION", communicationToActivity);
                    startActivity(intent);
                } else {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Błąd!")
                            .setMessage("Zostawiłeś puste pole w formularzu, spróbuj ponownie.")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // continue with delete
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            }
        });

        drawActivity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Draw.class);
                startActivity(intent);
            }
        });
    }


}
