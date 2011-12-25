package equipment.web.jsf.mbean;

import java.io.Serializable;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.service.ContainerIsoTypeService;

@Component("sizeTypeBean")
@Scope("request")
public class SizeTypeBean implements Serializable{
  private static final long serialVersionUID = 2458463346642161595L;
  
  @Resource(name="containerIsoTypeService")
  private ContainerIsoTypeService containerIsoTypeService;

  public Set<String> getSizeTypeGroups() {
    return containerIsoTypeService.getAllGroupCodes();
  }
  
  public Set<String> getIsoCodes() {
    return containerIsoTypeService.getAllIsoCodes();
  }
}
