package com.example.kcs.airpollution_7_18;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by pabel on 2016-07-21.
 */

//json control class.managing all json parsing
public class jsonController {
    private JSONObject fakejsonObject =null;
    private String first_fakedata = null;
    private String middle_fakedata = null;
    private String end_fakedata = null;
    private JSONObject jsonObject = null;
    private JSONArray airdata = null;

    //Constructor
    public jsonController(String jsonFile, boolean flag) {
        try {
            if(flag)
                jsonFile = CreateFakeJsonFile();

            jsonObject = new JSONObject(jsonFile);
            jsonObject = jsonObject.getJSONObject("sensorData");
            airdata = jsonObject.getJSONArray("dataArray");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONArray getAirdata(){
        return airdata;
    }

    public JSONObject getJsonObject(){
        return jsonObject;
    }

    public String CreateFakeJsonFile(){
        int random[] = new int [7];
        String airdata[] = new String[7];

        for(int i=0; i<random.length; i++)
        {
            random[i] =  (int) (Math.random() * 501);
            airdata[i] = Integer.toString(random[i]);
        }

        first_fakedata =
                        "{\"sensorData\": {\n" +
                        "    \"totalRows\": \"1\",\n" +
                        "    \"dataArray\":[{";

        middle_fakedata =
                       "            \"time\": "+airdata[0]+",\n" +
                       "            \"co2\": "+airdata[1]+",\n" +
                       "            \"co\": "+airdata[2]+",\n" +
                       "            \"so2\": "+airdata[3]+",\n" +
                       "            \"no2\": "+airdata[4]+",\n" +
                       "            \"pm2.5\": "+airdata[5]+",\n" +
                       "            \"o3\": "+airdata[6];

        end_fakedata =
                        " }\n" +
                        "    ]\n" +
                        "\t},\n" +
                        "\t\"sensorInfo\": {\n" +
                        "\t\t\"name\": \"air sensor\"\n" +
                        "\t}\n" +
                        "}    ";

        return first_fakedata+middle_fakedata+end_fakedata;
    }
}
