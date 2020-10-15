package temple.edu.paletteapp;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

public class PaletteAdapter extends BaseAdapter
{
    private String[] colors;
    private String[] parseColorStrings;

    public PaletteAdapter(String[] colors, String[] parseColors)
    {
        super();
        this.colors = colors;
        this.parseColorStrings = parseColors;
    }

    @Override
    public int getCount()
    {
        return colors.length;
    }

    @Override
    public Object getItem(int position)
    {
        return colors[position];
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        TextView colorOption = new TextView(parent.getContext());
        colorOption.setText(colors[position]);
        colorOption.setTextSize(16);
        colorOption.setHeight(256);
        Log.d("PaletteAdapter", (String)colorOption.getText());

        colorOption.setBackgroundColor(Color.parseColor(parseColorStrings[position]));

        return colorOption;
    }
}
