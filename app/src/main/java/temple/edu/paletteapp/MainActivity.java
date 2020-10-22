package temple.edu.paletteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements CanvasFragment.CanvasColorInterface,
        PaletteFragment.PaletteColorInterface {

    String chosenColor;
    String parseColor;
    PaletteFragment paletteFragment;
    CanvasFragment canvasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Resources res = getResources();

        final String colors[] = res.getStringArray(R.array.colors);

        //This is only used for the parseColor method
        //These are not visible to the user.
        final String parseColorStrings[] = {"White", "Red", "Blue", "Green", "Yellow",
                "Magenta", "Purple", "Teal", "Aqua", "Maroon", "Olive", "Gray"};

        chosenColor = res.getStringArray(R.array.colors)[0];
        parseColor = parseColorStrings[0];

        paletteFragment = PaletteFragment.newInstance(colors, parseColorStrings);
        canvasFragment = new CanvasFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_1, paletteFragment)
                .add(R.id.container_2, canvasFragment)
                .commit();
    }

    public void setChosenColor(String chosenColor, String parseColor) {
        canvasFragment.updateBackgroundColor(chosenColor, parseColor);
    }

    public String getChosenColor() {
        Log.d("MainActivity", chosenColor);
        return chosenColor;
    }

    public String getParseColor() {
        Log.d("MainActivity", parseColor);
        return parseColor;
    }
}