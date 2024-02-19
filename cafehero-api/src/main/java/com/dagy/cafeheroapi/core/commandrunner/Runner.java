package com.dagy.cafeheroapi.core.commandrunner;

import com.dagy.cafeheroapi.core.commandrunner.seeders.CompanySeeder;
import com.dagy.cafeheroapi.core.commandrunner.seeders.PermissionSeeder;
import com.dagy.cafeheroapi.core.commandrunner.seeders.SettingSeeder;
import com.dagy.cafeheroapi.core.commandrunner.seeders.UserSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private final SettingSeeder settingSeeder;
    private final CompanySeeder companySeeder;
     private final PermissionSeeder permissionSeeder;
    private final UserSeeder userSeeder;

    @Autowired
    public Runner(
            SettingSeeder settingSeeder,
            CompanySeeder companySeeder,
            PermissionSeeder permissionSeeder,
            UserSeeder userSeeder) {
        this.settingSeeder = settingSeeder;
        this.companySeeder = companySeeder;
        this.permissionSeeder = permissionSeeder;
        this.userSeeder = userSeeder;
    }

    @Override
    public void run(String... args) throws Exception {
//        settingSeeder.run();
//        companySeeder.run();
        permissionSeeder.run();
        userSeeder.run();
    }
}
