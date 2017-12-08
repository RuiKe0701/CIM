package team.ruike.cim.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.ruike.cim.dao.TemporaryOrderDao;
import team.ruike.cim.dao.TemporaryOrderTermDao;
import team.ruike.cim.pojo.TemporaryOrder;
import team.ruike.cim.pojo.TemporaryOrderState;
import team.ruike.cim.pojo.TemporaryOrderTerm;
import team.ruike.cim.service.TemporaryOrderService;
import team.ruike.cim.util.GenerateNumber;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import java.util.List;

/**
 * 临时订单业务类
 *
 * @author 甄立
 * @version 1.0
 */
@Service("temporaryOrderService")
public class TemporaryOrderServiceImpl implements TemporaryOrderService {

    @Resource
    private TemporaryOrderDao temporaryOrderDao;

    @Resource
    private TemporaryOrderTermDao temporaryOrderTermDao;

    @Override
    public void queryTemporaryOrder(TemporaryOrder temporaryOrder, Pager<TemporaryOrder> pager) {
        Integer count = temporaryOrderDao.selectCount(temporaryOrder);
        pager.setTotalRecord(count);
        List<TemporaryOrder> temporaryOrderList = temporaryOrderDao.select(temporaryOrder, (pager.getCurrentPage() - 1) * pager.getPageSize(), pager.getPageSize());
        pager.setList(temporaryOrderList);
    }

    @Override
    public TemporaryOrder queryTemporaryOrderById(Integer temporaryOrderId) {
        TemporaryOrder temporaryOrder = null;
        if (temporaryOrderId != null && temporaryOrderId > 0) {
            temporaryOrder = temporaryOrderDao.selectById(temporaryOrderId);
        }
        return temporaryOrder;
    }

    @Transactional
    public void addTemporaryOrder(TemporaryOrder temporaryOrder, List<TemporaryOrderTerm> temporaryOrderTerms) {
        if (temporaryOrder != null && temporaryOrderTerms != null && temporaryOrderTerms.size() > 0) {
            //订单号
            temporaryOrder.setTemporaryOrderNo(GenerateNumber.getGenerateNumber().getRandomFileName().toString());
            //临时订单状态
            temporaryOrder.setTemporaryOrderState(new TemporaryOrderState() {{
                setStatus(1);
            }});
            Integer orderId = temporaryOrderDao.add(temporaryOrder);
            //添加临时订单项
            for (TemporaryOrderTerm temporaryOrderTerm : temporaryOrderTerms) {
                //合同订单ID
                temporaryOrderTerm.setTemporaryOrderTermId(orderId);
                //生产批次编号
                temporaryOrderTerm.setProductBatch(GenerateNumber.getGenerateNumber().getRandomFileName());
                temporaryOrderTermDao.add(temporaryOrderTerm);
            }

        } else {
            new NullPointerException("添加临时订单失败 数据错误");
        }


    }
}