package com.common.generate.javacreate.service.impl.es;

import com.common.generate.javacreate.model.es.BoTermQuery;
import com.common.generate.javacreate.model.es.UserEsQueryDTO;
import com.common.generate.javacreate.model.es.PageParam;
import com.common.generate.javacreate.model.es.QueryParam;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author xialei
 * @date 2021/10/27 15:12
 */

@Service
public class UserQueryServiceImpl extends EsHighLevelSearchServiceImpl<UserEsQueryDTO> {
    @Override
    public List<UserEsQueryDTO> queryList(PageParam pageParam, BoTermQuery boTermQuery, String indexName, Class<UserEsQueryDTO> userEsQueryDTOClass) {
        return null;
    }

//    public List<UserEsQueryDTO> query(PageParam pageParam, QueryParam queryParam) {
//        String queryContent = queryParam.getQueryContent();
//        String name = queryParam.getName();
//        String sex = queryParam.getSex();
//
//        BoTermQuery boTermQuery = BoTermQuery.create();
//        BoTermQuery.Should should = BoTermQuery.Should.create(1);
//        if (!StringUtils.isEmpty(queryContent)) {
//            should.addMatchCondition(queryContent, "name", "content");
//            boTermQuery.addShouldCondition(should);
//        }
//        if (!StringUtils.isEmpty(sex)) {
//            boTermQuery.addTermCondition("sex", sex);
//        }
//        if (name != null) {
//            boTermQuery.addMatchCondition("name", name);
//        }
//        return this.queryList(pageParam, boTermQuery,
//                "user", UserEsQueryDTO.class);
//
//    }

}
