package ai.subut.kurjun.http.local;


import com.google.inject.servlet.ServletModule;

import ai.subut.kurjun.http.ServletUtils;


/**
 * Guice servlet module for local non-virtual apt repository.
 *
 */
public class LocalAptRepoServletModule extends ServletModule
{

    private String servletPath = "";


    /**
     * Gets servlet path that will be served. Defaults to empty string.
     *
     * @return
     */
    public String getServletPath()
    {
        return servletPath;
    }


    /**
     * Sets servlet path that will be served.
     *
     * @param servletPath
     */
    public void setServletPath( String servletPath )
    {
        servletPath = ServletUtils.ensureLeadingSlash( servletPath );
        servletPath = ServletUtils.removeTrailingSlash( servletPath );
        this.servletPath = servletPath;
    }


    @Override
    protected void configureServlets()
    {

        serve( servletPath + "/*" ).with( LocalAptRepoServlet.class );

    }


}

