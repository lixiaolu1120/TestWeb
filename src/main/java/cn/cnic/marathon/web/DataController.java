package cn.cnic.marathon.web;

import cn.cnic.marathon.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * app数据请求类 .
 *
 * @author liuxiaoer@cnic.cn
 * @date 2015/4/22.
 */
@Controller
@RequestMapping("ds/")
public class DataController {

    @Autowired
    private DataService dataService;

    /**
     * 日程信息列表
     *
     * @param type
     * @return
     */
    @RequestMapping("/schedule/{type}/{time}")
    @ResponseBody
    public String scheduleAfterTime(@PathVariable int type, @PathVariable long time) {
        return dataService.getSchedules(type, time);
    }

    /**
     * 标注信息列表
     *
     * @param type
     * @return
     */
    @RequestMapping("/marks/{type}/{time}")
    @ResponseBody
    public String marks(@PathVariable int type, @PathVariable long time) {
        return dataService.getMarks(type, time);
    }

    /**
     * 运动员信息
     *
     * @return
     */
    @RequestMapping("/athlete/{time}")
    @ResponseBody
    public String athlete(@PathVariable long time) {
        return dataService.getAthletes(time);
    }

    /**
     * 合作伙伴信息
     *
     * @return
     */
    @RequestMapping("/partner/{time}")
    @ResponseBody
    public String partner(@PathVariable long time) {
        return dataService.getPartners(time);
    }

    /**
     * 啦啦队信息
     *
     * @return
     */
    @RequestMapping("/cheer/{time}")
    @ResponseBody
    public String cheer(@PathVariable long time) {
        return dataService.getCheers(time);
    }

    /**
     * 收集用户位置信息
     *
     * @param lonlat
     * @param user
     */
    @RequestMapping("/collect/{lonlat}/{user}")
    @ResponseBody
    public void collect(@PathVariable String lonlat, @PathVariable String user) {
        dataService.collect(lonlat, user);
    }
}
