package top.stx.train.business.req;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import top.stx.train.common.req.PageReq;

public class DailyTrainStationQueryReq extends PageReq {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;


    private String trainCode;

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
return "DailyTrainStationQueryReq{" +
"} " + super.toString();
}
}
