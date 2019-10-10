package com.krupoderov.github.untitledforum;

import com.krupoderov.github.untitledforum.model.Discussion;
import com.krupoderov.github.untitledforum.repository.DiscussionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UntitledForumApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(UntitledForumApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UntitledForumApplication.class, args);
    }

    @Bean
    public CommandLineRunner blog(DiscussionRepository repository) {
        return (args -> {
            LOGGER.info("Starting a example discussion...");
            repository.save(new Discussion(
                    "Michael",
                    "krupoderov.mikhail@gmail.com",
                    "Rock music",
                    "Piece of My Heart",
                    "Janis Joplin",
                    "This is a demo :)"
            ));
            repository.save(new Discussion(
                    "Michael",
                    "krupoderov.mikhail@gmail.com",
                    "Rock music",
                    "Rock Around the Clock",
                    "Bill Haley & His Comets",
                    "This is a demo 2 :)"
            ));

            LOGGER.info("Get all the discussions");
            for (Discussion discussion : repository.findAll()) {
                LOGGER.info(discussion.toString());
            }
        });
    }
}
