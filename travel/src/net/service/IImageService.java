package net.service;

import net.beans.image;

import java.util.List;

public interface IImageService {

    image imageDetails(int imageID) ;

    List<image> getMyImageList(int UID);
    List<image> getMyCollection(int UID) ;

    List<image> selectHotPhotos(String method) ;
    boolean isImageCollected(int ImageID,int UID);
    int cancelOrCollectImage(int ImageID,int UID);
    int cancelCollection(int ImageID, int UID);
    int deleteImage(int ImageID);
}
