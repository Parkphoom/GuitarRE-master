package com.example.famtanakit.guitar.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.famtanakit.guitar.R;
import com.example.famtanakit.guitar.model.ChordItem;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ChordListAdapter extends ArrayAdapter<ChordItem> {

    private Context mContext;
    private int mResource;
    private List<ChordItem> mPhoneItemList;

    public ChordListAdapter(@NonNull Context context,
                            int resource,
                            @NonNull List<ChordItem> phoneItemList) {
        super(context, resource, phoneItemList);
        this.mContext = context;
        this.mResource = resource;
        this.mPhoneItemList = phoneItemList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResource, parent, false);

        TextView chordTextView = view.findViewById(R.id.chord_text_view);
        TextView keyTextView = view.findViewById(R.id.key_text_view);
        ImageView imageView = view.findViewById(R.id.image_view);

        ChordItem chordItem = mPhoneItemList.get(position);
        String chord_name = chordItem.chord_name;
        String key_chord = chordItem.key_chord;
        String image = chordItem.image;

        chordTextView.setText(chord_name);
        keyTextView.setText(key_chord);

        AssetManager am = mContext.getAssets();
        try {
            InputStream is = am.open(image);
            Drawable drawable = Drawable.createFromStream(is, "");
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            File privateDir = mContext.getFilesDir();
            File logoFile = new File(privateDir, image);

            Bitmap bitmap = BitmapFactory.decodeFile(logoFile.getAbsolutePath(), null);
            imageView.setImageBitmap(bitmap);

            e.printStackTrace();
        }

        return view;
    }
}
