package temple.edu.paletteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class PaletteFragment extends Fragment
{
    public PaletteFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View paletteView = inflater.inflate(R.layout.fragment_main, container, false);

        final Resources res = getResources();

        final ConstraintLayout paletteLayout = paletteView.findViewById(R.id.paletteLayout);
        final GridView paletteGridView = paletteView.findViewById(R.id.paletteGridView);

        final String colors[] = res.getStringArray(R.array.colors);

        //This is only used for the parseColor method
        //These are not visible to the user.
        final String parseColorStrings[] = {"White", "Red", "Blue", "Green", "Yellow",
            "Magenta", "Purple", "Teal", "Aqua", "Maroon", "Olive", "Gray"};
        final PaletteAdapter paletteAdapter = new PaletteAdapter(colors, parseColorStrings);

        if (paletteGridView != null)
        {
            paletteGridView.setAdapter(paletteAdapter);

            paletteGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });
        }

        return paletteView;
    }
}