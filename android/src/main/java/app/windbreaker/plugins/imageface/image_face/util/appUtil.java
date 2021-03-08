package app.windbreaker.plugins.imageface.image_face.util;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.Printer;

import java.io.File;

import app.windbreaker.plugins.imageface.image_face.facesdk.ImageUtils;

public class appUtil {
    public appUtil()
    {

    }

    /**
     * 人脸识别判断
     * @param Path
     * @return
     */
    public int HasFace(String Path)
    {
        int hwidth=1280;
        int hheight=720;
        int facesize =0;
        Log.e("Path","nndPath:"+Path);
        try {
            if (Path == null || Path.length() == 0) {
                return 0;
            }
            File file = new File(Path);
            if (!file.exists()) {
                return 0;
            }
            Log.e("Path","nndPath111111:"+Path);
            Bitmap imageBitmap = ImageUtils.getBitmap(Path, hwidth, hheight);
            Log.e("Path","nndPath222222size:"+imageBitmap.getWidth() + " height:"+imageBitmap.getHeight());
            facesize = com.wop.facesdk.GoogleFaceUserUtils.detectFace(imageBitmap);
            Log.e("Path","nndPathfacesize:"+facesize);
        }
        catch (Exception e)
        {
            return 0;
        }
        if (facesize>0)
        {
            return facesize;
        }
        return 0;
    }
}
