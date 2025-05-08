package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.*;
import com.sprint.mission.discodeit.entity.dto.CreateBinaryContentRequest;
import com.sprint.mission.discodeit.entity.dto.CreateUserRequest;
import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class DiscodeitApplication {

	static User setupUser(UserService userService) {
		CreateUserRequest createUserRequest = new CreateUserRequest("임정현", "1234wjdgusdl", "12345678");
//		Optional<CreateBinaryContentRequest> createBinaryContentRequest = new CreateBinaryContentRequest("profileImage", FileType.IMAGE);
		User user = userService.create(createUserRequest, Optional.empty());
		return user;
	}

	static Channel setupChannel(ChannelService channelService) {
		Channel channel = channelService.create(ChannelType.PUBLIC, "공지", "공지 채널입니다.");
		return channel;
	}

	static void messageCreateTest(MessageService messageService, Channel channel, User author) {
		Message message = messageService.create("안녕하세요.", channel.getId(), author.getId());
		System.out.println("메시지 생성: " + message.getId());
	}


	public static void main(String[] args) {
//		SpringApplication.run(DiscodeitApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(DiscodeitApplication.class, args);
		// 서비스 초기화
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ChannelService channelService = (ChannelService) context.getBean("basicChannelService");
		UserService userService = (UserService) context.getBean("basicUserService");
		MessageService messageService = (MessageService) context.getBean("basicMessageService");

		// 셋업
		User user = setupUser(userService);
		Channel channel = setupChannel(channelService);
		// 테스트
		messageCreateTest(messageService, channel, user);
	}

}
