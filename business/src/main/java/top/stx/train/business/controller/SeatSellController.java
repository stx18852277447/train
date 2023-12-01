package top.stx.train.business.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.stx.train.business.req.SeatSellReq;
import top.stx.train.business.resp.SeatSellResp;
import top.stx.train.business.service.DailyTrainSeatService;
import top.stx.train.common.resp.CommonResp;

import java.util.List;

@RestController
@RequestMapping("/seat-sell")
public class SeatSellController {

    @Resource
    private DailyTrainSeatService dailyTrainSeatService;

    @GetMapping("/query")
    public CommonResp<List<SeatSellResp>> query(@Valid SeatSellReq req) {
        List<SeatSellResp> seatList = dailyTrainSeatService.querySeatSell(req);
        return new CommonResp<>(seatList);
    }

}
