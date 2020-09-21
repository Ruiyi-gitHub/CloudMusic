package Test;

import edu.wang.pojo.User;
import edu.wang.pojo.dao.BaseMapper;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
public class UserTest {
    @Test
    public void userFindByIdTest() {
        for (User o : BaseMapper.getMapperAgency().userFindByIdTest()) {
            System.out.println(o.getUname() + "  " + o.getUage());
        }
    }

    static Logger logger = Logger.getLogger(UserTest.class);

    @Test
    public void textLog4j() {
        logger.info("info:进入了 testLog4j");
        logger.debug("debug:进入了 testLog4j");
        logger.error("error:进入了 testLog4j");
    }

    @Test
    public void addUser() {
        if (BaseMapper.getMapperAgency().userAddByDB(new User("刘志豪", 17)) > 0) {
            BaseMapper.getSession().commit();
            System.out.println("新增成功！");
        } else {
            BaseMapper.getSession().rollback();
            System.out.println("新增失败！");
        }
    }

    @Test
    public void delUser() {
        if (BaseMapper.getMapperAgency().userDelByDB(4) > 0) {
            BaseMapper.getSession().commit();
            System.out.println("删除成功！");
        } else {
            BaseMapper.getSession().rollback();
            System.out.println("删除失败！");
        }
    }

    @Test
    public void upUser() {
        if (BaseMapper.getMapperAgency().userUpdateByUser(new User(4, "刘傻傻", 10)) > 0) {
            BaseMapper.getSession().commit();
            System.out.println("修改成功！");
        } else {
            BaseMapper.getSession().rollback();
            System.out.println("修改失败！");
        }
    }

    @Test
    public void importPictureDB() throws IOException {
        byte[] bytes = null;
        FileInputStream in = new FileInputStream(
                "I:\\Users\\17114\\Music\\MV\\BOOZ音乐-华晨宇写给抑郁症患者的歌曲《好想爱这个世界啊》(超清).mp4");
        try {
            bytes = new byte[in.available()];
        } catch (IOException e) {
            e.printStackTrace();
        }
        in.read(bytes);
        in.close();
        System.out.println(bytes);
        if (BaseMapper.getMapperAgency().importAudioDB(new User("告白", bytes, null)) > 0) {
            BaseMapper.getSession().commit();
            System.out.println("新增成功");
        } else {
            System.out.println("新增失败");
        }
    }

    @Test
    public void dbImportFile() {
        DataInputStream dis = null;
        DataOutputStream dataOut = null;
        try {
            List<byte[]> bytes = BaseMapper.getMapperAgency().dbImportFile();
            OutputStream out = new FileOutputStream("G:\\作业\\S2\\S2结业项目\\项目资源\\音频导入路径\\测试.mp3");
            for (byte[] aByte : bytes) {
                System.out.println(aByte);
                InputStream in = byte2Input(aByte);
                dis = new DataInputStream(in);
                dataOut = new DataOutputStream(out);
                dataOut.write(aByte);
                System.out.println("复制成功");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void importVioceDB() {
        try {
            byte[] input2byte = input2byte(new FileInputStream("I:\\Users\\17114\\Music\\MV\\BOOZ音乐-华晨宇写给抑郁症患者的歌曲《好想爱这个世界啊》(超清).mp4"));
            if (BaseMapper.getMapperAgency().importVoiceDB(new User("好想爱这个世界啊", null, input2byte)) > 0) {
                System.out.println(input2byte);
                BaseMapper.getSession().commit();
                System.out.println("新增成功");
            } else {
                System.out.println("新增失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final InputStream byte2Input(byte[] buf) {
        return new ByteArrayInputStream(buf);
    }

    public static final byte[] input2byte(InputStream inStream) throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 1024)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }
}
