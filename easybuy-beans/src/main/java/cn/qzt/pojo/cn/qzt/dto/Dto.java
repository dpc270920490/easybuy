package cn.qzt.pojo.cn.qzt.dto;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/7/211:20
 */
public class Dto<E> {
    private E data;
    private String message;
    private String errorCode;
    private String success;

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
