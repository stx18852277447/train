package top.stx.train.member.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.stx.train.common.resp.CommonResp;
import top.stx.train.member.req.MemberRegisterReq;
import top.stx.train.member.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberService memberService;
    @GetMapping("/count")
    public Integer count(){
        return memberService.count();
    }
    @PostMapping("/register")
    public CommonResp<Long> register(MemberRegisterReq req){
        Long register= memberService.register(req);
        return new CommonResp<>(register);
    }
}
