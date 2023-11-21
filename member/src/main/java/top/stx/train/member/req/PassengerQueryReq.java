package top.stx.train.member.req;

import lombok.Data;
import top.stx.train.common.req.PageReq;

@Data
public class PassengerQueryReq extends PageReq {
    private Long memberId;
}
