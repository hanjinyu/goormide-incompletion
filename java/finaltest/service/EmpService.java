package finaltest.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import finaltest.repository.EmpRepository;
import finaltest.model.EmpEntity;
import finaltest.model.EmpParam;
import finaltest.model.EmpResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    EmpRepository empRepository;
    
    @Transactional
    public void add(EmpParam ep) {
        EmpEntity ee = new EmpEntity();
        ee.setTitle(ep.getTitle());
        empRepository.save(ee);
    
    }
    
    @Transactional
    public List<EmpResult> getEmpList(){
        List<EmpEntity> empEntityList = empRepository.findAll();
        List<EmpResult> results = empEntityList.stream().map(empEntity -> {
            EmpResult empResult = new EmpResult();
            empResult.setId(empEntity.getId());
            empResult.setTitle(empEntity.getTitle());
            return empResult;
        }).collect(Collectors.toList());
        return results;
    }
        
    @Transactional
    public EmpResult getEmpItem(long id) {
        return empRepository.findById(id).map(empEntity -> {
             EmpResult empResult = new EmpResult();
            empResult.setId(empEntity.getId());
            empResult.setTitle(empEntity.getTitle());
            return empResult;
        }).get();
    }
    
    @Transactional
    public void update(EmpParam ep) {
        Optional<EmpEntity> empEntity = empRepository.findById(ep.getId());
        empEntity.ifPresent(entity -> {
            entity.setTitle(ep.getTitle());
            empRepository.save(entity);
        });
    }
    
    @Transactional
    public void delete(long id) {
        empRepository.deleteById(id);
    }
}
