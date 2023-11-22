package top.stx.train.business.controller.admin;

import java.util.List;

import top.stx.train.common.context.LoginMemberContext;
import top.stx.train.common.resp.CommonResp;
import top.stx.train.common.req.PageResp;
import top.stx.train.business.req.StationQueryReq;
import top.stx.train.business.req.StationSaveReq;
import top.stx.train.business.resp.StationQueryResp;
import top.stx.train.business.service.StationService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/station")
public class StationAdminController {

    @Resource
    private StationService stationService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody StationSaveReq req) {
        stationService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<StationQueryResp>> queryList(@Valid StationQueryReq req) {
        PageResp<StationQueryResp> list = stationService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        stationService.delete(id);
        return new CommonResp<>();
    }

    @GetMapping("/query-all")
    public CommonResp<List<StationQueryResp>> queryList() {
        List<StationQueryResp> list = stationService.queryAll();
        return new CommonResp<>(list);
    }

}
