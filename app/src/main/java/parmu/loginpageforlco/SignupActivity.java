package parmu.loginpageforlco;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dd.processbutton.iml.ActionProcessButton;
import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;
import com.suke.widget.SwitchButton;

import studio.carbonylgroup.textfieldboxes.ExtendedEditText;
import studio.carbonylgroup.textfieldboxes.TextFieldBoxes;

public class SignupActivity extends AppCompatActivity {

    private SwitchButton switchButton;

    private TextFieldBoxes BEmail, BPassword;
    private ExtendedEditText EEmail, EPassword;
    private ActionProcessButton login;
    private TextView signupText;
    private SweetAlertDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}


        signupText = (TextView) findViewById(R.id.signup_text);
        switchButton = (SwitchButton) findViewById(R.id.s_switch_button);
        BEmail = (TextFieldBoxes) findViewById(R.id.s_text_field_boxes_username);
        BPassword = (TextFieldBoxes) findViewById(R.id.s_text_field_boxes_password);
        login = (ActionProcessButton) findViewById(R.id.s_btnSignIn);
        EEmail = (ExtendedEditText) findViewById(R.id.s_extended_edit_text_username);
        EPassword = (ExtendedEditText) findViewById(R.id.s_extended_edit_text_password);

//        if(switchButton == null)
//            Log.e("asd", "its null");
//        else
//            Log.e("asd", "not null");
//        Log.e("asd", switchButton.toString());

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

        if(getIntent().getStringExtra("theme").equals("dark")){
            switchButton.setChecked(true);
            changeTheme("dark");
        }

        progressDialog = new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE);
        progressDialog.getProgressHelper().setBarColor(Color.parseColor("#7cc43a"));
        progressDialog.setTitleText("Sign up");
        progressDialog.setContentText("You're now registered! Let's code! ヽ༼◐ل͜◑༽ﾉ");
        progressDialog.setCancelable(false);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
            }
        });

    }

    public void changeTheme(String theme){
        if(theme.equals("dark")){

            ImageView img = (ImageView) findViewById(R.id.s_img);
            img.setImageResource(R.drawable.lco_dark);

            signupText.setTextColor(Color.parseColor("#FFFFFF"));

            LinearLayout layout = (LinearLayout) findViewById(R.id.s_main_layout);
            layout.setBackgroundColor(Color.parseColor("#252b23"));

            BEmail.setBackgroundColor(Color.parseColor("#364427"));
            BPassword.setBackgroundColor(Color.parseColor("#364427"));

            BEmail.setPrimaryColor(Color.parseColor("#FFFFFF"));
            BPassword.setPrimaryColor(Color.parseColor("#FFFFFF"));

            EEmail.setTextColor(Color.parseColor("#FFFFFF"));
            EPassword.setTextColor(Color.parseColor("#FFFFFF"));

        }else{
            ImageView img = (ImageView) findViewById(R.id.s_img);
            img.setImageResource(R.drawable.lco_light);

            signupText.setTextColor(Color.parseColor("#000000"));

            LinearLayout layout = (LinearLayout) findViewById(R.id.s_main_layout);
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
