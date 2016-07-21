package com.example.kcs.airpollution_7_18;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pabel on 2016-07-21.
 */
public class realtimeDataFragment extends Fragment {

    TextView tv_co_val;
    TextView tv_co2_val;
    TextView tv_no2_val;
    TextView tv_so2_val;
    TextView tv_pm_val;
    TextView tv_o3_val;
    ImageView iv_current_AQI;
    JSONObject jsonObj;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        final View view = inflater.inflate(R.layout.airpollutionpable_data,container,false);

        //tv_co2_val = (TextView)view.findViewById(R.id.tv_co2_val);
        //tv_time_val = (TextView)view.findViewById(R.id.tv_time_val);
        tv_co_val = (TextView)view.findViewById(R.id.tv_co_val);
        tv_co2_val = (TextView)view.findViewById(R.id.tv_co2_val);
        tv_no2_val = (TextView)view.findViewById(R.id.tv_no2_val);
        tv_so2_val = (TextView)view.findViewById(R.id.tv_so2_val);
        tv_pm_val = (TextView)view.findViewById(R.id.tv_pm2_5_val);
        tv_o3_val = (TextView)view.findViewById(R.id.tv_o3_val);
        iv_current_AQI = (ImageView)view.findViewById(R.id.iv_current_AQI);
        return view;
    }
    public void setTextView(JSONObject obj){
        try
        {
            //JSONObject obj = jsonArray.getJSONObject(position);
            //tv_time_val.setText(obj.getString("time"));
            tv_co_val.setText(obj.getString("co"));
            tv_co2_val.setText(obj.getString("co2"));
            tv_so2_val.setText(obj.getString("so2"));
            tv_no2_val.setText(obj.getString("no2"));
            tv_pm_val.setText(obj.getString("pm2.5"));
            tv_o3_val.setText(obj.getString("o3"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
