package com.aidansu.lockscreen;

import android.app.admin.DeviceAdminReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
/**
 * @className DeviceAdminReceiver.java
 * @classDescription 获取管理员权限服务
 * @author AIDAN SU
 * @ceateTime 2014-6-12
 *
 */
public class Dar extends DeviceAdminReceiver{

	public static ComponentName getCn(Context context){
		return new ComponentName(context, Dar.class);
	}

	@Override
	public void onEnabled(Context context, Intent intent) {
		super.onEnabled(context, intent);
	}

	@Override
	public void onDisabled(Context context, Intent intent) {
		super.onDisabled(context, intent);
	}
}
