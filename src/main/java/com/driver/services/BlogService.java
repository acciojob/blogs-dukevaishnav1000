package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    ImageService imageService1;

    @Autowired
    UserRepository userRepository1;

    public List<Blog> showBlogs(){
        //find all blogs
    List<Blog> blogList=   blogRepository1.findAll();

    return blogList;
    }

    public void createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time


        User u=userRepository1.findById(userId).get();

        Blog b=new Blog(title,content);
        b.setUser(u);
        List<Blog> blist=u.getBlogs();
        blist.add(b);
        u.setBlogList(blist);
        userRepository1.save(u);
        //updating the blog details

        //Updating the userInformation and changing its blogs

    }

    public Blog findBlogById(int blogId){
        //find a blog

        return blogRepository1.findById(blogId).get();
    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it
        Image i=new Image(description,dimensions);
        Blog b=blogRepository1.findById(blogId).get();
        i.setBlog(b);
        List<Image> images=b.getImageList();
        images.add(i);
        b.setImageList(images);
        blogRepository1.save(b);
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        blogRepository1.deleteById(Integer.valueOf(blogId));

    }
}
