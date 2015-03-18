package project.gps;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class database extends Activity {
	    EditText tdph_no=null;
		EditText tdname=null;
		EditText tno=null;
		EditText startloc=null;
		EditText desloc=null;
		EditText cname=null;
		EditText date=null;
		EditText diste=null;
		EditText ccost= null;
		ImageButton submit;
		
		
		DB1 db;
		AlertDialog.Builder a= null;
		String dist2;
		String cost2;
		String sloc;
		String dloc;
	    public void onCreate(Bundle savedInstanceState) 
	    {
	        
	    	super.onCreate(savedInstanceState);
	        setContentView(R.layout.database);
	       Intent it1= getIntent();
	        dist2=it1.getStringExtra("distan");
	     
	        cost2=it1.getStringExtra("cos");
	      
	       
	       
	        
	        submit=(ImageButton) findViewById(R.id.submit); 
	        tdph_no=(EditText)findViewById(R.id.ph_no);
	        tdname=(EditText)findViewById(R.id.tname);
	        tno=(EditText)findViewById(R.id.tno);
	        startloc=(EditText)findViewById(R.id.sloc);
	        desloc=(EditText)findViewById(R.id.dloc);
	        cname=(EditText)findViewById(R.id.cname);
	        date=(EditText)findViewById(R.id.date);
	        diste=(EditText)findViewById(R.id.diste);
	        ccost=(EditText)findViewById(R.id.ccost);
	       diste.setText(dist2);
			ccost.setText(cost2);
	        
	        a= new AlertDialog.Builder(this);
	        
 
	        submit.setOnClickListener( new android.view.View.OnClickListener() {
				
				public void onClick(View v) {
					String tdphno=tdph_no.getText().toString();
					String tname = tdname.getText().toString();
					String tano=tno.getText().toString();
					String start_loc = startloc.getText().toString();
					String des_loc = desloc.getText().toString();
					String cname1 = cname.getText().toString();
					String date1 = date.getText().toString();
					
					if(tdphno.equals("")||tname.equals("")||tano.equals("")||start_loc.equals("")||des_loc.equals("")||cname1.equals("")||date1.equals(""))
					{
						
					
						a.setTitle("Entry missing!!");
						a.setMessage("You can not proceed without filling all the entries");
						a.setNegativeButton("ok", new OnClickListener() {
							
							public void onClick(DialogInterface dialog, int which) {
							
							}

							
						});
						AlertDialog alert = a.show();	
					}
					else{
						db=new DB1();
						db.insertMyDb(tdphno,tname,tano,start_loc,des_loc,cname1,date1,dist2,cost2);
						tdph_no.setText("");
						tdname.setText("");
						tno.setText("");
						startloc.setText("");
						desloc.setText("");
						cname.setText("");
						date.setText("");
						diste.setText("");
						ccost.setText("");
						Toast.makeText(database.this, "data entered", 5000).show();
						}
					
			        a.setPositiveButton("OK", new OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
												
						}
					});
					
					
					
					
				}
			});

	    }
	

}
