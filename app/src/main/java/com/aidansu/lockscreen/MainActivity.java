package com.aidansu.lockscreen;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.Intent;
import android.os.Bundle;
/**
 * @className MainActivity.java
 * @classDescription 锁屏主界面
 * @author AIDAN SU
 * @ceateTime 2014-6-12
 *
 */
public class MainActivity extends Activity {

	private DevicePolicyManager devicePolicyManager=null;
	private static final int REQUEST_CODE_ADD_DEVICE_ADMIN=100;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 设备安全管理服务    2.2之前的版本是没有对外暴露的 只能通过反射技术获取
		devicePolicyManager = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
		boolean isAdminActive = devicePolicyManager.isAdminActive(Dar.getCn(this));

		if (isAdminActive) {
			// 锁屏
			devicePolicyManager.lockNow();
			finish();
		}else{
			startAddDeviceAdminAty();
		}
	}

	private void startAddDeviceAdminAty(){
		String info = getResources().getString(R.string.info);
		Intent i = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
		i.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,Dar.getCn(this));
		i.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,info);
		startActivityForResult(i, REQUEST_CODE_ADD_DEVICE_ADMIN);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (resultCode==Activity.RESULT_OK) {
			devicePolicyManager.lockNow();
		}
		finish();
		super.onActivityResult(requestCode, resultCode, data);
	}

}
