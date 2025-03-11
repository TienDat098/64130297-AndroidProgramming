package ntd.lvanimal;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewAnimal;
    ArrayList<String> dsAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    listViewAnimal=findViewById(R.id.LVAnimal);
    //B1chuẩn bị dữ liệu
        dsAnimal = new ArrayList<String>();
        dsAnimal.add("Hổ");
        dsAnimal.add("Voi");
        dsAnimal.add("Sư tử");
        dsAnimal.add("Chó sói");
        dsAnimal.add("Gấu trúc");
        dsAnimal.add("Chim cánh cụt");
        dsAnimal.add("Cá heo");
        dsAnimal.add("Cá mập");
        dsAnimal.add("Hưu");
        dsAnimal.add("Ngựa");
        //b2 tạo Adapter
        ArrayAdapter<String> adapterAnimal;
        adapterAnimal= new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,dsAnimal);
        listViewAnimal.setAdapter(adapterAnimal);
        //Bước 3 gắn adapter
        listViewAnimal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String giaTriDuocChon = dsAnimal.get(position);
                Toast.makeText(MainActivity.this,giaTriDuocChon,Toast.LENGTH_SHORT).show();
            }
        });
    }
}