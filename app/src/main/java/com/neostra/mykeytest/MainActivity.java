package com.neostra.mykeytest;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.provider.Settings;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView appList;
    private AppAdapter appAdapter;
    private List<AppInfo> appDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_list_main);
        appList = findViewById(R.id.app_list);
        appDate = getAllAppInfos();
        appAdapter = new AppAdapter(MainActivity.this,appDate);
        appList.setAdapter(appAdapter);
        appList.setOnItemClickListener(onItemClickListener);
        initStatus();
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            for (AppInfo appInfo : appDate) {//全部设为未选中
                appInfo.setChecked(false);
            }
            appDate.get(position).setChecked(true);
            appAdapter.notifyDataSetChanged();
            Log.d("dzm","package name = " + appDate.get(position).getPackageName());
            //startAPP(appDate.get(position).getPackageName());
            //Settings.System.putString(getContentResolver(), "keyA", appDate.get(position).getPackageName());
            //String packageName = Settings.System.getString(getContentResolver(),"keyA");
            //Log.d("dzm","package name = " + packageName);
        }
    };

    public void startAPP(String appPackageName) {
        Intent intent = this.getPackageManager().getLaunchIntentForPackage(appPackageName);
        startActivity(intent);
    }

    private void initStatus(){
        for (AppInfo appInfo : appDate) {//全部设为未选中
            appInfo.setChecked(false);
        }
        appDate.get(0).setChecked(true);
        appAdapter.notifyDataSetChanged();
    }

    protected List<AppInfo> getAllAppInfos() {
        List<AppInfo> list = new ArrayList<AppInfo>();
        PackageManager packageManager = getPackageManager();
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> ResolveInfos = packageManager.queryIntentActivities(intent, 0);
        for (ResolveInfo ri : ResolveInfos) {
            String packageName = ri.activityInfo.packageName;
            Drawable icon = ri.loadIcon(packageManager);
            String appName = ri.loadLabel(packageManager).toString();
            AppInfo appInfo = new AppInfo(icon, appName, packageName);
            list.add(appInfo);
        }
        return list;
    }
}
