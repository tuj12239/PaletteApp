package temple.edu.paletteapp;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CanvasFragment extends Fragment {

    TextView textView;
    ConstraintLayout canvasLayout;

    public CanvasFragment() {}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View canvasView = inflater.inflate(R.layout.fragment_canvas, container, false);

        textView = canvasView.findViewById(R.id.colorName);
        canvasLayout = canvasView.findViewById(R.id.canvasLayout);

        String chosenColor = ((CanvasColorInterface)getActivity()).getChosenColor();
        String parseColor = ((CanvasColorInterface)getActivity()).getParseColor();

        textView.setText(chosenColor);
        canvasLayout.setBackgroundColor(Color.parseColor(parseColor));

        return canvasView;
    }

    public void updateBackgroundColor(String chosenColor, String parseColor) {
        textView.setText(chosenColor);
        canvasLayout.setBackgroundColor(Color.parseColor(parseColor));
    }

    interface CanvasColorInterface {
        String getChosenColor();
        String getParseColor();
    }
}