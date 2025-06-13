package com.dev.backend_api.enumeration;

import com.dev.backend_api.constants.AuthorityConstants;

public enum Authority {

    /** Người dùng với quyền hạn cơ bản */
    USER(AuthorityConstants.USER_AUTHORITIES),

    /** Quản trị viên với quyền hạn cao hơn người dùng */
    ADMIN(AuthorityConstants.ADMIN_AUTHORITIES),

    /** Siêu quản trị viên với quyền hạn cao nhất */
    SUPER_ADMIN(AuthorityConstants.SUPER_ADMIN_AUTHORITIES),

    /** Người dùng ẩn danh không có quyền truy cập */
    ANONYMOUS(AuthorityConstants.ANONYMOUS_AUTHORITIES),

    /** Người quản lý với quyền hạn quản lý nhất định */
    MANAGER(AuthorityConstants.MANAGER_AUTHORITIES);

    private final String value;

    Authority(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    
}
