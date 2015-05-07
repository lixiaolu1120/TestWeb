package cn.cnic.marathon.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by liuxiaoer@cnic.cn on 2015/4/24.
 */
@Repository
public interface DataDao {

    /**
     * 获取日常信息
     * @param type 日程类型
     * @param time 时间
     * @return
     */
    public List getScheduleList(int type, long time);

    /**
     * 获取地图标注
     * @param type
     * @param time 时间
     * @return
     */
    public List getMarkList(int type, long time);

    /**
     * 获取运动员信息列表
     * @param time 时间
     * @return
     */
    public List getAthleteList(long time);

    /**
     * 获取啦啦队信息列表
     * @param time 时间
     * @return
     */
    public List getCheerList(long time);

    /**
     * 获取合作伙伴列表
     * @param time 时间
     * @return
     */
    public List getPartnerList(long time);

    /**
     * 采集经纬度信息
     * @param lon 经度
     * @param lat 纬度
     * @param user 用户
     */
    public void collect(float lon, float lat, String user);
}
