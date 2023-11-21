package top.stx.train.member.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.stx.train.common.context.LoginMemberContext;
import top.stx.train.common.req.PageResp;
import top.stx.train.common.resp.CommonResp;
import top.stx.train.member.req.PassengerQueryReq;
import top.stx.train.member.req.PassengerSaveReq1;
import top.stx.train.member.resp.PassengerQueryResp;
import top.stx.train.member.service.PassengerService1;

@RestController
@RequestMapping("/passenger")
public class PassengerController1 {
    @Resource
    private PassengerService1 passengerService1;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody PassengerSaveReq1 req) {
        passengerService1.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<PassengerQueryResp>> queryList(@Valid PassengerQueryReq req) {
        req.setMemberId(LoginMemberContext.getId());
        PageResp<PassengerQueryResp> list = passengerService1.queryList(req);
        return new CommonResp<>(list);
    }
    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        passengerService1.delete(id);
        return new CommonResp<>();
    }

}
