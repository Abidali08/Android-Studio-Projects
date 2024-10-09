package com.example.intentpassing;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnemail,btnshare,btnmsg;
    TextView btndial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
        Dial();
        btnmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Imag = new Intent(Intent.ACTION_SENDTO);
                Imag.setData(Uri.parse("smsto:"+Uri.encode("03464503603")));
                Imag.putExtra("sms_body","AOA, How are you?");
                startActivity(Imag);
            }
        });
        btnemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Iemail = new Intent(Intent.ACTION_SEND);
                Iemail.setType("message/rfc822");
                Iemail.putExtra(Intent.EXTRA_EMAIL,new String[]{"abc@gmail.com","def@gmail.com"});
                Iemail.putExtra(Intent.EXTRA_SUBJECT,"Questions");
                Iemail.putExtra(Intent.EXTRA_TEXT,"Jab dejha en ka jaldi");
                startActivity(Intent.createChooser(Iemail,"Email Via a"));
            }
        });
        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Ishare = new Intent(Intent.ACTION_SEND);
                Ishare.setType("text/plain");
                Ishare.putExtra(Intent.EXTRA_TEXT,"Download this App, https://play.google.com/store/apps/details?id=com.whatsapp&hl=en&pli=1");
                startActivity(Intent.createChooser(Ishare,"Share through"));
            }
        });

    }

    void init()
    {
        btndial = findViewById(R.id.btndial);
        btnemail = findViewById(R.id.btnemail);
        btnshare = findViewById(R.id.btnshare);
        btnmsg = findViewById(R.id.btnmsg);
    }

    void Dial()
    {
        btndial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: 03464503603"));
                startActivity(iDial);
            }
        });
    }
}