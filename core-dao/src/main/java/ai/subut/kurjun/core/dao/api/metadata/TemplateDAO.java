package ai.subut.kurjun.core.dao.api.metadata;


import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.persist.Transactional;

import ai.subut.kurjun.core.dao.api.DAOException;
import ai.subut.kurjun.core.dao.api.GenericDAOImpl;
import ai.subut.kurjun.core.dao.model.metadata.TemplateDataEntity;
import ai.subut.kurjun.model.metadata.template.TemplateData;
import ai.subut.kurjun.model.repository.ArtifactId;


public class TemplateDAO extends GenericDAOImpl<TemplateData>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( TemplateDAO.class );

    public TemplateDAO()
    {
        super();
    }

    @Transactional
    public TemplateData find( ArtifactId id ) throws DAOException
    {
        try
        {
            EntityManager em = getEntityManager();
            return em.find( TemplateDataEntity.class, id );
        }
        catch ( Exception e )
        {
            LOGGER.error( "****** Error in TemplateDAO find :" + e.getMessage(), e );
            throw new DAOException( e );
        }
    }
}