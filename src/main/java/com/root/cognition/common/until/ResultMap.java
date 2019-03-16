package com.root.cognition.common.until;

import java.util.HashMap;

/**
 * @author Worry
 * @version 2019/3/10
 */
public class ResultMap extends HashMap<String, Object>{


    /**
     * 返回成功状态与信息
     * @return Map（state =0，msg=操作成功）
     */
    public static ResultMap success() {
        ResultMap returnMap = new ResultMap();
        returnMap.put("state", 0);
        returnMap.put("msg", "操作成功");
        return returnMap;
    }


    /**
     * 返回失败状态与信息
     * @return Map(state =1,msg=操作失败）
     */
    public static ResultMap error() {
        ResultMap returnMap = new ResultMap();
        returnMap.put("state",1);
        returnMap.put("msg","操作失败");
        return returnMap;
    }

    /**
     * 公共的返回方法
     * @param state  状态信息
     * @param message  提示信息
     * @param entity 对象信息
     * @return
     */
    public static ResultMap returnMap(int state, String message, Object entity) {
        ResultMap returnMap = new ResultMap();
        returnMap.put("state", state);
        returnMap.put("message", message);
        returnMap.put("data", entity);
        return returnMap;
    }

    @Override
    public ResultMap put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
