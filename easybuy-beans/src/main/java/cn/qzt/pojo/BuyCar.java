package cn.qzt.pojo;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2916:49
 */
public class BuyCar {


    /**
     *主键
     */
    private Integer id;
    /**
     *订单主键
     */
    private Integer orderId;
    /**
     *商品主键
     */
    private Integer productId;
    /**
     *数量
     */
    private Integer quantity;
    /**
     *消费
     */
    private String cost;

    /**
     * 商品名称
     */
    private String productName;
    /**
     *商品单价
     */
    private String productPrice;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
