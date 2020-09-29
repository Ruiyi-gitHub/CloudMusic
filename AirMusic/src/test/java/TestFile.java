
import com.airmusic.dao.BaseMapper;
import com.airmusic.entiy.Picture;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestFile {
    public static List<Picture> getFiles(String filepath) {
        List<Picture> files = new ArrayList<>();
        File[] tempLists = new File(filepath).listFiles();
        for (File tempList : tempLists) {
            if (tempList.isFile()) {
                Picture audio = new Picture(tempList.getName().substring(0,tempList.getName().indexOf(".")),tempList.toString());
                files.add(audio);
            }
        }
        return files;
    }

    @Test
    public void filepathImportDB(){
        if (BaseMapper.getMapperAgency().importPicturePath(getFiles("D:\\项目资源\\图片\\")) > 0) {
            BaseMapper.commit();
            System.out.println("批量插入成功！");
            BaseMapper.closeSession();
        }else{
            BaseMapper.closeSession();
        }
    }

}
