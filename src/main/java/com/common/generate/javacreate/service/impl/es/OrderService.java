package com.common.generate.javacreate.service.impl.es;

import com.common.generate.javacreate.model.es.BoTermQuery;
import com.common.generate.javacreate.model.es.PageParam;
import com.common.generate.javacreate.service.impl.es.orderdocument.OrderDocumentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xialei
 * @date 2021/12/2 13:48
 */
@Service
public class OrderService extends EsBaseSearchService<OrderDocumentDTO>{

    @Override
    public List<OrderDocumentDTO> queryList(PageParam pageParam, BoTermQuery boTermQuery, String indexName, Class<OrderDocumentDTO> orderDocumentDTOClass) {
        return null;
    }
}
