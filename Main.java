
package pkg7;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Main {

    
    public static void main(String[] args) throws IOException {
        String stringUrl = "http://cdn3-www.cattime.com/assets/uploads/2011/08/best-kitten-names-1.jpg";
        downloadUsingStream(stringUrl);
    }

    private static void downloadUsingStream(String URL) throws IOException{
        URL url = new URL(URL);
        String[] imagename = url.getFile().split("/");
        String destFolder= "C:\\Users\\Lesha\\"+imagename[imagename.length-1];
        File file = new File(destFolder);
        System.out.println(file.getPath());
            file.createNewFile();
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

    
}
