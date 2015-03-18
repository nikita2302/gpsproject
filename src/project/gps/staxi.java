package project.gps;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;



public class staxi extends Activity{
	ImageButton procd;
	ImageButton beck;

	EditText taxinum;


	AlertDialog.Builder a= null;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staxi);
        procd=(ImageButton)findViewById(R.id.procd);
        beck=(ImageButton)findViewById(R.id.beck);
        a= new AlertDialog.Builder(this);
        taxinum=(EditText)findViewById(R.id.taxinum);
 beck.setOnClickListener(new android.view.View.OnClickListener() {
			
			public void onClick(View v) {
			Intent it= new Intent(staxi.this,search.class);	
				startActivity(it);
			}
		});
     procd.setOnClickListener(new android.view.View.OnClickListener() {
        
        
        
    	 public void onClick(View v) {
    		 String t= taxinum.getText().toString();
    		 
    		 if(t.equals(""))
				{
					a.setTitle("Entry missing!!");
					a.setMessage("It is mandatory to fill taxi no. field");
					a.setPositiveButton("ok", new OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
						
						}

						
					});
					AlertDialog alert = a.show();}
    		 else
    		 {
 			Intent it3= new Intent(staxi.this,taxi.class);	
 			it3.putExtra("taxi", t);	
 			startActivity(it3);
 			}}
 		});
        
        
        
        
        
	}
}

