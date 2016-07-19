package com.example.kcs.airpollution_7_18;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private ViewPager mPager;
    private boolean sensorflag = true;
    private String SensorName = "sensordata.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_sensor).setOnClickListener(mClickListener);
        AirSetUp();
    }

    //Read JSON File.
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open(SensorName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    //Button Listener
    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View view_main) {
            TextView Sensor=(TextView)findViewById(R.id.btn_sensor);
            switch (view_main.getId()) {
                case R.id.btn_sensor:
                    if(sensorflag) {
                        Sensor.setText("SensorData2");
                        SensorName = "sensordata2.json";
                        sensorflag = false;
                    }
                    else {
                        Sensor.setText("SensorData");
                        SensorName = "sensordata.json";
                        sensorflag = true;
                    }
                    AirSetUp();
                    break;
            }
        }
    };

    //Set airdata and PagerAdapter
    public void AirSetUp(){
        try
        {
            JSONObject jsonObject = new JSONObject(loadJSONFromAsset());
            jsonObject = jsonObject.getJSONObject("sensorData");
            JSONArray airdata = jsonObject.getJSONArray("dataArray");

            mPager= (ViewPager)findViewById(R.id.pager);
            mPager.setAdapter(new PA(getLayoutInflater(), airdata));
            mPager.setCurrentItem(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
