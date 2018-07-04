package cn.qzt.pojo;
import java.io.Serializable;
import java.util.Date;
/***
*   EasybuyUser
*
*
*
*/
public class EasybuyUser implements Serializable {
        /**
        *主键
        */
        private Integer id;
        /**
        *登录名
        */
        private String loginName;
        /**
        *用户名
        */
        private String userName;
        /**
        *密码
        */
        private String password;
        /**
        *性别(1:男 0：女)
        */
        private Integer sex;
        /**
        *身份证号
        */
        private String identityCode;
        /**
        *邮箱
        */
        private String email;
        /**
        *手机
        */
        private String mobile;
        /**
        *类型（1：后台 0:前台）
        */
        private Integer type;
        /**
        *get and set
        */
            public void setId (Integer  id){
                this.id=id;
            }
            public  Integer getId(){
                return this.id;
            }
            public void setLoginName (String  loginName){
                this.loginName=loginName;
            }
            public  String getLoginName(){
                return this.loginName;
            }
            public void setUserName (String  userName){
                this.userName=userName;
            }
            public  String getUserName(){
                return this.userName;
            }
            public void setPassword (String  password){
                this.password=password;
            }
            public  String getPassword(){
                return this.password;
            }
            public void setSex (Integer  sex){
                this.sex=sex;
            }
            public  Integer getSex(){
                return this.sex;
            }
            public void setIdentityCode (String  identityCode){
                this.identityCode=identityCode;
            }
            public  String getIdentityCode(){
                return this.identityCode;
            }
            public void setEmail (String  email){
                this.email=email;
            }
            public  String getEmail(){
                return this.email;
            }
            public void setMobile (String  mobile){
                this.mobile=mobile;
            }
            public  String getMobile(){
                return this.mobile;
            }
            public void setType (Integer  type){
                this.type=type;
            }
            public  Integer getType(){
                return this.type;
            }
}
