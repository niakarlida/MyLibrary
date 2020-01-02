package id.ac.poliban.mi.nia.mylibrary;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btStore, btGet;
    private EditText edName;
    private DatabaseHelper databaseHelper;
    private TextView tvNames;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        tvNames = (TextView) findViewById(R.id.tvNames);
        btStore = (Button) findViewById(R.id.btStore);
        btGet = (Button) findViewById(R.id.btGet);
        edName = (EditText) findViewById(R.id.edName);

        btStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addStudentDetail(edName.getText().toString());
                edName.setText("");
                Toast.makeText(MainActivity.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList = databaseHelper.getAllStudentsList();
                tvNames.setText("");
                for (int i = 0; i <arrayList.size(); i++){
                    tvNames.setText(tvNames.getText().toString()+", "+arrayList.get(i));
                }
            }
        });
    }

}
