package belog.dao;

import belog.pojo.po.Taxonomy;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxonomyMapper {
    @Delete({
        "delete from t_taxonomy",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_taxonomy (count, description, ",
        "parent, taxonomy, ",
        "name, slug, term_group)",
        "values (#{count,jdbcType=BIGINT}, #{description,jdbcType=VARCHAR}, ",
        "#{parent,jdbcType=BIGINT}, #{taxonomy,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{slug,jdbcType=VARCHAR}, #{termGroup,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Taxonomy record);

    int insertSelective(Taxonomy record);

    @Select({
        "select",
        "id, count, description, parent, taxonomy, name, slug, term_group",
        "from t_taxonomy",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("BaseResultMap")
    Taxonomy selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Taxonomy record);

    @Update({
        "update t_taxonomy",
        "set count = #{count,jdbcType=BIGINT},",
          "description = #{description,jdbcType=VARCHAR},",
          "parent = #{parent,jdbcType=BIGINT},",
          "taxonomy = #{taxonomy,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "slug = #{slug,jdbcType=VARCHAR},",
          "term_group = #{termGroup,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Taxonomy record);

    @Select({
            "select",
            "id, count, description, parent, taxonomy, name, slug, term_group",
            "from t_taxonomy",
            "where taxonomy = #{taxonomy}"
    })
    @ResultMap("BaseResultMap")
    List<Taxonomy> selectByTaxonomy(String taxonomy);

    @Select({
            "select",
            "id, count, description, parent, taxonomy, name, slug, term_group",
            "from t_taxonomy",
            "where parent = #{pid}"
    })
    @ResultMap("BaseResultMap")
    List<Taxonomy> selectByPid(Long pid);

    @Select({
            "select",
            "id, count, description, parent, taxonomy, name, slug, term_group",
            "from t_taxonomy",
            "where parent = #{pid} and taxonomy = #{taxonomy}"
    })
    @ResultMap("BaseResultMap")
    List<Taxonomy> selectByPidAndTaxonomy(@Param("pid") Long pid, @Param("taxonomy") String taxonomy);

    @Select({
            "select",
            "id, count, description, parent, taxonomy, name, slug, term_group",
            "from t_taxonomy",
            "where name = #{name} LIMIT 1"
    })
    @ResultMap("BaseResultMap")
    Taxonomy selectOneByName(String name);
}