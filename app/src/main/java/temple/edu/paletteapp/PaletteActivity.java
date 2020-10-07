package temple.edu.paletteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ConstraintLayout paletteLayout = findViewById(R.id.paletteLayout);
        final GridView paletteGridView = findViewById(R.id.paletteGridView);

        final String colors[] = {"White", "Red", "Blue", "Green", "Yellow", "Magenta",
                "Purple", "Teal", "Aqua", "Maroon", "Olive", "Gray"};
        final PaletteAdapter paletteAdapter = new PaletteAdapter(colors);

        paletteGridView.setAdapter(paletteAdapter);

        paletteGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Do the thing!
            }
        });
    }
}