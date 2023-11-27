package top.stx.train.business.req;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import top.stx.train.common.req.PageReq;

public class DailyTrainCarriageQueryReq extends PageReq {
    private String trainCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
public String toString() {
return "DailyTrainCarriageQueryReq{" +
"} " + super.toString();
}
}
