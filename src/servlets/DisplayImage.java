package servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/images/*")
public class DisplayImage extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final String imagesBase = "/home/carlos";

    public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String URLAfterWebDomain = request.getRequestURI();
        //Only accept mappings as src="/images/whatever.jpg", even if web.xml has other mappings to this servlet.
        

        //get the image name, or even directory and image, e.g. /images/music/beethoven.jpg:
        String relativeImagePath = URLAfterWebDomain.substring("/images/".length()+7);  //will get "music/beethoven.jpg"

        System.out.println("\nFetching image from "+imagesBase+"   "+relativeImagePath);
        response.setContentType("image/jpeg"); //as far as I know, this works for PNG as well. You might want to change the mapping to /images/*.jpg if it's giving problems

        ServletOutputStream outStream;
        outStream = response.getOutputStream();
        FileInputStream fin = new FileInputStream(imagesBase+relativeImagePath);

        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(outStream);
        int ch =0; ;
        while((ch=bin.read())!=-1)
            bout.write(ch);
        
        bin.close();
        fin.close();
        bout.close();
        outStream.close();
    }
}