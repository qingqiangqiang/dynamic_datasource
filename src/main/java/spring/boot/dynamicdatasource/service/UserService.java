package spring.boot.dynamicdatasource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.dynamicdatasource.conf.DS;
import spring.boot.dynamicdatasource.dao.mapper.AppointmentClassInfoMapper;
import spring.boot.dynamicdatasource.dao.model.AppointmentClassInfo;

/**
 * Created by 顷强强 on 2018/3/5.
 */
@Service("userService")
public class UserService {

    @Autowired
    private AppointmentClassInfoMapper appointmentClassInfoMapper;

    @DS("defaultDB")
    public AppointmentClassInfo ds1(Long id) {
        return appointmentClassInfoMapper.selectByPrimaryKey(id);
    }

    @DS("defaultDB")
    public Integer insertToDS1(AppointmentClassInfo appointmentClassInfo) {
        return appointmentClassInfoMapper.insert(appointmentClassInfo);
    }
    @DS("logDB")
    public AppointmentClassInfo ds2(Long id) {
        return appointmentClassInfoMapper.selectByPrimaryKey(id);
    }


    @DS("logDB")
    public Integer insertToDS2(AppointmentClassInfo appointmentClassInfo) {
        return appointmentClassInfoMapper.insert(appointmentClassInfo);
    }
}
