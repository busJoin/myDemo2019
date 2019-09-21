package com.leader.demo.mail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.nio.file.FileSystem;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {
    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void sendMail(){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("2389889598@qq.com");
        mail.setTo("1934199858@qq.com");
        mail.setSubject("Spring Boot Send Mail");
        mail.setText("你好，你正在发送邮件。");
        mailSender.send(mail);
    }

    @Before
    public void init(){
        //java mail发邮件是附件名过长默认会被截断，附件名显示【tcmime.29121.29517.50430.bin】，主动设为false可正常显示附件名
        System.setProperty("mail.mime.splitlongparameters", "false");
        System.out.println("初始化");
    }

    @Test
    public void sendInLineResourceMail(){
        //java mail发邮件是附件名过长默认会被截断
        System.setProperty("mail.mime.splitlongparameters", "false");
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom("2389889598@qq.com");
            helper.setTo("1934199858@qq.com");
            helper.setSubject("subject");
            String content = "<html><body><h1>test发附件</h1><img width='250px' src=\'cid:" + "img110" + "\'><h2>一个小文本</h2></body></html>";
            helper.setText(content,true);

            File file = new File("C:\\Users\\chang\\Desktop\\images.jpg");
            FileSystemResource res = new FileSystemResource(file);
            helper.addInline("img110",res);
            //添加附件
            FileSystemResource file1 = new FileSystemResource(new File("C:\\Users\\chang\\Desktop\\2019年暑期预购统计报表-2019.9.2施施姐(1).xlsx"));
            String fileName = file1.getFilename();
            helper.addAttachment(fileName,file1);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
