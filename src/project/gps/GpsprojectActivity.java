package project.gps;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.List;


import android.app.ProgressDialog;

import android.content.Context;

import android.content.Intent;
import android.content.res.AssetManager;

import android.graphics.drawable.Drawable;

import android.location.Address;

import android.location.Geocoder;

import android.location.Location;

import java.util.Locale;

import android.location.LocationListener;

import android.location.LocationManager;

import android.os.Bundle;
import android.os.Handler;

import android.provider.Settings;
import android.view.View;

import android.view.View.OnClickListener;

import android.view.View.OnLongClickListener;

import android.widget.Button;
import android.widget.ImageButton;

import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;

import android.widget.SlidingDrawer.OnDrawerOpenListener;

import android.widget.Toast;


import com.google.android.maps.GeoPoint;

import com.google.android.maps.MapActivity;

import com.google.android.maps.MapController;

import com.google.android.maps.MapView;

import com.google.android.maps.OverlayItem;


public class GpsprojectActivity  extends MapActivity  {
  	
ImageButton btnslider=null;
	ImageButton btngps=null;
	
ImageButton start_loc=null;
	ImageButton des_loc=null;

	
    ImageButton distance=null;
    ImageButton search=null;

    ImageButton cost=null;
	private MapController mapController;

	
private MapView mapView;
	private LocationManager locationManager;

	private Location location;
	private Myoverlays itemizedoverlay;

    double cur_latitude;
    double cur_longitude;
    double des_latitude;
    double des_longitude;
	
protected ProgressDialog pdDialog;
    double dist;
    List<Address> myList;
    List<Address> myList1;
    String sgeo;
    String dgeo;
	
 
   public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        copyAssets();
     btnslider=(ImageButton) findViewById(R.id.btnHandle);
  
   
        btngps=(ImageButton) findViewById(R.id.btngps);
      
  start_loc=(ImageButton) findViewById(R.id.start_loc);
     
   des_loc=(ImageButton) findViewById(R.id.des_loc);
     
   distance=(ImageButton)findViewById(R.id.distance);
   
     search=(ImageButton)findViewById(R.id.search);
      
  cost=(ImageButton)findViewById(R.id.cost);
      
  final SlidingDrawer sd=(SlidingDrawer) findViewById(R.id.slider);
    
    
        locationManager=(LocationManager) this.getSystemService(LOCATION_SERVICE);
   
     locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0,0, new GeoUpdateHandler());
       

	
		des_loc.setVisibility(View.GONE);
	
	distance.setVisibility(View.GONE);
		
	
	cost.setVisibility(View.GONE);
        
sd.setOnDrawerOpenListener(new OnDrawerOpenListener() {
	
public void onDrawerOpened() {
				
btngps.setVisibility(View.GONE);
	
start_loc.setVisibility(View.GONE);

des_loc.setVisibility(View.GONE);

distance.setVisibility(View.GONE);
			
				
search.setVisibility(View.GONE);
				
cost.setVisibility(View.GONE);
			}
		});
       
 sd.setOnDrawerCloseListener(new OnDrawerCloseListener() {
			

			
public void onDrawerClosed() {
				

btngps.setVisibility(View.VISIBLE);
				
start_loc.setVisibility(View.VISIBLE);
				
start_loc.setClickable(true);
				
search.setVisibility(View.VISIBLE);
				
des_loc.setClickable(true);
				
				
distance.setClickable(true);
				
				
search.setClickable(true);
				
				
cost.setClickable(true);
			}
		});
      
 btngps.setOnClickListener(new OnClickListener() {
        	
public void onClick(View v)
        	{
        		
sd.open();
        		}
        	});
       
search.setOnClickListener(new OnClickListener() {
       	
public void onClick(View v)
       	{
           Intent it = new Intent(GpsprojectActivity.this,search.class);
        
   startActivity(it);
       		}
       	});
       
 btngps.setOnLongClickListener(new OnLongClickListener() {
			
			
public boolean onLongClick(View v) {
				
sd.close();
				
return false;
			}
		});

        
        
       
 start_loc.setOnClickListener(new OnClickListener() {
			
			
public void onClick(View v) {
			
 location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			 
System.out.println("Location="+location);
			
			
 if(location!=null)
				{
				  
				
 System.out.println("LocaTION="+location);
	          
  cur_latitude= location.getLatitude();
	         
   cur_longitude= location.getLongitude();
	          
 Toast.makeText(GpsprojectActivity.this, "Location::"+location.getLatitude()+""+location.getLongitude(), Toast.LENGTH_LONG).show();
			    	
des_loc.setVisibility(View.VISIBLE);
			    	
start_loc.setClickable(false);
			    	
			    	
				
}
			else
			{
				
				
System.out.println(" Location not found");
				
Toast.makeText(GpsprojectActivity.this, "Location not found", Toast.LENGTH_LONG).show();
				
des_loc.setVisibility(View.VISIBLE);
		    	
start_loc.setClickable(false);
			}
			 
		
}
			 
			 
		});
		
