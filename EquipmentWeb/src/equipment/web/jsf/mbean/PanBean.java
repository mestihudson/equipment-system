package equipment.web.jsf.mbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import equipment.dao.PanDao;
import equipment.domain.entity.Pan;

@Component("panBean")
@Scope("request")
public class PanBean implements Serializable {
  
  @Resource(name = "panDao")
  private PanDao panDao;
  

  public List<Pan> getTask() {
    return panDao.findAll();
  }
  

 
  
 

}
