package org.cleancode.course.service;

import org.cleancode.course.model.Image;
import org.cleancode.course.model.Post;
import org.cleancode.course.model.PostStatus;
import org.cleancode.course.model.Rating;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class TheService {

    private List<Post> posts = new ArrayList<>();
    private List<Rating> ratings = new ArrayList<>();

    public TheService() {
        this.posts.addAll(Arrays.asList(
                new Post(1, "7 estrategias para ganar a las chapas", "Lorem ipsum...", "Arturo González", PostStatus.FEATURED),
                new Post(2, "Descubre con este cuestionario si sufres del síndrome 'me gusta mas la cama que ir a trabajar'", "Lorem ipsum...", "Pedro Ramírez", PostStatus.PUBLISHED),
                new Post(3, "Cómo me hice rico escribiendo posts sobre cómo me hice rico", "Lorem ipsum...", "Juan", PostStatus.FEATURED),
                new Post(4, "Esto es un borrador", "...", "Juan", PostStatus.DRAFT)));

        this.ratings.addAll(Arrays.asList(
                new Rating(1, 3, "Lorem ipsum...", 1),
                new Rating(2, 3, "Lorem ipsum...", 1),
                new Rating(3, 1, "Lorem ipsum...", 2),
                new Rating(4, 1, "Lorem ipsum...", 1),
                new Rating(5, 0, "Lorem ipsum...", 2),
                new Rating(6, 2, "Lorem ipsum...", 2),
                new Rating(7, 3, "Lorem ipsum...", 3),
                new Rating(8, 4, "Lorem ipsum...", 4)));
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Post> getFeaturedPosts() {
        return posts
                .stream()
                .filter(post -> post.isFeatured())
                .collect(Collectors.toList());
    }

    public List<String[]> getPostRatingsAggregate(int postId) {
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
        return e;
    }

    private long getRatingValue(List<Rating> postRatings, int i) {
        return postRatings
                .stream()
                .filter(rating -> rating.getRate() == i)
                .count();
    }

    public String countPostLetters(char candidate, int postId) {
        Post post = posts.stream().filter(p -> p.getId() == postId).findFirst().get();
        var postLettersMessage = new PostLettersMessage();
        int count = 0;
        for(int j = 0; j < post.getContent().toCharArray().length; j++) {
            if(post.getContent().toLowerCase(Locale.ROOT).toCharArray()[j] == candidate) {
                count++;
            }
        }
        return postLettersMessage.make(candidate, count);
    }


    public String getPostInfo(int postId, boolean includeImages) {
        StringBuffer buffer = new StringBuffer();
        Post post = posts.stream().filter(p -> p.getId() == postId).findFirst().get();
        if(post.isFeatured()) {
            buffer.append(post.getTitle() + "\n");
            if(includeImages) {
                List<Image> images = post.getImages();
                if(!images.isEmpty()) {
                    images.stream().forEach(image -> buffer.append(image.getUrl() + "\n"));
                }
            }
            List<String> content = post.getTags();
            if(!content.isEmpty()) {
                content.stream().forEach(c -> buffer.append(c + "\n"));
            }
            buffer.append(post.getContent());
        }
        if("FEATURED".equals(post.getStatus())) {
            List<Rating> ratings = post.getRatings();
            if(!ratings.isEmpty()) {
                ratings.stream().forEach(rating -> {
                    buffer.append(rating.getRate());
                    if(includeImages) {
                        List<Image> images = rating.getImages();
                        if(!images.isEmpty()) {
                            images.stream().forEach(image -> buffer.append(image.getUrl()));
                        }
                    }
                });
            }
        }
        post.setInfo(buffer.toString());
        return post.getInfo();
    }

    public String printPostPreview(int postId) {
        String message = "";
        Post post = posts.stream().filter(p -> p.getId() == postId).findFirst().get();
        switch(post.getStatus()) {
            case FEATURED: message = printFeaturedPost();
            break;
            case DRAFT: message = printDraftPost();
            break;
            case PUBLISHED: message = printPublishedPost();
            break;
            default: message = printDefaultPost();
        }
        return message;
    }

    public String printFeaturedPost() {
        return "I am a featured post";
    }

    public String printDraftPost() {
        return "I am a draft post";
    }

    public String printPublishedPost() {
        return "I am a published post";
    }

    public String printDefaultPost() {
        return "I am a default post";
    }
}
