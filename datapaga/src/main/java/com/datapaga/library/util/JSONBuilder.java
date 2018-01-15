package com.datapaga.library.util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 12/12/2017.
 * https://www.linkedin.com/in/icarloscornejo
 */

/**
 * A custom class for quick building JSON's.
 */
public class JSONBuilder {

    private JSONObject mJSON;
    private String[] mKeys;

    public JSONBuilder() {
        mJSON = new JSONObject();
    }

    public JSONBuilder(JSONObject mJSON) {
        this.mJSON = mJSON;
    }

    public void add(String key, Object value) {
        try {
            mJSON.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONBuilder keys(String... keys){
        this.mKeys = keys;
        return this;
    }

    public JSONObject values(Object... values){
        for(int i = 0; i < mKeys.length; i++){
            add(mKeys[i], values[i]);
        }

        return mJSON;
    }

    public JSONObject getJSON() {
        return mJSON;
    }

    public JSONObject toJson(String json) {
        try {
            mJSON = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mJSON;
    }
}
