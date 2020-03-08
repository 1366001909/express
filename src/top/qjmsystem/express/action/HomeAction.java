package top.qjmsystem.express.action;

//主页action
public class HomeAction {
	// 返回逻辑视图名，由他决定跳转哪个页面
	public String frame() {

		// 返回后台主模块主界面
		return "frame";
	}

	public String top() {
		// 返回后台主模块顶部部分
		return "top";
	}

	public String left() {
		// 返回后台主模块左侧部分
		return "left";
	}
}
