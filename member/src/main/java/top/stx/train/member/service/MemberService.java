package top.stx.train.member.service;

import java.util.List;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import jakarta.annotation.Resource;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.stx.train.common.controller.ControllerExceptionHandler;
import top.stx.train.common.exception.BusinessException;
import top.stx.train.common.exception.BusinessExceptionEnum;
import top.stx.train.common.util.SnowUtil;
import top.stx.train.member.domain.Member;
import top.stx.train.member.domain.MemberExample;
import top.stx.train.member.mapper.MemberMapper;
import top.stx.train.member.req.MemberLoginReq;
import top.stx.train.member.req.MemberRegisterReq;
import top.stx.train.member.req.MemberSendCodeReq;
import top.stx.train.member.resp.MemberLoginResp;

@Service
public class MemberService {
    @Resource
    private MemberMapper memberMapper;
    private static final Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    public int count() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    public long register(MemberRegisterReq req) {
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);

        if (CollUtil.isNotEmpty(list)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }

        Member member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();

    }

    public void sendCode(MemberSendCodeReq req) {
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        //如果手机号不存在，则插入一条记录
        if (CollUtil.isEmpty(list)) {
            log.info("手机号不存在，插入一条记录");
            Member member = new Member();
            member.setId(SnowUtil.getSnowflakeNextId());
            member.setMobile(mobile);
            memberMapper.insert(member);
        } else {
            log.info("手机号存在，不插入记录");
        }
        //生成验证码
        //String code = RandomUtil.randomString(4);
        String code = "8888";
        log.info("生成短信验证码:(", code);
        //保存短信记录表:手机号，短信验证码，有效期，是否已使用，业务类型，发送时间，使用时间
        log.info("保存短信记录表");
        //对接短信通道，发送短信
        log.info("对接短信通道");
    }
    public MemberLoginResp login(MemberLoginReq req) {
        String mobile = req.getMobile();
        String code = req.getCode();
        Member memberDB = selectByMobile(mobile);
        // 如果手机号不存在，则插入一条记录
        if (ObjectUtil.isNull(memberDB)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_NOT_EXIST);
        }
        // 校验短信验证码
        if (!"8888".equals(code)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_CODE_ERROR);
        }
        return BeanUtil.copyProperties(memberDB,MemberLoginResp.class);
    }

    private Member selectByMobile(String mobile) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        if (CollUtil.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }
    }
}
