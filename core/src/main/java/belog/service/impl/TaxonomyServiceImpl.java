package belog.service.impl;

import belog.dao.TaxonomyMapper;
import belog.dao.TaxonomyRelationshipsMapper;
import belog.pojo.Page;
import belog.pojo.po.Taxonomy;
import belog.service.TaxonomyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Beldon
 */
@Service("TaxonomyService")
public class TaxonomyServiceImpl extends BaseService implements TaxonomyService {

    @Autowired
    protected TaxonomyMapper taxonomyMapper;

    @Autowired
    protected TaxonomyRelationshipsMapper taxonomyRelationshipsMapper;

    public void countPlus(long catId, long sum) {
        taxonomyMapper.countPlus(catId, sum);
    }

    public void countMinus(long catId, long sum) {
        taxonomyMapper.countMinus(catId, sum);
    }

    public void deleteById(long id) {
        taxonomyMapper.deleteByPrimaryKey(id);
        taxonomyRelationshipsMapper.deleteByTaxonomyId(id);
    }

    public List<Taxonomy> findAll(String type) {
        return taxonomyMapper.selectByTaxonomy(type);
    }

    public List<Taxonomy> findByPid(long pid) {
        return taxonomyMapper.selectByPid(pid);
    }

    public List<Taxonomy> findByPid(long pid, String type) {
        return taxonomyMapper.selectByPidAndTaxonomy(pid, type);
    }

    public Taxonomy findOneByName(String name) {
        return taxonomyMapper.selectOneByName(name);
    }

    public Taxonomy findOneByNameAndType(String name, String type) {
        return taxonomyMapper.selectOneByNameAndType(name, type);
    }

    public List<Taxonomy> findByObjectIdAndType(Long objectId, String type) {
        return taxonomyMapper.findByObjectIdAndType(objectId, type);
    }

    public List<Taxonomy> findByPage(String type, Page<Taxonomy> page) {
        return taxonomyMapper.findByPage(type, page);
    }

}
