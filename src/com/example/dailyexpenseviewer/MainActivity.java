package com.example.dailyexpenseviewer;

import java.util.Calendar;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
//	private TextView tvDateViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
         if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
//         Spinner spinner = (Spinner) findViewById(R.id.currency);
//         // Create an ArrayAdapter using the string array and a default spinner layout
//         ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//              R.array.currency_array, android.R.layout.simple_spinner_item);
//         // Specify the layout to use when the list of choices appears
//         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//         // Apply the adapter to the spinner
//         spinner.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
    
    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    	public TextView tvDateViewer;
    	
    	@Override
    	public Dialog onCreateDialog(Bundle savedInstanceState) {
    		// Use the current date as the default date in the picker
    		final Calendar c = Calendar.getInstance();
    		int year = c.get(Calendar.YEAR);
    		int month = c.get(Calendar.MONTH);
    		int day = c.get(Calendar.DAY_OF_MONTH);

    		// Create a new instance of DatePickerDialog and return it
    		return new DatePickerDialog(getActivity(), this, year, month, day);
    	}	

    	public void onDateSet(DatePicker view, int year, int month, int day) {
    		// Do something with the date chosen by the user
    		TextView tvDateViewer = (TextView)getActivity().findViewById (R.id.dateViewer);
    		tvDateViewer.setText(new StringBuilder()
				// Month is 0 based, just add 1
				.append(day).append("-").append(month + 1).append("-")
				.append(year).append(" "));
    	}
    }
    
    public void showDatePickerDialog(View v) {

    		DialogFragment newFragment = new DatePickerFragment();
    		newFragment.show(getFragmentManager(), "datePicker");

    }


}
