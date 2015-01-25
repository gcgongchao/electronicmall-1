package cn.edu.bjtu.elctronicmall.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import cn.edu.bjtu.elctronicmall.GloableParams;
import cn.edu.bjtu.elctronicmall.R;
import cn.edu.bjtu.elctronicmall.adapter.PanicBuyingAdapter;
import cn.edu.bjtu.elctronicmall.bean.Good;
import cn.edu.bjtu.elctronicmall.dao.GoodDao;
import cn.edu.bjtu.elctronicmall.global.GlobalData;
import cn.edu.bjtu.elctronicmall.manager.TitleManager;

public class PanicBuyingView extends BaseView {

	private ListView lv_panic_buying;
	// private static final String path =
	// "/data/data/cn.edu.bjtu.electronicmall/files/ec.db";
	private SQLiteDatabase database;
	private GoodDao dao;
	private int CATEGORYID_PANICCBUY = 1;
	// 存放所有查询到的good
	private List<Good> panicGoods = new ArrayList<Good>();

	/**
	 * 限时抢购
	 * 
	 * @param context
	 */
	public PanicBuyingView(Context context, Bundle bundle) {
		super(context, bundle);
		showView = (ViewGroup) View.inflate(context, R.layout.panic_buying,
				null);
		// 设置标题的信息
		TitleManager.getInstance().setOneText("限时抢购");
		TitleManager.getInstance().setButtonText("返回");
		database = SQLiteDatabase.openDatabase(GloableParams.PATH, null,
				SQLiteDatabase.OPEN_READONLY);
		dao = new GoodDao(context);
		initView();
	}

	/**
	 * 初始化操作
	 */
	private void initView() {
		lv_panic_buying = (ListView) showView
				.findViewById(R.id.lv_panic_buying);
		panicGoods = dao.findGoodByCategory(database, CATEGORYID_PANICCBUY);
		PanicBuyingAdapter adapter = new PanicBuyingAdapter(panicGoods, context);
		lv_panic_buying.setAdapter(adapter);
	}

	@Override
	public View getView(Context context) {
		// TODO Auto-generated method stub
		return showView;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return GlobalData.PANICBUYINGVIEW;
	}
}