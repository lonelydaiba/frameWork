package daily.framework.request;

import java.io.Serializable;

import io.swagger.annotations.ApiParam;

/**
 * ClassName:BaseQuery
 *
 * 使用Mybatis-PageHelper分页插件
 * @version 1.0
 * @since v1.0
 */

public class BaseQuery implements Serializable{
    /**
     * serialVersionUID:
     *
     * @since v1.0
     */

    private static final long serialVersionUID = 7083388456236015798L;
    @ApiParam(value="页码,从1开始",required=true,defaultValue="1")
    private Integer pageNo;
    @ApiParam(value="每页显示数量",required=true,defaultValue="10")
    private Integer pageSize;
    @ApiParam(hidden=true,value="排序")
    private String orderBy;

    private static final Integer DEFAULT_PAGENUM = 1;
    private static final Integer DEFAULT_PAGESIZE = 10;

    public static final Integer ONLY_COUNT = -1;//如果只查询数量，设置pageSize为当前值

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        if(pageSize==null){
            return DEFAULT_PAGESIZE;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        if(pageNo==null || pageNo<1){
            return DEFAULT_PAGENUM;
        }
        return pageNo;
    }

}
