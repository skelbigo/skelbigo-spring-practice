package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final MessageService messageService;
    private final NotificationSender notificationSender;
    private final ObjectProvider<NotificationIdGenerator> idGeneratorProvider;

    public NotificationService(MessageService messageService, NotificationSender notificationSender, ObjectProvider<NotificationIdGenerator> idGeneratorProvider) {
        this.messageService = messageService;
        this.notificationSender = notificationSender;
        this.idGeneratorProvider = idGeneratorProvider;
    }

    public void sendNotification() {
        NotificationIdGenerator idGenerator = idGeneratorProvider.getObject();
        System.out.println("Notification id: " + idGenerator.getId());
        String message = messageService.generateGreeting();
        notificationSender.send(message);
    }

    @PostConstruct
    public void init() {
        System.out.println("NotificationService initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("NotificationService destroyed");
    }
}
