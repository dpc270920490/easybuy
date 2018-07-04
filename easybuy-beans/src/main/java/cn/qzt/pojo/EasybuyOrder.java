package cn.qzt.pojo;
import java.io.Serializable;
import java.util.Date;
/***
*   EasybuyOrder
*
*
*
*/
public class EasybuyOrder implements Serializable {
        /**
        *主键
        */
        private Integer id;
        /**
        *用户主键
        */
        private Integer userId;
        /**
        *
        */
        private String loginName;
        /**
        *用户地址
        */
        private String userAddress;
        /**
        *创建时间
        */
        private Date createTime;
        /**
        *总消费
        */
        private String cost;
        /**
        *订单号
        */
        private String serialNumber;


        private Integer isPlace;


    public Integer getIsPlace() {
        return isPlace;
    }

    public void setIsPlace(Integer isPlace) {
        this.isPlace = isPlace;
    }

    /**
        *get and set
        */


            public void setId (Integer  id){
                this.id=id;
            }
            public  Integer getId(){
                return this.id;
            }
            public void setUserId (Integer  userId){
                this.userId=userId;
            }
            public  Integer getUserId(){
                return this.userId;
            }
            public void setLoginName (String  loginName){
                this.loginName=loginName;
            }
            public  String getLoginName(){
                return this.loginName;
            }
            public void setUserAddress (String  userAddress){
                this.userAddress=userAddress;
            }
            public  String getUserAddress(){
                return this.userAddress;
            }
            public void setCreateTime (Date  createTime){
                this.createTime=createTime;
            }
            public  Date getCreateTime(){
                return this.createTime;
            }
            public void setCost (String  cost){
                this.cost=cost;
            }
            public  String getCost(){
                return this.cost;
            }
            public void setSerialNumber (String  serialNumber){
                this.serialNumber=serialNumber;
            }
            public  String getSerialNumber(){
                return this.serialNumber;
            }
}
