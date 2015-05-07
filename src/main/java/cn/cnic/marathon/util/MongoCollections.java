package cn.cnic.marathon.util;

import java.util.Collection;

/**
 * 马拉松应用数据集合
 * Created by liuxiaoer@cnic.cn on 2015/4/24.
 */
public enum MongoCollections {

    //日程集合
    CollectionSchedule("schedule"),
    //运动员信息集合
    CollectionAthlete("athlete"),
    //截图标注集合
    CollectionMarks("marks"),
    //啦啦队信息集合
    CollectionCheer("cheer"),
    //合作伙伴信息集合
    CollectionPartner("partner"),
    //经纬度
    CollectionLocation("location");

    private String value;

    private MongoCollections(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
