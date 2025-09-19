package example.movie.model.mapper;

import example.movie.model.dto.DiscussionPost;

import java.util.List;

public interface DiscussionPostMapper {
    void inertPost(DiscussionPost post);
    int deletePostByIdAndPassword(Integer postId, String password);
    List<DiscussionPost> findPostsByMovieID(Integer movieId);
}
