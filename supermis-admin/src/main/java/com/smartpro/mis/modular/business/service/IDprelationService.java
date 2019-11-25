package com.smartpro.mis.modular.business.service;

import com.smartpro.mis.modular.system.model.Dprelation;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 医患关系表 服务类
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-29
 */
public interface IDprelationService extends IService<Dprelation> {
    /**
     * 查询我的医生列表
     * @param id
     * @return
     */
    List<Map<String, Object>> selectDocsByKey(int id);

    /**
     * 查询我的病人列表
     * @param id
     * @return
     */

    List<Map<String, Object>>selectPacsByKey(int id);


    /**
     * 查询我的医生列表，
     * status 为 -1 表示忽略status字段查询条件；
     * status 为 1 表示已经建立绑定关系的列表；
     * status 为 2 表示医生发出与病人建立绑定关系的请求等待病人同意的列表；
     * status 为 5 表示病人发出与医生建立绑定关系的请求等待医生同意的列表；
     * @param id
     * * @param status
     * @return
     */
    List<Map<String, Object>> selectDocs(int id,int status);

    /**
     *     查询我的病人列表，
     * status 为 -1 表示忽略status字段查询条件；
     * status 为 1 表示已经建立绑定关系的列表；
     * status 为 2 表示医生发出与病人建立绑定关系的请求等待病人同意的列表；
     * status 为 5 表示病人发出与医生建立绑定关系的请求等待医生同意的列表；
     *      * @param id
     *      * * @param status
     *      * @return
     *      */

    List<Map<String, Object>>selectPacs(int id,int status);


    /**
     * 修改绑定状态
     */
    int setStatus(@Param("id") Integer id, @Param("status") int status);
}
