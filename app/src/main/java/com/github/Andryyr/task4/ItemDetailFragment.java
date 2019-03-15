package com.github.Andryyr.task4;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.Andryyr.task4.DataBase.DatabaseHelper;
import com.github.Andryyr.task4.dummy.ListOfPictures;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */

    public static final String ARG_ITEM_ID = "item_id";

    private static final String LOG_TAG = ItemDetailFragment.class.getSimpleName();

    private static DatabaseHelper MyDB;

    /**
     * The dummy content this fragment is presenting.
     */
    private ListOfPictures.Picture mItem;

    private Target target;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @SuppressLint("ResourceType")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FloatingActionButton button = getActivity().findViewById(R.id.fappingButtonAdd);

//        MyDB = new DatabaseHelper(getActivity()); //не робит(((


        MyDB = DatabaseHelper.getInstance(getContext());
        assert getArguments() != null;
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = ListOfPictures.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
            boolean isLiked = false;
            if (MyDB.contains(mItem.content.first) != -1) {
                if (button != null) {
                    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
                    button.setImageResource(android.R.drawable.btn_star_big_on);
                    isLiked = true;
                }
                Log.d(LOG_TAG, "exists");
            } else {
                Log.d(LOG_TAG, "Do not exits");
            }

            if (button != null) {
                boolean finalIsLiked = isLiked;
                button.setOnClickListener((View v) -> {
                    if (!finalIsLiked) {
                        boolean bool = MyDB.addToTable(mItem.content.first, mItem.content.second);
                        if (bool) {
                            Log.d(LOG_TAG, "Added to DataBase");
                            button.setImageResource(android.R.drawable.btn_star_big_on);
                        } else Log.d(LOG_TAG, ":((((( Add");
                    } else {
                        boolean bool = MyDB.deleteFromTable(mItem.content.first);
                        if (bool) {
                            Log.d(LOG_TAG, "Delete from DataBase");
                            button.setImageResource(android.R.drawable.btn_star_big_off);
                        } else Log.d(LOG_TAG, ":((((( delete");
                    }
                });
            }

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content.first);
            }
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        // Show the dummy content as text in a TextView.
        rootView.findViewById(R.id.progresspic).setVisibility(View.VISIBLE);
        rootView.findViewById(R.id.item_detail).setVisibility(View.GONE);
        if (mItem != null) {

            rootView.findViewById(R.id.progresspic).setVisibility(View.GONE);
            rootView.findViewById(R.id.item_detail).setVisibility(View.VISIBLE);

            target = new Target() {
                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    Log.d(LOG_TAG, "onBitmapLoadedPicasso");
                    Log.d(LOG_TAG, "Loaded from : " + from.name());
                    ((ImageView) rootView.findViewById(R.id.item_detail)).setImageBitmap(bitmap);
                }

                @Override
                public void onBitmapFailed(Drawable errorDrawable) {

                }

                @Override
                public void onPrepareLoad(Drawable placeHolderDrawable) {
                    Log.d(LOG_TAG, "onPrepareLoadPicasso");
                }
            };

            Picasso.with(getContext()).load(mItem.content.second).into(target);

        }
        return rootView;
    }
}
