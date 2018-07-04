import cn.qzt.pojo.BuyCar;

import cn.qzt.pojo.EasybuyOrder;
import cn.qzt.service.EasybuyOrderService;
import cn.qzt.service.EasybuyProductService;
import cn.qzt.service.impl.EasybuyOrderDetailServiceImpl;
import cn.qzt.utils.JedisAPI;
import com.alibaba.fastjson.JSON;
import com.sun.javafx.collections.MappingChange;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2618:47
 */
public class ProductTest {
    @Test
    public void getProduct(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");

        EasybuyProductService service = (EasybuyProductService) context.getBean("easybuyProductServiceImpl");
        String str = "askffjwqdqwf151684184qw";
        System.out.println(DigestUtils.md5(str.getBytes()));



//        boolean a= DigestUtils.md5Hex("我是谁").equals(DigestUtils.md5Hex(str));
//
//        System.out.println(a);


    }

    @Test
    public void data(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(new Date()));


    }

    @Test
    public void getAs(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");

        EasybuyOrderDetailServiceImpl service = (EasybuyOrderDetailServiceImpl) context.getBean("easybuyOrderDetailServiceImpl");


//        List<EasybuyOrderDetail> detailList = service.getOrderDetail(2);
//
//        System.out.println(detailList.get(0).getCost());

               List<BuyCar> carList =  service.getBuyCar(23);
        System.out.println(carList.get(0).getProductName());

    }
    @Test
    public void redis(){
        ApplicationContext cox = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");

        JedisAPI jedisAPI = (JedisAPI) cox.getBean("jedisAPI");
        System.out.println(jedisAPI.getJedisPool().hashCode());
        System.out.println(jedisAPI.get("name"));

    }
    @Test
    public void json() throws ParseException {


        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTimeInMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(new Date()));
        System.out.println(format.parse("1995-07-15 16:56:02"));


        System.out.println(new SimpleDateFormat("yyyyMMdd").format(new Date()));

        Map<String,Object> map = new HashMap<String,Object>();


    }
    @Test
    public void getMap(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("serialNumber","60B7487F47F9434EAA5FD1D9E22CB06C");
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        EasybuyOrderService service = (EasybuyOrderService) context.getBean("easybuyOrderServiceImpl");

    }
}
