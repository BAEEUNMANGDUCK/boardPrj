package com.example.demo;

import com.example.demo.domain.post.PostRequest;
import com.example.demo.domain.post.PostResponse;
import com.example.demo.domain.post.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    PostService postService;

    @Test
    void savePost(){
        PostRequest params = new PostRequest();
        params.setTitle("서비스 테스트 제목");
        params.setContent("서비스 테스트 내용");
        params.setWriter("Test");
        params.setNoticeYn(false);


        long id = postService.savePost(params);
        System.out.println("생성된 게시물 ID: "+ id);


    }

    @Test
    void findPostById(){
        PostResponse post = postService.findPostById(4L);
        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }


    @Test
    void updatePost(){
        PostRequest params = new PostRequest();
        params.setId(4L);
        params.setTitle("업데이트 테스트 제목");
        params.setContent("업데이트 테스트 내용");
        params.setWriter("update Test");
        params.setNoticeYn(true);

        long id = postService.savePost(params);
        System.out.println("생성된 게시글 ID: " + id);

    }

    @Test
    void deletePost(){
        Long id = postService.deletePost(4L);
        System.out.println("삭제된 게시글 ID: " + id);

    }

}

