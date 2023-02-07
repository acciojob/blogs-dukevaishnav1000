package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;

    @Autowired
    BlogRepository bs;
    public Image createAndReturn(Blog blog, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog

        Image i=new Image(description,dimensions);
        i.setBlog(blog);
        Blog bee=bs.findById(blog.getId()).get();
        List<Image> il=bee.getImageList();
        il.add(i);
        bee.setImageList(il);
        bs.save(bee);

        return i;
    }

    public void deleteImage(Image image){
        imageRepository2.deleteById(image.getId());
    }

    public Image findById(int id) {
        return imageRepository2.findById(id).get();
    }

    public int countImagesInScreen(Image image, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        //In case the image is null, return 0
        if(image!=null) {
            String imageArr[] = image.getDimensions().split("X");
            String screenArr[] = screenDimensions.split("X");

         int result=Integer.parseInt(screenArr[0]) * Integer.parseInt(screenArr[1]) / (Integer.parseInt(imageArr[0]) * Integer.parseInt(imageArr[1]));
            return result;
        }
        return 0;
        }
}
