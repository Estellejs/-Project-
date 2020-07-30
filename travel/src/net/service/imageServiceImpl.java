package net.service;

import net.beans.image;
import net.dao.IImageDao;
import net.dao.imageDaoImpl;
import java.sql.SQLException;
import java.util.List;

public class imageServiceImpl implements IImageService {
    private IImageDao dao;
    public imageServiceImpl(){
        dao=new imageDaoImpl();
    }

    @Override
    public image imageDetails(int imageID) {
        try {
            return dao.imageDetails(imageID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<image> getMyImageList(int UID) {
        try{
            return dao.getMyImageList(UID);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<image> getMyCollection(int UID)  {
        try{
         return dao.getMyCollection(UID);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<image> selectHotPhotos(String method) {
        try {
            return dao.selectHotPhotos(method);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isImageCollected(int ImageID, int UID) {
        try {
            return dao.isImageCollected(ImageID,UID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int cancelOrCollectImage(int ImageID, int UID) {
        try {
            return dao.cancelOrCollectImage(ImageID,UID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int cancelCollection(int ImageID, int UID) {
        try {
            return dao.cancelCollection(ImageID,UID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteImage(int ImageID) {
        try {
            return dao.deleteImage(ImageID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
