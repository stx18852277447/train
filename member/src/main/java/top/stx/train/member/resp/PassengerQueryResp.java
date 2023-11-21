package top.stx.train.member.resp;

import java.util.Date;

import lombok.Data;

@Data
public class PassengerQueryResp {
    private Long id;
    private Long memberId;
    private String name;
    private String idCard;
    private String type;
    private Date createTime;
    private Date updateTime;
}
