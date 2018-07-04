package cn.qzt.pojo;
import java.io.Serializable;
import java.util.Date;
/***
*   EasybuyNews
*
*
*
*/
public class EasybuyNews implements Serializable {
        /**
        *主键
        */
        private Integer id;
        /**
        *标题
        */
        private String title;
        /**
        *内容
        */
        private String content;
        /**
        *创建时间
        */
        private String createTime;
        /**
        *get and set
        */
            public void setId (Integer  id){
                this.id=id;
            }
            public  Integer getId(){
                return this.id;
            }
            public void setTitle (String  title){
                this.title=title;
            }
            public  String getTitle(){
                return this.title;
            }
            public void setContent (String  content){
                this.content=content;
            }
            public  String getContent(){
                return this.content;
            }
            public void setCreateTime (String  createTime){
                this.createTime=createTime;
            }
            public  String getCreateTime(){
                return this.createTime;
            }
}
