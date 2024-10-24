import java.io.*;
import java.net.*;

class Downloader {

    public static void main(String[] args) throws FileNotFoundException {
        Downloader dowloader = new Downloader();
        dowloader.downloadFiles("http://cdn.sstatic.net/Sites/stackoverflow/img/apple-touch-icon@2.png?v=73d79a89bded&a", "C:\\Users\\IP44", 1);
    }

    public static void downloadFiles(String strURL, String strPath, int buffSize)  {
        try {
            URL connection = new URL(strURL);
            HttpURLConnection urlconn;
            urlconn = (HttpURLConnection) connection.openConnection();
            urlconn.setRequestMethod("GET");
            urlconn.connect();
            InputStream in = null;
            in = urlconn.getInputStream();
            OutputStream writer = new FileOutputStream(strPath);
            byte buffer[] = new byte[buffSize];
            int c = in.read(buffer);
            while (c > 0) {
                writer.write(buffer, 0, c);
                c = in.read(buffer);
            }
            writer.flush();
            writer.close();
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}