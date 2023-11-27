package top.stx.train.business.req;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import top.stx.train.common.req.PageReq;

public class DailyTrainQueryReq extends PageReq {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Override
    public String toString() {
        return "DailyTrainQueryReq{" +
            "} " + super.toString();
    }
}
