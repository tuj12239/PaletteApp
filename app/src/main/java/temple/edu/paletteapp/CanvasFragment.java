package temple.edu.paletteapp;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CanvasFragment extends Fragment {

    public CanvasFragment() {}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View canvasView = inflater.inflate(R.layout.fragment_canvas, container, false);

        final TextView textView = canvasView.findViewById(R.id.colorName);
        final ConstraintLayout canvasLayout = canvasView.findViewById(R.id.canvasLayout);

        String chosenColor = this.getIntent().getStringExtra("selectedColor");
        String parseColor = this.getIntent().getStringExtra("parseColor");

        textView.setText(chosenColor);
        canvasLayout.setBackgroundColor(Color.parseColor(parseColor));

        return canvasView;
    }

    interface CanvasColorInterface {
        String[] getCanvasColors();
    }
}