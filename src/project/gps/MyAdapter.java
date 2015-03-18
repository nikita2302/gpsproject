package project.gps;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

public class MyAdapter extends ArrayAdapter<bean> {

	Context ctx;
	ArrayList<bean> namelist=null;
	bean b=null;
	EditText et=null;
	EditText et2=null;
	EditText et3=null;
	
	public MyAdapter(Context context, int textViewResourceId,ArrayList<bean> objects) 
	{
		super(context, textViewResourceId, objects);
		namelist = (ArrayList<bean>)objects ;
		
		ctx=context;
	}
	public int getCount()
	{             
		return namelist.size();
		
	}
	
	public View getView(int position,View convertView,ViewGroup parent)
	{  
		
		@SuppressWarnings("static-access")
		LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
         convertView = inflater.inflate(R.layout.listrow, null);
         if(convertView!=null)
     	{
        	 bean be=namelist.get(position);
        	 et=(EditText) convertView.findViewById(R.id.name);
        	 et2=(EditText) convertView.findViewById(R.id.taxi);
        	 et3=(EditText) convertView.findViewById(R.id.taxidrivername);
             et.setText(be.getCustomername());
        	 et2.setText(be.getTaxino());
        	 et3.setText(be.getTaxidrivername());
          	}
              
         return convertView;
	}


}
