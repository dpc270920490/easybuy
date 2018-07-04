package cn.qzt.pojo;
import java.io.Serializable;
import java.util.Date;
/***
*   EasybuyProduct
*
*
*
*/
public class EasybuyProduct implements Serializable {
        /**
        *主键
        */
        private Integer id;
        /**
        *名称
        */
        private String name;
        /**
        *描述
        */
        private String description;
        /**
        *价格
        */
        private String price;
        /**
        *库存
        */
        private Integer stock;
        /**
        *分类1
        */
        private Integer categoryLevel1Id;
        /**
        *分类2
        */
        private Integer categoryLevel2Id;
        /**
        *分类3
        */
        private Integer categoryLevel3Id;
        /**
        *文件名称
        */
        private String fileName;
        /**
        *是否删除(1：删除 0：未删除)
        */
        private Integer isDelete;
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
            public void setDescription (String  description){
                this.description=description;
            }
            public  String getDescription(){
                return this.description;
            }
            public void setPrice (String  price){
                this.price=price;
            }
            public  String getPrice(){
                return this.price;
            }
            public void setStock (Integer  stock){
                this.stock=stock;
            }
            public  Integer getStock(){
                return this.stock;
            }
            public void setCategoryLevel1Id (Integer  categoryLevel1Id){
                this.categoryLevel1Id=categoryLevel1Id;
            }
            public  Integer getCategoryLevel1Id(){
                return this.categoryLevel1Id;
            }
            public void setCategoryLevel2Id (Integer  categoryLevel2Id){
                this.categoryLevel2Id=categoryLevel2Id;
            }
            public  Integer getCategoryLevel2Id(){
                return this.categoryLevel2Id;
            }
            public void setCategoryLevel3Id (Integer  categoryLevel3Id){
                this.categoryLevel3Id=categoryLevel3Id;
            }
            public  Integer getCategoryLevel3Id(){
                return this.categoryLevel3Id;
            }
            public void setFileName (String  fileName){
                this.fileName=fileName;
            }
            public  String getFileName(){
                return this.fileName;
            }
            public void setIsDelete (Integer  isDelete){
                this.isDelete=isDelete;
            }
            public  Integer getIsDelete(){
                return this.isDelete;
            }
}
