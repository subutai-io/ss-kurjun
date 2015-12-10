package ai.subut.kurjun.repo.util;


import ai.subut.kurjun.common.service.KurjunContext;
import ai.subut.kurjun.metadata.factory.PackageMetadataStoreFactory;
import ai.subut.kurjun.repo.service.PackagesIndexBuilder;
import ai.subut.kurjun.storage.factory.FileStoreFactory;


/**
 * Simple implementation of {@link AptIndexBuilderFactory}. Used in Blueprint config file.
 *
 */
public class AptIndexBuilderFactoryImpl implements AptIndexBuilderFactory
{

    private FileStoreFactory fileStoreFactory;
    private PackageMetadataStoreFactory metadataStoreFactory;


    public AptIndexBuilderFactoryImpl( FileStoreFactory fileStoreFactory,
                                       PackageMetadataStoreFactory metadataStoreFactory )
    {
        this.fileStoreFactory = fileStoreFactory;
        this.metadataStoreFactory = metadataStoreFactory;
    }


    @Override
    public PackagesIndexBuilder createPackagesIndexBuilder( KurjunContext context )
    {
        return new PackagesIndexBuilderImpl( fileStoreFactory, context );
    }


    @Override
    public ReleaseIndexBuilder createReleaseIndexBuilder( KurjunContext context )
    {
        return null; // TODO: new ReleaseIndexBuilder( this, context );
    }

}

