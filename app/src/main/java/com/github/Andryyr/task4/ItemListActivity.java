package com.github.Andryyr.task4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.Andryyr.task4.DataBase.DatabaseHelper;
import com.github.Andryyr.task4.Gson.MyGson;
import com.github.Andryyr.task4.dummy.ListOfPictures;

import java.util.ArrayList;

import lombok.val;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.INTERNET;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ItemListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */

    private static final String LOG_TAG = ItemListActivity.class.getSimpleName();
    private static DatabaseHelper MyDB;

    private TextInputLayout inputSearch;
    private final String client_id = "5610d1a6848922a1f88b56a87079f607633124c714cac451401f1528797f8739";
    private static ArrayList<ListOfPictures.Picture> LINKS_AND_DESCRIPTION = new ArrayList<>();
    final Context myActivity = this;
    private boolean mTwoPane;
    boolean flag = false;

    private void LoadPics() {
        SimpleItemRecyclerViewAdapter adapterForListOfNamesOfPictures = new SimpleItemRecyclerViewAdapter(this, new ListOfPictures(LINKS_AND_DESCRIPTION.size()), mTwoPane);

        RecyclerView listNames = findViewById(R.id.item_list);
        listNames.setAdapter(adapterForListOfNamesOfPictures);
        listNames.setLayoutManager(new LinearLayoutManager(myActivity));
        ContextCompat.checkSelfPermission(myActivity, INTERNET);
        for (int i = 0; i < LINKS_AND_DESCRIPTION.size(); i++) {
            Log.d(LOG_TAG, LINKS_AND_DESCRIPTION.get(i).toString());
            Log.d(LOG_TAG, LINKS_AND_DESCRIPTION.get(i).content.second);
            if (LINKS_AND_DESCRIPTION.get(i).content.first != null) {
                adapterForListOfNamesOfPictures.setElement(i, LINKS_AND_DESCRIPTION.get(i));
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        MyDB = new DatabaseHelper(myActivity);
        MyDB = DatabaseHelper.getInstance(myActivity);
        setContentView(R.layout.activity_item_list);
        Log.d(LOG_TAG, "onCreate");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        View button = findViewById(R.id.fappingButton);

//        getMenuInflater().inflate(R.);

//        View s = button.findViewById(R.id.toolbar_layout);

        button.setOnClickListener((View v) -> {
            LINKS_AND_DESCRIPTION.clear();
            flag = true;
            Cursor a = MyDB.getAllData();
            Log.d(LOG_TAG, a.getCount() + "");
            int number = 1;
            while (a.moveToNext()) {
                LINKS_AND_DESCRIPTION.add(new ListOfPictures.Picture(number++ + "", new Pair<>(a.getString(1), a.getString(2))));
            }

            LoadPics();
        });
        inputSearch = findViewById(R.id.text_input);


        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
        flag = (LINKS_AND_DESCRIPTION.size() == 0);

        if (!flag) {
            LoadPics();
        }

    }


    protected void search(String input) {
        LINKS_AND_DESCRIPTION.clear();
        flag = true;

        Log.d(LOG_TAG, LINKS_AND_DESCRIPTION.size() + "LINKS_AND_DESCRIPTION SIZE");
        val request = App.getApi().getData(input, client_id);
        Log.d(LOG_TAG, App.getApi().getData(input, client_id).request().toString());
        request.enqueue(new Callback<MyGson>() {
            @Override
            public void onResponse(@NonNull Call<MyGson> call, @NonNull Response<MyGson> response) {
                assert response.body() != null;
                MyGson r = response.body();


                assert r != null;
                for (int i = 0; i < r.getResults().size(); i++) {
                    LINKS_AND_DESCRIPTION.add(new ListOfPictures.Picture(i + "", new Pair<>(r.getResults().get(i).getDescription(), r.getResults().get(i).getUrls().getRegular())));
                }
                Log.d(LOG_TAG, LINKS_AND_DESCRIPTION.size() + " ");
                LoadPics();
            }

            @Override
            public void onFailure(Call<MyGson> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void doSearch(View view) {
        String search_word = inputSearch.getEditText().getText().toString().trim();

        search(search_word);
    }


    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final ItemListActivity mParentActivity;
        private final ListOfPictures mValues;
        private final boolean mTwoPane;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListOfPictures.Picture item = (ListOfPictures.Picture) view.getTag();
                if (mTwoPane) {
                    Bundle arguments = new Bundle();

                    arguments.putString(ItemDetailFragment.ARG_ITEM_ID, item.id);
                    ItemDetailFragment fragment = new ItemDetailFragment();
                    fragment.setArguments(arguments);

                    mParentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, ItemDetailActivity.class);
                    intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, item.id);
                    context.startActivity(intent);
                }
            }
        };

        SimpleItemRecyclerViewAdapter(ItemListActivity parent,
                                      ListOfPictures items,
                                      boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content, parent, false);
            return new ViewHolder(view);
        }


        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {
            holder.id.setText(mValues.get(i).id);

            holder.itemView.setTag(mValues.get(i));
            holder.itemView.setOnClickListener(mOnClickListener);

            holder.bind(mValues.get(i), i);
        }

        void setElement(int pos, ListOfPictures.Picture data) {
            this.mValues.set(pos, data);
            notifyItemChanged(pos);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView id;
            final TextView description;

            ViewHolder(@NonNull View view) {
                super(view);
                id = view.findViewById(R.id.id);
                description = itemView.findViewById(R.id.description);
            }

            @SuppressLint("SetTextI18n")
            void bind(ListOfPictures.Picture data, int i) {
                if (data == null) {
                    description.setVisibility(View.GONE);
                } else {
                    id.setVisibility(View.VISIBLE);
                    id.setText(i + 1 + "");
                    description.setVisibility(View.VISIBLE);
                    description.setText(data.content.first);
                }
            }
        }
    }
}
