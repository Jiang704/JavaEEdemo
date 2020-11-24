package com.jiang.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.baidu.ai.aip.utils.GsonUtils;
import com.baidu.ai.aip.utils.HttpUtil;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取用户人脸列表
 */
public class FaceGetList {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    //提前编译出结果




    public static String faceGetList(int id) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/face/getlist";
        try {
            Map<String, Object> map = new HashMap<>();
            //map.put("user_id", "201892001");
            map.put("user_id", id);
            map.put("group_id", "student");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            //String accessToken = "[调用鉴权接口获取的token]";
            String accessToken = AuthService.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            JSONObject pa=JSONObject.parseObject(result);
            String result2 = pa.getString("result");
            pa=JSONObject.parseObject(result2);
            String face_list = pa.getString("face_list");
            System.out.println("face_list:"+face_list);
            List<Face_list> list = JSONObject.parseArray(face_list, Face_list.class);
            String face = list.get(0).getFace_token();
            System.out.println(face);
            return face;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        FaceGetList.faceGetList(201892007);
    }
}