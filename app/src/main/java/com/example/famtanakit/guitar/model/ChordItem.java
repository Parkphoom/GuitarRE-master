package com.example.famtanakit.guitar.model;

import java.util.Locale;

public class ChordItem {
    public final long _id;
    public final String chord_name;
    public final String key_chord;
    public final String image;

    public ChordItem(long _id, String chord_name, String key_chord, String image) {
        this._id = _id;
        this.chord_name = chord_name;
        this.key_chord = key_chord;
        this.image = image;
    }

    @Override
    public String toString() {
        String msg = String.format(
                Locale.getDefault(),
                "%s (%s)",
                this.chord_name,
                this.key_chord
        );
        return msg;
    }
}
