package ai.subut.kurjun.web.conf;


import ai.subut.kurjun.web.conf.routes.rest.RestRoutes;
import ai.subut.kurjun.web.controllers.*;
import com.google.inject.Inject;
import ninja.Router;
import ninja.application.ApplicationRoutes;


/**
 *
 */

public class Routes implements ApplicationRoutes
{
    @Inject
    private RestRoutes restRoutes;

    @Override
    public void init( final Router router )
    {
        restRoutes.init( router );


        // -------------------------------------------------------------------------------------------------------------
        //  Assets (CSS, JS, Images & Icons)
        // -------------------------------------------------------------------------------------------------------------
        router.GET().route( "/assets/{fileName: .*}" ).with( DownloadController.class, "serveStatic" );

        // -------------------------------------------------------------------------------------------------------------
        //  Home
        // -------------------------------------------------------------------------------------------------------------
        //router.GET().route( "/" ).with( HomeController.class, "homePage" );

        // -------------------------------------------------------------------------------------------------------------
        //  Identity
        // -------------------------------------------------------------------------------------------------------------
        router.POST().route( "/login" ).with( IdentityController.class, "authorizeUser" );
        router.GET().route( "/login" ).with( IdentityController.class, "loginPage" );
        router.POST().route( "/users/create" ).with( IdentityController.class, "createUser" );
        router.GET().route( "/users" ).with( IdentityController.class, "listUsers" );
        router.POST().route( "/logout" ).with( IdentityController.class, "logout" );
        router.POST().route( "/system/owner" ).with( IdentityController.class, "setSystemOwner");
        router.GET().route( "/system/owner" ).with( IdentityController.class, "getSystemOwner");

        // -------------------------------------------------------------------------------------------------------------
        //  Templates
        // -------------------------------------------------------------------------------------------------------------
        router.GET().route( "/" ).with( TemplateController.class, "listTemplates" );
        router.GET().route( "/templates/upload" ).with( TemplateController.class, "getUploadTemplateForm" );
        router.POST().route( "/templates/upload" ).with( TemplateController.class, "uploadTemplate" );
        router.GET().route( "/templates/{id}/info" ).with( TemplateController.class, "getTemplateInfo" );
        router.GET().route( "/templates/{id}/download" ).with( TemplateController.class, "downloadTemplate" );
        router.POST().route( "/templates/{id}/delete" ).with( TemplateController.class, "deleteTemplate" );

        // -------------------------------------------------------------------------------------------------------------
        //  Apt
        // -------------------------------------------------------------------------------------------------------------
        router.GET().route( "/apt" ).with( AptController.class, "list" );
        //router.GET().route( "/apt/{id}/info" ).with( AptController.class, "getTemplateInfo" );
        router.GET().route( "/apt/upload" ).with( AptController.class, "getUploadForm" );
        router.POST().route( "/apt/upload" ).with( AptController.class, "upload" );
        router.GET().route( "/apt/{id}/download" ).with( AptController.class, "download" );
        router.POST().route( "/apt/{id}/delete" ).with( AptController.class, "delete" );

        // -------------------------------------------------------------------------------------------------------------
        //  Raw Files
        // -------------------------------------------------------------------------------------------------------------
        router.GET().route( "/raw-files" ).with( RawFileController.class, "list" );
        //router.GET().route( "/raw-files/info" ).with( RawFileController.class, "info" );
        router.GET().route( "/raw-files/upload" ).with( RawFileController.class, "getUploadForm" );
        router.POST().route( "/raw-files/upload" ).with( RawFileController.class, "upload" );
        router.GET().route( "/raw-files/download" ).with( RawFileController.class, "download" );
        router.POST().route( "/raw-files/delete" ).with( RawFileController.class, "delete" );

        // -------------------------------------------------------------------------------------------------------------
        //  Relations
        // -------------------------------------------------------------------------------------------------------------
        router.POST().route( "/relations/trust" ).with( RelationController.class, "addTrustRelation" );
        router.GET().route( "/relations" ).with( RelationController.class, "getRelations" );
        router.GET().route( "/relations/source" ).with( RelationController.class, "getRelationsByOwner" );
        router.GET().route( "/relations/target" ).with( RelationController.class, "getRelationsByTarget" );
        router.GET().route( "/relations/object" ).with( RelationController.class, "getRelationsByObject" );

        // -------------------------------------------------------------------------------------------------------------
        //  Repositories
        // -------------------------------------------------------------------------------------------------------------
        router.POST().route( "/repositories/add" ).with( RepositoryController.class, "addRepo" );
        router.GET().route( "/repositories" ).with( RepositoryController.class, "getRepoList" );
        router.GET().route( "/repositories/{id}" ).with( RepositoryController.class, "getRepo" );



    }
}
