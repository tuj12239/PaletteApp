package temple.edu.paletteapp;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class PaletteFragment extends Fragment
{
    String[] colors;
    String[] parseColorStrings;

    public PaletteFragment(){}

    public static PaletteFragment newInstance(String[] colors, String[] parseColors) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("colors", colors);
        bundle.putStringArray("parseColors", parseColors);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle;
        if(getArguments() != null) {
            bundle = getArguments();
            colors = getArguments().getStringArray("colors");
            parseColorStrings = getArguments().getStringArray("parseColors");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View paletteView = inflater.inflate(R.layout.fragment_palette, container, false);

        final ConstraintLayout paletteLayout = paletteView.findViewById(R.id.paletteLayout);
        final GridView paletteGridView = paletteView.findViewById(R.id.paletteGridView);


        final PaletteAdapter paletteAdapter = new PaletteAdapter(colors, parseColorStrings);

        if (paletteGridView != null)
        {
            paletteGridView.setAdapter(paletteAdapter);

            paletteGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.d("PaletteFragment", colors[position]);
                    ((PaletteColorInterface)getActivity()).setChosenColor(colors[position], parseColorStrings[position]);
                }
            });
        }

        return paletteView;
    }

    interface PaletteColorInterface {
        void setChosenColor(String color, String parseColor);
    }
}