import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class HelloClassLoader extends ClassLoader{

    // 定义一个绝对路径
    private String sPath;

    // 构造函数
    public HelloClassLoader(String path) {
        super(null);
        this.sPath = path;
    }

    /**
     *
     * @param name 表示一个需要传递的类文件
     * @return
     */
    @Override
    protected Class<?> findClass(String name) {
        String FileName = sPath + File.separator + name;
        byte[] data = findByteData(FileName);
        assert data != null;
        String className = name.substring(0, name.indexOf("."));
        return defineClass(className, data, 0, data.length);
    }

    /**
     * 自定义一个文件解析的函数
     * @param aFileName
     * @return
     */
    private byte[] findByteData(String aFileName) {
        // 以当前路径来创建一个File的对象
        File file = new File(aFileName);
        // 测试文件是否正确
        System.out.println(file.getName());
        int length = (int)file.length();
        System.out.println(length);
        byte[] bytes = new byte[length];
        try (FileInputStream fileInputStream = new FileInputStream(file); // 创建字节输入流
             // 创建 fileInputStream,以该文件输入流创建 FileChannel
             FileChannel inChannel = fileInputStream.getChannel();
             // 创建一个大小为n字节的缓冲区
             ByteArrayOutputStream bufferedWriter = new ByteArrayOutputStream((int) inChannel.size());
             WritableByteChannel writableByteChannel = Channels.newChannel(bufferedWriter)) {
            int bufSize = 1024;
            //todo allocate 的值为多大较合适 1024？
            ByteBuffer buffer = ByteBuffer.allocate(bufSize);
            while (true) {
                int read = inChannel.read(buffer);
                boolean stop = (read == 0 || read == -1);
                if (stop) {
                    break;
                }
                buffer.flip();
                writableByteChannel.write(buffer);
                buffer.clear();
            }
            byte[] old = bufferedWriter.toByteArray();
            byte[] news = new byte[old.length];
            for (int i = 0; i < old.length; i++) {
                news[i] = (byte) (255 - old[i]);
            }
            return news;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        try{
            String path = "D:/极客大学/Java训练营/自动加载一个类/hello";
            HelloClassLoader myClassLoader = new HelloClassLoader(path);
            Class<?> myClassLoaderClass = myClassLoader.findClass("Hello.xlass");
            Class<?> hello = myClassLoaderClass.getClassLoader().loadClass("Hello");
            Method helloMethod = hello.getMethod("hello");
            helloMethod.invoke(hello.newInstance());
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
