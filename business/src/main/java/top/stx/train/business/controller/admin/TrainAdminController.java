package top.stx.train.business.controller.admin;

import top.stx.train.business.service.TrainSeatService;
import top.stx.train.common.context.LoginMemberContext;
import top.stx.train.common.resp.CommonResp;
import top.stx.train.common.req.PageResp;
import top.stx.train.business.req.TrainQueryReq;
import top.stx.train.business.req.TrainSaveReq;
import top.stx.train.business.resp.TrainQueryResp;
import top.stx.train.business.service.TrainService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/train")
public class TrainAdminController {

    @Resource
    private TrainService trainService;

    @Resource
    private TrainSeatService trainSeatService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody TrainSaveReq req) {
        trainService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<TrainQueryResp>> queryList(@Valid TrainQueryReq req) {
        PageResp<TrainQueryResp> list = trainService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        trainService.delete(id);
        return new CommonResp<>();
    }
    @GetMapping("/gen-seat/{trainCode}")
    public CommonResp<Object> genSeat(@PathVariable String trainCode){
    trainSeatService.genTrainSeat(trainCode);
        return new CommonResp<>();
    }

}
