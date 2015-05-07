package cn.cnic.marathon.dao.impl;

import cn.cnic.marathon.dao.DataDao;
import cn.cnic.marathon.util.MongoCollections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by liuxiaoer@cnic.cn on 2015/4/24.
 */
@Repository
public class DataDaoImpl implements DataDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List getScheduleList(int type,long time) {
        Query query = new Query(Criteria.where("type").is(type).and("_id").gt(new Date(time)));
        return mongoTemplate.find(query, HashMap.class, MongoCollections.CollectionSchedule.getValue());
    }

    @Override
    public List getMarkList(int type, long time) {
        Query query = new Query(Criteria.where("type").is(type).and("_id").gt(new Date(time)));
        return mongoTemplate.find(query, HashMap.class, MongoCollections.CollectionMarks.getValue());
    }

    @Override
    public List getAthleteList(long time) {
        Query query = new Query(Criteria.where("_id").gt(new Date(time)));
        return mongoTemplate.find(query, HashMap.class, MongoCollections.CollectionAthlete.getValue());
    }

    @Override
    public List getCheerList(long time) {
        Query query = new Query(Criteria.where("_id").gt(new Date(time)));
        return mongoTemplate.find(query, HashMap.class, MongoCollections.CollectionCheer.getValue());
    }

    @Override
    public List getPartnerList(long time) {
        Query query = new Query(Criteria.where("_id").gt(new Date(time)));
        return mongoTemplate.find(query, HashMap.class, MongoCollections.CollectionPartner.getValue());
    }

    @Override
    public void collect(float lon, float lat, String user) {
        Map map = new HashMap();
        map.put("lon", lon);
        map.put("lat", lat);
        map.put("user_id", user);
        map.put("create_at", new Date());
        mongoTemplate.insert(map, MongoCollections.CollectionLocation.getValue());
    }
}
