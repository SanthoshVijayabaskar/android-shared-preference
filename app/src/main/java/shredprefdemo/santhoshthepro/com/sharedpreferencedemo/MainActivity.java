package shredprefdemo.santhoshthepro.com.sharedpreferencedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText edtUserName,edtPassword;
    TextView txtDisplay;
    Button btnSave, btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUserName=(EditText)findViewById(R.id.edtUserName);
        edtPassword=(EditText)findViewById(R.id.edtPassword);
        txtDisplay=(TextView)findViewById(R.id.txtDisplay);
        btnSave=(Button)findViewById(R.id.btnSave);
        btnRead=(Button)findViewById(R.id.btnRead);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /** Under data/data/shared_Pref you can see the sata stored as XML File **/
                /** Preferences are Similar to Bundles But Preference persist while Bundle dosen't **/
                SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("username",edtUserName.getText().toString());
                editor.putString("password",edtPassword.getText().toString());
                editor.apply();

                Toast.makeText(getApplicationContext(),"Credential Saved!",Toast.LENGTH_LONG).show();
            }
        });


        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

                String name = sharedPref.getString("username","");
                String password = sharedPref.getString("password","");

                txtDisplay.setText(name+" "+password);

                Toast.makeText(getApplicationContext(),"Credential Retrived!",Toast.LENGTH_LONG).show();
            }
        });
    }
}
