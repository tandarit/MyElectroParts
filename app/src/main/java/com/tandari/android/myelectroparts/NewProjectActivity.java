package com.tandari.android.myelectroparts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.tandari.android.myelectroparts.Models.Category;
import com.tandari.android.myelectroparts.Models.Project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewProjectActivity extends AppCompatActivity {
    public static final String NEW_PROJECT_TAG= "project_data";
    public static final String NEW_CATEGORIES_TAG= "categories_data";

    private EditText mTitleEditText;
    private TextView mCategoriesTextView;
    private Spinner mCategorySpinner;
    private SeekBar mDifficultySeekBar;
    private TextView mDifficultyTextView;
    private Button mNewProjectButton;
    private List<Category> mCategoryList;
    private List<Category> mSelectedCategoryList= new ArrayList<>();
    private StringBuffer mCategoriesString = new StringBuffer();
    private boolean mSelected=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_project);


        mTitleEditText = (EditText) findViewById(R.id.title_editText);

        mCategoriesTextView = (TextView) findViewById(R.id.categoriesTextView);

        mCategorySpinner = (Spinner) findViewById(R.id.categoriesSpinner);

        Bundle bundle = getIntent().getExtras();
        mCategoryList=(List<Category>) bundle.getSerializable(ProjectListFragment.NEW_PROJECT_ACTIVITY_CATEGORIES);


        ArrayAdapter<Category> adapter = new ArrayAdapter<Category>(this, android.R.layout.simple_spinner_item, mCategoryList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCategorySpinner.setAdapter(adapter);

        mCategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(mSelected) {
                        mSelectedCategoryList.add((Category) adapterView.getItemAtPosition(i));
                        mCategoriesString.append(((Category) adapterView.getItemAtPosition(i)).getCategoryName() + " ");
                        mCategoriesTextView.setText(mCategoriesString);

                    }
                    mSelected = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });


        mDifficultySeekBar = (SeekBar) findViewById(R.id.difficultySeekBar);
        mDifficultyTextView = (TextView) findViewById(R.id.difficulty_textView);
        mDifficultySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressChangedValue = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mDifficultyTextView.setText("Difficult: "+Integer.toString(progressChangedValue));
            }
        });

        mNewProjectButton = (Button) findViewById(R.id.add_new_project_button);
        mNewProjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Project p=new Project();
                p.setProjectTitle(mTitleEditText.getText().toString());
                p.setDate(new Date());
                p.setProjectDifficulty(mDifficultySeekBar.getProgress());


                Bundle resultBundle=new Bundle();
                resultBundle.putSerializable(NEW_CATEGORIES_TAG, (Serializable)mSelectedCategoryList);
                resultBundle.putSerializable(NEW_PROJECT_TAG, p);

                Intent resultIntent = new Intent();
                resultIntent.putExtras(resultBundle);

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
