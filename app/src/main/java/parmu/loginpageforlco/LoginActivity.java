package parmu.loginpageforlco;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dd.processbutton.iml.ActionProcessButton;
import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;
import com.suke.widget.SwitchButton;

import org.w3c.dom.Text;

import studio.carbonylgroup.textfieldboxes.ExtendedEditText;
import studio.carbonylgroup.textfieldboxes.TextFieldBoxes;

public class LoginActivity extends AppCompatActivity {


    private SwitchButton switchButton;
    private static boolean isDark = false;

    private TextFieldBoxes BEmail, BPassword;
    private ExtendedEditText EEmail, EPassword;
    private ActionProcessButton login, signup;
    private TextView signinText;
    private SweetAlertDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signinText = (TextView) findViewById(R.id.signin_text);
        switchButton = (SwitchButton) findViewById(R.id.switch_button);
        BEmail = (TextFieldBoxes) findViewById(R.id.text_field_boxes_username);
        BPassword = (TextFieldBoxes) findViewById(R.id.text_field_boxes_password);
        login = (ActionProcessButton) findViewById(R.id.btnSignIn);
        signup= (ActionProcessButton) findViewById(R.id.btnSignUp);
        EEmail = (ExtendedEditText) findViewById(R.id.extended_edit_text_username);
        EPassword = (ExtendedEditText) findViewById(R.id.extended_edit_text_password);

        progressDialog = new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE);
        progressDialog.getProgressHelper().setBarColor(Color.parseColor("#7cc43a"));
        progressDialog.setTitleText("Log in");
        progressDialog.setContentText("welcome back I missed you! ٩ʕ◕౪◕ʔو");
        progressDialog.setCancelable(false);

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}


        switchButton.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                //TODO do your job
                if(isChecked){
                    //switch to dark mode.
                    changeTheme("dark");
                    Log.e("asd", "checked");

                }else{
                    //switch to light mode.
                    changeTheme("light");
                    Log.e("asd", "unchecked");
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                if (switchButton.isChecked())
                    intent.putExtra("theme", "dark");
                else
                    intent.putExtra("theme", "light");
                startActivity(intent);
            }
        });

    }


    public void changeTheme(String theme){
        if(theme.equals("dark")){

            ImageView img = (ImageView) findViewById(R.id.img);
            img.setImageResource(R.drawable.lco_dark);

            signinText.setTextColor(Color.parseColor("#FFFFFF"));

            LinearLayout layout = (LinearLayout) findViewById(R.id.main_layout);
            layout.setBackgroundColor(Color.parseColor("#252b23"));

            BEmail.setBackgroundColor(Color.parseColor("#364427"));
            BPassword.setBackgroundColor(Color.parseColor("#364427"));

            BEmail.setPrimaryColor(Color.parseColor("#FFFFFF"));
            BPassword.setPrimaryColor(Color.parseColor("#FFFFFF"));

            EEmail.setTextColor(Color.parseColor("#FFFFFF"));
            EPassword.setTextColor(Color.parseColor("#FFFFFF"));

        }else{
            ImageView img = (ImageView) findViewById(R.id.img);
            img.setImageResource(R.drawable.lco_light);

            signinText.setTextColor(Color.parseColor("#000000"));

            LinearLayout layout = (LinearLayout) findViewById(R.id.main_layout);
            layout.setBackgroundColor(Color.parseColor("#52a337"));

            BEmail.setBackgroundColor(Color.parseColor("#c7d1be"));
            BPassword.setBackgroundColor(Color.parseColor("#c7d1be"));

            BEmail.setPrimaryColor(Color.parseColor("#000000"));
            BPassword.setPrimaryColor(Color.parseColor("#000000"));

            EEmail.setTextColor(Color.parseColor("#000000"));
            EPassword.setTextColor(Color.parseColor("#000000"));

        }
    }
}
