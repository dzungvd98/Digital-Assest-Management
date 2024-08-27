package test;

import main.Permission;
import main.PermissionEnum;

public class TestPermission {
    
    public Permission InitPermissionData() {
        Permission permission = new Permission();
        permission.GrandDrivePermission("1", "D", PermissionEnum.CONTRIBUTOR);


    }
}
