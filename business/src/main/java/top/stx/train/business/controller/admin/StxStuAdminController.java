package top.stx.train.business.controller.admin;

import top.stx.train.common.resp.CommonResp;
import top.stx.train.common.req.PageResp;
import top.stx.train.business.req.StxStuQueryReq;
import top.stx.train.business.req.StxStuSaveReq;
import top.stx.train.business.resp.StxStuQueryResp;
import top.stx.train.business.service.StxStuService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/stx-stu")
public class StxStuAdminController {

    @Resource
    private StxStuService stxStuService;

    //@PostMapping("/save")
    //public CommonResp<Object> save(@Valid @RequestBody StxStuSaveReq req) {
    //    stxStuService.save(req);
    //    return new CommonResp<>();
    //}

    @GetMapping("/query-list")
    public CommonResp<PageResp<StxStuQueryResp>> queryList(@Valid StxStuQueryReq req) {
        PageResp<StxStuQueryResp> list = stxStuService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        stxStuService.delete(id);
        return new CommonResp<>();
    }

}
