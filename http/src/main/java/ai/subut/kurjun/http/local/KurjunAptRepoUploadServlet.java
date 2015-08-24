package ai.subut.kurjun.http.local;


import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import ai.subut.kurjun.http.ServletUtils;
import ai.subut.kurjun.model.repository.LocalRepository;


@Singleton
@MultipartConfig
class KurjunAptRepoUploadServlet extends HttpServlet
{

    private static final String DEB_PACKAGE_PART = "package";

    @Inject
    private LocalRepository repository;


    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
    {
        if ( !ServletUtils.isMultipart( req ) )
        {
            writeResponse( resp, HttpServletResponse.SC_BAD_REQUEST, "Not a multipart request" );
            return;
        }

        ServletUtils.setMultipartConfig( req, this.getClass() );

        Part part = req.getPart( DEB_PACKAGE_PART );
        if ( part != null )
        {
            try ( InputStream is = part.getInputStream() )
            {
                repository.put( is );
            }
        }
        else
        {
            String msg = String.format( "No package attached with name '%s'", DEB_PACKAGE_PART );
            writeResponse( resp, HttpServletResponse.SC_BAD_REQUEST, msg );
        }
    }


    private void writeResponse( HttpServletResponse resp, int statusCode, String msg ) throws IOException
    {
        resp.setStatus( statusCode );
        try ( ServletOutputStream os = resp.getOutputStream() )
        {
            os.print( msg );
        }
    }

}

