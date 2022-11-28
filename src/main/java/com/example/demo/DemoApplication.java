package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
		log.info("Before Free: {} Total: {} Max: {}", FileUtils.byteCountToDisplaySize(Runtime.getRuntime().freeMemory()), FileUtils.byteCountToDisplaySize(Runtime.getRuntime().totalMemory()), FileUtils.byteCountToDisplaySize(Runtime.getRuntime().maxMemory()));
        String[] array = new String[100000 * 100000];
        log.info("Bytes used by array: " + FileUtils.byteCountToDisplaySize(ClassLayout.parseInstance(array).instanceSize()));
		log.info("After Free: {} Total: {} Max: {}", FileUtils.byteCountToDisplaySize(Runtime.getRuntime().freeMemory()), FileUtils.byteCountToDisplaySize(Runtime.getRuntime().totalMemory()), FileUtils.byteCountToDisplaySize(Runtime.getRuntime().maxMemory()));
		String[] array2 = new String[100000 * 100000];
        log.info("After2 Free: {} Total: {} Max: {}", FileUtils.byteCountToDisplaySize(Runtime.getRuntime().freeMemory()), FileUtils.byteCountToDisplaySize(Runtime.getRuntime().totalMemory()), FileUtils.byteCountToDisplaySize(Runtime.getRuntime().maxMemory()));
    }
}
