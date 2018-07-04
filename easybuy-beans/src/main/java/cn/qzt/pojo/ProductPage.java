package cn.qzt.pojo;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2617:27
 */
public class ProductPage {

    /**
     * 种类
     */
    private String category;
    /**
     * 最低价格
     */
    private Integer priceLow;
    /**
     * 最高价格
     */
    private Integer priceTall;


    /**
     * 排序条件
     */
    private String ramk;
    /**
     * 页码
     */
    private Integer pageNo=0;
    /**
     * 起始记录
     */

    private Integer pageStart;
    /**
     * 页容量
     */
    private Integer pageSize;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPriceLow() {
        return priceLow;
    }

    public void setPriceLow(Integer priceLow) {
        this.priceLow = priceLow;
    }

    public Integer getPriceTall() {
        return priceTall;
    }

    public void setPriceTall(Integer priceTall) {
        this.priceTall = priceTall;
    }

    public String getRamk() {
        return ramk;
    }

    public void setRamk(String ramk) {
        this.ramk = ramk;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
