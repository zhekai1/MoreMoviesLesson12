package sg.edu.rp.c346.id21024750.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvMovieTitle;
    TextView tvGenre;
    TextView tvYear;
    EditText etMovieTitle;
    EditText etGenre;
    EditText etYear;
    Spinner spinnerMovies;
    TextView tvRating;
    Button btnInsert;
    Button btnShowList;
    Button btnShowMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMovieTitle= findViewById(R.id.tvMovieTitle);
        tvGenre = findViewById(R.id.tvGenre);
        tvYear = findViewById(R.id.tvYear);
        etMovieTitle = findViewById(R.id.etMovieTitle);
        etGenre = findViewById(R.id.etGenre);
        etYear = findViewById(R.id.etYear);
        spinnerMovies = findViewById(R.id.spinnerMovies);
        tvRating = findViewById(R.id.tvRating);
        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShowList);
        btnShowMovies = findViewById(R.id.btnShowMovies);
    }
}