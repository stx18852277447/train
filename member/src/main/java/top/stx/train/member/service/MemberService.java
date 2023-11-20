package top.stx.train.member.service;

import java.util.List;

import cn.hutool.core.collection.CollUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.stx.train.common.exception.BusinessException;
import top.stx.train.common.exception.BusinessExceptionEnum;
import top.stx.train.common.util.SnowUtil;
import top.stx.train.member.domain.Member;
import top.stx.train.member.domain.MemberExample;
import top.stx.train.member.mapper.MemberMapper;
import top.stx.train.member.req.MemberRegisterReq;

@Service
public class MemberService {
    @Resource
    private MemberMapper memberMapper;

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
}
