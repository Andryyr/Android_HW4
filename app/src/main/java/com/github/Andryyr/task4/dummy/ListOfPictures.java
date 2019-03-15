package com.github.Andryyr.task4.dummy;

import android.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 */
public class ListOfPictures {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Picture> ITEMS = new ArrayList<Picture>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Picture> ITEM_MAP = new HashMap<String, Picture>();

    private static int COUNT;

    public ListOfPictures(int size) {
        ITEMS.clear();
        ITEM_MAP.clear();
        COUNT = size;
        for (int i = 0; i < COUNT; i++)
            ITEMS.add(new Picture("", new Pair<>("", "")));
    }

    public Picture get(int i) {
        return ITEMS.get(i);
    }

    private static void addItem(Picture item) {
        ITEM_MAP.put(item.id, item);
    }

    public void set(int pos, Picture picture) {
        addItem(picture);
        ITEMS.set(pos, picture);
    }

    public int size() {
        return ITEMS.size();
    }

    public static class Picture {
        public final String id;
        public final Pair<String, String> content;

        public Picture(String id, Pair<String, String> content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return (content.first == null ? "nullString" : content.first);
        }
    }
}
