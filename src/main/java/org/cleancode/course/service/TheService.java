package org.cleancode.course.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class TheService {

    public static final int POST_STATUS_POSITION = 4;
    public static final String FEATURED_STATUS_VALUE = "3";
    public static final int POST_ID_POSITION = 0;
    private List<String[]> posts = new ArrayList<>();
    private List<String[]> ratings = new ArrayList<>();

    public TheService() {

        // The array of String that forms a post:
        // [0] id of the post
        // [1] title of the post
        // [2] contain of the post
        // [3] author of the post
        // [4] status of the post { 1: DRAFT, 2: PUBLISHED, 3: FEATURED }
        this.posts.addAll(Arrays.asList(
                new String[]{"1", "7 estrategias para ganar a las chapas", "Lorem ipsum...", "Arturo González", "3"},
                new String[]{"2", "Descubre con este cuestionario si sufres del síndrome 'me gusta mas la cama que ir a trabajar'", "Lorem ipsum...", "Pedro Ramírez", "2"},
                new String[]{"3", "Cómo me hice rico escribiendo posts sobre cómo me hice rico", "Lorem ipsum...", "Juan", "3"},
                new String[]{"4", "Esto es un borrador", "...", "Juan", "1"}));

        // The array of String that forms a rate:
        // [0] id of the rate
        // [1] id of the post rated
        // [2] rate number
        // [3] comment if any
        this.ratings.addAll(Arrays.asList(
                new String[]{"1", "1", "3", "Lorem ipsum..."},
                new String[]{"2", "1", "3", "Lorem ipsum..."},
                new String[]{"3", "1", "2", "Lorem ipsum..."},
                new String[]{"4", "1", "1", "Lorem ipsum..."},
                new String[]{"5", "2", "0", "Lorem ipsum..."},
                new String[]{"6", "2", "2", "Lorem ipsum..."},
                new String[]{"7", "3", "3", "Lorem ipsum..."},
                new String[]{"8", "4", "1", "Lorem ipsum..."}));
    }

    public List<String[]> getPosts() {
        return posts;
    }

    public List<String[]> getFeaturedPosts() {
        List<String[]> featuredPosts = new ArrayList<>();
        for(String[] post: posts) {
            if (FEATURED_STATUS_VALUE.equals(post[POST_STATUS_POSITION])) {
                featuredPosts.add(post);
            }
        }
        return featuredPosts;
    }

    public List<String[]> copyPostAddItAndReturnIt(int postId) {
        String[] newPost = new String[posts.get(0).length];
        var postToCopy = findPostById(postId);
        copyPostsContent(newPost, postToCopy);
        posts.add(newPost);
        return posts;
    }

    private String[] findPostById(int postId) {
        return posts
                .stream()
                .filter(post -> post[POST_ID_POSITION] == "" + postId)
                .findFirst()
                .get();
    }

    private void copyPostsContent(String[] newPost, String[] postToCopy) {
        for (int i = 0; i < newPost.length - 1; i++) {
            newPost[i] = postToCopy[i];
        }
    }

    public List<String[]> getPostRatingsAggregate(String postId) {
        List<String[]> postRatings = ratings
                .stream()
                .filter(rating -> postId.equals(rating[1]))
                .collect(Collectors.toList());

        int zeroStars = 0;
        int oneStar = 0;
        int twoStars = 0;
        int threeStars = 0;
        for(int k = 0; k < postRatings.size(); k++) {
            switch(postRatings.get(k)[2]) {
                case "0": zeroStars++;
                break;
                case "1": oneStar++;
                break;
                case "2": twoStars++;
                break;
                case "3": threeStars++;
                break;
                default: zeroStars++;
                break;
            }
        }
        List<String[]> e = new ArrayList<>();
        e.addAll(Arrays.asList(new String[]{"3 stars", "" + threeStars},new String[]{"2 stars", "" + twoStars},new String[]{"1 stars", "" + oneStar},new String[]{"0 stars", "" + zeroStars}));
        return e;
    }

    public String countPostLetters(char a, int i) {
        String[] post = posts.get(i);
        int n = 0;
        for(int j = 0; j < post[2].toCharArray().length; j++) {
            if(post[2].toLowerCase(Locale.ROOT).toCharArray()[j] == a) {
                n++;
            }
        }
        String number;
        String verb;
        String pluralModifier;
        if (n == 0) {
            number = "no";
            verb = "are";
            pluralModifier = "s";
        } else if (n == 1) {
            number = "1";
            verb = "is";
            pluralModifier = "";
        } else {
            number = Integer.toString(n);
            verb = "are";
            pluralModifier = "s";
        }
        String message = String.format("There %s %s %s%s", verb, number, a, pluralModifier);
        return message;
    }
}
