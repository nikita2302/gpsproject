package project.gps;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;

public class sdate extends Activity {
	ImageButton proceed;
	ImageButton back;
	RadioButton radiodistance;
	RadioButton radiorecord;
	EditText date;
	AlertDialog.Builder a= null;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date);
        proceed=(ImageButton)findViewById(R.id.proceed);
        back=(ImageButton)findViewById(R.id.back);
        radiodistance=(RadioButton)findViewById(R.id.radiodistance);
        radiorecord=(RadioButton)findViewById(R.id.radiorecord);
        date=(EditText)findViewById(R.id.date);
        a= new AlertDialog.Builder(this);
        back.setOnClickListener(new android.view.View.OnClickListener() {
			
			public void onClick(View v) {
			Intent it= new Intent(sdate.this,search.class);	
				startActivity(it);
			}
		});
     proceed.setOnClickListener(new android.view.View.OnClickListener() {
			
			public void onClick(View v) {
				if(radiodistance.isChecked())
				{
					String d= date.getText().toString();
					if(d.equals(""))
					{
						a.setTitle("Entry missing!!");
						a.setMessage("It is mandatory to fill date field");
						a.setNegativeButton("ok", new OnClickListener() {
							
							public void onClick(DialogInterface dialog, int which) {
							
							}

							
						});
						AlertDialog alert = a.show();	
					}
					else{
					Intent it1= new Intent(sdate.this,distance.class);
			        it1.putExtra("01/01/01", d);
			        startActivity(it1);}
					}
				if(radiorecord.isChecked())
				{
					String d= date.getText().toString();
					if(d.equals(""))
					{
						a.setTitle("Entry missing!!");
						a.setMessage("You can not proceed without filling all the entries");
						a.setNegativeButton("ok", new OnClickListener() {
							
							public void onClick(DialogInterface dialog, int which) {
							
							}

							
						});
						AlertDialog alert = a.show();	
					}
					else
					{
			Intent it2= new Intent(sdate.this,record.class);	
			it2.putExtra("01/01/01", d);
			startActivity(it2);
				}}
			}
		});
}

}
