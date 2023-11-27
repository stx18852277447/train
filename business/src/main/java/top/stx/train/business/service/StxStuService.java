package top.stx.train.business.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.stx.train.common.req.PageResp;
import top.stx.train.common.util.SnowUtil;
import top.stx.train.business.domain.StxStu;
import top.stx.train.business.domain.StxStuExample;
import top.stx.train.business.mapper.StxStuMapper;
import top.stx.train.business.req.StxStuQueryReq;
import top.stx.train.business.req.StxStuSaveReq;
import top.stx.train.business.resp.StxStuQueryResp;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StxStuService {

    private static final Logger LOG = LoggerFactory.getLogger(StxStuService.class);

    @Resource
    private StxStuMapper stxStuMapper;

    //public void save(StxStuSaveReq req) {
    //    DateTime now = DateTime.now();
    //    StxStu stxStu = BeanUtil.copyProperties(req, StxStu.class);
    //    if (ObjectUtil.isNull(stxStu.getId())) {
    //    stxStu.setId(SnowUtil.getSnowflakeNextId());
    //    stxStu.setCreateTime(now);
    //    stxStu.setUpdateTime(now);
    //    stxStuMapper.insert(stxStu);
    //    } else {
    //    stxStu.setUpdateTime(now);
    //    stxStuMapper.updateByPrimaryKey(stxStu);
    //    }
    //}

    public PageResp<StxStuQueryResp> queryList(StxStuQueryReq req) {
        StxStuExample stxStuExample = new StxStuExample();
        stxStuExample.setOrderByClause("id desc");
        StxStuExample.Criteria criteria = stxStuExample.createCriteria();
        LOG.info("查询页码：{}", req.getPage());
        LOG.info("每页条数：{}", req.getSize());
        PageHelper.startPage(req.getPage(), req.getSize());
        List<StxStu> stxStuList = stxStuMapper.selectByExample(stxStuExample);

        PageInfo<StxStu> pageInfo = new PageInfo<>(stxStuList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        List<StxStuQueryResp> list = BeanUtil.copyToList(stxStuList, StxStuQueryResp.class);

        PageResp<StxStuQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }
    public void delete(Long id) {
        stxStuMapper.deleteByPrimaryKey(id);
    }
}