des_loc.setOnClickListener(new OnClickListener() {

			
public void onClick(View v) {
				
location = locationManager
.getLastKnownLocation(LocationManager.GPS_PROVIDER);
				

System.out.println("LocaTION=" + location);
				
if (location != null) {
					
Toast.makeText(GpsprojectActivity.this,"Location::" + location.getLatitude() + ""+ location.getLongitude(),Toast.LENGTH_LONG).show();
					des_latitude = location.getLatitude();
					des_longitude = location.getLongitude();
					
					distance.setVisibility(View.VISIBLE);
			    	des_loc.setClickable(false);
			    	 
				} else { 
					
					System.out.println("location not found");
					Toast.makeText(GpsprojectActivity.this,
							"Location not found", Toast.LENGTH_LONG).show();
					distance.setVisibility(View.VISIBLE);
			    	des_loc.setClickable(false);

				}
			}
		});
     
      distance.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
		
			   distance();
			   cost.setVisibility(View.VISIBLE);
		    	distance.setClickable(false);
						}
					});
      cost.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			Intent it= new Intent(GpsprojectActivity.this,cost.class);
			
			String s=""+1000;
			String s1=""+dist;
			it.putExtra( s,s1);
			
			startActivity(it);
			
		
}
	});
        // showCurrentLocation();
       
 mapView = (MapView) findViewById(R.id.mapview);
        
		
mapView.setBuiltInZoomControls(true);
		// Either satellite or 2d 
		
mapView.setSatellite(true);
		
mapController = mapView.getController();
		
mapController.setZoom(18); // Zoom 1 is world view
		
locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
boolean enabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
		
if (!enabled) {
			 
 Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
				
startActivity(intent);
			}
		
else{
		
locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,0, new GeoUpdateHandler());

		
Drawable drawable = this.getResources().getDrawable(R.drawable.point2);
		
itemizedoverlay = new Myoverlays(drawable);
		
createMarker();
		}
    }

    
   
 
protected boolean isRouteDisplayed() {
	
return false;
}


public class GeoUpdateHandler implements LocationListener {

	
public void onLocationChanged(Location loc) {
		
System.out.println("function called");
		
location = loc;
		
int lat = (int) (location.getLatitude() * 1E6);
		
int lng = (int) (location.getLongitude() * 1E6);
		
GeoPoint point = new GeoPoint(lat, lng);
		
createMarker();
				
mapController.animateTo(point); // mapController.setCenter(point);

	}

	
	
public void onProviderDisabled(String provider) {
	}

	
	
public void onProviderEnabled(String provider) {
	}

	
	
public void onStatusChanged(String provider, int status, Bundle extras) {

	}
}

private void createMarker() {
	
GeoPoint p = mapView.getMapCenter();
	
OverlayItem overlayitem = new OverlayItem(p, "", "");
	
itemizedoverlay.addOverlay(overlayitem);
	
mapView.getOverlays().add(itemizedoverlay);
}
 

void distance()
{
   
 Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
  
  float result[]=new float[5];
    location.distanceBetween(cur_latitude, cur_longitude, des_latitude, des_longitude, result);
   
 System.out.println(result[0]);
    dist=result[0];
    
 
   Toast.makeText(GpsprojectActivity.this, ""+result[0], Toast.LENGTH_LONG).show();
    
}
private void copyAssets()
{
	
	AssetManager assetManager = getAssets(); 
	String[] files = null;
	    try {
	        files = assetManager.list("");
	        String  s=files[0];
	        } 
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	    for(String s : files)
	    {
	    	InputStream in = null;
	        OutputStream out = null;
	        try {
	            in = assetManager.open(s);
	            out = new FileOutputStream("/sdcard/" + s);
	            copyFile(in, out);
	            in.close();
	            in = null;
	            out.flush();
	            out.close();
	            out = null;
	          }catch(Exception e) {
	             
	          }       
	      }
	  }
	  private void copyFile(InputStream in, OutputStream out) throws IOException {
	      byte[] buffer = new byte[1024];
	      int read;
	      while((read = in.read(buffer)) != -1){
	        out.write(buffer, 0, read);
	      }
	  }
}