package com.marcnazarian.android.planningpoker;

import java.util.ArrayList;
import java.util.List;

import com.marcnazarian.android.planningpoker.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StoryPointAdapter extends BaseAdapter {

	private List<StoryPoint> availableStoryPoints;
	private Context context;
	private LayoutInflater inflater;
	
	private ArrayList<StoryPointAdapterListener> mListListener = new ArrayList<StoryPointAdapterListener>();
	
	public StoryPointAdapter(Context context,
			List<StoryPoint> storyPointsList) {
		this.context = context;
		this.availableStoryPoints = storyPointsList;
		this.inflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return availableStoryPoints.size();
	}

	public StoryPoint getItem(int pos) {
		return availableStoryPoints.get(pos);
	}

	public long getItemId(int pos) {
		return pos;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout layoutItem;
		if (convertView == null) {
			// Init item regarding XML layout "storypoints_layout.xml"
			layoutItem = (LinearLayout) inflater.inflate(R.layout.storypoints_layout, parent, false);
		} else {
			layoutItem = (LinearLayout) convertView;
		}
		TextView tvLabel = (TextView)layoutItem.findViewById(R.id.Label);
		tvLabel.setText(availableStoryPoints.get(position).getLabel());
		layoutItem.setPadding(10, 20, 10, 20);

		// store StoryPoint position in the TextView Component
		tvLabel.setTag(position);
		// Add a listener
		tvLabel.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Once one click the StoryPoint, we retrieve the position of the StoryPoint
				Integer position = (Integer)v.getTag();
				// Alert listeners that there was a click on the TVLabel TextView.
				sendListener(availableStoryPoints.get(position), position);
			}
		});
		
		return layoutItem;
	}
	
	public interface StoryPointAdapterListener {
		public void onClickNumber(StoryPoint item, int position);
	}

	public void addListener(StoryPointAdapterListener aListener) {
		mListListener.add(aListener);
	}
	
	private void sendListener(StoryPoint item, int position) {
		for(int i = mListListener.size()-1; i >= 0; i--) {
			mListListener.get(i).onClickNumber(item, position);
		}
	}
}
