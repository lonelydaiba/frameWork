package daily.framework.util.dubbo;

import java.util.List;

/**
 * 分页查询结果
 *
 */
public class PageModel<T> {

	/** 总数 */
	private int count;
	
	/** 当前页查询的数据列表 */
	private List<T> datas;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
}
