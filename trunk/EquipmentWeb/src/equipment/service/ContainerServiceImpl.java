package equipment.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import equipment.dao.ContainerDao;
import equipment.domain.entity.Container;

@Service("containerService")
@Transactional
public class ContainerServiceImpl implements ContainerService {
  @Resource(name="containerDao")
  private ContainerDao containerDao;

  @Override
  public char calculateCheckDigit(String containerNumber) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean validateCheckDigit(String containerNumber, char checkDigit) {
    return Character.isDigit(checkDigit) && checkDigit == calculateCheckDigit(containerNumber);
  }

  @Override
  public Container findByNumber(String containerNumber) {
    return containerDao.findById(containerNumber);
  }

  @Override
  public void create(Container container) {
    containerDao.save(container);
  }
}
