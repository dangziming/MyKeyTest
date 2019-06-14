package com.neostra.mykeytest;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AppAdapter extends BaseAdapter {
    private List<AppInfo> appData;
    private Context mContext;
    public AppAdapter(Context context, List<AppInfo> data){
        mContext = context;
        appData = data;
    }
    @Override
    public int getCount() {
        return appData.size();
    }

    @Override
    public Object getItem(int position) {
        return appData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = View.inflate(mContext,R.layout.app_item_main,null);
        }
        AppInfo appInfo = appData.get(position);
        ImageView appIcon = convertView.findViewById(R.id.app_icon);
        TextView appName = convertView.findViewById(R.id.app_name);

        appIcon.setImageDrawable(appInfo.getIcon());
        appName.setText(appInfo.getAppName());

        CheckBox checkBox = convertView.findViewById(R.id.app_cb);
        if(appData.get(position).isChecked()){
            checkBox.setChecked(true);
        }else {
            checkBox.setChecked(false);
        }
        return convertView;
    }
}
