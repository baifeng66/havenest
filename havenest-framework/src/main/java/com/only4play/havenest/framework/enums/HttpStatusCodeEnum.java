package com.only4play.havenest.framework.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpStatusCodeEnum {
    SUCCESS(200, "操作成功"),
    FALL(500, "操作失败");

    private final Integer code;

    private final String msg;
}
