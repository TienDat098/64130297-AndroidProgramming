package ntd.tuluyenlogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginButton;
    public  void TimDieuKhien(){
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        loginButton=findViewById(R.id.loginButton);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    TimDieuKhien();
    loginButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(username.getText().toString().equals("nguyentiendat")&& password.getText().toString().equals("123")){
                Toast.makeText(MainActivity.this,"Login Successful!",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this,"Login failed!",Toast.LENGTH_SHORT).show();
            }
        }
    });
    }
}