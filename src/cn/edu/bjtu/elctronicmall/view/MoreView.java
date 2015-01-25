package cn.edu.bjtu.elctronicmall.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import cn.edu.bjtu.elctronicmall.R;
import cn.edu.bjtu.elctronicmall.global.GlobalData;
import cn.edu.bjtu.elctronicmall.manager.TitleManager;

/**
 * 更多功能界面
 * 
 * @author dong
 * 
 */
public class MoreView extends BaseView {

	public MoreView(Context context, Bundle bundle) {
		super(context, bundle);
		showView = (ViewGroup) View.inflate(context, R.layout.more, null);
		TitleManager.getInstance().setButtonText("返回");
		TitleManager.getInstance().setOneText("更多");
	}

	@Override
	public View getView(Context context) {
		// TODO Auto-generated method stub
		return showView;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return GlobalData.MOREVIEW;
	}

}