package br.com.mobideas.postfacebook;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.auth.FacebookHandle;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

public class MainActivity extends Activity {
	AQuery a;
	FacebookHandle handle;
	static String PERMISSIONS = "read_stream,read_friendlists,manage_friendlists,manage_notifications,publish_stream,publish_checkins,offline_access,user_photos,user_likes,user_groups,friends_photos";
	String APP_ID = "602936446384967";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = new AQuery(this);
        a.id(R.id.btPost).clickable(true).clicked(this, "autenticar");
    }
    
	public void autenticar(){
        handle = new FacebookHandle(this, APP_ID, PERMISSIONS);
        String url = "https://graph.facebook.com/me/feed";
        a.auth(handle).progress(R.id.progress).ajax(url, JSONObject.class, this, "post");
	}
	
    public void post(){
        String url = "https://graph.facebook.com/me/feed";
        
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("access_token", handle.getToken());
        params.put("message", "Estou participando do Hackathon Sesc Santo André ! #changebrazil (Postando da minha app Android)");
        
        a.ajax(url, params, JSONObject.class, new AjaxCallback<JSONObject>() {

            @Override
            public void callback(String url, JSONObject json, AjaxStatus status) {
                show(json);
            }
        });
    }
    

    
    public void show(JSONObject json){
    	Toast.makeText(this, json==null?"Erro. Json null":json.toString(), Toast.LENGTH_LONG).show();
    }
    
}
