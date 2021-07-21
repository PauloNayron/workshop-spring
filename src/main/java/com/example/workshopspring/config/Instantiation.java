package com.example.workshopspring.config;

import com.example.workshopspring.domain.Post;
import com.example.workshopspring.domain.User;
import com.example.workshopspring.dto.AuthorDTO;
import com.example.workshopspring.dto.CommentDTO;
import com.example.workshopspring.repository.PostRepository;
import com.example.workshopspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = User.builder().name("Maria Brown").email("maria@gmail.com").build();
        User alex = User.builder().name("Alex Green").email("alex@gmail.com").build();
        User bob = User.builder().name("Bob Grey").email("bob@gmail.com").build();

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = Post.builder().date(LocalDate.parse("2019-06-01")).title("Partiu viagem").body("Vou viajar para São Paulo. Abraços!").author(new AuthorDTO(maria)).build();
        Post post2 = Post.builder().date(LocalDate.parse("2021-06-01")).title("Bom dia").body("Acordei Feliz hoje!").author(new AuthorDTO(maria)).build();


        CommentDTO c1 = new CommentDTO("Boa viagem!", LocalDate.parse("2019-06-01"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite!", LocalDate.parse("2019-06-01"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", LocalDate.parse("2021-06-01"), new AuthorDTO(alex));

        post1.setComments(Arrays.asList(c1, c2));
        post2.setComments(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.setPosts(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
