package equipment.web.jsf.mbean;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.dao.ContainerIsoTypeDao;
import equipment.domain.entity.ContainerIsoType;

@Component
@Scope("request")
public class ContainerCodeBean implements Serializable {
  private static final long serialVersionUID = -5650490585039961293L;
  private Collection<ContainerIsoType> containerIsoTypes;
  
  @Autowired
  private ContainerIsoTypeDao containerIsoTypesDao;
  
  public Collection<ContainerIsoType> getContainerIsoTypes() {
    if(containerIsoTypes == null) {
      containerIsoTypes = containerIsoTypesDao.findAll();
    }
    return containerIsoTypes;
  }
}
