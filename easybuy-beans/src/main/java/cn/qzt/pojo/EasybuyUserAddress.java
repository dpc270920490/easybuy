package cn.qzt.pojo;
import java.io.Serializable;
import java.util.Date;
/***
*   EasybuyUserAddress
*
*
*
*/
public class EasybuyUserAddress implements Serializable {
        /**
        *主键id
        */
        private Integer id;
        /**
        *用户主键
        */
        private Integer userId;
        /**
        *地址
        */
        private String address;
        /**
        *创建时间
        */
        private Date createTime;
        /**
        *是否是默认地址（1:是 0否）
        */
        private Integer isDefault;
        /**
        *备注
        */
        private String remark;
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
            public void setAddress (String  address){
                this.address=address;
            }
            public  String getAddress(){
                return this.address;
            }
            public void setCreateTime (Date  createTime){
                this.createTime=createTime;
            }
            public  Date getCreateTime(){
                return this.createTime;
            }
            public void setIsDefault (Integer  isDefault){
                this.isDefault=isDefault;
            }
            public  Integer getIsDefault(){
                return this.isDefault;
            }
            public void setRemark (String  remark){
                this.remark=remark;
            }
            public  String getRemark(){
                return this.remark;
            }
}
