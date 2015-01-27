package cn.edu.bjtu.elctronicmall.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import cn.edu.bjtu.elctronicmall.R;
import cn.edu.bjtu.elctronicmall.global.GlobalData;
import cn.edu.bjtu.elctronicmall.manager.UIManager;

public class MyAccountView extends BaseView {

	private Button btn_myebuy_login;

	public MyAccountView(Context context, final Bundle bundle) {
		super(context, bundle);
		showView = (ViewGroup) View.inflate(context, R.layout.myaccount, null);
		btn_myebuy_login = (Button) showView
				.findViewById(R.id.btn_myebuy_login);
		btn_myebuy_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				UIManager.getInstance().changeVew(LoginView.class, bundle);

			}
		});
		// 地址管理
		RelativeLayout rl_addressmanager = (RelativeLayout) showView
				.findViewById(R.id.rl_addressmanager);
		// 进入地址页面
		rl_addressmanager.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (GlobalData.LOGIN_SUCCES == -1) {
					UIManager.getInstance().changeVew(LoginView.class, bundle);
				} else {
					UIManager.getInstance()
							.changeVew(AddressView.class, bundle);
				}
			}
		});
	}

	@Override
	public View getView(Context context) {
		// TODO Auto-generated method stub
		return showView;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return GlobalData.MYACCOUNTVIEW;
	}

}
