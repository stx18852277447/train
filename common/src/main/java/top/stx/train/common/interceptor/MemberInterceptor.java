package top.stx.train.common.interceptor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.stx.train.common.context.LoginMemberContext;
import top.stx.train.common.resp.MemberLoginResp;
import top.stx.train.common.util.JwtUtil;

@Component
@Slf4j
public class MemberInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handlen)
        throws Exception {

        //获取header的token参数
        String token = request.getHeader("token");
        if (StrUtil.isNotBlank(token)) {
            log.info("获取会员登录token:{0", token);
            JSONObject loginMember = JwtUtil.getJSONObject(token);
            log.info("当前登录会员:{", loginMember);
            MemberLoginResp member = JSONUtil.toBean(loginMember, MemberLoginResp.class);
            LoginMemberContext.setMember(member);
        }
        return true;
    }
}
