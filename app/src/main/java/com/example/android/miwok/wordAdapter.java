package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by macbook on 3/14/18.
 */

public class wordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;
    private int mAudioResourceId;
    public wordAdapter(Context context, ArrayList<Word> translationWords, int colorCategory) {
        super(context, 0, translationWords);
        mColorResourceId = colorCategory;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_view, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word current_Translate_Word = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miowk_word = (TextView) listItemView.findViewById(R.id.miowkWord);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miowk_word.setText(current_Translate_Word.getMiowkTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView default_word = (TextView) listItemView.findViewById(R.id.englishWord);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        default_word.setText(current_Translate_Word.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.img_icon);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        if (current_Translate_Word.hasImage()) {
            iconView.setImageResource(current_Translate_Word.getImageResourceId());
            iconView.setVisibility(View.VISIBLE);

        } else {
            iconView.setVisibility(View.GONE);
        }
        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}


