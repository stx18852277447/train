package top.stx.train.business.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import top.stx.train.common.req.MemberTicketReq;
import top.stx.train.common.resp.CommonResp;

@FeignClient(name = "member", url = "http://127.0.0.1:8001")
//@FeignClient("member")
public interface MemberFeign {

    @GetMapping("/member/feign/ticket/save")
    CommonResp<Object> save(@RequestBody MemberTicketReq req);
}
