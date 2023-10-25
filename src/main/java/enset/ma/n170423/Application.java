package enset.ma.n170423;

import enset.ma.n170423.entities.Client;
import enset.ma.n170423.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
        return args -> {
            clientRepository.save(new Client(null, "KIM Namjoon", "KN@gmail.com", "KN", null));
            clientRepository.save(new Client(null, "KIM Seokjin", "KS@gmail.com", "KS", null));
            clientRepository.save(new Client(null, "MIN Yoongi", "MY@gmail.com", "MY", null));
            clientRepository.save(new Client(null, "JUNG Hoseok", "JH@gmail.com", "JH", null));
            clientRepository.save(new Client(null, "PARK Jimin", "PJ@gmail.com", "PJ", null));
            clientRepository.save(new Client(null, "KIM Taehyung", "KT@gmail.com", "KT", null));
            clientRepository.save(new Client(null, "JEON JUngkook", "JJ@gmail.com", "JJ", null));
        };
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
