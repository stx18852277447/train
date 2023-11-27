package top.stx.train.business.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.stx.train.business.domain.Station;
import top.stx.train.business.domain.StxStu;
import top.stx.train.business.domain.StxStuExample;

public interface StxStuMapper {
    long countByExample(StxStuExample example);

    int deleteByExample(StxStuExample example);

    int insert(StxStu row);

    int insertSelective(StxStu row);

    List<StxStu> selectByExample(StxStuExample example);

    int updateByExampleSelective(@Param("row") StxStu row, @Param("example") StxStuExample example);

    int updateByExample(@Param("row") StxStu row, @Param("example") StxStuExample example);
    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(StxStu row);
}
