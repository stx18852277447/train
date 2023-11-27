package top.stx.train.business.req;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import top.stx.train.common.req.PageReq;

public class DailyTrainTicketQueryReq extends PageReq {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String trainCode;
    private String start;
    private String end;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "DailyTrainTicketQueryReq{" +
            "} " + super.toString();
    }
}
