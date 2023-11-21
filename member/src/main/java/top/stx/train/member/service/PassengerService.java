package top.stx.train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.stx.train.common.util.SnowUtil;
import top.stx.train.member.domain.Passenger;
import top.stx.train.member.mapper.PassengerMapper;
import top.stx.train.member.req.PassengerSaveReq;

@Service
public class PassengerService {
    @Resource
    private PassengerMapper passengerMapper;

    public void save(PassengerSaveReq req) {
        DateTime now = DateTime.now();
        Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
        passenger.setId(SnowUtil.getSnowflakeNextId());
        passenger.setCreateTime(now);
        passenger.setUpdateTime(now);
        passengerMapper.insert(passenger);
    }
}
