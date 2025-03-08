package ntd.chuyenmanhinhquiz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityLogin extends AppCompatActivity {
    EditText edtUserName;
    EditText edtPassword;
    EditText edtEmail;
    Button btnOK;

    public void TimDieuKhien() {
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPass);
        edtEmail = findViewById(R.id.edtEmail);
        btnOK = findViewById(R.id.btnOK);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TimDieuKhien();

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUserName = edtUserName.getText().toString().trim();
                String strPassword = edtPassword.getText().toString().trim();
                String strEmail = edtEmail.getText().toString().trim();

                if (strUserName.equals("nguyentiendat") && strPassword.equals("123") && Patterns.EMAIL_ADDRESS.matcher(strEmail).matches()) {
                    Intent iHome = new Intent(ActivityLogin.this, ActivityHome.class);
                    iHome.putExtra("UserName", strUserName);
                    startActivity(iHome);
                } else if (!Patterns.EMAIL_ADDRESS.matcher(strEmail).matches()) {
                    Toast.makeText(ActivityLogin.this, "Định dạng Email không chính xác. Vui lòng kiểm tra lại", Toast.LENGTH_SHORT).show();
                    edtEmail.setText("");
                } else if (!strUserName.equals("nguyentiendat") || !strPassword.equals("123")) {
                    Toast.makeText(ActivityLogin.this, "Tài khoản hoặc mật khẩu không chính xác. Vui lòng kiểm tra lại", Toast.LENGTH_SHORT).show();
                    edtUserName.setText("");
                    edtPassword.setText("");
                }
            }
        });
    }
}
