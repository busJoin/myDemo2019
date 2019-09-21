package com.chang.demo.study.timeJob;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
public class testScheduled {
    @Scheduled(initialDelay=1000, fixedDelay = 1000)
    public void task1() {
//        System.out.println("延迟1000毫秒后执行，任务执行完1000毫秒之后执行！");
        log.info("task1延迟1000毫秒后执行，任务执行完1000毫秒之后执行！");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedRate = 2000)
    public void task2() {
//        System.out.println("延迟1000毫秒后执行，之后每2000毫秒执行一次！");
        log.error("延迟1000毫秒后执行，之后每2000毫秒执行一次！");
    }

    @Scheduled(cron = "*/2 * * * * ?")
    public void task3() {
//        System.out.println("每2秒执行一次！");
        log.warn("每2秒执行一次！");
    }
}
