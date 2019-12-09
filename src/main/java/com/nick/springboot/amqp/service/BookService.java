package com.nick.springboot.amqp.service;

import com.nick.springboot.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = "nick.news")
    public void receive(Book book){
        System.out.println("收到消息："+book);
        System.out.println("--------------");
    }

    @RabbitListener(queues = "nick")
    public void receive02(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
