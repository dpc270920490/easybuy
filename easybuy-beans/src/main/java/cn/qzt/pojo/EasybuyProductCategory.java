package cn.qzt.pojo;
import java.io.Serializable;
import java.util.Date;
/***
*   EasybuyProductCategory
*
*
*
*/
public class EasybuyProductCategory implements Serializable {
        /**
        *主键
        */
        private Integer id;
        /**
        *名称
        */
        private String name;
        /**
        *父级目录id
        */
        private Integer parentId;
        /**
        *级别(1:一级 2：二级 3：三级)
        */
        private Integer type;
        /**
        *图标
        */
        private String iconClass;
        /**
        *get and set
        */
            public void setId (Integer  id){
                this.id=id;
            }
            public  Integer getId(){
                return this.id;
            }
            public void setName (String  name){
                this.name=name;
            }
            public  String getName(){
                return this.name;
            }
            public void setParentId (Integer  parentId){
                this.parentId=parentId;
            }
            public  Integer getParentId(){
                return this.parentId;
            }
            public void setType (Integer  type){
                this.type=type;
            }
            public  Integer getType(){
                return this.type;
            }
            public void setIconClass (String  iconClass){
                this.iconClass=iconClass;
            }
            public  String getIconClass(){
                return this.iconClass;
            }
}
