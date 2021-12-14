package org.cleancode.course.service;

import java.util.List;
import java.util.Locale;

import org.cleancode.course.model.Post;
import org.cleancode.course.model.Rating;
import org.cleancode.course.repository.PostRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostService {

    // 1. Añadir metodo en controlador y servicio para obtener un post por id
    // 2. Completar el resto de métodos usando el repositorio
    // 3. Crear estructura de datos para el rating aggregate. {Post, List<RatingAggregate { rating, count }>}
    private PostWrapperFactory postWrapperFactory;
    private GenerateCountMessage generateCountMessage;
    private PostRepository postRepository;

    public Iterable<Post> getPosts() {
        return postRepository.findAll();
    }

    public List<Post> getFeaturedPosts() {
        return postRepository.findByStatus("FEATURED");
    }

    public List<String[]> getPostRatingsAggregate(int postId) {
        return null;
        /*
        List<Rating> postRatings = ratings
                .stream()
                .filter(rating -> rating.getPostId() == postId)
                .collect(Collectors.toList());
        long zeroStarsRates = getRatingValue(postRatings, 0);
        long oneStarsRates = getRatingValue(postRatings, 1);
        long twoStarsRates = getRatingValue(postRatings, 2);
        long threeStarsRates = getRatingValue(postRatings, 3);

        List<String[]> e = new ArrayList<>();
        e.addAll(Arrays.asList(new String[]{"3 stars", "" + threeStarsRates},new String[]{"2 stars", "" + twoStarsRates},new String[]{"1 stars", "" + oneStarsRates},new String[]{"0 stars", "" + zeroStarsRates}));
        return e;*/
    }

    private long getRatingValue(List<Rating> postRatings, int i) {
        return postRatings
                .stream()
                .filter(rating -> rating.getRate() == i)
                .count();
    }

    public String countPostLetters(char candidate, int postId) {
        Post post = getPostById(postId);
        int numberOfOccurrences = getNumberOfLettersInPostContent(candidate, post);
        return generateCountMessage.makeMessage(numberOfOccurrences, candidate);
    }

    private int getNumberOfLettersInPostContent(char candidate, Post post) {
        int numberOfOccurrences = 0;
        var contentPostArray = post.getContent().toLowerCase(Locale.ROOT).toCharArray();
        for(int j = 0; j < contentPostArray.length; j++) {
            if(contentPostArray[j] == candidate) {
                numberOfOccurrences++;
            }
        }
        return numberOfOccurrences;
    }

    public String printPostPreview(int postId) {
        Post post = getPostById(postId);
        return postWrapperFactory.makePostWrapper(post).print();
    }

    public Post getPostById(int postId) {
        return postRepository.findById(Long.valueOf(postId)).get();
    }
}
