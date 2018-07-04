import cn.qzt.service.EasybuyNewsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2518:27
 */
public class EasybuyNewsTest {
   @Test
    public void getNews(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");

       EasybuyNewsService newsService = (EasybuyNewsService) context.getBean("easybuyNewsServiceImpl");

        System.out.println(newsService);

    }
}
