package cn.qzt.utils;

import cn.qzt.pojo.cn.qzt.dto.Dto;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/7/211:24
 */
public class DtoUtils<E> extends Dto<E> {


    public static Dto dtoSuccess(Object vo){
        Dto dto = new DtoUtils();
        dto.setSuccess("true");
        dto.setData(vo);

        return dto;
    }



}
