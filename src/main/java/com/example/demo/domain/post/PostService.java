package com.example.demo.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    @Transactional
    public long savePost(final PostRequest params){
        postMapper.save(params);
        return params.getId();
    }

    public PostResponse findPostById(final Long id){
        return postMapper.findById(id);
    }

    @Transactional
    public long updatePost(final PostRequest params){
        postMapper.update(params);
        return params.getId();
    }

    @Transactional
    public Long deletePost(final long id){
        postMapper.deleteById(id);
        return id;
    }

    public List<PostResponse> findAllPost(){
        return postMapper.findAll();
    }

}
