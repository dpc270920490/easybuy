package cn.qzt.pojo;
import java.io.Serializable;
/***
*   EasybuyOrderDetail
*
*
*
*/
public class EasybuyOrderDetail implements Serializable {
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
        *get and set
        */
            public void setId (Integer  id){
                this.id=id;
            }
            public  Integer getId(){
                return this.id;
            }
            public void setOrderId (Integer  orderId){
                this.orderId=orderId;
            }
            public  Integer getOrderId(){
                return this.orderId;
            }
            public void setProductId (Integer  productId){
                this.productId=productId;
            }
            public  Integer getProductId(){
                return this.productId;
            }
            public void setQuantity (Integer  quantity){
                this.quantity=quantity;
            }
            public  Integer getQuantity(){
                return this.quantity;
            }
            public void setCost (String  cost){
                this.cost=cost;
            }
            public  String getCost(){
                return this.cost;
            }
}
