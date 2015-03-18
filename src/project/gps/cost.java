package project.gps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class cost extends Activity{
	Double distance;
	Double dist;
	EditText fcost;
	EditText ncost;
	EditText tcost;
	Float total_cost;
	float fc;
	float nc;
	ImageButton cost;
	 String s2;
	 String s_loc;
	 String d_loc;
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.cost);
	        cost=(ImageButton)findViewById(R.id.cost);
	        Intent it= getIntent();
            s2=it.getStringExtra(""+1000);
           // s_loc=getStringExtra("namesloc");
           // System.out.println(s_loc);
            //d_loc=getStringExtra("namedloc");
            //System.out.println(d_loc);
            System.out.println(s2);
	        dist=Double.valueOf(s2.trim()).doubleValue();
	        distance=(((dist)/(1000))-(1));
	        fcost=(EditText)findViewById(R.id.fcost);
	        ncost=(EditText)findViewById(R.id.ncost);
	        tcost=(EditText)findViewById(R.id.tcost);
	        cost.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
                     String fcst=fcost.getText().toString();
	                 String ncst=ncost.getText().toString();
	                 System.out.println(fcst+"    "+ncst);
	                 final float fc=Float.parseFloat(fcst);
	                 final float nc=Float.parseFloat(ncst);
	        	     total_cost=(float) (fc+(nc*distance));
			         tcost.setText(""+total_cost);	
			         Intent it1= new Intent(cost.this,database.class);
				String tcost1=""+total_cost;
						it1.putExtra( "cos",tcost1);
						it1.putExtra("distan",s2);
						//it1.putExtra("st_loc",s_loc);
						//it1.putExtra("des_loc", d_loc);
						startActivity(it1); 
				}
			});
}
	private String getStringExtra(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
