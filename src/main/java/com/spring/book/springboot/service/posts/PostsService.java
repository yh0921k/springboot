package com.spring.book.springboot.service.posts;

import com.spring.book.springboot.domain.posts.Posts;
import com.spring.book.springboot.domain.posts.PostsRepository;
import com.spring.book.springboot.web.dto.PostsListResponseDto;
import com.spring.book.springboot.web.dto.PostsResponseDto;
import com.spring.book.springboot.web.dto.PostsSaveRequestDto;
import com.spring.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class PostsService {
    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(("해당 게시글이 존재하지 않습니다. id = " + id)));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id = " + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id = " + id));
        postsRepository.delete(posts);
    }

    @Transactional(readOnly = true)
    public void test1Cache() {
        Posts posts = postsRepository.findById(1l).get();

        System.out.println(posts.getContent());
    }
}