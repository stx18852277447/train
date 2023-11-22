package top.stx.train.business.enums;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;

import lombok.Getter;

@Getter
public enum SeatTypeEnum {
    YDZ("1", "一等座", new BigDecimal("0.4")),
    EDZ("2", "二等座", new BigDecimal("0.3")),
    RW("3", "软卧", new BigDecimal("0.6")),
    Yw("4", "硬卧", new BigDecimal("0.5"));
    private String code;
    private String desc;
    private BigDecimal price;

    SeatTypeEnum(String code, String desc, BigDecimal price) {
        this.code = code;
        this.desc = desc;
        this.price = price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static List<HashMap<String, String>> getEnumList() {
        List<HashMap<String, String>> list = new ArrayList<>();
        for (SeatTypeEnum anEnum : EnumSet.allOf(SeatTypeEnum.class)) {
            HashMap<String, String> map = new HashMap<>();
            map.put("code", anEnum.code);
            map.put("desc", anEnum.desc);
            list.add(map);
        }
        return list;
    }

    public static SeatTypeEnum getEnumByCode(String code) {
        for (SeatTypeEnum enums : SeatTypeEnum.values()) {
            if (enums.getCode().equalsIgnoreCase(code)) {
                return enums;
            }
        }
        return null;
    }
}