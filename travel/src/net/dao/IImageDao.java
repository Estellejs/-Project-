package net.dao;

import net.beans.image;

import java.sql.SQLException;
import java.util.List;

public interface IImageDao {
    //根据imageID获取image所有信息
    image imageDetails(int imageID) throws SQLException;

    List<image> getMyImageList(int UID) throws SQLException;
    List<image> getMyCollection(int UID) throws SQLException;

    List<image> selectHotPhotos(String method) throws SQLException;
    //查找city，country，author的name

    boolean isImageCollected(int ImageID,int UID)throws SQLException;

    int cancelOrCollectImage(int ImageID,int UID) throws SQLException;
    int cancelCollection(int ImageID, int UID) throws SQLException;
    int deleteImage(int ImageID) throws SQLException;
}
