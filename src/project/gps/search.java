package project.gps;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;

public class search extends Activity {
	ImageButton search;
	ImageButton refresh;
	RadioButton radioname;
	RadioButton radiotaxi;
	RadioButton radiodate;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
	    search =(ImageButton)findViewById(R.id.search);
	    refresh=(ImageButton)findViewById(R.id.refresh);
	    radioname=(RadioButton)findViewById(R.id.radioname);
	    radiotaxi=(RadioButton)findViewById(R.id.radiotaxi);
	    radiodate=(RadioButton)findViewById(R.id.radiodate);
	    refresh.setOnClickListener(new OnClickListener() {
        	public void onClick(View v)
        	{
        	  radioname.setChecked(false);
        	  radiotaxi.setChecked(false);
        	  radiodate.setChecked(false);
        	  
        	}
        	});
	        search.setOnClickListener(new OnClickListener() {
        	public void onClick(View v)
        	{
        		if(radioname.isChecked())
        		{
        			Intent it = new Intent(search.this,sname.class);
        			startActivity(it);
        		}
        		if(radiotaxi.isChecked())
        		{
        			Intent it1=new Intent(search.this,staxi.class);
        			startActivity(it1);
        		}
        		if(radiodate.isChecked())
        		{
        			Intent it2 = new Intent(search.this,sdate.class);
        			startActivity(it2);
        		}
        	}
    	    });
         	
	}
	
}

	
	


