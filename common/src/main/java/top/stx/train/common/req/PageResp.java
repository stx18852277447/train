package top.stx.train.common.req;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PageResp<T> implements Serializable {
    private Long total;
    private List<T> list;
}
