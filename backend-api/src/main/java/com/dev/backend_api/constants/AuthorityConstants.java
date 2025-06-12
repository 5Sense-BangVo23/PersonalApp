package com.dev.backend_api.constants;

public final class AuthorityConstants {

    private AuthorityConstants() {
        // Ngăn không cho khởi tạo class chứa constants
    }

    // 🎯 Action permissions
    public static final String ACTION_VIEW   = "action:view";
    public static final String ACTION_EDIT   = "action:edit";
    public static final String ACTION_DELETE = "action:delete";
    public static final String ACTION_CREATE = "action:create";

    // 👤 User permissions
    public static final String USER_VIEW   = "user:view";
    public static final String USER_EDIT   = "user:edit";
    public static final String USER_DELETE = "user:delete";
    public static final String USER_CREATE = "user:create";

    // 🔐 Role permissions
    public static final String ROLE_VIEW   = "role:view";
    public static final String ROLE_EDIT   = "role:edit";
    public static final String ROLE_DELETE = "role:delete";
    public static final String ROLE_CREATE = "role:create";

    // 🛡️ Permission management
    public static final String PERMISSION_VIEW   = "permission:view";
    public static final String PERMISSION_EDIT   = "permission:edit";
    public static final String PERMISSION_DELETE = "permission:delete";
    public static final String PERMISSION_CREATE = "permission:create";

    // 👥 Role-based authorities
    public static final String USER_AUTHORITIES = String.join(",",
            ACTION_VIEW, ACTION_EDIT, ACTION_DELETE, ACTION_CREATE
    );

    public static final String ADMIN_AUTHORITIES = String.join(",",
            ACTION_VIEW, ACTION_EDIT, ACTION_DELETE, ACTION_CREATE,
            USER_VIEW, USER_EDIT, USER_DELETE, USER_CREATE,
            ROLE_VIEW, ROLE_EDIT, ROLE_DELETE, ROLE_CREATE
    );

    public static final String SUPER_ADMIN_AUTHORITIES = String.join(",",
            ACTION_VIEW, ACTION_EDIT, ACTION_DELETE, ACTION_CREATE,
            USER_VIEW, USER_EDIT, USER_DELETE, USER_CREATE,
            ROLE_VIEW, ROLE_EDIT, ROLE_DELETE, ROLE_CREATE,
            PERMISSION_VIEW, PERMISSION_EDIT, PERMISSION_DELETE, PERMISSION_CREATE
    );

    public static final String ANONYMOUS_AUTHORITIES = String.join(",", ACTION_VIEW);

    public static final String MANAGER_AUTHORITIES = String.join(",",
            ACTION_VIEW, ACTION_EDIT, ACTION_DELETE, ACTION_CREATE,
            USER_VIEW, USER_EDIT, USER_DELETE, USER_CREATE,
            ROLE_VIEW, ROLE_EDIT, ROLE_DELETE, ROLE_CREATE
    );
}

