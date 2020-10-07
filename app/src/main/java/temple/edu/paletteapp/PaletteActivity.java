package temple.edu.paletteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class PaletteActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ConstraintLayout paletteLayout = findViewById(R.id.paletteLayout);
        final GridView paletteGridView = findViewById(R.id.paletteGridView);

        final String colors[] = {"White", "Red", "Blue", "Green", "Yellow", "Magenta",
                "Purple", "Teal", "Aqua", "Maroon", "Olive", "Gray"};
        final PaletteAdapter paletteAdapter = new PaletteAdapter(colors);

        final Intent paletteIntent = new Intent(this, CanvasActivity.class);

        if (paletteGridView != null)
        {
            paletteGridView.setAdapter(paletteAdapter);

            paletteGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    paletteIntent.putExtra("selectedColor", colors[position]);
                    startActivity(paletteIntent);
                }
            });
        }
    }
}