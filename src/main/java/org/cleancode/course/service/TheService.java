package org.cleancode.course.service;

import org.cleancode.course.model.Image;
import org.cleancode.course.model.Post;
import org.cleancode.course.model.Rating;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class TheService {

    private List<Post> posts = new ArrayList<>();
    private List<String[]> theList2 = new ArrayList<>();

    public TheService() {
        this.posts.addAll(Arrays.asList(
                new Post(1, "7 estrategias para ganar a las chapas", "Lorem ipsum...", "Arturo González", "3"),
                new Post(2, "Descubre con este cuestionario si sufres del síndrome 'me gusta mas la cama que ir a trabajar'", "Lorem ipsum...", "Pedro Ramírez", "2"),
                new Post(3, "Cómo me hice rico escribiendo posts sobre cómo me hice rico", "Lorem ipsum...", "Juan", "3"),
                new Post(4, "Esto es un borrador", "...", "Juan", "1")));

        this.theList2.addAll(Arrays.asList(
                new String[]{"1", "1", "3", "Lorem ipsum..."},
                new String[]{"2", "1", "3", "Lorem ipsum..."},
                new String[]{"3", "1", "2", "Lorem ipsum..."},
                new String[]{"4", "1", "1", "Lorem ipsum..."},
                new String[]{"5", "2", "0", "Lorem ipsum..."},
                new String[]{"6", "2", "2", "Lorem ipsum..."},
                new String[]{"7", "3", "3", "Lorem ipsum..."},
                new String[]{"8", "4", "1", "Lorem ipsum..."}));
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Post> getFeaturedPosts() {
        List<Post> featuredPosts = new ArrayList<>();
        for(Post post: posts)
            if("3".equals(post.getStatus()))
                featuredPosts.add(post);

            return featuredPosts;
    }

    public List<String[]> getPRA(String i) {
        List<String[]> pR = theList2
                .stream()
                .filter(r -> r[1].equals(i)).collect(Collectors.toList());
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for(int j = 0; j < pR.size(); j++) {
            switch(pR.get(j)[2]) {
                case "0": a++;
                break;
                case "1": b++;
                break;
                case "2": c++;
                break;
                case "3": d++;
                break;
                default: a++;
                break;
            }
        }
        List<String[]> e = new ArrayList<>();
        e.addAll(Arrays.asList(new String[]{"3 stars", "" + d},new String[]{"2 stars", "" + c},new String[]{"1 stars", "" + b},new String[]{"0 stars", "" + a}));
        return e;
    }

    public String countPostLetters(char a, int i) {
        Post post = posts.get(i);
        int n = 0;
        for(int j = 0; j < post.getContent().toCharArray().length; j++) {
            if(post.getContent().toLowerCase(Locale.ROOT).toCharArray()[j] == a) {
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


    public static String getPostInfo(Post post, boolean includeImages) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(post.getTitle() + "\n");
        if("FEATURED".equals(post.getStatus())) {
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
        }
        buffer.append(post.getContent());
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
}
