package com.marcnazarian.android.planningpoker;

import java.util.ArrayList;

import com.marcnazarian.android.planningpoker.R;
import com.marcnazarian.android.planningpoker.StoryPointAdapter.StoryPointAdapterListener;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.widget.ListView;

public class PlanningPoker extends Activity implements StoryPointAdapterListener {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.main);
    	// Retrieve story points list
    	ArrayList<StoryPoint> values = StoryPoint.getAvailableStoryPoints();
    	// Create and init user story adapter
    	StoryPointAdapter adapter = new StoryPointAdapter(this, values);
    	
    	adapter.addListener(this);
    	
    	// Retrieve ListView component
    	ListView list = (ListView)findViewById(R.id.listFibo);
    	// Init list with data
    	list.setAdapter(adapter);
    	
    	/*List<String> storyPoints = new ArrayList<String>();
    	for (storyPoint sp : storyPoints) {
			fiboSuite.add(sp.getLabel());
		}
    	ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
        		fiboSuite);
        setListAdapter(adapter);*/
    }

	public void onClickNumber(StoryPoint storyPoint, int position) {
		Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(getString(R.string.app_name));
		builder.setMessage(getString(R.string.my_choice) + " " + storyPoint.getLabel());
		builder.setPositiveButton(getString(R.string.ok), null);
		builder.show();
	}
	
}