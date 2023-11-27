package top.stx.train.business.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.stx.train.business.req.ConfirmOrderDoReq;
import top.stx.train.business.service.ConfirmOrderService;
import top.stx.train.common.resp.CommonResp;

@RestController
@RequestMapping("/confirm-order")
public class ConfirmOrderController {
    @Resource
    private ConfirmOrderService confirmOrderService;

    @PostMapping("/do")
    public CommonResp<Object> doConfirm(@Valid @RequestBody ConfirmOrderDoReq req) {
        confirmOrderService.doConfirm(req);
        return new CommonResp<>();
    }
}
