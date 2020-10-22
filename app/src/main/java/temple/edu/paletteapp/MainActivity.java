package temple.edu.paletteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CanvasFragment.CanvasColorInterface,
        PaletteFragment.PaletteColorInterface {

    private String chosenColor;
    private String parseColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setChosenColor(String color) {
        chosenColor = color;
    }

    public void setParseColor(String color) {
        parseColor = color;
    }

    public String getChosenColor() {
        return chosenColor;
    }

    public String getParseColor() {
        return parseColor;
    }
}