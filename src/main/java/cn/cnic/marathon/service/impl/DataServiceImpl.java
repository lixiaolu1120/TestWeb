package cn.cnic.marathon.service.impl;

import cn.cnic.marathon.dao.DataDao;
import cn.cnic.marathon.service.DataService;
import java.util.List;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuxiaoer@cnic.cn on 2015/4/24.
 */
@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataDao dataDao;
    
    @Override
    public String getSchedules(int type,long time) {
        List data = dataDao.getScheduleList(type, time);
        return JSONArray.fromObject(data).toString();
    }

    @Override
    public String getMarks(int type,long time) {
        List data = dataDao.getMarkList(type, time);
        return JSONArray.fromObject(data).toString();
    }

    @Override
    public String getAthletes(long time) {
        List data = dataDao.getAthleteList(time);
        return JSONArray.fromObject(data).toString();
    }

    @Override
    public String getCheers(long time) {
        List data = dataDao.getCheerList(time);
        return JSONArray.fromObject(data).toString();
    }

    @Override
    public String getPartners(long time) {
        List data = dataDao.getPartnerList(time);
        return JSONArray.fromObject(data).toString();
    }

    @Override
    public void collect(String lonlat, String user) {
        String[] lonlats = lonlat.split(",");
        float lon = Float.valueOf(lonlats[0]);
        float lat = Float.valueOf(lonlats[1]);
        dataDao.collect(lon, lat, user);
    }
}
