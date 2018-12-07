package cn.lzy.server.softwareautomationms.util;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * 通用工具类
 * @author lzy
 * @version 1.0
 * @date 2018-11-22 11:07
 */
public class Utils {

    /**
     * 获取日志操作对象
     **/
    private static Logger logger = LoggerFactory.getLogger(Utils.class);

    /**
     * 项目名称
     **/
    public static final String PROJECT_NAME = "软件自动化管理系统";

    public static final String SERVER_ERR = "服务器内部错误！";

    public static final String ACCOUNT_ERR = "账号或密码错误！";

    public static final String STATUS = "status";
    public static final String ERROR_STRING = "errorString";


    /**
     * 用户账号最大长度
     **/
    public static final int ACCOUNT_MAX_LENGTH = 20;
    /**
     * 用户密码最大长度
     **/
    public static final int PASSWORD_MAX_LENGTH = 16;
    /**
     * 用户密码最小长度
     **/
    public static final int PASSWORD_MIN_LENGTH = 6;

    public static final String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 角色等级标识 分为6挡，分别用0,1,2,3,4,5表示。
     *      0--管理员；1--项目经理；2--开发人员; 3--测试人员；4--UI设计人员；5--临时访客。
     **/
    public static final int ADMIN = 0;
    public static final int PM = 1;
    public static final int DEVELOPER = 2;
    public static final int TESTER = 3;
    public static final int UI = 4;
    public static final int VISITOR = 5;



    private Utils() {
        logger.info("you can not instantiation me!");
    }

    /**
     * 拼装响应数据
     * @author lzy
     * @date 2018/11/22 11:28
     * @param flag 状态标志 true--成功，false--失败。
     * @param errorString flag为false时的错误信息。
     * @param data 响应数据
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    public static Map<String,Object> packageResponseData(boolean flag,
                     String errorString, Object data){
        Map<String,Object> map = Maps.newHashMap();
        map.put("flag", flag);
        map.put("data", data);
        map.put("errorString", Strings.nullToEmpty(errorString));
        return map;
    }

    /**
     * 生成请求最后的返回数据
     * @author lzy
     * @date 2018/11/27 17:42
     * @param responseData 响应数据
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    public static Map<String,Object> generatorResponseData(Object responseData) {
        Map<String,Object> map;
        try {
            map = packageResponseData(true, null, responseData);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return packageResponseData(false, SERVER_ERR, null);
        }
        return map;
    }

    /**
     * 获取UUID
     * @author lzy
     * @date 2018/11/22 11:42
     * @return java.lang.String
     **/
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }

    /**
     * 获取两个日期（不含时分秒）相差的天数，不包含今天
     * @author lzy
     * @date 2018/11/26 16:03
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return int
     **/
    public static int dateBetween(Date startDate, Date endDate) throws ParseException {
        Date dateStart = dateParse(dateFormat(startDate, DATE_PATTERN), DATE_PATTERN);
        Date dateEnd = dateParse(dateFormat(endDate, DATE_PATTERN), DATE_PATTERN);
        return (int) ((dateEnd.getTime() - dateStart.getTime())/1000/60/60/24);
    }

    /**
     * 获取两个日期（不含时分秒）相差的天数，包含今天
     * @author lzy
     * @date 2018/11/26 16:16
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return int
     **/
    public static int dateBetweenIncludeToday(Date startDate, Date endDate)
            throws ParseException {
        return dateBetween(startDate, endDate) + 1;
    }


    /**
     * 字符串解析成时间对象
     * @author lzy
     * @date 2018/11/26 16:15
     * @param dateTimeString 字符串类型时间
     * @param pattern 格式化格式
     * @return java.util.Date
     **/
    public static Date dateParse(String dateTimeString, String pattern) throws ParseException {
        if(Strings.isNullOrEmpty(pattern)){
            pattern = DATE_PATTERN;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dateTimeString);
    }

    /**
     * 时间格式化成字符串
     * @author lzy
     * @date 2018/11/26 16:16
     * @param date Data类型时间
     * @param pattern 格式化格式
     * @return java.lang.String
     **/
    public static String dateFormat(Date date, String pattern){
        if(Strings.isNullOrEmpty(pattern)){
            pattern = DATE_PATTERN;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 将null或""的字符串转换为默认文字。否则返回原始字符串
     * @author lzy
     * @date 2018/12/1 10:33
     * @param str 需要判断是否进行转换的字符串
     * @return java.lang.String
     **/
    public static String transformNullOrEmptyToDefault(Optional<String> str) {
        if (str.isPresent()) {
            return str.get();
        } else {
            return "";
        }
    }
}
