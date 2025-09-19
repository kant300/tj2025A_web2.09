package example.movie.controller;

import example.movie.model.dto.DiscussionPost;
import example.movie.model.dto.PostCreateRequest;
import example.movie.model.dto.PostDeleteRequest;
import example.movie.service.DiscussionPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies/{movieId}/discussion")
public class DiscussionPostController {
    private final DiscussionPostService postService;

    public DiscussionPostController(DiscussionPostService postService){
        this.postService = postService;
    }

    @PostMapping("")
    public ResponseEntity<DiscussionPost> createPost(@PathVariable Integer movieId, @RequestBody PostCreateRequest request){
        DiscussionPost post = new DiscussionPost();
        post.setContent(request.getContent());
        post.setPassword(request.getPassword());
        DiscussionPost createPost = postService.createPost(movieId, .2
                post);
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }
    @DeleteMapping("")
    public ResponseEntity<Void> deletePost(@PathVariable Integer postId, @RequestBody PostDeleteRequest request){
        boolean isDeleted = postService.deletePost(postId, request.getPassword());
        if(isDeleted){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
    @GetMapping("")
    public ResponseEntity<List<DiscussionPost>> getPostsByMovieId(@PathVariable Integer movieId){
        List<DiscussionPost> posts = postService.getPostsByMovieId(movieId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

}
