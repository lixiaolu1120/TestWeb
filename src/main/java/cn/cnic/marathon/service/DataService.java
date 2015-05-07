package cn.cnic.marathon.service;

/**
 * Created by liuxiaoer@cnic.cn on 2015/4/24.
 */
public interface DataService {
    /**
     * 获取日常信息
     *
     * @param type 日程类型
     * @param time 时间
     * @return
     */
    public String getSchedules(int type, long time);

    /**
     * 获取地图标注
     *
     * @param type
     * @param time 时间
     * @return
     */
    public String getMarks(int type, long time);

    /**
     * 获取运动员信息列表
     *
     * @param time 时间
     * @return
     */
    public String getAthletes(long time);

    /**
     * 获取啦啦队信息列表
     *
     * @return
     */
    public String getCheers(long time);

    /**
     * 获取合作伙伴列表
     *
     * @param time 时间
     * @return
     */
    public String getPartners(long time);

    /**
     * 采集经纬度信息
     *
     * @param lonlat 经纬度
     * @param user   用户
     */
    public void collect(String lonlat, String user);
}
