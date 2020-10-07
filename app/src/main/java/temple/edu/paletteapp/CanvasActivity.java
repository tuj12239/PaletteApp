package temple.edu.paletteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        final TextView textView = findViewById(R.id.colorName);
        final ConstraintLayout canvasLayout = findViewById(R.id.canvasLayout);

        String chosenColor = this.getIntent().getStringExtra("selectedColor");

        textView.setText(chosenColor);
        canvasLayout.setBackgroundColor(Color.parseColor(chosenColor));
    }
}