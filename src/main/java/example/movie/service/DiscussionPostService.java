//package example.movie.service;
//
//import example.movie.model.dto.DiscussionPost;
//import example.movie.model.dto.PostCreateRequest;
//import example.movie.model.mapper.DiscussionPostMapper;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class DiscussionPostService {
//    private final DiscussionPostMapper postMapper;
//
//    public DiscussionPostService(DiscussionPostMapper postMapper){
//        this.postMapper = postMapper;
//    }
//
//    public DiscussionPost createPost(Integer movieId, PostCreateRequest request){
//        DiscussionPost post = new DiscussionPost();
//        post.setMovieId(movieId);
//        post.setContent(request.getContent());
//        post.setPassword(request.getPassword());
//        postMapper.insertPost(post);
//        return convertToDto(post);
//    }
//
//    public boolean deletePost(Integer postId, String password){
//        int deletedRows = postMapper.deletePostByIdAndPassword(postId, password);
//        return deletedRows > 0;
//    }
//    public List<DiscussionPost> getPostsByMovieId(Integer movieId){
//        List<DiscussionPost> posts = postMapper.findPostsByMovieID(movieId);
//        return posts.stream()
//                .map(this::convertToDto)
//                .collect(Collectors.toList());
//    }
//    private DiscussionPost convertToDto(DiscussionPost post) {
//        if (post == null) {
//            return null;
//        }
//        DiscussionPost dto = new DiscussionPost();
//        dto.setPostId(post.getPostId());
//        dto.setMovieId(post.getMovieId());
//        dto.setContent(post.getContent());
//        dto.setPassword(post.getPassword());
//        dto.setCreatedAt(post.getCreatedAt());
//        return dto;
//    }
//
//}
