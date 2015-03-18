package project.gps;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;



public class sname extends Activity{
	ImageButton prd;
	ImageButton bck;

	EditText customname;
	AlertDialog.Builder a= null;


	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sname);
        prd=(ImageButton)findViewById(R.id.prd);
        bck=(ImageButton)findViewById(R.id.bck);
        a= new AlertDialog.Builder(this);
       
        customname=(EditText)findViewById(R.id.customname);
 bck.setOnClickListener(new  android.view.View.OnClickListener() {
			
			public void onClick(View v) {
			Intent it= new Intent(sname.this,search.class);	
				startActivity(it);
			}
		});
     prd.setOnClickListener(new  android.view.View.OnClickListener() {
        
        
        
    	 public void onClick(View v) {
    		 String c= customname.getText().toString();
    		 if(c.equals(""))
				{
					a.setTitle("Entry missing!!");
					a.setMessage("It is mandatory to fill name field");
					a.setPositiveButton("ok", new OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
						
						}

						
					});
					AlertDialog alert = a.show();}
    		 else{
 			Intent it2= new Intent(sname.this,name.class);	
 			it2.putExtra("custom", c);	
 			startActivity(it2);
 			}}
 		});
        
        
        
        
        
	}
}
